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

    private void addSuccessPageHtmlCode(PrintWriter out, String username) {
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Admin Dashboard</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'/>");
        out.println("<style>");
        out.println("/* Custom styles for the dashboard */");
        out.println("body { font-family: 'Arial', sans-serif; margin-top: 56px; }");
        out.println("#sidebar { position: fixed; top: 56px; left: 0; width: 250px; background-color: #343a40; padding-top: 20px; transition: width 0.3s; height: 100vh; z-index: 100; overflow-y: auto; }");
        out.println("#sidebar .btn { text-align: left; padding: 15px; margin-bottom: 10px; font-size: 16px; }");
        out.println("#sidebar .btn:hover { background-color: #007bff; }");
        out.println("#main-content { margin-left: 250px; padding-top: 30px; transition: margin-left 0.3s; }");
        out.println("#content-container { margin-top: 20px; }");
        out.println("@media (max-width: 768px) { #sidebar { width: 0; z-index: 1000; } #sidebar.open { width: 250px; } #main-content { margin-left: 0; } }");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");

        out.println("<nav class='navbar navbar-expand-lg navbar-dark bg-dark fixed-top'>");
        out.println("<div class='container-fluid'>");
        out.println("<a class='navbar-brand' href='#'>Admin Dashboard</a>");
        out.println("<button class='btn btn-outline-danger' id='logoutButton' onclick='window.location.href=\"/sms\"'>Logout</button>");
        out.println("<button class='btn btn-outline-light' id='sidebarToggle' onclick='toggleSidebar()'>☰</button>");
        out.println("</div>");
        out.println("</nav>");

        out.println("<div class='container-fluid'>");
        out.println("<div class='row'>");

        out.println("<div class='col-md-3 col-lg-2 bg-dark text-white p-4' id='sidebar' style='overflow-y: auto;'>");
        out.println("<h3 class='text-center'>Admin Menu</h3>");
        out.println("<ul class='nav flex-column'>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100' onclick='showContent(\"addStudent\")'>Add Student</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"deleteStudent\")'>Delete Student</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"addCourse\")'>Add Course</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"deleteCourse\")'>Delete Course</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"enrollStudent\")'>Enroll Student</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"unenrollStudent\")'>Unenroll Student</button></li>");

        out.println("<li class='nav-item'>");
        out.println("    <a href='/sms/display-student' class='btn btn-outline-light w-100 mt-2'>Fetch All Students</a>");
        out.println("</li>");

//        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"fetchAllStudents\")'>Fetch All Students</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"fetchAllCourses\")'>Fetch All Courses</button></li>");
        out.println("<li class='nav-item'><button class='btn btn-outline-light w-100 mt-2' onclick='showContent(\"attendance\")'>Attendance</button></li>");  // Added Attendance menu
        out.println("</ul>");
        out.println("</div>");

        out.println("<div class='col-md-9 col-lg-10 p-5' id='main-content'>");
        out.println("<div class='container' id='content-container'>");
        out.println("<h2>Welcome to the Admin Dashboard</h2>");
        out.println("<p>Select a menu item to perform an action.</p>");
        out.println("</div>");
        out.println("</div>");

        out.println("</div>");
        out.println("</div>");

        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("<script>");
        out.println("function toggleSidebar() {");
        out.println("    var sidebar = document.getElementById('sidebar');");
        out.println("    sidebar.classList.toggle('open');");
        out.println("}");

        out.println("function showContent(menuItem) {");
        out.println("    const mainContent = document.getElementById('content-container');");
        out.println("    mainContent.innerHTML = '';"); // Clear existing content

        out.println("    switch (menuItem) {");
        out.println("        case 'addStudent':");
        out.println("            mainContent.innerHTML = '<h2>Add Student</h2>' +");


        out.println("        '<form action=\"/sms/register-student\" method=\"post\">' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentId\" class=\"form-label\">Student ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"studentId\" name=\"id\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentName\" class=\"form-label\">Student Name</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"studentName\" name=\"name\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentAge\" class=\"form-label\">Age</label>' +");
        out.println("                '<input type=\"number\" class=\"form-control\" id=\"studentAge\" name=\"age\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentDepartment\" class=\"form-label\">Department</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"studentDepartment\" name=\"department\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentStatus\" class=\"form-label\">Status</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"studentStatus\" name=\"status\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<button type=\"submit\" class=\"btn btn-primary\">Add Student</button>' +");
        out.println("        '</form>'; break;");


        out.println("        case 'deleteStudent':");
        out.println("            mainContent.innerHTML = '<h2>Delete Student</h2>' +");
        out.println("        '<form action=\"/sms/delete-student\" method=\"post\">' +");
        out.println("                    '<div class=\"mb-3\">' +");
        out.println("                        '<label for=\"studentId\" class=\"form-label\">Student ID</label>' +");
        out.println("                        '<input type=\"text\" class=\"form-control\" id=\"studentId\" name=\"id\" required>' +");
        out.println("                    '</div>' +");
        out.println("                    '<button type=\"submit\" class=\"btn btn-danger\">Delete Student</button>' +");
        out.println("                '</form>'; break;");

        out.println("        case 'addCourse':");
        out.println("            mainContent.innerHTML = '<h2>Add Course</h2>' +");
        out.println("        '<form action=\"/sms/add-course\" method=\"post\">' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"courseId\" class=\"form-label\">Course ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"courseId\" name=\"courseId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"courseName\" class=\"form-label\">Course Name</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"courseName\" name=\"courseName\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"instructorId\" class=\"form-label\">Instructor ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"instructorId\" name=\"instructorId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"schedule\" class=\"form-label\">Schedule</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"schedule\" name=\"schedule\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<button type=\"submit\" class=\"btn btn-primary\">Add Course</button>' +");
        out.println("        '</form>'; break;");


        out.println("        case 'deleteCourse':");
        out.println("            mainContent.innerHTML = '<h2>Delete Course</h2>' +");
        out.println("        '<form action=\"/sms/delete-course\" method=\"post\">' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"courseId\" class=\"form-label\">Course ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"courseId\" name=\"courseId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<button type=\"submit\" class=\"btn btn-danger\">Delete Course</button>' +");
        out.println("        '</form>'; break;");


        out.println("        case 'attendance':");
        out.println("            mainContent.innerHTML = '<h2>Student Attendance</h2>' +");
        out.println("                '<table class=\"table table-striped\"><thead><tr><th>Student Name</th><th>Course</th><th>Date</th><th>Present</th></tr></thead><tbody>' +");
        out.println("                '<tr><td>John Doe</td><td>CS101</td><td>2025-01-14</td><td>Yes</td></tr>' +");
        out.println("                '<tr><td>Jane Smith</td><td>CS102</td><td>2025-01-14</td><td>No</td></tr>' +");
        out.println("                '<tr><td>Mary Johnson</td><td>CS103</td><td>2025-01-14</td><td>Yes</td></tr>' +");
        out.println("                '</tbody></table>'; break;");

        out.println("        case 'enrollStudent':");
        out.println("            mainContent.innerHTML = '<h2>Enroll Student in Course</h2>' +");
        out.println("        '<form action=\"/sms/enroll-student\" method=\"post\">' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentId\" class=\"form-label\">Student ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"studentId\" name=\"studentId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"courseId\" class=\"form-label\">Course ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"courseId\" name=\"courseId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<button type=\"submit\" class=\"btn btn-success\">Enroll Student</button>' +");
        out.println("        '</form>'; break;");

        out.println("        case 'unenrollStudent':");
        out.println("            mainContent.innerHTML = '<h2>Unenroll Student from Course</h2>' +");
        out.println("        '<form action=\"/sms/unenroll-student\" method=\"post\">' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"studentId\" class=\"form-label\">Student ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"studentId\" name=\"studentId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<div class=\"mb-3\">' +");
        out.println("                '<label for=\"courseId\" class=\"form-label\">Course ID</label>' +");
        out.println("                '<input type=\"text\" class=\"form-control\" id=\"courseId\" name=\"courseId\" required>' +");
        out.println("            '</div>' +");
        out.println("            '<button type=\"submit\" class=\"btn btn-warning\">Unenroll Student</button>' +");
        out.println("        '</form>'; break;");

        out.println("        default:");
        out.println("            mainContent.innerHTML = '<h2>Welcome to the Admin Dashboard</h2>' + '<p>Select a menu item to perform an action.</p>'; break;");
        out.println("    }");
        out.println("}");
        out.println("</script>");

        out.println("</body>");
        out.println("</html>");

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
