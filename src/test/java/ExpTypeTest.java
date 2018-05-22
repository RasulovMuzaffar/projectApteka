import org.junit.Test;
import sample.model.dao.ExpenseTypeDao;
import sample.model.dao.ExpenseTypeDaoImpl;
import sample.model.pojo.ExpenseType;

public class ExpTypeTest {
    @Test
    public void insertData(){
        ExpenseTypeDao exp = new ExpenseTypeDaoImpl();

        exp.insertExpType(new ExpenseType("obed","обед килиш учун"));
    }

    @Test
    public void updateData(){
        ExpenseTypeDao exp = new ExpenseTypeDaoImpl();

        exp.updateExpType(new ExpenseType(1,"обед","обед килиш учун"));
    }

    @Test
    public void allData(){
        ExpenseTypeDao exp = new ExpenseTypeDaoImpl();
        System.out.println(exp.allExpenseType());
    }

    @Test
    public void findDataById(){
        ExpenseTypeDao exp = new ExpenseTypeDaoImpl();
        System.out.println(exp.findExpTypeById(2));
    }
}
