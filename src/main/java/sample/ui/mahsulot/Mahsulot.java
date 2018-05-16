package sample.ui.mahsulot;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mahsulot {

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
        nexter(chiqim, "/sample/ui/chiqim/chiqim.fxml");
        nexter(kirim, "/sample/ui/kirim/kirim.fxml");
        nexter(kup, "/sample/ui/kop/kop.fxml");
        nexter(skidka, "/sample/ui/mahsulot/mahulot.fxml");
        nexter(mahsulot, "/sample/ui/mahsulotlar/mahsulotlar.fxml");
        nexter(muddati, "/sample/ui/muddat/muddat.fxml");
        nexter(xodimlar, "/sample/ui/ruyxatXodim/xodimlar");
        nexter(statistic, "/sample/ui/statistic/statistic.fxml");
    }
    private void nexter(JFXButton mahsulot, String s) {
        mahsulot.setOnAction(event -> {
            try{
                Parent blah = FXMLLoader.load(getClass().getResource(s));
                Scene scene = new Scene(blah);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
