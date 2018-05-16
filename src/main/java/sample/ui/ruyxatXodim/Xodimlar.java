package sample.ui.ruyxatXodim;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Xodimlar {

    public JFXButton statistic;
    public JFXButton kirim;
    public JFXButton kup;
    public JFXButton chiqim;
    public JFXButton muddati;
    public JFXButton skidka;
    public JFXButton xodimlar;
    public JFXButton mahsulot;

    @FXML
    public void initialize(){
        nexter(statistic, "/sample/ui/statistic.fxml");
        nexter(kirim, "/sample/ui/kirim.fxml");
        nexter(kup, "/sample/ui/kup.fxml");
        nexter(chiqim, "/sample/ui/chiqim.fxml");
        nexter(muddati, "/sample/ui/muddat.fxml");
        nexter(skidka, "/sample/ui/skidka.fxml");
        nexter(xodimlar, "/sample/ui/xodimlar.fxml");
        nexter(mahsulot, "/sample/ui/mahsulot.fxml");

    }

    private void nexter(JFXButton mahsulot, String s) {
        mahsulot.setOnAction(event -> {
            try{
                Parent blah = FXMLLoader.load(getClass().getResource(s));
                Scene scene = new Scene(blah);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }catch (Exception e){}
        });
    }
}
