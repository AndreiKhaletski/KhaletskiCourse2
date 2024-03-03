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

        for (Map.Entry<String, Integer> pair : iVoteService.mapCollectPerfomer()) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            switch (key) {
                case "a1" -> writer.write("<p>Linkin Park = " + value + " гол.</p>");
                case "a2" -> writer.write("<p>Revolver = " + value + " гол.</p>");
                case "a3" -> writer.write("<p>Mangolia Park = " + value + " гол.</p>");
                case "a4" -> writer.write("<p>Colin = " + value + " гол.</p>");
            }
        }

        writer.write("<p><b>Ваши любимые жанры:</b></p>");

        for (Map.Entry<String, Integer> pair : iVoteService.mapCollectGenres()) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            switch (key) {
                case "g1" -> writer.write("<p>Hip-Hop = " + value + " гол.</p>");
                case "g2" -> writer.write("<p>Rock = " + value + " гол.</p>");
                case "g3" -> writer.write("<p>Pop = " + value + " гол.</p>");
                case "g4" -> writer.write("<p>Disco = " + value + " гол.</p>");
                case "g5" -> writer.write("<p>Fusion = " + value + " гол.</p>");
                case "g6" -> writer.write("<p>Classical = " + value + " гол.</p>");
                case "g7" -> writer.write("<p>Electronic = " + value + " гол.</p>");
                case "g8" -> writer.write("<p>Jazz = " + value + " гол.</p>");
                case "g9" -> writer.write("<p>Country = " + value + " гол.</p>");
                case "g10" -> writer.write("<p>Reggae = " + value + " гол.</p>");
            }
        }

        writer.write("<p><b>Комментарии:</b><p>");
        for (String s : iVoteService.commentsList()) {
            writer.write("<p>" + s + " (" + formatter.format(new Date()) + ")" + "</p>");
        }
    }
}
