package by.id_academy.jd2.first.controller;

import by.id_academy.jd2.first.service.VoteService;
import by.id_academy.jd2.first.service.api.IVoteService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {


    private final static String ARTIST_PARAM_NAME = "performerHtml";
    private final static String GENRE_PARAM_NAME = "genresHtml";
    private final static String ABOUT_PARAM_NAME = "commentHtml";
    IVoteService iVoteService = new VoteService();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        String performer = req.getParameter(ARTIST_PARAM_NAME);
        String[] genres = req.getParameterValues(GENRE_PARAM_NAME);
        String comment = req.getParameter(ABOUT_PARAM_NAME);

        iVoteService.save(performer, genres, comment);

        writer.write("<p><i>Результаты голосования:</i></p>");
        writer.write("<p><b>Лучший исполнитель:</b><p>");

        writer.write(iVoteService.calculatePerformerResults());

        writer.write("<p><b>Ваши любимые жанры:</b></p>");
        writer.write(iVoteService.calculateGenreResults());

        writer.write("<p><b>Комментарии:</b><p>");
        for (String s : iVoteService.commentsList()) {
            writer.write("<p>" + s + " (" + formatter.format(new Date()) + ")" + "</p>");
        }
    }
}