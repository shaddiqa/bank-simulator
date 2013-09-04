package com.midtrans.bank.ws;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jpos.core.Configuration;
import org.jpos.q2.QBeanSupport;

import javax.naming.ConfigurationException;

public class BankRest extends QBeanSupport {
    private Server server;
    private int port;

    @Override
    protected void initService() throws Exception {
        Configuration cfg = getConfiguration();
        port = cfg.getInt("port", 8080);
        server = new Server(port);

        String contextPath = cfg.get("contextPath","/");
        log.info("context path = " + contextPath);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, contextPath);

        String []packagesToScan = cfg.getAll("packagesToScan");
        String []pathSpec = cfg.getAll("pathSpec");

        if(packagesToScan.length != pathSpec.length)
            throw new ConfigurationException("number of packagesToScan must equal to number of pathSpec");

        for(int i=0;i<packagesToScan.length;i++) {
            ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
            servletHolder.setInitParameter("com.sun.jersey.config.property.packages", packagesToScan[i]);
            servletContextHandler.addServlet(servletHolder, pathSpec[i]);
            log.info(packagesToScan[i] + " ==> " + pathSpec[i]);
        }
    }

    @Override
    protected void startService() throws Exception {
        if (!server.isRunning()) {
            server.start();
            log.info("server start on port " + port);
        } else {
            log.info("server already running on port " + port);
        }
    }

    @Override
    protected void stopService() throws Exception {
        if (server.isRunning()) {
            server.stop();
            log.info("server stop on port " + port);
        }
    }
}
