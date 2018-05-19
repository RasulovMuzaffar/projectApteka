package sample.model.dao;

import sample.model.pojo.Staff;

import java.util.List;

public interface StaffDao {
//    List<Staff> allStaff();
//
//    Staff getStaffByLoginPassword(String login, String password);
//
//    Staff getStaffById(int id);

    List<Staff> findAllStaffs();
}
