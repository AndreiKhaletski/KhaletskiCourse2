package by.id_academy.jd2.first;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        getServletContext().setAttribute("Serv", this);
    }

    private final List<String> listPerformer = new ArrayList<>();
    private final List<String> listGenres = new ArrayList<>();
    private final List<String> commentsList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        Date date = new Date();

        String performer = req.getParameter("performerHtml");
        String[] genres = req.getParameterValues("genresHtml");
        String comment = req.getParameter("commentHtml");

        if (genres.length < 3 || genres.length > 5) {
            writer.println("<h1>" + "Необходимо выбрать от 3 до 5 жанров" + "</h1>");
            writer.close();
        } else {
            listGenres.addAll(Arrays.asList(genres));
        }

        listPerformer.add(performer);

        if (!Objects.equals(comment, "")) {
            commentsList.add(comment + " (" + date + ")");
        }

        writer.write("<p><i>Результаты голосования:</i></p>");
        writer.write("<p><b>Лучший исполнитель:</b><p>");

        Map<String, Integer> listMapPerformer = listPerformer.stream().collect(toMap(e -> e, e -> 1, Integer::sum));

        List<Map.Entry<String, Integer>> collect = listMapPerformer.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        Map<String, Integer> listMapGenres = listGenres.stream().collect(toMap(e -> e, e -> 1, Integer::sum));

        List<Map.Entry<String, Integer>> collect2 = listMapGenres.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        for (Map.Entry<String, Integer> pair : collect) {
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
        for (Map.Entry<String, Integer> pair : collect2) {
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
        for (int i = 0; i < commentsList.size(); i++) {
            writer.write("<p>" + commentsList.get(i) + "</p>");
        }
    }
}
