import org.junit.Test;
import sample.model.dao.InvoiceHeaderDao;
import sample.model.dao.InvoiceHeaderDaoImpl;
import sample.model.pojo.InvoiceHeader;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InvoiceTest {
    @Test
    public void insertInvoice() {
        //int id, String numb, Date date, int idSuppler, int idStaff
        InvoiceHeaderDao ihd = new InvoiceHeaderDaoImpl();
        InvoiceHeader i = new InvoiceHeader();
        i.setNumb("123");
        i.setDate(new Date());
        i.setIdStaff(1);
        i.setIdSuppler(1);

        if(ihd.insertInvHead(i)) System.out.println("data is inserting");
    }

    @Test
    public void allData(){
        InvoiceHeaderDao ihd = new InvoiceHeaderDaoImpl();
        System.out.println(ihd.findAll());
    }

    @Test
    public void findById(){
        InvoiceHeaderDao ihd = new InvoiceHeaderDaoImpl();
        System.out.println(ihd.findById(1));
    }

    @Test
    public void findByDate(){
        InvoiceHeaderDao ihd = new InvoiceHeaderDaoImpl();
        System.out.println(ihd.findByDate(convertDate("01.01.2018"), convertDate("24.06.2018")));
    }

    private Timestamp convertDate(String str) {
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date parsedDate = dateFormat.parse(str);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception e) { //this generic but you can control another types of exception
            // look the origin of excption
            System.out.println(e);
        }
        System.out.println(timestamp);
        return timestamp;
    }
}
