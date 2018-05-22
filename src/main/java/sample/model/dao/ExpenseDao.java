package sample.model.dao;

import sample.model.pojo.Expense;

import java.sql.Timestamp;
import java.util.List;

public interface ExpenseDao {
    List<Expense> allExpenses();

    Expense findExpenseById(int id);

    List<Expense> findExpensesByIdStaff(int id);

    List<Expense> findExpensesByIdExpType(int id);

    List<Expense> findExpensesByBetweenDate(Timestamp oldDate, Timestamp currDate);

    boolean insertExp(Expense expense);

    boolean updateExp(Expense expense);
}
