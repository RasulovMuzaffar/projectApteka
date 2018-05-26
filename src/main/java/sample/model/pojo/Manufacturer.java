package sample.model.pojo;

import javafx.scene.control.Button;

import java.io.Serializable;

public class Manufacturer implements Serializable {
    private int id;
    private String state;
    private String name;
    private Button btnEdit;

    public Manufacturer() {
    }
    public Manufacturer(String state, String name) {
        this.state = state;
        this.name = name;
        this.btnEdit = btnEdit;
    }


    public Manufacturer(int id, String state, String name) {
        this.id = id;
        this.state = state;
        this.name = name;
        this.btnEdit = new Button("Изменить");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
