package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class ClienteGui extends Application {
    
   // ConstantsElements constantsElements = new ConstantsElements();
    
    @Override
    public void start(Stage stage) throws Exception {
        MainMenuBar mainMenuBar = new MainMenuBar();
        //Image image = new Image("file:src/image/icono.png");
        stage.setResizable(false);//Para que no pueda reajustar tamaño
       // stage.getIcons().add(image);
        stage.setTitle("Sistema de inventarios DieAle S.A");
        stage.setScene(mainMenuBar.getMainScene());
       // constantsElements.soundPlayer("ini");
        stage.show();
    }//end Start

    public void display() {
        launch();
    }//end display

}//end main interface