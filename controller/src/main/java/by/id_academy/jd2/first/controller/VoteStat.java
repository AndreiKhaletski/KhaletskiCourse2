package by.id_academy.jd2.first.controller;

import by.id_academy.jd2.first.service.VoteService;
import by.id_academy.jd2.first.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "VoteStat", urlPatterns = "/votestat")
public class VoteStat extends HttpServlet {
    IVoteService iVoteService = new VoteService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<p><i>Результаты голосования:</i></p>");
        writer.write("<p><b>Лучший исполнитель:</b><p>");

        writer.write(iVoteService.calculatePerformerResults());

        writer.write("<p><b>Ваши любимые жанры:</b></p>");
        writer.write(iVoteService.calculateGenreResults());
    }
}
