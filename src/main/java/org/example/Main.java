package org.example;

import org.htmlunit.WebClient;
import org.htmlunit.html.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Main {
    @Test
    public void htmlunit3() throws IOException {


        WebClient webClient = new WebClient();
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = webClient.getPage("http://www.facebook.com");
        System.out.println(page1.getUrl());
        List<HtmlForm> forms = page1.getForms();

        // System.out.println("---"+form.size());
        HtmlForm form = forms.get(0);
        //  final List<HtmlInput> button = form.getInputsByValue("Log in");
        HtmlTextInput id = form.getInputByName("email");
        id.setValueAttribute("honey.gemini01@gmail.com");
        HtmlPasswordInput pass = form.getInputByName("pass");
        pass.setValueAttribute("honey1234");

        System.out.println("id--"+id.getAttribute("value"));
        System.out.println("pass--"+pass.getAttribute("value"));



        HtmlButton submit = page1.getFirstByXPath("//*[@name=\"login\"]");


        submit.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(page1.getUrl());





        //     final HtmlPage page2 = button.get(0).click();
    }

}