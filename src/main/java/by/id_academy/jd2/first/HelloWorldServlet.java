package by.id_academy.jd2.first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet1", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("Hello, my world!");
        // System.out.println("PRIVET ANDY"); НЕ ВИДЕН НА САЙТЕ ПРИЛОЖЕНИЯ (ТОЛЬКО В КОНСОЛИ)
        // - ПОПРОБОВАТЬ ЗАПУСТИТЬ


    }
}
