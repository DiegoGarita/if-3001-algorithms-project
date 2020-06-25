package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
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
    Button cliente;
    Button superAdmin;
    Button admin;


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
            labelReportes.setVisible(false);
            labelMantenimiento.setVisible(false);
            labelDefinicion = new Label("Reportes: Acceso a informes de avance y historial de citas\n"
                    + "Citas: Reservar una cita, modificarla o eliminarla\n Planes: Acceso a planes y recetas\n"
                    + "Ajustes: Modificar o eliminar su usuario\nMás: Página web de la clínica con más información\n");
            labelDefinicion.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));  // tipo y tamaño de letra
            labelDefinicion.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelDefinicion.setTextFill(Color.POWDERBLUE);
            labelDefinicion.setVisible(true);
            gridPaneAyuda.add(labelDefinicion, 0, 7);
            superAdmin.setDisable(false);
            admin.setDisable(false);
            cliente.setDisable(true);

        }); //end action Paises

        admin = new Button("Administrador");
        admin.setTextFill(Color.WHITE);
        admin.setStyle("-fx-background-color: BLACK");
        admin.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(admin, 0, 3);
        admin.setOnMouseClicked((event) -> {
            labelMantenimiento.setVisible(false);
            labelDefinicion.setVisible(false);

            labelReportes = new Label("Paciente: Crear reportes de los pacientes acceso a información \n"
                    + "Citas: En el cual podra agendar una cita para cualquier usuario registrado\n"
                    + "Planes: Acceso a planes y recetas varias \n");
            labelReportes.setTextFill(Color.POWDERBLUE);
            labelReportes.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelReportes.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelReportes.setVisible(true);
            gridPaneAyuda.add(labelReportes, 0, 7);
            superAdmin.setDisable(false);
            cliente.setDisable(false);
            admin.setDisable(true);

        }); //end action report

        superAdmin = new Button("Super administrador");
        superAdmin.setTextFill(Color.WHITE);
        superAdmin.setStyle("-fx-background-color: BLACK");
        superAdmin.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAyuda.add(superAdmin, 0, 2);
        superAdmin.setOnMouseClicked((event) -> {

            labelDefinicion.setVisible(false);
            labelReportes.setVisible(false);
            labelMantenimiento = new Label("Ajustes: Cambiar el horario de la clínica\n"
            +"Registros: Donde se crearan respaldos de información, se podrá cambiar la paginación y se tendra acceso a un historial\n"
                    + "Otros: En donde se podrá cambiar el logo del app y el path de los archivos");
            labelMantenimiento.setTextFill(Color.POWDERBLUE);
            labelMantenimiento.setFont(Font.font("Rockwell", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
            labelMantenimiento.setStyle("-fx-background-color: rgb(41, 75, 152);");
            labelMantenimiento.setVisible(true);
            gridPaneAyuda.add(labelMantenimiento, 0, 7);
            cliente.setDisable(false);
            admin.setDisable(false);
            superAdmin.setDisable(true);
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
