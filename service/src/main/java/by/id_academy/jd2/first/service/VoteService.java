package by.id_academy.jd2.first.service;

import by.id_academy.jd2.first.dao.VoteDAO;
import by.id_academy.jd2.first.dao.api.IVoteDao;
import by.id_academy.jd2.first.service.api.IVoteService;
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
    public List<Map.Entry<String, Integer>> mapCollectPerfomer() {
        Map<String, Integer> sortedOne = voteDao.mapPerformer();
        return sortedOne.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();
    }

    @Override
    public List<Map.Entry<String, Integer>> mapCollectGenres() {
        Map<String, Integer> sortedTwo = voteDao.mapGenres();
        return sortedTwo.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList();
    }
}
