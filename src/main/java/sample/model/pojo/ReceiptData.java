package sample.model.pojo;

public class ReceiptData {
    private int id;
    private int quantity;
    private double price;
    private int idReceipt;
    private int idStock;

    public ReceiptData() {
    }

    public ReceiptData(int id, int quantity, double price, int idReceipt, int idStock) {
        this.id = id;
        this.idReceipt = idReceipt;
        this.idStock = idStock;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ReceiptData{" +
                "id=" + id +
                ", idReceipt=" + idReceipt +
                ", idStock=" + idStock +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
