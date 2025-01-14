package com.sms.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setContentType("text/html");
        addLoginHtmlCode(resp.getWriter());
    }

    private void addLoginHtmlCode(PrintWriter writer) {
        // Serve the login page as HTML
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<title>Login Page</title>");
        writer.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>");
        writer.println("<style>");
        writer.println("body { background-color: #f7f7f7; }");
        writer.println(".login-container { max-width: 400px; margin-top: 100px; }");
        writer.println(".login-card { padding: 30px; border-radius: 8px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1); background-color: #ffffff; }");
        writer.println(".login-title { text-align: center; margin-bottom: 20px; }");
        writer.println(".form-control { border-radius: 25px; }");
        writer.println(".btn-login { width: 100%; border-radius: 25px; background-color: #007bff; color: white; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");

        writer.println("<div class='container'>");
        writer.println("<div class='login-container'>");
        writer.println("<div class='card login-card'>");
        writer.println("<h3 class='login-title'>Login</h3>");
        writer.println("<form action='login' method='POST'>");
        writer.println("<div class='mb-3'>");
        writer.println("<label for='username' class='form-label'>Username</label>");
        writer.println("<input type='text' class='form-control' id='username' name='username' required>");
        writer.println("</div>");
        writer.println("<div class='mb-3'>");
        writer.println("<label for='password' class='form-label'>Password</label>");
        writer.println("<input type='password' class='form-control' id='password' name='password' required>");
        writer.println("</div>");
        writer.println("<button type='submit' class='btn btn-login'>Login</button>");
        writer.println("</form>");
        writer.println("<div class='text-center mt-3'>");
        writer.println("<a href='#'>Forgot password?</a>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</div>");

        writer.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js'></script>");
        writer.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js'></script>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
