package by.id_academy.jd2.first.service;

import by.id_academy.jd2.first.dao.VoteDAO;
import by.id_academy.jd2.first.dao.api.IVoteDao;
import by.id_academy.jd2.first.service.api.IVoteService;

import java.io.PrintWriter;
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
    public List<String> commentsList() {
        return voteDao.commentsList();
    }

    @Override
    public void printPerformerResults(PrintWriter writer) {
        Map<String, Integer> sortedOne = voteDao.mapPerformer();
        List<Map.Entry<String, Integer>> sortedResultList = sortedOne.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        for (Map.Entry<String, Integer> pair : sortedResultList) {
            String key = pair.getKey();
            Integer value = pair.getValue();

            switch (key) {
                case "a1" -> writer.write("<p>Linkin Park = " + value + " гол.</p>");
                case "a2" -> writer.write("<p>Revolver = " + value + " гол.</p>");
                case "a3" -> writer.write("<p>Mangolia Park = " + value + " гол.</p>");
                case "a4" -> writer.write("<p>Colin = " + value + " гол.</p>");
            }
        }
    }

    @Override
    public void printGenreResults(PrintWriter writer) {
        Map<String, Integer> sortedTwo = voteDao.mapGenres();
        List<Map.Entry<String, Integer>> list = sortedTwo.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();

        for (Map.Entry<String, Integer> pair : list) {
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
    }

    @Override
    public void printCommentResults(PrintWriter writer) {

    }

    @Override
    public List<Map.Entry<String, Integer>> mapCollectGenres() {
        Map<String, Integer> sortedTwo = voteDao.mapGenres();
        return sortedTwo.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();
    }


}
