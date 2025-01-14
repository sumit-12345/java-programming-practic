package com.sms.servlet;

import com.sms.config.AppConfig;
import com.sms.model.Student;
import com.sms.service.StudentRegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = AppConfig.getContext();
        StudentRegistrationService studentService = context.getBean(StudentRegistrationService.class);
        List<Student> students = studentService.fetchAllStudents();
        displayStudents(resp.getWriter(), students);
    }

    private void displayStudents(PrintWriter out, List<Student> studentList) {
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>All Students</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #f8f9fa;");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("}");
        out.println(".container {");
        out.println("    margin-top: 50px;");
        out.println("}");
        out.println(".table-container {");
        out.println("    background-color: #ffffff;");
        out.println("    padding: 30px;");
        out.println("    border-radius: 15px;");
        out.println("    box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".table thead {");
        out.println("    background-color: #007bff;");
        out.println("    color: white;");
        out.println("}");
        out.println(".btn-back {");
        out.println("    background-color: #007bff;");
        out.println("    color: white;");
        out.println("    border: none;");
        out.println("    padding: 10px 20px;");
        out.println("    border-radius: 5px;");
        out.println("    font-size: 16px;");
        out.println("}");
        out.println(".btn-back:hover {");
        out.println("    background-color: #0056b3;");
        out.println("}");
        out.println(".btn-back:focus {");
        out.println("    outline: none;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='table-container'>");
        out.println("<h2 class='text-center'>All Students</h2>");

// Table for displaying student data
        out.println("<table class='table table-striped table-bordered'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Age</th>");
        out.println("<th>Department</th>");
        out.println("<th>Status</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

// Assuming you have a List<Student> to iterate through
        for (Student student : studentList) {
            out.println("<tr>");
            out.println("<td>" + student.getId() + "</td>");
            out.println("<td>" + student.getName() + "</td>");
            out.println("<td>" + student.getAge() + "</td>");
            out.println("<td>" + student.getDepartment() + "</td>");
            out.println("<td>" + student.getStatus() + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");

        out.println("<a href='javascript:history.back()' class='btn btn-back'>Go Back</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}
