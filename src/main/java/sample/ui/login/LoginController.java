package sample.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.model.dao.StaffDao;
import sample.model.dao.StaffDaoImpl;
import sample.model.pojo.Staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginController {

    public Label lblInfo;
    public TextField txtLogin;
    public PasswordField txtPassword;
    public Button btnLogin;

    public void btnLoginAction(ActionEvent event) throws IOException {

        StaffDao sd = new StaffDaoImpl();
        Staff staff = sd.getStaffByLoginPassword(txtLogin.getText(), txtPassword.getText());
        if (staff != null) {
            //idRole : {admin:1, manager:2, stockworker:3}
            switch (staff.getIdRole()) {
                case 1:
                    lblInfo.setText("very good! you are system admin!" + txtLogin.getText());
                    //Close current
//                    Stage stage = (Stage) button.getScene().getWindow();
                    // do what you have to do
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    stage.close();
                    Stage stage1 = new Stage();
                    getAdminPage(stage1);
                    break;
                case 2:
                    lblInfo.setText("very good! you are manager!" + txtLogin.getText());
                    break;
                case 3:
                    lblInfo.setText("very good! you are stock worker!" + txtLogin.getText());
                    break;
                default:
                    lblInfo.setText("who are you?" + txtLogin.getText());
                    break;
            }
        } else {
            lblInfo.setText("invalid login or password!!!");
        }
    }

    private void getAdminPage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/ui/admin/admin.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Другая форма");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
