package sample.model.pojo;

import java.sql.Timestamp;

public class Expense {
    private int id;
    private Timestamp date;
    private double amount;
    private String descripton;
    private int idExpType;
    private int idStaff;

    public Expense() {
    }

    public Expense(int id, Timestamp date, double amount, String descripton, int idExpType, int idStaff) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.descripton = descripton;
        this.idExpType = idExpType;
        this.idStaff = idStaff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public int getIdExpType() {
        return idExpType;
    }

    public void setIdExpType(int idExpType) {
        this.idExpType = idExpType;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", descripton='" + descripton + '\'' +
                ", idExpType=" + idExpType +
                ", idStaff=" + idStaff +
                '}';
    }
}
