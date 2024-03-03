package by.id_academy.jd2.first.service.api;

import java.util.List;
import java.util.Map;

public interface IVoteService {
    void save(String performer, String[] genres, String comment);

    List<Map.Entry<String, Integer>> mapCollectPerfomer();

    List<Map.Entry<String, Integer>> mapCollectGenres();

    List<String> commentsList();
}
