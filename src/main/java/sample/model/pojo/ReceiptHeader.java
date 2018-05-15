package sample.model.pojo;

import java.sql.Timestamp;

public class ReceiptHeader {
    private int id;
    private int number;
    private Timestamp date;
    private int idStaff;
    private int idUser;

    public ReceiptHeader() {
    }

    public ReceiptHeader(int id, int number, Timestamp date, int idStaff, int idUser) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.idStaff = idStaff;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "ReceiptHeader{" +
                "id=" + id +
                ", number=" + number +
                ", date=" + date +
                ", idStaff=" + idStaff +
                ", idUser=" + idUser +
                '}';
    }
}
