import org.junit.Test;
import sample.model.dao.ManufacturerDao;
import sample.model.dao.ManufacturerDaoImpl;
import sample.model.pojo.Manufacturer;

import java.util.List;

public class ManufacturerTest {
    @Test
    public void addData(){
        ManufacturerDao m = new ManufacturerDaoImpl();
        m.insertManufacturer(new Manufacturer("Uzbekistan","ООО ЙЦУ"));
    }

    @Test
    public void allDatas(){
        ManufacturerDao m = new ManufacturerDaoImpl();
        List<Manufacturer> list = m.allManufacturer();
        for (Manufacturer l : list) {
            System.out.println(l.toString());
        }
    }

    @Test
    public void getDataById(){
        ManufacturerDao m = new ManufacturerDaoImpl();
        System.out.println(m.findById(2));
    }
}
