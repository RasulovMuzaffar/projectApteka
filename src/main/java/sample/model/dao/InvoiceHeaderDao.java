package sample.model.dao;

import sample.model.pojo.InvoiceHeader;

import java.sql.Timestamp;
import java.util.List;

public interface InvoiceHeaderDao {
    List<InvoiceHeader> findAll();

    InvoiceHeader findById(int id);

    boolean insertInvHead(InvoiceHeader invoiceHeader);

    boolean updateInvHead(InvoiceHeader invoiceHeader);

    List<InvoiceHeader> findByIdSupplier(int idSupplier);

    List<InvoiceHeader> findByIdStaff(int idStaff);

    List<InvoiceHeader> findByDate(Timestamp d1, Timestamp d2);
}
