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
import sample.model.dao.SupplerDao;
import sample.model.dao.SupplerDaoImpl;
import sample.model.pojo.Suppler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SupplerPageController {

    @FXML
    private TextField txtNameSuppl;
    @FXML
    private TextField txtAddrSuppl;
    @FXML
    private TextField txtPhoneSuppl;
    @FXML
    private TextField txtMailSuppl;
    @FXML
    private JFXButton btnAddSuppl;

    @FXML
    private TableView<Suppler> supplerTable;
    @FXML
    private TableColumn<Suppler, String> supplerName;
    @FXML
    private TableColumn<Suppler, String> supplerAddr;
    @FXML
    private TableColumn<Suppler, String> supplerPhone;
    @FXML
    private TableColumn<Suppler, String> supplerEMail;
    @FXML
    private TableColumn<Suppler, Button> supplerEdit;



    @FXML
    public void initialize() {
        SupplerDao supplerDao = new SupplerDaoImpl();
        List<Suppler> list = supplerDao.getAllSupplers();

        supplerName.setCellValueFactory(new PropertyValueFactory<Suppler, String>("name"));
        supplerAddr.setCellValueFactory(new PropertyValueFactory<Suppler, String>("address"));
        supplerPhone.setCellValueFactory(new PropertyValueFactory<Suppler, String>("phone"));
        supplerEMail.setCellValueFactory(new PropertyValueFactory<Suppler, String>("email"));
        supplerEdit.setCellValueFactory(new PropertyValueFactory<Suppler,Button>("btnEdit"));
        supplerTable.getItems().setAll(list);

        supplerName.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void btnAddSupplAction(ActionEvent event) throws IOException {
        SupplerDao supplerDao = new SupplerDaoImpl();
        Suppler s = new Suppler();
        s.setName(txtNameSuppl.getText());
        s.setAddress(txtAddrSuppl.getText());
        s.setEmail(txtMailSuppl.getText());
        s.setPhone(txtPhoneSuppl.getText());
        supplerDao.insertSuppler(s);

        txtAddrSuppl.setText("");
        txtMailSuppl.setText("");
        txtNameSuppl.setText("");
        txtPhoneSuppl.setText("");

        supplerTable.getItems().add(0,s);
    }

}
