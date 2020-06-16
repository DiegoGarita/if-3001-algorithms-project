package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
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
    LogicaCola adminLogic = new LogicaCola();

    public GridPane reservarCita() {

        GridPane gridPaneReservarCita = new GridPane();
        gridPaneReservarCita.setMinSize(600, 700);
        gridPaneReservarCita.setVgap(15);
        gridPaneReservarCita.setHgap(15);
        gridPaneReservarCita.setAlignment(Pos.CENTER);
        gridPaneReservarCita.setStyle("-fx-background-color: dodgerblue");

        labelID = new Label("ID: ");
        gridPaneReservarCita.add(labelID, 0, 0);

        textFieldID = new TextField();
        textFieldID.setPromptText("ID");
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneReservarCita.add(textFieldID, 1, 0);
        textFieldID.setFocusTraversable(false);

        labelNombre = new Label("Nombre: ");
        gridPaneReservarCita.add(labelNombre, 0, 2);

        textNombre = new TextField();
        textNombre.setPromptText("Nombre");
        textNombre.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneReservarCita.add(textNombre, 1, 2);
        textNombre.setFocusTraversable(false);

        labelFecha = new Label("Fecha: ");
        gridPaneReservarCita.add(labelFecha, 0, 3);

        textFieldFecha = new TextField();
        textFieldFecha.setPromptText("Fecha");
        textFieldFecha.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneReservarCita.add(textFieldFecha, 1, 3);
        textFieldFecha.setFocusTraversable(false);

        labelHora = new Label("Hora: ");
        gridPaneReservarCita.add(labelHora, 0, 4);

        textFieldHora = new TextField();
        textFieldHora.setPromptText("Hora");
        textFieldHora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneReservarCita.add(textFieldHora, 1, 4);
        textFieldHora.setFocusTraversable(false);

        labelDoc = new Label("Doctor: ");
        gridPaneReservarCita.add(labelDoc, 0, 4);

        textFieldDoc = new TextField();
        textFieldDoc.setPromptText("Doctor");
        textFieldDoc.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneReservarCita.add(textFieldDoc, 1, 4);
        textFieldDoc.setFocusTraversable(false);

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);
        buttonAceptar.setStyle("-fx-background-color: BLACK");
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReservarCita.add(buttonAceptar, 1, 8);
        buttonAceptar.setOnAction((event) -> {
//            Cita cita = new Cita(textFieldID.getText(), textNombre.getText(), textFieldFecha.getText(), textFieldHora.getText(), textFieldDoc.getText());
//            adminLogic.escribeCitas();

        });//end setOnAction

        MainMenuBarAdministrador mainMenuBarAdministracion = new MainMenuBarAdministrador();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReservarCita.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneReservarCita.getChildren().clear();
            gridPaneReservarCita.setBackground(Background.EMPTY);
            gridPaneReservarCita.getChildren().add(mainMenuBarAdministracion.menuAdministrador());

        });//end btn cerrar

        return gridPaneReservarCita;
    }//end GridPane createCatalogue()

}
