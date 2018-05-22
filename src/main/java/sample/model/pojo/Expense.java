package sample.model.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Expense implements Serializable{
    private int id;
    private Timestamp date;
    private double amount;
    private String description;
    private int idExpType;
    private int idStaff;

    public Expense(int id, Timestamp date, double amount, String description, int idExpType, int idStaff) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.idExpType = idExpType;
        this.idStaff = idStaff;
    }

    public Expense(Timestamp date, double amount, String description, int idExpType, int idStaff) {
        this.date = date;
        this.amount = amount;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", description='" + description + '\'' +
                ", idExpType=" + idExpType +
                ", idStaff=" + idStaff +
                '}';
    }
}
