import org.junit.Test;
import sample.model.dao.ReceiptDataDao;
import sample.model.dao.ReceiptDataDaoImpl;
import sample.model.dao.ReceiptHeaderDao;
import sample.model.dao.ReceiptHeaderDaoImpl;
import sample.model.pojo.ReceiptData;
import sample.model.pojo.ReceiptHeader;

import java.util.ArrayList;
import java.util.List;

public class ReceiptTest {
    @Test
    public void allReceiptsHead() {
        ReceiptHeaderDao r = new ReceiptHeaderDaoImpl();
        System.out.println(r.allReceiptHeader());
    }

    @Test
    public void insertRH() {
        ReceiptHeaderDao r = new ReceiptHeaderDaoImpl();
        ReceiptHeader rh = new ReceiptHeader();
        rh.setNumber(r.maxSize());
        rh.setIdStaff(3);
        r.insertReceiptHeader(rh);
    }

    @Test
    public void insertRB(){
        ReceiptDataDao rdd = new ReceiptDataDaoImpl();
        ReceiptData rd1 = new ReceiptData();
        ReceiptData rd2 = new ReceiptData();

        List<ReceiptData> list = new ArrayList<>();

        rd1.setIdStock(1);
        rd1.setPrice(800);
        rd1.setQuantity(10);
        rd1.setIdReceipt(1);
        list.add(rd1);

        rd1.setIdStock(2);
        rd1.setPrice(1200);
        rd1.setQuantity(10);
        rd1.setIdReceipt(2);
        list.add(rd2);

        for (ReceiptData r : list) {
            rdd.insertReceiptData(r);
        }
    }
}
