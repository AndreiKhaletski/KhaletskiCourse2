package by.id_academy.jd2.first.dao.api;

import java.util.List;
import java.util.Map;

public interface IVoteDao {

    void save(String performer, String[] genres, String comment);

    Map<String, Integer> mapPerformer();

    Map<String, Integer> mapGenres();

    List<String> commentsList();
}
