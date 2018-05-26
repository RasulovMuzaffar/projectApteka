package sample.ui.stockWorker.contents;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.model.dao.ClassificationDao;
import sample.model.dao.ClassificationDaoImpl;
import sample.model.dao.MedicineDao;
import sample.model.dao.MedicineDaoImpl;
import sample.model.pojo.Classification;
import sample.model.pojo.Medicine;
import sample.model.pojo.Suppler;

import java.util.List;

public class MedicinePage {
    @FXML
    private TextField txtNameRu;
    @FXML
    private TextField txtNameEn;
    @FXML
    private TextField txtBarCode;
    @FXML
    private JFXComboBox cbClas;


    @FXML
    private TableView<Medicine> medTable;
    @FXML
    private TableColumn<Medicine, String> nameRu;
    @FXML
    private TableColumn<Medicine, String> nameEn;
    @FXML
    private TableColumn<Medicine, String> barcode;
    @FXML
    private TableColumn<Medicine, Button> medEdit;

    @FXML
    public void initialize() {
        MedicineDao medicineDao = new MedicineDaoImpl();
        List<Medicine> list = medicineDao.allMedicine();

        nameRu.setCellValueFactory(new PropertyValueFactory<Medicine, String>("nameRu"));
        nameEn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("nameEn"));
        barcode.setCellValueFactory(new PropertyValueFactory<Medicine, String>("barCode"));
        medEdit.setCellValueFactory(new PropertyValueFactory<Medicine, Button>("btnEdit"));
        medTable.getItems().setAll(list);

//        supplerName.setCellFactory(TextFieldTableCell.forTableColumn());

        ClassificationDao clasDao = new ClassificationDaoImpl();
        List<Classification> lc = clasDao.allClassification();

        ObservableList<Classification> observableList = FXCollections.observableList(lc);

        for (Classification c : lc) {
            cbClas.getItems().add(c.getName());
        }
        cbClas.getSelectionModel().selectFirst();
    }


    public void btnAddMedAction(ActionEvent event) {
//        MedicineDao md= new MedicineDaoImpl();
//        Medicine m = new Medicine();
//        m.setNameRu(txtNameRu.getText());
//        m.setNameEn(txtNameEn.getText());
//        m.setBarCode(txtBarCode.getText());
//        md.insertMedicine(m);
//
//        txtNameRu.setText("");
//        txtNameEn.setText("");
//        txtBarCode.setText("");
//
//        medTable.getItems().add(0,m);
        System.out.println(cbClas.getValue());
    }
}
