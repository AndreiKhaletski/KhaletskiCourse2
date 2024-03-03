package by.id_academy.jd2.first.service.api;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface IVoteService {
    void save(String performer, String[] genres, String comment);

    String calculatePerformerResults();

    String calculateGenreResults();

    List<String> commentsList();
}
