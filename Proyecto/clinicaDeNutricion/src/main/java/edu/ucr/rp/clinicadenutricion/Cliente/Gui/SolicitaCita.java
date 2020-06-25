package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.Utilitario.Calendario;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class SolicitaCita {

    TextField textFieldIDReservacion;
    TextField textFieldDoctora;
    Button botonGuardar;
    ComboBox comboBoxHora = new ComboBox();
    
    LogicaPila LogicaCliente = new LogicaPila();
    LogicaListas logic = new LogicaListas();
    IniciarSesion inicioSesion;
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    Calendario calendarioParaCitas = new Calendario();
    Alertas alerta = new Alertas();
    DatePicker dT_DateFligth;

    public GridPane solicitaCita() {

        GridPane gridPaneSolicitaCita = new GridPane();
        gridPaneSolicitaCita.setMinSize(600, 700);
        gridPaneSolicitaCita.setVgap(15);
        gridPaneSolicitaCita.setHgap(15);
        gridPaneSolicitaCita.setAlignment(Pos.CENTER);

        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));

        gridPaneSolicitaCita.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldIDReservacion = new TextField(); //--->> Buscar forma de que sea unico para cada cita reservada
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
            dT_DateFligth.setDisable(false);
        });

        dT_DateFligth = new DatePicker(LocalDate.now());
        dT_DateFligth.setEditable(false);
        dT_DateFligth.setDayCellFactory(calendarioParaCitas.dayCellFactory);
        dT_DateFligth.setDisable(true);
        gridPaneSolicitaCita.add(dT_DateFligth, 0, 2);
        dT_DateFligth.setOnMouseClicked((event) -> {
            comboBoxHora.getItems().clear();
            comboBoxHora.setDisable(false);

        });

        comboBoxHora.setValue("Hora de la cita");
        comboBoxHora.setDisable(true);
        gridPaneSolicitaCita.add(comboBoxHora, 0, 3);

        comboBoxHora.setOnMouseEntered((event) -> {
            textFieldDoctora.setDisable(false);
            comboBoxHora.setEditable(false);
            LogicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString());
            int tam = LogicaCliente.tamanio();
            for (int i = Integer.parseInt(configuracion.getAbreClinica());
                    i < Integer.parseInt(configuracion.getCierreClinica());
                    i = i + Integer.parseInt(configuracion.getTiempoConsulta())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
                if (tam != 0) {
                    for (int j = 0; j < tam; j++) {
                        if (comboBoxHora.getItems().contains(+j + ":00")) {
                            comboBoxHora.getItems().remove(j);
                        }

                        if (Integer.parseInt(LogicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) != i) {
                            if (i < 10) {
                                if (comboBoxHora.getItems().contains("0" + Integer.parseInt(LogicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00") || comboBoxHora.getItems().contains("0" + i + ":00")) {
                                    comboBoxHora.getItems().removeAll("0" + Integer.parseInt(LogicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00");
                                    comboBoxHora.getItems().removeAll("0" + i + ":00");
                                }
                                comboBoxHora.getItems().addAll("0" + i + ":00");

                            } else {
                                if (comboBoxHora.getItems().contains(+Integer.parseInt(LogicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00") || comboBoxHora.getItems().contains(+i + ":00")) {
                                    comboBoxHora.getItems().removeAll(+Integer.parseInt(LogicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00");
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

        textFieldDoctora = new TextField();
        textFieldDoctora.setPromptText("Doctora");
        textFieldDoctora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneSolicitaCita.add(textFieldDoctora, 0, 4);
        textFieldDoctora.setFocusTraversable(false);
        textFieldDoctora.setDisable(true);
        textFieldDoctora.setOnKeyPressed((event) -> {
            botonGuardar.setDisable(false);
        });

        Usuario usuario = logic.stringTokenizer(logic.leeLinea(inicioSesion.ID));
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
            
            if (!textFieldIDReservacion.getText().trim().equals("") 
                && !textFieldDoctora.getText().trim().equals("")){

            Cita cita = new Cita(textFieldIDReservacion.getText(), usuario.getId(), dT_DateFligth.getValue().toString(),
                    comboBoxHora.getValue().toString(), textFieldDoctora.getText());
            LogicaCliente.EscribeArchivoSolicitudCita(cita);

            Acciones acciones = new Acciones(inicioSesion.ID, "Solicitó una cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);

            alerta.alertInformation("Cita reservada con exito");
            textFieldIDReservacion.clear();
            textFieldDoctora.clear();
            comboBoxHora.setValue("Hora de cita");
            dT_DateFligth.setValue(LocalDate.now());
            botonGuardar.setDisable(true);
            textFieldDoctora.setDisable(true);
            comboBoxHora.setDisable(true);
            dT_DateFligth.setDisable(true);
            }//end if
            else {
                alerta.alertWarning("Hay campos vacios\nIntentelo de nuevo");
            }//end else
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

        });//end btn cerrar

        return gridPaneSolicitaCita;
    }//end GridPane createCatalogue()
}
