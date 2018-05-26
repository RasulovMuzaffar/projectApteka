package sample.model.pojo;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;

import java.io.Serializable;

public class Suppler implements Serializable {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Button btnEdit;

    public Suppler() {
    }

    public Suppler(int id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.btnEdit = new Button("Edit");
    }

//    public Suppler(int id, String name, String address, String phone, String email, JFXButton btnEdit) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.email = email;
//        this.btnEdit = btnEdit;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    @Override
    public String toString() {
        return "Suppler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
