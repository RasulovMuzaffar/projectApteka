package sample.model.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class InvoiceHeader implements Serializable {
    private int id;
    private String numb;
    private Date date;
    private int idSuppler;
    private int idStaff;
    private Timestamp inputDate;

    public InvoiceHeader() {
    }

    public InvoiceHeader(int id, String numb, Date date, int idSuppler, int idStaff, Timestamp inputDate) {
        this.id = id;
        this.numb = numb;
        this.date = date;
        this.idSuppler = idSuppler;
        this.idStaff = idStaff;
        this.inputDate = inputDate;
    }

    public InvoiceHeader(String numb, Date date, int idSuppler, int idStaff) {
        this.numb = numb;
        this.date = date;
        this.idSuppler = idSuppler;
        this.idStaff = idStaff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdSuppler() {
        return idSuppler;
    }

    public void setIdSuppler(int idSuppler) {
        this.idSuppler = idSuppler;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public Timestamp getInputDate() {
        return inputDate;
    }

    public void setInputDate(Timestamp inputDate) {
        this.inputDate = inputDate;
    }

    @Override
    public String toString() {
        return "InvoiceHeaderDao{" +
                "id=" + id +
                ", numb='" + numb + '\'' +
                ", date=" + date +
                ", idSuppler=" + idSuppler +
                ", idStaff=" + idStaff +
                ", inputDate=" + inputDate +
                '}';
    }
}
