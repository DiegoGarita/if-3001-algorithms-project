package edu.ucr.rp.clinicadenutricion.Admin.Gui;

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

    Button buttonDesplegarInfo;
    Button buttonAceptar;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxOpciones = new ComboBox();
    ComboBox comboBoxSeleccion = new ComboBox();

    Alertas alerta = new Alertas();
    IniciarSesion iniciarSesion;
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();

    PlanesAlimenticiosLogica planesAlimentacionLogica = new PlanesAlimenticiosLogica();

    public GridPane planesAlimenticios() {

        GridPane gridPanePlanesAlimenticios = new GridPane();
        gridPanePlanesAlimenticios.setMinSize(600, 700);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPanePlanesAlimenticios.setVgap(15);
        gridPanePlanesAlimenticios.setHgap(15);
        gridPanePlanesAlimenticios.setAlignment(Pos.CENTER);
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
            buttonDesplegarInfo.setDisable(false);
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
                    buttonDesplegarInfo.setVisible(true);
                    for (int i = 0; i < planesAlimentacionLogica.cantidadRecetas("*", "Recetas", planesAlimentacionLogica.arrayListRecetas); i++) {
                        comboBoxSeleccion.getItems().addAll(planesAlimentacionLogica.arrayListRecetas.get(i));
                    }
                } else if (comboBoxOpciones.getValue().toString().equals("Planes alimenticios")) {
                    comboBoxSeleccion.setVisible(true);
                    buttonDesplegarInfo.setVisible(true);
                    for (int i = 0; i < planesAlimentacionLogica.cantidadRecetas("*", "Planes", planesAlimentacionLogica.arrayListPlanes); i++) {
                        comboBoxSeleccion.getItems().addAll(planesAlimentacionLogica.arrayListPlanes.get(i));
                    }
                }
                buttonAceptar.setDisable(true);
                comboBoxOpciones.setDisable(true);

            } else {
                alerta.alertWarning("No selecciono una opcion\nIntente de nuevo");
            }

        });

        buttonDesplegarInfo = new Button("Desplegar");
        buttonDesplegarInfo.setTextFill(Color.WHITE);
        buttonDesplegarInfo.setVisible(false);
        buttonDesplegarInfo.setDisable(true);
        buttonDesplegarInfo.setStyle("-fx-background-color: BLACK");
        buttonDesplegarInfo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonDesplegarInfo, 1, 1);
        buttonDesplegarInfo.setOnAction((event) -> {

            if (comboBoxSeleccion.getSelectionModel().getSelectedItem().equals("Elige una opción") != true) {

                if (comboBoxOpciones.getValue().toString().equals("Recetas")) {
                    textAreaMostrar.setText(planesAlimentacionLogica.leeArchivo(comboBoxSeleccion.getValue().toString(), "Recetas"));
                    Acciones acciones = new Acciones(iniciarSesion.ID, "Solicitó la lista de Recetas", fechaHora.histoFechaHora());
                    logicaAVL.escribeHistorial(acciones);
                } else if (comboBoxOpciones.getValue().toString().equals("Planes alimenticios")) {
                    textAreaMostrar.setText(planesAlimentacionLogica.leeArchivo(comboBoxSeleccion.getValue().toString(), "Planes"));
                    Acciones acciones = new Acciones(iniciarSesion.ID, "Solicitó la lista de planes alimenticios", fechaHora.histoFechaHora());
                    logicaAVL.escribeHistorial(acciones);
                }
                buttonDesplegarInfo.setDisable(true);

            }
            else {
                alerta.alertWarning("No seleccionó una opción\nIntentelo de nuevo");
            }

        });

        textAreaMostrar.setEditable(false);
        gridPanePlanesAlimenticios.add(textAreaMostrar, 0, 3);

        MainMenuBarAdministrador o = new MainMenuBarAdministrador();

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);
        buttonClose.setStyle("-fx-background-color: BLACK");
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanePlanesAlimenticios.getChildren().clear();
            gridPanePlanesAlimenticios.setBackground(Background.EMPTY);
            gridPanePlanesAlimenticios.getChildren().add(o.menuAdministrador());

        });

        return gridPanePlanesAlimenticios;
    }//end gridPanePlanesAlimenticios

}//end PlanesAlimenticios
