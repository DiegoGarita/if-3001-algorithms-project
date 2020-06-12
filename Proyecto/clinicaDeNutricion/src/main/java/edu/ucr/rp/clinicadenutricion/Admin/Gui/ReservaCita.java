package edu.ucr.rp.clinicadenutricion.Admin.Gui;

//en esta clase el admin podra apartar una cita para su cliente
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReservaCita {

    //  SaveObject saveObject = new SaveObject();
    //  ConstantsElements constantsElements = new ConstantsElements();
    Object object;

    TextField textFieldPaciente;
    TextField textFieldDoctora;
    Button botonGuardar;
    LogoApp logo = new LogoApp();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane reservar() {

        //  File file = new File(fileName);
        GridPane gridPaneNewCatalogue = new GridPane();
        gridPaneNewCatalogue.setMinSize(600, 700);
        gridPaneNewCatalogue.setVgap(15);
        gridPaneNewCatalogue.setHgap(15);
        gridPaneNewCatalogue.setAlignment(Pos.CENTER);
        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldPaciente = new TextField();
        textFieldPaciente.setPromptText("Nombre del paciente");
        textFieldPaciente.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneNewCatalogue.add(textFieldPaciente, 0, 1);
        textFieldPaciente.setFocusTraversable(false);
        textFieldPaciente.setOnKeyPressed((event) -> {

        });

        Label labelFechHora = new Label("Hacer algo con Hora y fecha");
        gridPaneNewCatalogue.add(labelFechHora, 0, 2);

        textFieldDoctora = new TextField();
        textFieldDoctora.setPromptText("Doctora");
        textFieldDoctora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneNewCatalogue.add(textFieldDoctora, 0, 3); /// columna fila
        textFieldDoctora.setFocusTraversable(false);

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);
        botonGuardar.setStyle("-fx-background-color: BLACK");
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneNewCatalogue.add(botonGuardar, 0, 7);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {

        });//END BUTTON

        //***
        MainMenuBarAdmi o = new MainMenuBarAdmi();
        //***
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneNewCatalogue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneNewCatalogue.getChildren().clear();
            gridPaneNewCatalogue.setBackground(Background.EMPTY);
            gridPaneNewCatalogue.getChildren().add(o.menuAdmi());

        });//end btn cerrar

        return gridPaneNewCatalogue;
    }//end GridPane createCatalogue()

}
