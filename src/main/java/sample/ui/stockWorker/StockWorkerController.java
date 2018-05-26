package sample.ui.stockWorker;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sample.model.dao.SupplerDao;
import sample.model.dao.SupplerDaoImpl;
import sample.model.pojo.Staff;
import sample.model.pojo.Suppler;

import java.io.IOException;
import java.util.List;

public class StockWorkerController {
    @FXML
    private Label lblInfoUsr;
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
    private BorderPane borderPane;

    @FXML
    private JFXButton btnSuppler;
    @FXML
    private JFXButton btnManufact;
    @FXML
    private JFXButton btnInvoice;
    @FXML
    private JFXButton btnMedicine;
    @FXML
    private JFXButton btnStock;

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

    private Staff staff;

    public void userInfo(Staff stf) {
        staff = stf;
        lblInfoUsr.setText("Здравствуйте, " + staff.getFirstName() + " " + staff.getLastName());
//        try {
//            Parent dashboard = FXMLLoader.load(getClass().getResource("supplerPage.fxml"));
//            borderPane.setCenter(dashboard);
////        installizeTable();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        inizializeContent();
    }

    private void inizializeContent() {

    }

    private void installizeTable() {
//        SupplerDao supplerDao = new SupplerDaoImpl();
//        List<Suppler> list = supplerDao.getAllSupplers();
//
//        supplerName.setCellValueFactory(new PropertyValueFactory<Suppler, String>("name"));
//        supplerAddr.setCellValueFactory(new PropertyValueFactory<Suppler, String>("address"));
//        supplerPhone.setCellValueFactory(new PropertyValueFactory<Suppler, String>("phone"));
//        supplerEMail.setCellValueFactory(new PropertyValueFactory<Suppler, String>("email"));
//        supplerTable.getItems().setAll(list);
//
//        supplerName.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void changeNameCellEvent(TableColumn.CellEditEvent editEvent) {
        Suppler supplerSelected = supplerTable.getSelectionModel().getSelectedItem();
        supplerSelected.setName(editEvent.getNewValue().toString());
    }

//    public void btnAddSupplAction(ActionEvent event) throws IOException {
//        SupplerDao supplerDao = new SupplerDaoImpl();
//        Suppler s = new Suppler();
//        s.setName(txtNameSuppl.getText());
//        s.setAddress(txtAddrSuppl.getText());
//        s.setEmail(txtMailSuppl.getText());
//        s.setPhone(txtPhoneSuppl.getText());
//        supplerDao.insertSuppler(s);
//        txtAddrSuppl.setText("");
//        txtMailSuppl.setText("");
//        txtNameSuppl.setText("");
//        txtPhoneSuppl.setText("");
//        installizeTable();
//    }

    //    @FXML
    public void show_dashboard_suppler(MouseEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("contents/supplerPage.fxml"));
        borderPane.setCenter(dashboard);
    }

    public void show_dashboard_manufact(MouseEvent event) {

    }

    public void show_dashboard_invoice(MouseEvent event) {
    }

    public void show_dashboard_medicine(MouseEvent event) {
    }

    public void show_dashboard_stock(MouseEvent event) {
    }
}
