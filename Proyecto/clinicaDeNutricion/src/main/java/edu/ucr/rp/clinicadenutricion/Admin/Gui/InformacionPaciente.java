package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class InformacionPaciente {

    TextArea textAreaNotas = new TextArea();
    LogicaCola adminLogic = new LogicaCola();
    ComboBox comboBoxClientes = new ComboBox();

    public GridPane informacionPaciente() {

        GridPane gridPaneInformacionPaciente = new GridPane();
        gridPaneInformacionPaciente.setMinSize(600, 700);
        gridPaneInformacionPaciente.setVgap(15);
        gridPaneInformacionPaciente.setHgap(15);
        gridPaneInformacionPaciente.setAlignment(Pos.CENTER);
        gridPaneInformacionPaciente.setStyle("-fx-background-color: dodgerblue");

        comboBoxClientes.setValue("Clientes");
        comboBoxClientes.setStyle("-fx-background-color: lightblue");
        gridPaneInformacionPaciente.add(comboBoxClientes, 0, 0);

        for (int i = 0; i < adminLogic.cantidadDeClientes("ä"); i++) {
            comboBoxClientes.getItems().addAll(adminLogic.arrayListClientes.get(i).getId());
        }

        GridPane.setColumnSpan(textAreaNotas, Integer.BYTES);
        textAreaNotas.setVisible(false);
        textAreaNotas.setMinSize(650, 75);
        gridPaneInformacionPaciente.add(textAreaNotas, 0, 5);

        Button buttonBuscar = new Button("Buscar");
        buttonBuscar.setTextFill(Color.WHITE);
        buttonBuscar.setStyle("-fx-background-color: BLACK");
        buttonBuscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneInformacionPaciente.add(buttonBuscar, 1, 0);
        buttonBuscar.setDisable(false);

        buttonBuscar.setOnAction((event) -> {
            textAreaNotas.setText(adminLogic.leeArchivo(comboBoxClientes.getValue().toString()));
            textAreaNotas.setVisible(true);

        });// end boton

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneInformacionPaciente.add(buttonCerrar, 2, 0);

        MainMenuBarAdministrador o = new MainMenuBarAdministrador();

        buttonCerrar.setOnAction((event) -> {
            gridPaneInformacionPaciente.getChildren().clear();
            gridPaneInformacionPaciente.setBackground(Background.EMPTY);
            gridPaneInformacionPaciente.getChildren().add(o.menuAdministrador());

        });

        return gridPaneInformacionPaciente;
    }

}
