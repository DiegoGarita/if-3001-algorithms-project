package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
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
    DatePicker datePicker;

    IniciarSesion iniciarSesion;
    Alertas alertas = new Alertas();
    LogicaPila logicaPila = new LogicaPila();
    LogicaListas logicaListas = new LogicaListas();
    IniciarSesion inicioSesion;
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    LogicaCola logicaCola = new LogicaCola();
    Calendario calendario = new Calendario();
    Alertas alerta = new Alertas();

    public GridPane reservarCita() {

        GridPane gridPaneReservaCita = new GridPane();
        gridPaneReservaCita.setMinSize(600, 700);
        gridPaneReservaCita.setVgap(15);
        gridPaneReservaCita.setHgap(15);
        gridPaneReservaCita.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));

        gridPaneReservaCita.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        comboBoxClientes.setValue("Clientes");
        comboBoxClientes.setStyle("-fx-background-color: lightblue");
        gridPaneReservaCita.add(comboBoxClientes, 0, 0);
        for (int i = 0; i < logicaCola.cantidadDeClientes("ä"); i++) {
            comboBoxClientes.getItems().addAll(logicaCola.arrayListClientes.get(i).getId());
        }
        comboBoxClientes.setOnMouseClicked((event) -> {
            textFieldIDReservacion.setDisable(false);
        });

        textFieldIDReservacion = new TextField();
        textFieldIDReservacion.setPromptText("ID reservacion");
        textFieldIDReservacion.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        textFieldIDReservacion.setDisable(true);
        gridPaneReservaCita.add(textFieldIDReservacion, 0, 1);
        textFieldIDReservacion.setFocusTraversable(false);
        textFieldIDReservacion.setOnKeyPressed((event) -> {
            datePicker.setDisable(false);
        });

        datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);
        datePicker.setDayCellFactory(calendario.dayCellFactory);
        datePicker.setDisable(true);
        gridPaneReservaCita.add(datePicker, 0, 2);
        datePicker.setOnMouseClicked((event) -> {
            comboBoxHora.getItems().clear();
            comboBoxHora.setDisable(false);
        });

        comboBoxHora.setValue("Hora de cita");
        comboBoxHora.setDisable(true);
        gridPaneReservaCita.add(comboBoxHora, 0, 3);
        comboBoxHora.setEditable(false);
        comboBoxHora.setOnMouseClicked((event) -> {
            comboBoxHora.setEditable(false);
            logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString());
            int tam = logicaPila.tamanio();
            for (int i = Integer.parseInt(configuracion.getAbreClinica()); i < Integer.parseInt(configuracion.getCierreClinica()); i = i + Integer.parseInt(configuracion.getTiempoConsulta())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
                if (tam != 0) {
                    for (int j = 0; j < tam; j++) {
                        if (comboBoxHora.getItems().contains(+j + ":00")) {
                            comboBoxHora.getItems().remove(j);
                        }

                        if (Integer.parseInt(logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString()).get(j)) != i) {
                            if (i < 10) {
                                if (comboBoxHora.getItems().contains("0" + Integer.parseInt(logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString()).get(j)) + ":00") || comboBoxHora.getItems().contains("0" + i + ":00")) {
                                    comboBoxHora.getItems().removeAll("0" + Integer.parseInt(logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString()).get(j)) + ":00");
                                    comboBoxHora.getItems().removeAll("0" + i + ":00");
                                }
                                comboBoxHora.getItems().addAll("0" + i + ":00");

                            } else {
                                if (comboBoxHora.getItems().contains(+Integer.parseInt(logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString()).get(j)) + ":00") || comboBoxHora.getItems().contains(+i + ":00")) {
                                    comboBoxHora.getItems().removeAll(+Integer.parseInt(logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString()).get(j)) + ":00");
                                    comboBoxHora.getItems().removeAll(i + ":00");
                                }
                                comboBoxHora.getItems().addAll(i + ":00");
                            }
                        }

                    }
                } else {
                    if (i == Integer.parseInt(configuracion.getAbreClinica())) {
                        comboBoxHora.getItems().clear();
                    }
                    if (i < 10) {

                        comboBoxHora.getItems().addAll("0" + i + ":00");
                    } else {
                        comboBoxHora.getItems().addAll(i + ":00");
                    }

                }
            }
            botonGuardar.setDisable(false);
        });

        textFieldDoctora = new TextField();
        textFieldDoctora.setText(usuario.getName());
        textFieldDoctora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        textFieldDoctora.setDisable(true);
        gridPaneReservaCita.add(textFieldDoctora, 0, 4);
        textFieldDoctora.setFocusTraversable(false);
        textFieldDoctora.setOnKeyPressed((event) -> {
            datePicker.setDisable(false);
        });

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);
        botonGuardar.setStyle("-fx-background-color: BLACK");
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReservaCita.add(botonGuardar, 0, 7);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {

            if (comboBoxHora.getSelectionModel().getSelectedItem().equals("Hora de cita") != true) {

                if (!textFieldIDReservacion.getText().trim().equals("")) {

                    Cita cita = new Cita(textFieldIDReservacion.getText(), comboBoxClientes.getValue().toString(), datePicker.getValue().toString(),
                            comboBoxHora.getValue().toString(), textFieldDoctora.getText());
                    logicaPila.EscribeArchivoSolicitudCita(cita);

                    Acciones acciones = new Acciones(inicioSesion.ID, "Solicitó una cita", fechaHora.histoFechaHora());
                    logicaAVL.escribeHistorial(acciones);

                    botonGuardar.setDisable(true);
                    comboBoxClientes.setDisable(true);
                    comboBoxHora.setDisable(true);
                    datePicker.setDisable(true);
                    textFieldIDReservacion.setDisable(true);
                    textFieldIDReservacion.clear();
                    comboBoxClientes.setValue("Clientes");
                    comboBoxHora.setValue("Hora de cita");
                    datePicker.setValue(LocalDate.now());

                    alerta.alertInformation("Cita agendada, correctamente");
                } else {
                    alerta.alertWarning("Campos en blanco\nIntentelo de nuevo");
                }
            } else {
                alertas.alertWarning("No seleccionó la hora de cita\nIntentelo de nuevo");
            }
        });

        MainMenuBarAdministrador mainMenuBarAdmin = new MainMenuBarAdministrador();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReservaCita.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneReservaCita.getChildren().clear();
            gridPaneReservaCita.setBackground(Background.EMPTY);
            gridPaneReservaCita.getChildren().add(mainMenuBarAdmin.menuAdministrador());

        });

        return gridPaneReservaCita;
    }//end gridPaneReservaCita

}// end ReservaCita 
