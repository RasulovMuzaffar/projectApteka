import org.junit.Test;
import sample.model.dao.StockDao;
import sample.model.dao.StockDaoImpl;
import sample.model.pojo.Stock;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockTest {
    @Test
    public void insertData() {
        StockDao s = new StockDaoImpl();
        Stock stock = new Stock();
        Stock stock1 = new Stock();

        List<Stock> list = new ArrayList<>();
        stock.setIdInvoice(1);
        stock.setIdManifacturer(1);
        stock.setIdMedicine(1);
        stock.setPlaceStorage("ячейка1");
        stock.setPrice(1000);
        stock.setQuantity(30);
        stock.setSalePrice(1200);
        stock.setStockBalance(30);
        stock.setValidaty(convertDate("01.01.2020"));
        list.add(stock);

        stock1.setIdInvoice(1);
        stock1.setIdManifacturer(1);
        stock1.setIdMedicine(2);
        stock1.setPlaceStorage("ячейка2");
        stock1.setPrice(1000);
        stock1.setQuantity(30);
        stock1.setSalePrice(1200);
        stock1.setStockBalance(100);
        stock1.setValidaty(convertDate("01.01.2021"));
        list.add(stock1);
        for (Stock l : list) {
            s.insertStock(l);
        }
    }

    @Test
    public void allData() {
        StockDao s = new StockDaoImpl();
        for (Stock st : s.allStacks()) {
            System.out.println(st.toString());
        }
    }

    @Test
    public void updateData() {
        StockDao s = new StockDaoImpl();
        Stock stock = s.findById(1);

        stock.setValidaty(convertDate("01.01.2019"));
        stock.setStockBalance(10);
        stock.setPrice(500);
        stock.setSalePrice(700);
        stock.setQuantity(50);

        s.updateStock(stock);
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
