import org.junit.Test;
import sample.model.dao.ExpenseDao;
import sample.model.dao.ExpenseDaoImpl;
import sample.model.pojo.Expense;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpTest {
    //(date, amount, description, id_exp_type, id_staff)
    @Test
    public void insertData() {
        ExpenseDao exp = new ExpenseDaoImpl();
        exp.insertExp(new Expense(new Timestamp(System.currentTimeMillis()), 11.00, "blablabla", 1, 3));
    }

    @Test
    public void updateData() {
        ExpenseDao exp = new ExpenseDaoImpl();
        exp.updateExp(new Expense(1, new Timestamp(System.currentTimeMillis()), 101.00, "blablabla", 1, 3));
    }

    @Test
    public void allData() {
        ExpenseDao exp = new ExpenseDaoImpl();
        System.out.println(exp.allExpenses());
    }

    @Test
    public void findById() {
        ExpenseDao exp = new ExpenseDaoImpl();
        System.out.println(exp.findExpenseById(1));
    }

    @Test
    public void findByIdStaff() {
        ExpenseDao exp = new ExpenseDaoImpl();
        System.out.println(exp.findExpensesByIdStaff(3));
    }

    @Test
    public void findByIdExpType() {
        ExpenseDao exp = new ExpenseDaoImpl();
        System.out.println(exp.findExpensesByIdExpType(1));
    }

    @Test
    public void findByBtwDate() {
        ExpenseDao exp = new ExpenseDaoImpl();
        System.out.println(exp.findExpensesByBetweenDate(convertDate("01.01.2018"), new Timestamp(System.currentTimeMillis())));
    }

    private Timestamp convertDate(String str) {
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date parsedDate = dateFormat.parse(str);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception e) { //this generic but you can control another types of exception
            // look the origin of excption
            System.out.println(e);
        }
        System.out.println(timestamp);
        return timestamp;
    }
}
