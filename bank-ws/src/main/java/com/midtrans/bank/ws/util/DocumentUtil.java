package com.midtrans.bank.ws.util;

import com.midtrans.bank.core.model.Bank;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created with IntelliJ IDEA.
 * User: shaddiqa
 * Date: 9/4/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class DocumentUtil {
    public static Document createBankServer(Bank bank) {
        Document document = DocumentHelper.createDocument();

        Element server = document.addElement("server")
                .addAttribute("name", bank.getName())
                .addAttribute("class", "org.jpos.q2.iso.QServer")
                .addAttribute("logger", "Q2");

        Element attr = server.addElement("attr")
                .addAttribute("name", "port")
                .addAttribute("type", "java.lang.Integer")
                .addText(bank.getPort());

        Element channel = server.addElement("channel")
                .addAttribute("name", String.format("%s-channel", bank.getName()))
                .addAttribute("class", "org.jpos.iso.channel.NACChannel")
                .addAttribute("packager", "org.jpos.iso.packager.ISO87BPackager")
                .addAttribute("logger", "Q2")
                .addAttribute("header", bank.getHeader());

        Element requestListener = server.addElement("request-listener")
                .addAttribute("class", "com.midtrans.bank.core.BankRequestListener")
                .addAttribute("logger", "Q2");

        return document;
    }
}
