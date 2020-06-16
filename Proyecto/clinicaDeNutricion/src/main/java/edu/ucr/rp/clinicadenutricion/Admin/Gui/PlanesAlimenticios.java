package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.PlanesAlimenticiosLogica;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PlanesAlimenticios {

    ComboBox comboBoxSele = new ComboBox();
    Button buttonDesplegarInfo;
    Button buttonAceptar;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxOp = new ComboBox();
    LogoApp logo = new LogoApp();
    IniciarSesion iniciarSesion;

    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();

    PlanesAlimenticiosLogica planAl = new PlanesAlimenticiosLogica();

    public GridPane planesAlimenticios() {

        GridPane gridPanePlanesAlimenticios = new GridPane();
        gridPanePlanesAlimenticios.setMinSize(600, 700);
        gridPanePlanesAlimenticios.setVgap(15);
        gridPanePlanesAlimenticios.setHgap(15);
        gridPanePlanesAlimenticios.setAlignment(Pos.CENTER);
        gridPanePlanesAlimenticios.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        comboBoxOp.setValue("Elige una opcion");
        comboBoxOp.setStyle("-fx-background-color: lightblue");
        comboBoxOp.getItems().addAll("Planes alimenticios", "Recetas");
        gridPanePlanesAlimenticios.add(comboBoxOp, 0, 0);

        comboBoxSele.setValue("Elige una opcion");
        comboBoxSele.setVisible(false);
        comboBoxSele.setStyle("-fx-background-color: lightblue");
        gridPanePlanesAlimenticios.add(comboBoxSele, 0, 1);

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);
        buttonAceptar.setStyle("-fx-background-color: BLACK");
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonAceptar, 1, 0);
        buttonAceptar.setOnAction((event) -> {
            if (comboBoxOp.getValue().toString().equals("Recetas")) {
                comboBoxSele.setVisible(true);
                buttonDesplegarInfo.setVisible(true);
                for (int i = 0; i < planAl.cantidadRecetas("*", "Recetas", planAl.arrayListRecetas); i++) {
                    comboBoxSele.getItems().addAll(planAl.arrayListRecetas.get(i));
                }
            } else if (comboBoxOp.getValue().toString().equals("Planes alimenticios")) {
                comboBoxSele.setVisible(true);
                buttonDesplegarInfo.setVisible(true);
                for (int i = 0; i < planAl.cantidadRecetas("*", "Planes", planAl.arrayListPlanes); i++) {
                    comboBoxSele.getItems().addAll(planAl.arrayListPlanes.get(i));
                }
            }

        });//end setOnAction

        buttonDesplegarInfo = new Button("Desplegar");
        buttonDesplegarInfo.setTextFill(Color.WHITE);
        buttonDesplegarInfo.setVisible(false);
        buttonDesplegarInfo.setStyle("-fx-background-color: BLACK");
        buttonDesplegarInfo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePlanesAlimenticios.add(buttonDesplegarInfo, 1, 1);
        buttonDesplegarInfo.setOnAction((event) -> {
            if (comboBoxOp.getValue().toString().equals("Recetas")) {
                textAreaMostrar.setText(planAl.leeArchivo(comboBoxSele.getValue().toString(), "Recetas"));
                    Acciones acciones = new Acciones(iniciarSesion.ID, "Solicitó la lista de Recetas", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);
            } else if (comboBoxOp.getValue().toString().equals("Planes alimenticios")) {
                textAreaMostrar.setText(planAl.leeArchivo(comboBoxSele.getValue().toString(), "Planes"));
                Acciones acciones = new Acciones(iniciarSesion.ID, "Solicitó la lista de planes alimenticios", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);
            }

        });//end setOnAction

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

        });//end btn cerrar

        return gridPanePlanesAlimenticios;
    }//end GridPane createCatalogue()

}//end PlanesAlimenticios
