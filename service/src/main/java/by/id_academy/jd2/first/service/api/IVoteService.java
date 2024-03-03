package by.id_academy.jd2.first.service.api;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface IVoteService {
    void save(String performer, String[] genres, String comment);

    void printPerformerResults(PrintWriter writer);
    void printGenreResults(PrintWriter writer);
    void printCommentResults(PrintWriter writer);

    List<Map.Entry<String, Integer>> mapCollectGenres();

    List<String> commentsList();
}
