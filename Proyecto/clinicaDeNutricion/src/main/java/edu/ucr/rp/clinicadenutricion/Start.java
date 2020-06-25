package edu.ucr.rp.clinicadenutricion;

import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.MainMenuBarSesion;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainMenuBarSesion mainMenuBar = new MainMenuBarSesion();
        Image image = new Image("file:src/image/sesIni.png");
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.setTitle("Clínica SusanaDistancia S.A");
        stage.setScene(mainMenuBar.getMainScene());
        stage.show();
    }//end Start

    public void display() {
        launch();
    }//end display

}//end inicioSsionGui
