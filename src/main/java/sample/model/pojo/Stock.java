package sample.model.pojo;

import java.util.Date;

public class Stock {
    private int id;
    private Date validaty;
    private double price;
    private int quantity;
    private String placeStorage;
    private double salePrice;
    private int stockBalance;
    private int idInvoice;
    private int idMedicine;
    private int idManifacturer;

    public Stock() {
    }

    public Stock(int id, Date validaty, double price, int quantity, String placeStorage, double salePrice, int stockBalance, int idInvoice, int idMedicine, int idManifacturer) {
        this.id = id;
        this.validaty = validaty;
        this.price = price;
        this.quantity = quantity;
        this.placeStorage = placeStorage;
        this.salePrice = salePrice;
        this.stockBalance = stockBalance;
        this.idInvoice = idInvoice;
        this.idMedicine = idMedicine;
        this.idManifacturer = idManifacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getValidaty() {
        return validaty;
    }

    public void setValidaty(Date validaty) {
        this.validaty = validaty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPlaceStorage() {
        return placeStorage;
    }

    public void setPlaceStorage(String placeStorage) {
        this.placeStorage = placeStorage;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    public int getIdManifacturer() {
        return idManifacturer;
    }

    public void setIdManifacturer(int idManifacturer) {
        this.idManifacturer = idManifacturer;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", validaty=" + validaty +
                ", price=" + price +
                ", quantity=" + quantity +
                ", placeStorage='" + placeStorage + '\'' +
                ", salePrice=" + salePrice +
                ", stockBalance=" + stockBalance +
                ", idInvoice=" + idInvoice +
                ", idMedicine=" + idMedicine +
                ", idManifacturer=" + idManifacturer +
                '}';
    }
}
