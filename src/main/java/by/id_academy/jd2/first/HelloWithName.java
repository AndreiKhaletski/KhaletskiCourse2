package by.id_academy.jd2.first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello_with_name")
public class HelloWithName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");
//        resp.setHeader("Content-Type," , "text/html; charset=UTF-8");

        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastname");
        // почему проблема с регистром ?
        //http://127.0.0.1:8080/first-web-app-1.0-SNAPSHOT/hello_with_name?firstName=Andrey&lastname=Khaletski

        PrintWriter writer = resp.getWriter();
        writer.write("Привет" + firstname + " " + lastname);
    }
}
