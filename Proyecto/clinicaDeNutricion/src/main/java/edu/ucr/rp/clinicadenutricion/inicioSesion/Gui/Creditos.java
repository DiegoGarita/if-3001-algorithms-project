package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase se colocara lo que respecte a los creadores
public class Creditos {

    public GridPane getGraphicalUserInterfaceCreditos() {
        GridPane gridPaneCreditos = new GridPane();
        gridPaneCreditos.setMinSize(600, 700);
        gridPaneCreditos.setVgap(15);
        gridPaneCreditos.setHgap(15);
        gridPaneCreditos.setAlignment(Pos.TOP_LEFT);

        LogoApp logo = new LogoApp();

        gridPaneCreditos.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Text Titulo = new Text(200, 200, "Creditos de la aplicacion: Control de inventarios");
        Titulo.setFont(Font.font(20));
        Titulo.setOnMouseMoved(e -> {
            Titulo.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        });
        gridPaneCreditos.add(Titulo, 0, 0);

        Label labelCreditos = new Label("Realizado por: \n"
                + " Diego Garita Abarca B83214 \n Alejandro Quesada Leiva B86205");
        labelCreditos.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        labelCreditos.setTextFill(Color.GREENYELLOW);
        gridPaneCreditos.add(labelCreditos, 0, 1);
        labelCreditos.setVisible(true);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneCreditos.add(buttonCerrar, 0, 4);
        buttonCerrar.setOnAction((event) -> {
            gridPaneCreditos.getChildren().clear();
            gridPaneCreditos.setBackground(Background.EMPTY);

        });

        return gridPaneCreditos;
    }//end GridPane getGraphicalUserInterfaceCreditos()
}//end class Credits 
