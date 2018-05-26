package sample.model.pojo;

import javafx.scene.control.Button;

import java.io.Serializable;

public class Classification implements Serializable{
    private int id;
    private String name;
    private Button btnEdit;

    public Classification() {
    }

    public Classification(int id, String name) {
        this.id = id;
        this.name = name;
        this.btnEdit=new Button("Изменить");
    }

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

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
