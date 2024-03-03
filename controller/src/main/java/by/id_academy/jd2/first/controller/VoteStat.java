//package by.id_academy.jd2.first.Controller;
//
//import by.id_academy.jd2.first.Controller.Vote;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(name = "VoteStat", urlPatterns = "/votestat")
//public class VoteStat extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        ServletContext servletContext = getServletContext();
//        Vote vote = (Vote) servletContext.getAttribute("Serv");
//        vote.doPost(req, resp);
//
//    }
//}
