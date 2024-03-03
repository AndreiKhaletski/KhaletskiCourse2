package by.id_academy.jd2.first.dao;

import by.id_academy.jd2.first.dao.api.IVoteDao;
import java.util.*;
import static java.util.stream.Collectors.toMap;

public class VoteDAO implements IVoteDao {

    private final List<String> listPerformer = new ArrayList<>();
    private final List<String> listGenres = new ArrayList<>();
    private final List<String> commentsList = new ArrayList<>();
    private Map<String, Integer> mapPerformer;
    private Map<String, Integer> mapGenres;


    @Override
    public void save(String performer, String[] genres, String comment) {

        listPerformer.add(performer);
        listGenres.addAll(Arrays.asList(genres));
        commentsList.add(comment);

        this.mapPerformer = listPerformer.stream().collect(toMap(e -> e, e -> 1, Integer::sum));
        this.mapGenres = listGenres.stream().collect(toMap(e -> e, e -> 1, Integer::sum));
    }

    @Override
    public List<String> commentsList() {
        return this.commentsList;
    }

    @Override
    public Map<String, Integer> mapPerformer() {
        return mapPerformer;
    }

    @Override
    public Map<String, Integer> mapGenres() {
        return mapGenres;
    }
}
