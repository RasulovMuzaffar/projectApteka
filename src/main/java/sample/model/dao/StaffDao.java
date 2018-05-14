package sample.model.dao;

import sample.model.pojo.Staff;

import java.util.List;

public interface StaffDao {
    public List<Staff> allStaff();

    Staff getStaffByLoginPassword(String login, String password);
}
