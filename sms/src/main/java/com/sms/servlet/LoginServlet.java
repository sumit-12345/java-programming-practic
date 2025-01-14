package com.sms.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<Integer> studentId = new ArrayList<>();

        if (username.equals("admin") && password.equals("admin")) {
            addSuccessPageHtmlCode(resp.getWriter(),username);
        } else {
            addErrorPageHtmlCode(resp.getWriter());
        }
    }

    private void addSuccessPageHtmlCode(PrintWriter writer, String username) {

        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<title>Login Successful</title>");
        writer.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>");
        writer.println("<style>");
        writer.println("body { background-color: #f7f7f7; }");
        writer.println(".success-container { max-width: 400px; margin-top: 100px; }");
        writer.println(".success-card { padding: 30px; border-radius: 8px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1); background-color: #ffffff; }");
        writer.println(".success-title { text-align: center; margin-bottom: 20px; color: green; }");
        writer.println(".btn-home { width: 100%; border-radius: 25px; background-color: #007bff; color: white; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");

        writer.println("<div class='container'>");
        writer.println("<div class='success-container'>");
        writer.println("<div class='card success-card'>");
        writer.println("<h3 class='success-title'>Login Successful!</h3>");
        writer.println("<p class='text-center'>Welcome, " + username + "!</p>");

        writer.println("<div class='d-grid gap-2'>");
        // Back to Home button
        writer.println("<a href='index.html' class='btn btn-home'>Back to Home</a>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</div>");

        writer.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js'></script>");
        writer.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js'></script>");
        writer.println("</body>");
        writer.println("</html>");
    }
    private void addErrorPageHtmlCode(PrintWriter writer) {
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang='en'>");
        writer.println("<head>");
        writer.println("<meta charset='UTF-8'>");
        writer.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        writer.println("<title>Login Error</title>");
        writer.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>");
        writer.println("<style>");
        writer.println("body { background-color: #f7f7f7; }");
        writer.println(".error-container { max-width: 400px; margin-top: 100px; }");
        writer.println(".error-card { padding: 30px; border-radius: 8px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1); background-color: #ffffff; }");
        writer.println(".error-title { text-align: center; margin-bottom: 20px; }");
        writer.println(".form-control { border-radius: 25px; }");
        writer.println(".btn-home, .btn-forgot { width: 100%; border-radius: 25px; }");
        writer.println(".btn-home { background-color: #007bff; color: white; }");
        writer.println(".btn-forgot { background-color: #f8d7da; color: #721c24; margin-top: 10px; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");

        writer.println("<div class='container'>");
        writer.println("<div class='error-container'>");
        writer.println("<div class='card error-card'>");
        writer.println("<h3 class='error-title text-danger'>Login Failed</h3>");
        writer.println("<p class='text-center text-danger'>Incorrect username or password. Please try again.</p>");

        writer.println("<div class='d-grid gap-2'>");
        // Back to Home button
        writer.println("<a href='index.html' class='btn btn-home'>Back to Home</a>");
        // Forgot Password button
        writer.println("<a href='forgot-password.html' class='btn btn-forgot'>Forgot Password?</a>");
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
