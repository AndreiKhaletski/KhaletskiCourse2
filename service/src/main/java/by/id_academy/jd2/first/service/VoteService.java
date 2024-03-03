package by.id_academy.jd2.first.service;

import by.id_academy.jd2.first.dao.VoteDAO;
import by.id_academy.jd2.first.dao.api.IVoteDao;
import by.id_academy.jd2.first.service.api.IVoteService;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

public class VoteService implements IVoteService {
    private final IVoteDao voteDao = new VoteDAO();

    @Override
    public void save(String performer, String[] genres, String comment) {

        if (genres.length < 3 || genres.length > 5) {
            throw new IllegalArgumentException("Необходимо выбрать от 3 до 5 жанров");
        } else {
            this.voteDao.save(performer, genres, comment);
        }
    }

    @Override
    public String calculatePerformerResults() {
        Map<String, Integer> sortedOne = voteDao.mapPerformer();
        List<Map.Entry<String, Integer>> sortedResultList = sortedOne.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> pair : sortedResultList) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            switch (key) {
                case "a1" -> stringBuilder.append("<p>Linkin Park = " + value + " гол.</p>").append("\n");
                case "a2" -> stringBuilder.append("<p>Revolver = " + value + " гол.</p>").append("\n");
                case "a3" -> stringBuilder.append("<p>Mangolia Park = " + value + " гол.</p>").append("\n");
                case "a4" -> stringBuilder.append("<p>Colin = " + value + " гол.</p>").append("\n");
                default -> stringBuilder.append("Такой id группы не существуюет: " + key).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public String calculateGenreResults() {
        Map<String, Integer> sortedTwo = voteDao.mapGenres();
        List<Map.Entry<String, Integer>> list = sortedTwo.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> pair : list) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            switch (key) {
                case "g1" -> stringBuilder.append("<p>Hip-Hop = " + value + " гол.</p>").append("\n");
                case "g2" -> stringBuilder.append("<p>Rock = " + value + " гол.</p>").append("\n");
                case "g3" -> stringBuilder.append("<p>Pop = " + value + " гол.</p>").append("\n");
                case "g4" -> stringBuilder.append("<p>Disco = " + value + " гол.</p>").append("\n");
                case "g5" -> stringBuilder.append("<p>Fusion = " + value + " гол.</p>").append("\n");
                case "g6" -> stringBuilder.append("<p>Classical = " + value + " гол.</p>").append("\n");
                case "g7" -> stringBuilder.append("<p>Electronic = " + value + " гол.</p>").append("\n");
                case "g8" -> stringBuilder.append("<p>Jazz = " + value + " гол.</p>").append("\n");
                case "g9" -> stringBuilder.append("<p>Country = " + value + " гол.</p>").append("\n");
                case "g10" -> stringBuilder.append("<p>Reggae = " + value + " гол.</p>").append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public List<String> commentsList() {
        return voteDao.commentsList();
    }
}
