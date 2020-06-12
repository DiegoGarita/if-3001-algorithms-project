package edu.ucr.rp.clinicadenutricion.Admin.Gui;

//en esta clase el admin podra apartar una cita para su cliente
import edu.ucr.rp.clinicadenutricion.Admin.logic.AdminLogic;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReservaCita {

    TextField textFieldID;
    TextField textNombre;
    TextField textFieldFecha;
    TextField textFieldHora;
    TextField textFieldDoc;

    Label labelID;
    Label labelNombre;
    Label labelFecha;
    Label labelHora;
    Label labelDoc;

    Button buttonAceptar;

    AdminLogic adminLogic = new AdminLogic();
    
    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane reservar() {

        GridPane gridPaneAjustes = new GridPane();
        gridPaneAjustes.setMinSize(600, 700);
        gridPaneAjustes.setVgap(15);
        gridPaneAjustes.setHgap(15);
        gridPaneAjustes.setAlignment(Pos.CENTER);
        gridPaneAjustes.setStyle("-fx-background-color: dodgerblue");

        labelID = new Label("ID: ");
        gridPaneAjustes.add(labelID, 0, 0);

        textFieldID = new TextField();////////////
        textFieldID.setPromptText("ID");
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldID, 1, 0);
        textFieldID.setFocusTraversable(false);

        labelNombre = new Label("Nombre: ");
        gridPaneAjustes.add(labelNombre, 0, 2);

        textNombre = new TextField();/////////
        textNombre.setPromptText("Nombre");
        textNombre.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textNombre, 1, 2);
        textNombre.setFocusTraversable(false);

        labelFecha = new Label("Fecha: ");
        gridPaneAjustes.add(labelFecha, 0, 3);

        textFieldFecha = new TextField();//////////////////////////
        textFieldFecha.setPromptText("Fecha");
        textFieldFecha.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldFecha, 1, 3);
        textFieldFecha.setFocusTraversable(false);

        labelHora = new Label("Hora: ");
        gridPaneAjustes.add(labelHora, 0, 4);

        textFieldHora = new TextField();
        textFieldHora.setPromptText("Hora");
        textFieldHora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldHora, 1, 4);
        textFieldHora.setFocusTraversable(false);

        labelDoc = new Label("Doctor: ");
        gridPaneAjustes.add(labelDoc, 0, 4);

        textFieldDoc = new TextField();
        textFieldDoc.setPromptText("Doctor");
        textFieldDoc.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldDoc, 1, 4);
        textFieldDoc.setFocusTraversable(false);

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneAjustes.add(buttonAceptar, 1, 8);
        buttonAceptar.setOnAction((event) -> {
//            Cita cita = new Cita(textFieldID.getText(), textNombre.getText(), textFieldFecha.getText(), textFieldHora.getText(), textFieldDoc.getText());
//            adminLogic.writeFileCitas();
            

        });//end setOnAction

        MainMenuBarAdmi o = new MainMenuBarAdmi();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAjustes.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneAjustes.getChildren().clear();
            gridPaneAjustes.setBackground(Background.EMPTY);
            gridPaneAjustes.getChildren().add(o.menuAdmi());

        });//end btn cerrar

        return gridPaneAjustes;
    }//end GridPane createCatalogue()

}
