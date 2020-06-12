package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase se colocara ayudas paara los distintos tipos de usuario
public class Ayuda {

    Label labelCatalogue = new Label("");
    Label labelMaintenance = new Label("");
    Label labelReports = new Label("");
    Button buttonCatalogue;
    Button buttonMaintenance;
    Button buttonReports;
    
        LogoApp logo = new LogoApp();


    /**
     * 
     * @return Nos da la GUI que contiene información de cada una de las funcionalidades del app
     */
    public GridPane getGraphicalUserInterfaceHelper() {
        GridPane gridPaneHelper = new GridPane();
        gridPaneHelper.setMinSize(600, 700);
        gridPaneHelper.setVgap(15);
        gridPaneHelper.setHgap(15);
        gridPaneHelper.setAlignment(Pos.TOP_LEFT);
        gridPaneHelper.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Label labelFunctionality = new Label("¿ Y cómo funciona cada una de las opciones del app Control de inventarios ?");
        labelFunctionality.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        labelFunctionality.setTextFill(Color.POWDERBLUE);
        gridPaneHelper.add(labelFunctionality, 0, 1);

        buttonCatalogue = new Button("Crear Catalogo");
        buttonCatalogue.setTextFill(Color.WHITE);
        buttonCatalogue.setStyle("-fx-background-color: BLACK");
        buttonCatalogue.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneHelper.add(buttonCatalogue, 0, 2);
        buttonCatalogue.setOnAction((event) -> {
            labelReports.setVisible(false);
            labelMaintenance.setVisible(false);
            labelCatalogue = new Label("Crear catalogo: \n Es donde se define el nombre del objeto y las propiedades de este \n "
                    + "Definir propiedades: \n Aquí podra asignar las propiedades anteriormente definidas \n");
            labelCatalogue.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));  // tipo y tamaño de letra
            labelCatalogue.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelCatalogue.setTextFill(Color.POWDERBLUE);
            labelCatalogue.setVisible(true);
            gridPaneHelper.add(labelCatalogue, 0, 7);
            buttonMaintenance.setDisable(false);
            buttonReports.setDisable(false);
            buttonCatalogue.setDisable(true);

        }); //end action Paises

        buttonReports = new Button("Reporte");
        buttonReports.setTextFill(Color.WHITE);
        buttonReports.setStyle("-fx-background-color: BLACK");
        buttonReports.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneHelper.add(buttonReports, 0, 4);
        buttonReports.setOnMouseClicked((event) -> {
            labelMaintenance.setVisible(false);
            labelCatalogue.setVisible(false);

            labelReports = new Label("Búsqueda por catalogo: \n Es donde se muestran los distintos objetos que tiene un catalogo en específico \n "
                    + "Modificar catalogo: \n Aquí podrás modificar \n"
                    + "Listado de catalogos: Aquí se muestra la lista de catalogos existentes ");
            labelReports.setTextFill(Color.POWDERBLUE);
            labelReports.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelReports.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelReports.setVisible(true);
            gridPaneHelper.add(labelReports, 0, 7);
            buttonMaintenance.setDisable(false);
            buttonCatalogue.setDisable(false);
            buttonReports.setDisable(true);

        }); //end action report

        buttonMaintenance = new Button("Mantenimiento");
        buttonMaintenance.setTextFill(Color.WHITE);
        buttonMaintenance.setStyle("-fx-background-color: BLACK");
        buttonMaintenance.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneHelper.add(buttonMaintenance, 0, 3);
        buttonMaintenance.setOnMouseClicked((event) -> {

            labelCatalogue.setVisible(false);
            labelReports.setVisible(false);
            labelMaintenance = new Label("Aquí podrás eliminar por completo todos tus registros ");
            labelMaintenance.setTextFill(Color.POWDERBLUE);
            labelMaintenance.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelMaintenance.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelMaintenance.setVisible(true);
            gridPaneHelper.add(labelMaintenance, 0, 7);
            buttonCatalogue.setDisable(false);
            buttonReports.setDisable(false);
            buttonMaintenance.setDisable(true);
        }); //end action Mant

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);
        buttonClose.setStyle("-fx-background-color: BLACK");
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneHelper.add(buttonClose, 0, 5);
        buttonClose.setOnAction((event) -> {
            gridPaneHelper.getChildren().clear();
            gridPaneHelper.setBackground(Background.EMPTY);
        });//end action Cerrar

        return gridPaneHelper;
    }//end method getGraphicalUserInterfaceHelper
}//end class Help
