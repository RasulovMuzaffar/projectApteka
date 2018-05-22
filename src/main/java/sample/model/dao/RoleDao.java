package sample.model.dao;

import sample.model.pojo.Role;

import java.util.List;

public interface RoleDao {
    List<Role> allRoles();

    Role findRoleById(int id);
}
