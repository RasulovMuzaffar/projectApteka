package sample.model.dao;

import sample.model.pojo.Role;
import sample.model.pojo.Staff;

import java.util.List;

public interface StaffDao {
    List<Staff> allStaff();

    Staff findStaffByLoginPassword(String login, String password);

    Staff getStaffById(int id);

    List<Staff> findStaffByRoleId(int id);

    boolean insertStaff(Staff staff);

    boolean updateStaff(Staff staff);

//    List<Staff> findAllStaffs();
}
