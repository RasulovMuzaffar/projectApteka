import org.junit.Test;
import sample.model.dao.StaffDao;
import sample.model.dao.StaffDaoImpl;
import sample.model.pojo.Staff;

public class StaffTest {
    @Test
    public void testAllStaffs(){
        StaffDao s = new StaffDaoImpl();

        System.out.println(s.findAllStaffs());
    }
}
