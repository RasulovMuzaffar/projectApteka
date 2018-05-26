package sample.ui.stockWorker.contents;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.model.dao.ManufacturerDao;
import sample.model.dao.ManufacturerDaoImpl;
import sample.model.pojo.Manufacturer;

import java.util.List;

public class ManufacturerPageControl {

    @FXML
    private TextField txtStateMan;
    @FXML
    private TextField txtNameMan;
    @FXML
    private JFXButton btnAddManufact;

    @FXML
    private TableView<Manufacturer> manufactTable;
    @FXML
    private TableColumn<Manufacturer, String> manState;
    @FXML
    private TableColumn<Manufacturer, String> manName;
    @FXML
    private TableColumn<Manufacturer, Button> manEdit;

    public void initialize() {
        ManufacturerDao md = new ManufacturerDaoImpl();
        List<Manufacturer> list = md.allManufacturer();

        manName.setCellValueFactory(new PropertyValueFactory<Manufacturer, String>("name"));
        manState.setCellValueFactory(new PropertyValueFactory<Manufacturer, String>("state"));
        manEdit.setCellValueFactory(new PropertyValueFactory<Manufacturer, Button>("btnEdit"));

        manufactTable.getItems().setAll(list);

//        supplerName.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void btnAddManAction(ActionEvent event) {
        ManufacturerDao md = new ManufacturerDaoImpl();
        Manufacturer m = new Manufacturer();
        m.setName(txtNameMan.getText());
        m.setState(txtStateMan.getText());
        md.insertManufacturer(m);

        txtNameMan.setText("");
        txtStateMan.setText("");

        manufactTable.getItems().add(0,m);
    }
}
