import org.junit.Test;
import sample.model.dao.RoleDao;
import sample.model.dao.RoleDaoImpl;

public class RoleTest {
    @Test
    public void findRoleById(){
        RoleDao rd = new RoleDaoImpl();
        System.out.println(rd.findRoleById(1));
    }

    @Test
    public void findAllRoles(){
        RoleDao rd = new RoleDaoImpl();
        System.out.println(rd.allRoles());
    }

}
