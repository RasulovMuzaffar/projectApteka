import org.junit.Test;
import sample.model.dao.MedicineDao;
import sample.model.dao.MedicineDaoImpl;
import sample.model.pojo.Medicine;

public class MedicineTest {
    @Test
    public void addData(){
        MedicineDao m = new MedicineDaoImpl();

        Medicine med = new Medicine();

        med.setBarCode("123456789");
        med.setIdClass(1);
        med.setIdRecommend(1);
        med.setNameEn("Analgin");
        med.setNameRu("Аналгин");

        m.insertMedicine(med);
    }

    @Test
    public void editData(){
        MedicineDao m = new MedicineDaoImpl();
        Medicine med = m.findById(1);
        med.setNameRu("Аналгин");
        med.setNameEn("Analgin");

        System.out.println(med.toString());
        m.updateMedicine(med);
    }
}
