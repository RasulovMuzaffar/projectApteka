package sample.model.dao;

import sample.model.pojo.ExpenseType;

import java.util.List;

public interface ExpenseTypeDao {
    List<ExpenseType> allExpenseType();

    ExpenseType findExpTypeById(int id);

    boolean insertExpType(ExpenseType exp);

    boolean updateExpType(ExpenseType exp);
}
