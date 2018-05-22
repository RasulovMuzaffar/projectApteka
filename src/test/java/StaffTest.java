import org.junit.Test;
import sample.model.dao.StaffDao;
import sample.model.dao.StaffDaoImpl;
import sample.model.pojo.Staff;

import java.util.List;

public class StaffTest {
    @Test
    public void testAllStaffs() {
        StaffDao s = new StaffDaoImpl();

        System.out.println(s.getStaffById(1));
    }

    @Test
    public void findStaffByLoginPassword() {
        StaffDao sd = new StaffDaoImpl();

        System.out.println(sd.findStaffByLoginPassword("admin", "admin"));
    }

    @Test
    public void findStaffByRoleId() {
        StaffDao sd = new StaffDaoImpl();
        System.out.println(sd.findStaffByRoleId(1));
    }

    @Test
    public void insertStaff() {
        //first_name, last_name, login, password, phone, email, role_id
        StaffDao sd = new StaffDaoImpl();
        sd.insertStaff(new Staff("seller", "seller", "seller", "seller", "1234567", "seller@gmail.com", 4));
    }

    @Test
    public void updateStaff() {
        StaffDao sd = new StaffDaoImpl();
        sd.updateStaff(new Staff(3, "seller", "seller", "seller", "seller", "123", "seller@gmail.com", 4));
    }

    @Test
    public void allStaffs(){
        StaffDao sd = new StaffDaoImpl();
        List<Staff> list = sd.allStaff();

        for (Staff s:list) {
            System.out.println(s.toString());
        }

    }
}
