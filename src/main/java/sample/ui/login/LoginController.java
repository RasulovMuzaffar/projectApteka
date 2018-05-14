package sample.ui.login;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.database.DatabaseHandler;
import sample.model.dao.StaffDao;
import sample.model.dao.StaffDaoImpl;
import sample.model.pojo.Staff;

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

    public void btnLoginAction(ActionEvent event) {

        StaffDao sd = new StaffDaoImpl();
        Staff staff = sd.getStaffByLoginPassword(txtLogin.getText(), txtPassword.getText());
        if (staff != null) {
            switch (staff.getIdRole()) {
                case 1:
                    lblInfo.setText("very good! you are system admin!" + txtLogin.getText());
                    break;
                case 2:
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
}
