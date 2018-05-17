import org.junit.Test;
import sample.model.dao.SupplerDao;
import sample.model.dao.SupplerDaoImpl;
import sample.model.pojo.Suppler;

public class SupplerTest {
    @Test
    public void testInsertData() {
        SupplerDao sd = new SupplerDaoImpl();
        //name, address, phone, email
        Suppler suppler = new Suppler(1,"test","test","test","test");

        sd.insertSuppler(suppler);
    }

    @Test
    public void testUpdateData(){
        SupplerDao sd = new SupplerDaoImpl();
        //name, address, phone, email
        Suppler suppler = new Suppler(1,"testU","testU","testU","testU");

        sd.updateSuppler(suppler);
    }

    @Test
    public void testAllSupplers(){
        SupplerDao sd = new SupplerDaoImpl();
        //name, address, phone, email

        System.out.println(sd.getAllSupplers());
    }

    @Test
    public void testFindSupplerById(){
        SupplerDao sd = new SupplerDaoImpl();
        //name, address, phone, email

        System.out.println(sd.findSupplerById(1).toString());
    }
}
