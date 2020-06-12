package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

//En esta clase se colocara informacion basica del app

import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class AcercaDe {
    
        LogoApp logo = new LogoApp();


    /**
     * 
     * @return Nos da la GUI que contiene información básica del app
     */
    public GridPane getGraphicalUserInterfaceAbout() {
        GridPane about = new GridPane();
        about.setMinSize(600, 700);
        about.setVgap(15); 
        about.setHgap(15);
        about.setAlignment(Pos.TOP_LEFT);
        about.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));


        Text title = new Text(200, 200, "Acerca de la aplicación: Control de inventarios");
        title.setFont(Font.font(20));
        title.setOnMouseMoved(e -> {
            title.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        });
        about.add(title, 0, 0);

        Label lBAbout = new Label("Aplicación control de inventarios 2020 \n"
                + " Desarrollado en: Apache NetBeans IDE 11.3 \n Lenguaje Java, version 14 \n 2020");
        lBAbout.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        lBAbout.setTextFill(Color.DEEPSKYBLUE);
        about.add(lBAbout, 0, 1);
        lBAbout.setVisible(true);

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);
        buttonClose.setStyle("-fx-background-color: BLACK");
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        about.add(buttonClose, 0, 2);
        buttonClose.setOnAction((event) -> {
            about.getChildren().clear();
            about.setBackground(Background.EMPTY);
        });
        return about;
    }//end method acercaDe
}//end about
