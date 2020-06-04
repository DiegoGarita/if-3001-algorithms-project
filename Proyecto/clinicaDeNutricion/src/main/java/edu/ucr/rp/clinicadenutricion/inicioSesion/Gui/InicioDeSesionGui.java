package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InicioDeSesionGui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainMenuBar mainMenuBar = new MainMenuBar();
        Image image = new Image("file:src/image/sesIni.png");
        stage.setResizable(false);//Para que no pueda reajustar tamaño
        stage.getIcons().add(image);
        stage.setTitle("Clinica SusanaDistancia S.A");
        stage.setScene(mainMenuBar.getMainScene());
        stage.show();
    }//end Start

    public void display() {
        launch();
    }//end display

}//end inicioSsionGui
