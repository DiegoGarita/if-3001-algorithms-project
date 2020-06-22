package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.Calendario;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReservaCita {

    TextField textFieldIDReservacion;
    TextField textFieldDoctora;
    Button botonGuardar;
    ComboBox comboBoxHora = new ComboBox();
    ComboBox comboBoxClientes = new ComboBox();
    LogicaPila LogicaCliente = new LogicaPila();
    LogicaListas logic = new LogicaListas();
    IniciarSesion inicioSesion;
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    LogicaCola logicaCola = new LogicaCola();
    Calendario calendarioParaCitas = new Calendario();
    Alertas alerta = new Alertas();
    DatePicker dT_DateFligth;

    public GridPane reservarCita() {

        GridPane gridPaneSolicitaCita = new GridPane();
        gridPaneSolicitaCita.setMinSize(600, 700);
        gridPaneSolicitaCita.setVgap(15);
        gridPaneSolicitaCita.setHgap(15);
        gridPaneSolicitaCita.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));

        gridPaneSolicitaCita.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        comboBoxClientes.setValue("Clientes");
        comboBoxClientes.setStyle("-fx-background-color: lightblue");
        gridPaneSolicitaCita.add(comboBoxClientes, 0, 0);

        for (int i = 0; i < logicaCola.cantidadDeClientes("ä"); i++) {
            comboBoxClientes.getItems().addAll(logicaCola.arrayListClientes.get(i).getId());
        }
        comboBoxClientes.setOnMouseClicked((event) -> {
            textFieldIDReservacion.setDisable(false);
        });

        textFieldIDReservacion = new TextField(); //--->> Buscar forma de que sea unico para cada cita reservada
        textFieldIDReservacion.setPromptText("ID reservacion");
        textFieldIDReservacion.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        textFieldIDReservacion.setDisable(true);
        gridPaneSolicitaCita.add(textFieldIDReservacion, 0, 1);
        textFieldIDReservacion.setFocusTraversable(false);
        textFieldIDReservacion.setOnKeyPressed((event) -> {
            dT_DateFligth.setDisable(false);
        });

        dT_DateFligth = new DatePicker(LocalDate.now());
        dT_DateFligth.setEditable(false);
        dT_DateFligth.setDayCellFactory(calendarioParaCitas.dayCellFactory);
        dT_DateFligth.setDisable(true);
        gridPaneSolicitaCita.add(dT_DateFligth, 0, 2);
        dT_DateFligth.setOnMouseClicked((event) -> {
            comboBoxHora.setDisable(false);
        });

        comboBoxHora.setValue("Hora de cita");
        for (int i = Integer.parseInt(configuracion.getAbreClinica());
                i < Integer.parseInt(configuracion.getCierreClinica());
                i = i + Integer.parseInt(configuracion.getTiempoConsulta())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
            comboBoxHora.getItems().addAll(i + ":00");
        }
        comboBoxHora.setDisable(true);
        gridPaneSolicitaCita.add(comboBoxHora, 0, 3);
        comboBoxHora.setOnMouseClicked((event) -> {
            textFieldDoctora.setDisable(false);
        });

        textFieldDoctora = new TextField();
        textFieldDoctora.setPromptText("Doctora");
        textFieldDoctora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        textFieldDoctora.setDisable(true);
        gridPaneSolicitaCita.add(textFieldDoctora, 0, 4);
        textFieldDoctora.setFocusTraversable(false);
        textFieldDoctora.setOnKeyPressed((event) -> {
            botonGuardar.setDisable(false);
        });

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);
        botonGuardar.setStyle("-fx-background-color: BLACK");
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneSolicitaCita.add(botonGuardar, 0, 7);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {

            Cita cita = new Cita(textFieldIDReservacion.getText(), comboBoxClientes.getValue().toString(), dT_DateFligth.getValue().toString(),
                    comboBoxHora.getValue().toString(), textFieldDoctora.getText());
            LogicaCliente.EscribeArchivoSolicitudCita(cita);

            Acciones acciones = new Acciones(inicioSesion.ID, "Solicitó una cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);

            botonGuardar.setDisable(true);
            comboBoxClientes.setDisable(true);
            comboBoxHora.setDisable(true);
            textFieldDoctora.setDisable(true);
            dT_DateFligth.setDisable(true);
            textFieldIDReservacion.setDisable(true);
            textFieldIDReservacion.clear();
            textFieldDoctora.clear();
            comboBoxClientes.setValue("Clientes");
            comboBoxHora.setValue("Hora de cita");
            dT_DateFligth.setValue(LocalDate.now());

            alerta.alertInformation("Cita agendada, correctamente");

        });

        MainMenuBarAdministrador mainMenuBarAdmin = new MainMenuBarAdministrador();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneSolicitaCita.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneSolicitaCita.getChildren().clear();
            gridPaneSolicitaCita.setBackground(Background.EMPTY);
            gridPaneSolicitaCita.getChildren().add(mainMenuBarAdmin.menuAdministrador());

        });//end btn cerrar

        return gridPaneSolicitaCita;
    }//end GridPane createCatalogue()

}// end ReservaCita 
