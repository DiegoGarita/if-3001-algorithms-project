package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.PlanesAlimenticiosLogica;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PlanesAlimenticios {

    Button buttonDesplegarInformacion;
    Button buttonAceptar;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxOpciones = new ComboBox();
    ComboBox comboBoxSeleccion = new ComboBox();

    Alertas alerta = new Alertas();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    IniciarSesion inicioSesion;
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();

    PlanesAlimenticiosLogica planesAlimenticiosLogica = new PlanesAlimenticiosLogica();

    public GridPane planesAlimenticios() {

        GridPane gridPanePlanesAlimenticios = new GridPane();
        gridPanePlanesAlimenticios.setMinSize(600, 700);
        gridPanePlanesAlimenticios.setVgap(15);
        gridPanePlanesAlimenticios.setHgap(15);
        gridPanePlanesAlimenticios.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPanePlanesAlimenticios.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        comboBoxOpciones.setValue("Elige una opción");
        comboBoxOpciones.setStyle("-fx-background-color: lightblue");
        comboBoxOpciones.getItems().addAll("Planes alimenticios", "Recetas");
        gridPanePlanesAlimenticios.add(comboBoxOpciones, 0, 0);
        comboBoxOpciones.setOnMouseClicked((event) -> {
            buttonAceptar.setDisable(false);
        });

        comboBoxSeleccion.setValue("Elige una opción");
        comboBoxSeleccion.setVisible(false);
        comboBoxSeleccion.setStyle("-fx-background-color: lightblue");
        gridPanePlanesAlimenticios.add(comboBoxSeleccion, 0, 1);
        comboBoxSeleccion.setOnMouseClicked((event) -> {
            buttonDesplegarInformacion.setDisable(false);
        });

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);
        buttonAceptar.setStyle("-fx-background-color: BLACK");
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonAceptar, 1, 0);
        buttonAceptar.setDisable(true);
        buttonAceptar.setOnAction((event) -> {

            if (comboBoxOpciones.getSelectionModel().getSelectedItem().equals("Elige una opción") != true) {

                if (comboBoxOpciones.getValue().toString().equals("Recetas")) {
                    comboBoxSeleccion.setVisible(true);
                    buttonDesplegarInformacion.setVisible(true);
                    for (int i = 0; i < planesAlimenticiosLogica.cantidadRecetas("*", "Recetas", planesAlimenticiosLogica.arrayListRecetas); i++) {
                        comboBoxSeleccion.getItems().addAll(planesAlimenticiosLogica.arrayListRecetas.get(i));
                    }
                } else if (comboBoxOpciones.getValue().toString().equals("Planes alimenticios")) {
                    comboBoxSeleccion.setVisible(true);
                    buttonDesplegarInformacion.setVisible(true);
                    for (int i = 0; i < planesAlimenticiosLogica.cantidadRecetas("*", "Planes", planesAlimenticiosLogica.arrayListPlanes); i++) {
                        comboBoxSeleccion.getItems().addAll(planesAlimenticiosLogica.arrayListPlanes.get(i));
                    }
                }
                comboBoxOpciones.setDisable(true);
                buttonAceptar.setDisable(true);

            } else {
                alerta.alertWarning("No selecciono una opcion\nIntente de nuevo");
            }

        });

        buttonDesplegarInformacion = new Button("Desplegar");
        buttonDesplegarInformacion.setTextFill(Color.WHITE);
        buttonDesplegarInformacion.setVisible(false);
        buttonDesplegarInformacion.setDisable(true);
        buttonDesplegarInformacion.setStyle("-fx-background-color: BLACK");
        buttonDesplegarInformacion.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonDesplegarInformacion, 1, 1);
        buttonDesplegarInformacion.setOnAction((event) -> {

            if (comboBoxSeleccion.getSelectionModel().getSelectedItem().equals("Elige una opción") != true) {

                if (comboBoxOpciones.getValue().toString().equals("Recetas")) {
                    textAreaMostrar.setText(planesAlimenticiosLogica.leeArchivo(comboBoxSeleccion.getValue().toString(), "Recetas"));
                    Acciones acciones = new Acciones(inicioSesion.ID, "Solicitó información sobre recetas", fechaHora.histoFechaHora());
                    logicaAVL.escribeHistorial(acciones);
                } else if (comboBoxOpciones.getValue().toString().equals("Planes alimenticios")) {
                    Acciones acciones = new Acciones(inicioSesion.ID, "Solicitó información sobre planes alimenticios", fechaHora.histoFechaHora());
                    logicaAVL.escribeHistorial(acciones);
                    textAreaMostrar.setText(planesAlimenticiosLogica.leeArchivo(comboBoxSeleccion.getValue().toString(), "Planes"));
                }
                buttonDesplegarInformacion.setDisable(true);
                comboBoxOpciones.setDisable(true);

            } else {
                alerta.alertWarning("No seleccionó una opción\nIntentelo de nuevo");
            }

        });

        textAreaMostrar.setEditable(false);
        gridPanePlanesAlimenticios.add(textAreaMostrar, 0, 3);

        MainMenuBarCliente mainMenuBarCliente = new MainMenuBarCliente();

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);
        buttonClose.setStyle("-fx-background-color: BLACK");
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanePlanesAlimenticios.getChildren().clear();
            gridPanePlanesAlimenticios.setBackground(Background.EMPTY);
            gridPanePlanesAlimenticios.getChildren().add(mainMenuBarCliente.menuCliente());

        });

        return gridPanePlanesAlimenticios;
    }
}
