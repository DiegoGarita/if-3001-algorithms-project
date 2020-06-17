package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase se colocara ayudas paara los distintos tipos de usuario
public class Ayuda {

    Label labelDefinicion = new Label("");
    Label labelMantenimiento = new Label("");
    Label labelReportes = new Label("");
    Button buttonDefinicion;
    Button buttonMantenimiento;
    Button buttonReportes;

    LogoApp logo = new LogoApp();
        ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane getGraphicalUserInterfaceAyuda() {
        GridPane gridPaneAyuda = new GridPane();
        gridPaneAyuda.setMinSize(600, 700);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        gridPaneAyuda.setVgap(15);
        gridPaneAyuda.setHgap(15);
        gridPaneAyuda.setAlignment(Pos.TOP_LEFT);
        gridPaneAyuda.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Label labelFuncionalidad = new Label("¿ Y cómo funciona cada una de las opciones del app Control de inventarios ?");
        labelFuncionalidad.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        labelFuncionalidad.setTextFill(Color.POWDERBLUE);
        gridPaneAyuda.add(labelFuncionalidad, 0, 1);

        buttonDefinicion = new Button("Crear Catalogo");
        buttonDefinicion.setTextFill(Color.WHITE);
        buttonDefinicion.setStyle("-fx-background-color: BLACK");
        buttonDefinicion.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(buttonDefinicion, 0, 2);
        buttonDefinicion.setOnAction((event) -> {
            labelReportes.setVisible(false);
            labelMantenimiento.setVisible(false);
            labelDefinicion = new Label("Crear catalogo: \n Es donde se define el nombre del objeto y las propiedades de este \n "
                    + "Definir propiedades: \n Aquí podra asignar las propiedades anteriormente definidas \n");
            labelDefinicion.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));  // tipo y tamaño de letra
            labelDefinicion.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelDefinicion.setTextFill(Color.POWDERBLUE);
            labelDefinicion.setVisible(true);
            gridPaneAyuda.add(labelDefinicion, 0, 7);
            buttonMantenimiento.setDisable(false);
            buttonReportes.setDisable(false);
            buttonDefinicion.setDisable(true);

        }); //end action Paises

        buttonReportes = new Button("Reporte");
        buttonReportes.setTextFill(Color.WHITE);
        buttonReportes.setStyle("-fx-background-color: BLACK");
        buttonReportes.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(buttonReportes, 0, 4);
        buttonReportes.setOnMouseClicked((event) -> {
            labelMantenimiento.setVisible(false);
            labelDefinicion.setVisible(false);

            labelReportes = new Label("Búsqueda por catalogo: \n Es donde se muestran los distintos objetos que tiene un catalogo en específico \n "
                    + "Modificar catalogo: \n Aquí podrás modificar \n"
                    + "Listado de catalogos: Aquí se muestra la lista de catalogos existentes ");
            labelReportes.setTextFill(Color.POWDERBLUE);
            labelReportes.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelReportes.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelReportes.setVisible(true);
            gridPaneAyuda.add(labelReportes, 0, 7);
            buttonMantenimiento.setDisable(false);
            buttonDefinicion.setDisable(false);
            buttonReportes.setDisable(true);

        }); //end action report

        buttonMantenimiento = new Button("Mantenimiento");
        buttonMantenimiento.setTextFill(Color.WHITE);
        buttonMantenimiento.setStyle("-fx-background-color: BLACK");
        buttonMantenimiento.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(buttonMantenimiento, 0, 3);
        buttonMantenimiento.setOnMouseClicked((event) -> {

            labelDefinicion.setVisible(false);
            labelReportes.setVisible(false);
            labelMantenimiento = new Label("Aquí podrás eliminar por completo todos tus registros ");
            labelMantenimiento.setTextFill(Color.POWDERBLUE);
            labelMantenimiento.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelMantenimiento.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelMantenimiento.setVisible(true);
            gridPaneAyuda.add(labelMantenimiento, 0, 7);
            buttonDefinicion.setDisable(false);
            buttonReportes.setDisable(false);
            buttonMantenimiento.setDisable(true);
        }); //end action Mant

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(buttonCerrar, 0, 5);
        buttonCerrar.setOnAction((event) -> {
            gridPaneAyuda.getChildren().clear();
            gridPaneAyuda.setBackground(Background.EMPTY);
        });//end action Cerrar

        return gridPaneAyuda;
    }//end method getGraphicalUserInterfaceAyuda
}//end class Help
