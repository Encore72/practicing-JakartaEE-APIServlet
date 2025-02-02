package org.ifer.jakartaeeapiservlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/Param/Url-Get")
public class ParamGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String greet = req.getParameter("greet");
        String name = req.getParameter("name");
        Date date = new Date();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("     <head>");
        out.println("         <meta charset=\"UTF-8\">");
        out.println("         <title>Get Params from Url</title>");
        out.println("     </head>");
        out.println("     <body>");
        out.println("         <h1>Get Params from Url</h1>");
        if(greet != null && name != null) {
            out.println("         <h2>Sending: " + name + ", " + greet + "</h2>");
        } else if (greet != null){
            out.println("         <h2>Sending, " + greet + "</h2>");
        } else {
            out.println("         <h2>There are no parameters for greet or name</h2>");
        }
        try {
            Integer code = Integer.valueOf(req.getParameter("code"));
            out.println("       <h3>The code sent is: " + code + "</h3>");
        } catch (NumberFormatException e) {
            out.println("       <h3>The code sent is not a number</h3>");
        }
        try {
            out.println("           <h3>Today is: " + date + "</h3>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out.println("     </body>");
        out.println("</html>");
        out.close();
    }
}
