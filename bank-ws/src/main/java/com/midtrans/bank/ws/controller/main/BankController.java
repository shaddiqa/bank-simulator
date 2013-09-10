package com.midtrans.bank.ws.controller.main;

import com.google.gson.Gson;
import com.midtrans.bank.core.model.Bank;
import com.midtrans.bank.ws.util.DocumentUtil;
import com.midtrans.bank.ws.util.JsonUtil;
import org.apache.commons.io.IOUtils;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/bank")
public class BankController {

    private String DIRNAME = "deploy/";
    private Gson gson = JsonUtil.getGson();

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Context HttpServletRequest request) {
        try {
            String input = IOUtils.toString(request.getInputStream());

            Bank bank = gson.fromJson(input, Bank.class);

            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileWriter(String.format("%s%s",DIRNAME,xmlName(bank.getId(),bank.getName()))), format);
            writer.write(DocumentUtil.createBankServer(bank));
            writer.close();

            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@Context HttpServletRequest request) {
        try {
            String input = IOUtils.toString(request.getInputStream());

            Bank bank = gson.fromJson(input, Bank.class);

            File file = new File(String.format("%s%s",DIRNAME,xmlName(bank.getId(),bank.getName())));

            if(file.delete()) {
                return Response.status(Response.Status.OK).build();
            } else {
                return Response.status(Response.Status.ACCEPTED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    private String xmlName(Long id, String bankName) {
        return String.format("%02d_%s-server.xml",id, bankName);
    }
}
