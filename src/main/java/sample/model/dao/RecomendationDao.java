package sample.model.dao;

import sample.model.pojo.Recomendation;

import java.util.List;

public interface RecomendationDao {
    List<Recomendation> allRecom();

    Recomendation findById(int id);

    boolean insertRecom(Recomendation recomendation);

    boolean updateRecom(Recomendation recomendation);
}
