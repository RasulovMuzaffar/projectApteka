package sample.model.dao;

import sample.model.pojo.Classification;

import java.util.List;

public interface ClassificationDao {
    List<Classification> allClassification();

    Classification findById(int id);

    boolean insertClf(Classification classification);

    boolean updateClf(Classification classification);
}
