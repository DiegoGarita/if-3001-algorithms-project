package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.Utilitario.Calendario;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class SolicitaCita {

    TextField textFieldIDReservacion;
    Button botonGuardar;
    ComboBox comboBoxDoctora = new ComboBox();
    ComboBox comboBoxHora = new ComboBox();
    DatePicker datePicker;

    LogicaPila logicaPila = new LogicaPila();
    LogicaListas logicaListas = new LogicaListas();
    IniciarSesion inicioSesion;
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Calendario calendario = new Calendario();
    Alertas alerta = new Alertas();
    LogicaCola logicaCola = new LogicaCola();

    public GridPane solicitaCita() {

        GridPane gridPaneSolicitaCita = new GridPane();
        gridPaneSolicitaCita.setMinSize(600, 700);
        gridPaneSolicitaCita.setVgap(15);
        gridPaneSolicitaCita.setHgap(15);
        gridPaneSolicitaCita.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPaneSolicitaCita.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldIDReservacion = new TextField();
        textFieldIDReservacion.setPromptText("ID reservacion");
        textFieldIDReservacion.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneSolicitaCita.add(textFieldIDReservacion, 0, 1);
        textFieldIDReservacion.setFocusTraversable(false);
        textFieldIDReservacion.setOnKeyPressed((event) -> {
            datePicker.setDisable(false);
        });

        datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);
        datePicker.setDayCellFactory(calendario.dayCellFactory);
        datePicker.setDisable(true);
        gridPaneSolicitaCita.add(datePicker, 0, 2);
        datePicker.setOnMouseClicked((event) -> {
            comboBoxHora.getItems().clear();
            comboBoxHora.setDisable(false);

        });

        comboBoxHora.setValue("Hora de la cita");
        comboBoxHora.setDisable(true);
        comboBoxHora.setEditable(false);
        gridPaneSolicitaCita.add(comboBoxHora, 0, 3);
        comboBoxHora.setOnMouseClicked((event) -> {
            comboBoxDoctora.setDisable(false);
            comboBoxHora.setEditable(false);
            logicaPila.leeArchivoHoraFecha(datePicker.getValue().toString());
            int tam = logicaPila.tamanio();
            for (int i = Integer.parseInt(configuracion.getAbreClinica());
                    i < Integer.parseInt(configuracion.getCierreClinica());
                    i = i + Integer.parseInt(configuracion.getTiempoConsulta())) {
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

        });

        comboBoxDoctora.setEditable(false);
        comboBoxDoctora.setValue("Doctora");
        comboBoxDoctora.setStyle("-fx-background-color: lightblue");
        gridPaneSolicitaCita.add(comboBoxDoctora, 0, 4);
        comboBoxDoctora.setFocusTraversable(false);
        comboBoxDoctora.setDisable(true);

        for (int i = 0; i < logicaCola.cantidadDeClientes("ö"); i++) {
            comboBoxDoctora.getItems().addAll(logicaCola.arrayListClientes.get(i).getName());
        }
        comboBoxDoctora.setOnMouseClicked((event) -> {
            botonGuardar.setDisable(false);
        });

        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea(inicioSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);
        botonGuardar.setStyle("-fx-background-color: BLACK");
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneSolicitaCita.add(botonGuardar, 0, 7);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {

            if (comboBoxHora.getSelectionModel().getSelectedItem().equals("Hora de la cita") != true
                    && comboBoxDoctora.getSelectionModel().getSelectedItem().equals("Doctora") != true) {

                if (!textFieldIDReservacion.getText().trim().equals("")) {

                    Cita cita = new Cita(textFieldIDReservacion.getText(), usuario.getId(), datePicker.getValue().toString(),
                            comboBoxHora.getValue().toString(), comboBoxDoctora.getValue().toString());
                    logicaPila.EscribeArchivoSolicitudCita(cita);

                    Acciones acciones = new Acciones(inicioSesion.ID, "Solicitó una cita", fechaHora.histoFechaHora());
                    logicaAVL.escribeHistorial(acciones);

                    alerta.alertInformation("Cita reservada con exito");
                    textFieldIDReservacion.clear();
                    comboBoxHora.setValue("Hora de cita");
                    datePicker.setValue(LocalDate.now());
                    botonGuardar.setDisable(true);
                    comboBoxDoctora.setDisable(true);
                    comboBoxHora.setDisable(true);
                    datePicker.setDisable(true);
                }
                else {
                    alerta.alertWarning("Hay campos vacíos\nIntentelo de nuevo");
                }

            }
            else {
                alerta.alertWarning("No seleccionó la hora de cita o doctora\nIntentelo de nuevo");
            }
        });

        MainMenuBarCliente mainMenuBarCliente = new MainMenuBarCliente();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneSolicitaCita.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneSolicitaCita.getChildren().clear();
            gridPaneSolicitaCita.setBackground(Background.EMPTY);
            gridPaneSolicitaCita.getChildren().add(mainMenuBarCliente.menuCliente());

        });

        Label aclaracion1 = new Label();
        aclaracion1.setText("* Es de suma importancia que recuerde el ID de su cita\n"
                + "Ya que si desea modificar/cancelar este será necesario");
        aclaracion1.setFont(new Font("Arial", 15));
        aclaracion1.setTextFill(Color.web("#0076a3"));
        aclaracion1.setStyle("-fx-font-weight: bold");
        aclaracion1.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneSolicitaCita.add(aclaracion1, 0, 9);

        GridPane.setColumnSpan(aclaracion1, Integer.BYTES);

        return gridPaneSolicitaCita;
    }//end gridPaneSolicitaCita
}
