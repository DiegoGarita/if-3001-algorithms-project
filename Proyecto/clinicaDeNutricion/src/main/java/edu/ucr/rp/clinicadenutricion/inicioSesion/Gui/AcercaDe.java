package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class AcercaDe {

    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane getGraphicalUserInterfaceAcercaDe() {
        GridPane acercaDe = new GridPane();
        acercaDe.setMinSize(600, 700);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        acercaDe.setVgap(15);
        acercaDe.setHgap(15);
        acercaDe.setAlignment(Pos.TOP_LEFT);
        acercaDe.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Text title = new Text(200, 200, "Acerca de la aplicación: Clínica de alimentación");
        title.setFont(Font.font(20));
        title.setOnMouseMoved(e -> {
            title.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        });
        acercaDe.add(title, 0, 0);

        Label labelAcercaDe = new Label("Clínica de alimentación 2020 \n"
                + " Desarrollado en: Apache NetBeans IDE 11.3 \n Lenguaje Java, version 14 \n 2020");
        labelAcercaDe.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        labelAcercaDe.setTextFill(Color.DEEPSKYBLUE);
        acercaDe.add(labelAcercaDe, 0, 1);
        labelAcercaDe.setVisible(true);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        acercaDe.add(buttonCerrar, 0, 2);
        buttonCerrar.setOnAction((event) -> {
            acercaDe.getChildren().clear();
            acercaDe.setBackground(Background.EMPTY);
        });
        return acercaDe;
    }//end method acercaDe
}//end acercaDe
