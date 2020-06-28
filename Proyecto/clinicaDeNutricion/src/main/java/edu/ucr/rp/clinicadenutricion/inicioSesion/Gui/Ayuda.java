package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Ayuda {

    Label labelClie = new Label("");
    Label labelAjus = new Label("");
    Label labelPaci = new Label("");
    Button cliente;
    Button superAdmin;
    Button admin;

    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();

    public GridPane Ayuda() {
        GridPane gridPaneAyuda = new GridPane();
        gridPaneAyuda.setMinSize(600, 700);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPaneAyuda.setVgap(15);
        gridPaneAyuda.setHgap(15);
        gridPaneAyuda.setAlignment(Pos.TOP_LEFT);
        gridPaneAyuda.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Label labelFuncionalidad = new Label("¿ Y cómo funcionan los tres roles de clínica?");
        labelFuncionalidad.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
        labelFuncionalidad.setTextFill(Color.POWDERBLUE);
        gridPaneAyuda.add(labelFuncionalidad, 0, 1);

        cliente = new Button("Cliente");
        cliente.setTextFill(Color.WHITE);
        cliente.setStyle("-fx-background-color: BLACK");
        cliente.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(cliente, 0, 4);
        cliente.setOnAction((event) -> {
            labelPaci.setVisible(false);
            labelAjus.setVisible(false);
            labelClie = new Label("Reportes: Acceso a informes de avance y historial de citas\n"
                    + "Citas: Reservar una cita, modificarla o eliminarla\nPlanes: Acceso a planes y recetas\n"
                    + "Ajustes: Modificar o eliminar su usuario\nMás: Página web de la clínica con más información\n");
            labelClie.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelClie.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelClie.setTextFill(Color.POWDERBLUE);
            labelClie.setVisible(true);
            gridPaneAyuda.add(labelClie, 0, 7);
            superAdmin.setDisable(false);
            admin.setDisable(false);
            cliente.setDisable(true);

        });

        admin = new Button("Administrador");
        admin.setTextFill(Color.WHITE);
        admin.setStyle("-fx-background-color: BLACK");
        admin.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(admin, 0, 3);
        admin.setOnMouseClicked((event) -> {
            labelAjus.setVisible(false);
            labelClie.setVisible(false);

            labelPaci = new Label("Paciente: Crear reportes de los pacientes acceso a información \n"
                    + "Citas: En el cual podrá agendar una cita para cualquier usuario registrado\n ademas de cancelar y modificar\n"
                    + "Planes: Acceso a planes y recetas varias \n");
            labelPaci.setTextFill(Color.POWDERBLUE);
            labelPaci.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelPaci.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelPaci.setVisible(true);
            gridPaneAyuda.add(labelPaci, 0, 7);
            superAdmin.setDisable(false);
            cliente.setDisable(false);
            admin.setDisable(true);

        });

        superAdmin = new Button("Super administrador");
        superAdmin.setTextFill(Color.WHITE);
        superAdmin.setStyle("-fx-background-color: BLACK");
        superAdmin.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(superAdmin, 0, 2);
        superAdmin.setOnMouseClicked((event) -> {

            labelClie.setVisible(false);
            labelPaci.setVisible(false);
            labelAjus = new Label("Ajustes: Cambiar el horario de la clínica\n"
                    + "Registros: Donde se crearan respaldos de información, se podrá cambiar\n la paginación y se tendrá acceso a un historial\n"
                    + "Otros: En donde se podrá cambiar el logo del app y el path de los archivos");
            labelAjus.setTextFill(Color.POWDERBLUE);
            labelAjus.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelAjus.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelAjus.setVisible(true);
            gridPaneAyuda.add(labelAjus, 0, 7);
            cliente.setDisable(false);
            admin.setDisable(false);
            superAdmin.setDisable(true);
        });

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(buttonCerrar, 0, 5);
        buttonCerrar.setOnAction((event) -> {
            gridPaneAyuda.getChildren().clear();
            gridPaneAyuda.setBackground(Background.EMPTY);
        });

        return gridPaneAyuda;
    }//end method Ayuda
}
