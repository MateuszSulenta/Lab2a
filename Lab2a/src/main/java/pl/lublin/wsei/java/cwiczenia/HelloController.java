package pl.lublin.wsei.java.cwiczenia;

import javafx.application.HostServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class HelloController {


    @FXML
    private Label welcomeText;
    private Infografika selInfografika;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public Label lbFile;
    public ListView lstInfografiki;
    public TextField txtAdresStrony;
    public Button btnPokazInfografike;
    public Button btnPrzejdzDoStrony;
    ImageIcon imgMiniaturka;

    GusInfoGraphicList igList;
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter xmlFilter = new FileChooser.ExtensionFilter("Pliki XML (*xml)", "*.xml");
    ObservableList<String> tytuly = FXCollections.observableArrayList();


    @FXML
    public void initialize(){
        fileChooser.getExtensionFilters().add(xmlFilter);
        lstInfografiki.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>(){
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                        int index = t1.intValue();
                        if (index != -1) {
                            selInfografika = igList.infografiki.get(index);
                            txtAdresStrony.setText(igList.infografiki.get(index).AdresStrony);
                            Image image = new Image(igList.infografiki.get(index).adresMiniaturki);
                        }
                        else {
                            txtAdresStrony.setText("");
                            imgMiniaturka.setImage(null);
                            Object selfInfografika = null;
                            selInfografika = null;
                        }
                        

                    }
                }
        );
    }

    public void btnOpenFIleAction(ActionEvent actionEvent) {
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            igList = new GusInfoGraphicList(file.getAbsolutePath());
            lbFile.setText(file.getAbsolutePath());
            for (Infografika ig: igList.infografiki) tytuly.add(ig.tytul);
            lstInfografiki.setItems(tytuly);
        }
        else {
            lbFile.setText("Proszę wczytać plik...");
        }
    }
    public void btnZaladujStrone(ActionEvent actionEvent) {
        if (selInfografika != null)
            hostServices.showDocument(selInfografika.adresStrony);
    }
    private Stage stage;
    private HostServices hostServices;
            public void setStage(Stage stage) {
                this.stage = stage;
            }
        public void setHostServices(HostServices hostServices){
            this.hostServices = hostServices;
                }

                public void btnPokazOnAction(ActionEvent actionEvent){
                try{
                    FXMLLoader loader = new FXMLoader(getClass().getResource("imgViewer.fxml"));
                    Parent root = loader.load();
                    ImgViewer viewer = loader.getController();
                            if (selInfografika != null) {
                                Image img = new Image(selInfografika.adresGrafiki);
                                viewer.imgView.setFitWidth(img.getWidth());
                                viewer.imgView.setFitHeight(img.getHeight());
                                viewer.imgView.setImage(img);

                            }
                            Stage stage = new Stage();
                            stage.setTitle("Podgląd infografiki");
                            stage.setScene(new Scene(root, 900, 800));
                            stage.show();


                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
                }

}
