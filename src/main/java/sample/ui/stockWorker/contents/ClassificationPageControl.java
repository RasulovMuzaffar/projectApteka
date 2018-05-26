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
import sample.model.dao.ClassificationDao;
import sample.model.dao.ClassificationDaoImpl;
import sample.model.pojo.Classification;

import java.util.List;

public class ClassificationPageControl {
    @FXML
    private TextField txtNameClas;
    @FXML
    private JFXButton btnAddClas;

    @FXML
    private TableView<Classification> clasTable;
    @FXML
    private TableColumn<Classification, String> clasName;
    @FXML
    private TableColumn<Classification, Button> clasEdit;

    @FXML
    public void initialize() {
        ClassificationDao clasDao = new ClassificationDaoImpl();
        List<Classification> list = clasDao.allClassification();

        clasName.setCellValueFactory(new PropertyValueFactory<Classification, String>("name"));
        clasEdit.setCellValueFactory(new PropertyValueFactory<Classification,Button>("btnEdit"));
        clasTable.getItems().setAll(list);

//        supplerName.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    public void btnAddClasAction(ActionEvent event) {
    }
}
