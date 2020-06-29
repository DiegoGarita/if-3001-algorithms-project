package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.Calendario;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ModificaCancelaCita {

    TextField textFieldId;
    Button buttonModificar;
    Button buttonCancelarCita;
    Button buttonAceparModifi;
    Button buttonAcepId;
    ComboBox comboBoxHora = new ComboBox();

    Alertas alertas = new Alertas();
    LogicaListas logicaListas = new LogicaListas();
    IniciarSesion iniciarSesion;
    LogicaPila logicaPila = new LogicaPila();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Calendario calendario = new Calendario();
    Alertas alerta = new Alertas();

    public GridPane modificaCancelaCita() {
        GridPane gridPaneModificaCancela = new GridPane();
        gridPaneModificaCancela.setMinSize(600, 700);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPaneModificaCancela.setVgap(15);
        gridPaneModificaCancela.setHgap(15);
        gridPaneModificaCancela.setAlignment(Pos.CENTER);

        gridPaneModificaCancela.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        textFieldId = new TextField();
        textFieldId.setPromptText("Id de cita");
        gridPaneModificaCancela.add(textFieldId, 0, 0);
        textFieldId.setOnKeyPressed((event) -> {
            buttonAcepId.setDisable(false);
        });

        buttonAcepId = new Button("Aceptar");
        buttonAcepId.setTextFill(Color.WHITE);
        buttonAcepId.setStyle("-fx-background-color: BLACK");
        buttonAcepId.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonAcepId, 1, 0);
        buttonAcepId.setDisable(true);
        buttonAcepId.setOnAction((event) -> {

            if (!textFieldId.getText().trim().equals("") && logicaPila.existeCita(textFieldId.getText(), iniciarSesion.ID)) {

                buttonModificar.setDisable(false);
                buttonCancelarCita.setDisable(false);
                buttonAcepId.setDisable(true);
                textFieldId.setDisable(true);
            } else {
                alerta.alertWarning("Espacios erróneos\n"
                        + "Verifique no dejar espacios vacíos y que el ID\n"
                        + "de su cita sea válido\nIntentelo de nuevo");
            }
        });

        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);
        datePicker.setDisable(true);
        datePicker.setDayCellFactory(calendario.dayCellFactory);
        gridPaneModificaCancela.add(datePicker, 0, 2);
        datePicker.setOnMouseClicked((event) -> {
            comboBoxHora.getItems().clear();
            comboBoxHora.setDisable(false);
        });

        comboBoxHora.setDisable(true);
        comboBoxHora.setValue("Nueva hora");
        gridPaneModificaCancela.add(comboBoxHora, 1, 2);
        comboBoxHora.setEditable(false);
        comboBoxHora.setOnMouseClicked((event) -> {
            buttonAceparModifi.setDisable(false);
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

        });

        buttonModificar = new Button("Modificar");
        buttonModificar.setTextFill(Color.WHITE);
        buttonModificar.setStyle("-fx-background-color: BLACK");
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonModificar, 0, 1);
        buttonModificar.setDisable(true);
        buttonModificar.setOnAction((event) -> {

            datePicker.setDisable(false);
            buttonCancelarCita.setDisable(true);
            buttonModificar.setDisable(true);

        });

        buttonCancelarCita = new Button("Cancelar cita");
        buttonCancelarCita.setTextFill(Color.WHITE);
        buttonCancelarCita.setStyle("-fx-background-color: BLACK");
        buttonCancelarCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonCancelarCita, 1, 1);
        buttonCancelarCita.setDisable(true);
        buttonCancelarCita.setOnAction((event) -> {

            Cita cita = logicaPila.stringTokenizer(logicaPila.leeLinea(textFieldId.getText()));
            logicaPila.leeArchivoSolicitudCita();
            logicaPila.elimina(cita);
            logicaPila.remueveLineaDelArchivo(cita.getIDCita());

            Acciones acciones = new Acciones(iniciarSesion.ID, "Eliminó su cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);
            alerta.alertInformation("Se cancelo su cita, correctamente");
            textFieldId.clear();
            buttonModificar.setDisable(true);
            buttonCancelarCita.setDisable(true);

        });

        buttonAceparModifi = new Button("Aceptar cambios");
        buttonAceparModifi.setTextFill(Color.WHITE);
        buttonAceparModifi.setStyle("-fx-background-color: BLACK");
        buttonAceparModifi.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonAceparModifi, 2, 2);
        buttonAceparModifi.setDisable(true);
        buttonAceparModifi.setOnAction((event) -> {

            if (comboBoxHora.getSelectionModel().getSelectedItem().equals("Nueva hora") != true) {

                Cita cita = logicaPila.stringTokenizer(logicaPila.leeLinea(textFieldId.getText()));
                Cita citaAux = new Cita(textFieldId.getText(), cita.getNombre(),
                        datePicker.getValue().toString(), comboBoxHora.getValue().toString(), cita.getDoctora());
                logicaPila.leeArchivoSolicitudCita();
                logicaPila.remueveLineaDelArchivo(cita.getIDCita());  //---> Cambio  cita por x citaAux(no funciono)
                logicaPila.EscribeArchivoSolicitudCita(citaAux);
                Acciones acciones = new Acciones(iniciarSesion.ID, "Modificó su cita", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);

                alerta.alertInformation("Se modificó su cita correctamente");
                buttonAceparModifi.setDisable(true);
                comboBoxHora.setDisable(true);
                comboBoxHora.setValue("Hora de la cita");
                datePicker.setDisable(true);
                datePicker.setValue(LocalDate.now());
                textFieldId.clear();
            } else {
                alertas.alertWarning("No seleccionó la hora de cita\nIntentelo de nuevo");
            }
        });

        MainMenuBarCliente mainMenuBarCliente = new MainMenuBarCliente();

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonCerrar, 0, 8);
        buttonCerrar.setOnAction((event) -> {

            gridPaneModificaCancela.getChildren().clear();
            gridPaneModificaCancela.setBackground(Background.EMPTY);
            gridPaneModificaCancela.getChildren().add(mainMenuBarCliente.menuCliente());

        });

        return gridPaneModificaCancela;
    }
}
