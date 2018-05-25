package sample.model.dao;

import sample.model.pojo.ReceiptHeader;

import java.util.List;

public interface ReceiptHeaderDao {
    List<ReceiptHeader> allReceiptHeader();

    ReceiptHeader findById(int id);

    boolean insertReceiptHeader (ReceiptHeader receiptHeader);

    boolean updateReceiptHeader (ReceiptHeader receiptHeader);

    int maxSize();

}
