package by.id_academy.jd2.first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.stream.Collectors.toMap;

@WebServlet(name = "Vote", urlPatterns = "/vote")
public class Vote extends HttpServlet {
    private final List<String> list = new ArrayList<>();
    private final List<String> comments_list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        String answer = req.getParameter("answer");
        list.add(answer);

        Enumeration<String> enumes = req.getParameterNames();
        while (enumes.hasMoreElements()) {
            String vote = enumes.nextElement();
            boolean checked = vote.startsWith("vote");
            if (checked) {
                list.add(req.getParameter(vote));
            }
        }

        String comment = req.getParameter("comment");
        Date date = new Date();
        comments_list.add(comment + " (" + date + ")");

        writer.write("<p><i>Результаты голосования:</i></p>");
        writer.write("<p><b>Лучший исполнитель:</b><p>");

        Map<String, Integer> list_map = list.stream().collect(toMap(e -> e, e -> 1, Integer::sum));

//        list_map.forEach((k, v) -> out.println(k + " " + v));
        List<Map.Entry<String, Integer>> collect = list_map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        for (Map.Entry<String, Integer> pair : collect) {
            String key = pair.getKey();
            Integer value = pair.getValue();
//            writer.write("<p>" + key + " : " + value + "</p>");

            switch (key) {
                case "a1" -> writer.write("<p>Linkin Park = " + value + " гол.</p>");
                case "a2" -> writer.write("<p>Revolver = " + value + " гол.</p>");
                case "a3" -> writer.write("<p>Mangolia Park = " + value + " гол.</p>");
                case "a4" -> writer.write("<p>Colin = " + value + " гол.</p>");
            }
        }

        writer.write("<p><b>Ваши любимые жанры:</b></p>");
        for (Map.Entry<String, Integer> pair : collect) {
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
        for (int i = 0; i < comments_list.size(); i++) {
            writer.write("<p>" + comments_list.get(i) + "</p>");
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        doGet(req, resp);
////        service(req, resp);
//    }
}
