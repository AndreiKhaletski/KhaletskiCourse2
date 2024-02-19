//package by.id_academy.jd2.first;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.http.HttpRequest;
//import java.time.Instant;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import static java.lang.System.out;
//import static java.util.stream.Collectors.toMap;
//
////http://127.0.0.1:8080/first-web-app-1.0-SNAPSHOT/vote
//
//@WebServlet(name = "Vote", urlPatterns = "/vote")
//public class Vote extends HttpServlet {
////    private static final String VALUE_TEMPLATE = "<p>%s = %s</p>";
////
////    private static final Map<String, String> BAND_ID_NAME_MAP = Map.of(
////            "a1", "Linkin Park",
////            "a2", "Revolver",
////            "a3", "Mangolia Park",
////            "a4", "Colin"
////    );
////
////    public static final Map<String, Integer> BAND_NAME_VOTES_MAP = Map.of(
////            "a1", 0,
////            "a2", 0,
////            "a3", 0,
////            "a4", 0
////    );
//
////    private static void validateRequest(HttpServletRequest request) {
////        String[] answers = request.getParameterValues("answer-Checkbox");
////        answers.length > 5....
////        answers.length < 3 ...
////
////    }
//
//    ArrayList<String> list = new ArrayList<>();
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        //-------------------------------
////        private final Instant receivingTimestamp;
////        private final String value;
////
////        new TextContent(String value) {
////            this.value = value;
////            this.receivingTimestamp = Instant.now()
////        }
////
////        no setters
////        only getters
//        //-------------------------------
//
//
//        long dateHeader = req.getDateHeader("");
//        // Has void as return value
////        validateRequest(req);
//
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
//        String answer = req.getParameter("answer");
////        BAND_NAME_VOTES_MAP.add(answer);
//        list.add(answer);
//
//////        скорее всего значения сохраняются в листе и при повторном голосовании лист сохраняет старые значения и плюсует
////
////        int currentBandVotes = BAND_NAME_VOTES_MAP.getOrDefault(answer, 0);
////        BAND_NAME_VOTES_MAP.put(answer, currentBandVotes + 1);
////
////        List<Map.Entry<String, Integer>> sortedValuesList = BAND_NAME_VOTES_MAP.entrySet().stream()
////                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
////                .toList();
////
//        PrintWriter writer = resp.getWriter();
////        writer.write("<p>Результаты голосования:</p>");
////
////        for (Map.Entry<String, Integer> entry : sortedValuesList) {
////            String bandName = BAND_ID_NAME_MAP.get(entry.getKey());
////            int bandVotes = BAND_NAME_VOTES_MAP.get(entry.getKey());
////            writer.write(String.format(VALUE_TEMPLATE, bandName, bandVotes));
////        }
//
//        writer.write("------------------------------------------------------");
//        writer.write("<p><i>Результаты голосования:</i></p>");
//
//        Map<String, Integer> list_map = list.stream().collect(toMap(e -> e, e -> 1, Integer::sum));
//
////        list_map.forEach((k, v) -> out.println(k + " " + v));
//        List<Map.Entry<String, Integer>> collect = list_map.entrySet().stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .toList();
//
//        for (Map.Entry<String, Integer> pair : collect) {
//            String key = pair.getKey();
//            Integer value = pair.getValue();
////            writer.write("<p>" + key + " : " + value + "</p>");
//
//            switch (key) {
//                case "a1" -> writer.write("<p>Linkin Park = " + value + "</p>");
//                case "a2" -> writer.write("<p>Revolver = " + value + "</p>");
//                case "a3" -> writer.write("<p>Mangolia Park = " + value + "</p>");
//                case "a4" -> writer.write("<p>Colin = " + value + "</p>");
//            }
//        }
//
//        out.println("==========================================");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//
////        doGet(req,resp);
//        service(req, resp);
//    }
//}
