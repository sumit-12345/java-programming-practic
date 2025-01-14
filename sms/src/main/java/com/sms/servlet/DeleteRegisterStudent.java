package com.sms.servlet;

import com.sms.config.AppConfig;
import com.sms.model.Student;
import com.sms.service.StudentRegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-student")
public class DeleteRegisterStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(req.getParameterMap().keySet());
            Student student = new Student();
            student.setId(Integer.parseInt(req.getParameter("id")));
            System.out.println(student);
            AnnotationConfigApplicationContext context = AppConfig.getContext();
            StudentRegistrationService studentService = context.getBean(StudentRegistrationService.class);
            boolean success = studentService.deleteStudent(student);
            if (success) {
                addHtmlForDeleteStudentSuccess(resp.getWriter());
            } else {
                addHtmlForDeleteStudentFailure(resp.getWriter());
            }
        }catch (RuntimeException runtimeException) {
            addHtmlForDeleteStudentFailure(resp.getWriter());
        }
    }

    private void addHtmlForDeleteStudentSuccess(PrintWriter out) {
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Registration Successful</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #f0f8ff;");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("}");
        out.println(".container {");
        out.println("    max-width: 600px;");
        out.println("    margin-top: 50px;");
        out.println("    text-align: center;");
        out.println("}");
        out.println(".card {");
        out.println("    padding: 30px;");
        out.println("    border-radius: 15px;");
        out.println("    background-color: #ffffff;");
        out.println("    box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".icon {");
        out.println("    font-size: 50px;");
        out.println("    color: #28a745;");
        out.println("}");
        out.println(".success-message {");
        out.println("    font-size: 24px;");
        out.println("    color: #333;");
        out.println("    margin: 20px 0;");
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
        out.println("    text-decoration: none;");
        out.println("}");
        out.println(".btn-back:focus {");
        out.println("    outline: none;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='card'>");
        out.println("<div class='icon'>✔️</div>");
        out.println("<div class='success-message'>");
        out.println("<h2>Student Deleted Successful!</h2>");
        out.println("<p>Congratulations, the student has been successfully Deleted.</p>");
        out.println("</div>");
        out.println("<a href='javascript:history.back()' class='btn btn-back'>Go Back</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private void addHtmlForDeleteStudentFailure(PrintWriter out) {
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Registration Failed</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<style>");
        out.println("body {");
        out.println("    background-color: #f8d7da;");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("}");
        out.println(".container {");
        out.println("    max-width: 600px;");
        out.println("    margin-top: 50px;");
        out.println("    text-align: center;");
        out.println("}");
        out.println(".card {");
        out.println("    padding: 30px;");
        out.println("    border-radius: 15px;");
        out.println("    background-color: #ffffff;");
        out.println("    box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println(".icon {");
        out.println("    font-size: 50px;");
        out.println("    color: #dc3545;");
        out.println("}");
        out.println(".failure-message {");
        out.println("    font-size: 24px;");
        out.println("    color: #333;");
        out.println("    margin: 20px 0;");
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
        out.println("    text-decoration: none;");
        out.println("}");
        out.println(".btn-back:focus {");
        out.println("    outline: none;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='card'>");
        out.println("<div class='icon'>❌</div>");
        out.println("<div class='failure-message'>");
        out.println("<h2>Student Registration Failed</h2>");
        out.println("<p>Oops, something went wrong. The student could not be deleted.</p>");
        out.println("</div>");
        out.println("<a href='javascript:history.back()' class='btn btn-back'>Go Back</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

}
