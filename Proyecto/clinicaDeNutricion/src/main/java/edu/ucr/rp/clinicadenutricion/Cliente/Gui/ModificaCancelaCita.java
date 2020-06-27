package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
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
    LogicaListas logica = new LogicaListas();
    IniciarSesion iniciarSesion;
    LogicaPila logicaCliente = new LogicaPila();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    Calendario calendarioParaCitas = new Calendario();
    Alertas alerta = new Alertas();

    public GridPane modificaCancelaCita() {
        GridPane gridPaneModificaCancela = new GridPane();
        gridPaneModificaCancela.setMinSize(600, 700);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        gridPaneModificaCancela.setVgap(15);
        gridPaneModificaCancela.setHgap(15);
        gridPaneModificaCancela.setAlignment(Pos.CENTER);

        gridPaneModificaCancela.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuario = logica.stringTokenizer(logica.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        Cita citaTrae = logicaCliente.stringTokenizer(logicaCliente.leeLinea(""));

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

            if (!textFieldId.getText().trim().equals("") && logicaCliente.existeCita(textFieldId.getText(), iniciarSesion.ID)) {

                buttonModificar.setDisable(false);
                buttonCancelarCita.setDisable(false);
                buttonAcepId.setDisable(true);
                textFieldId.setDisable(true);
            }//end if
            else {
                alerta.alertWarning("Campos vacios\nIntentelo de nuevo");
            }//end else
        });//end setOnAction

        DatePicker dT_DateFligth = new DatePicker(LocalDate.now());
        dT_DateFligth.setEditable(false);
        dT_DateFligth.setDisable(true);
        dT_DateFligth.setDayCellFactory(calendarioParaCitas.dayCellFactory);
        gridPaneModificaCancela.add(dT_DateFligth, 0, 2);
        dT_DateFligth.setOnMouseClicked((event) -> {
            comboBoxHora.getItems().clear();
            comboBoxHora.setDisable(false);
        });

        comboBoxHora.setDisable(true);
        gridPaneModificaCancela.add(comboBoxHora, 1, 2);

        comboBoxHora.setOnMouseEntered((event) -> {
            buttonAceparModifi.setDisable(false);
            comboBoxHora.setEditable(false);
            logicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString());
            int tam = logicaCliente.tamanio();
            for (int i = Integer.parseInt(configuracion.getAbreClinica()); i < Integer.parseInt(configuracion.getCierreClinica()); i = i + Integer.parseInt(configuracion.getTiempoConsulta())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
                if (tam != 0) {
                    for (int j = 0; j < tam; j++) {
                        if (comboBoxHora.getItems().contains(+j + ":00")) {
                            comboBoxHora.getItems().remove(j);
                        }

                        if (Integer.parseInt(logicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) != i) {
                            if (i < 10) {
                                if (comboBoxHora.getItems().contains("0" + Integer.parseInt(logicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00") || comboBoxHora.getItems().contains("0" + i + ":00")) {
                                    comboBoxHora.getItems().removeAll("0" + Integer.parseInt(logicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00");
                                    comboBoxHora.getItems().removeAll("0" + i + ":00");
                                }
                                comboBoxHora.getItems().addAll("0" + i + ":00");

                            } else {
                                if (comboBoxHora.getItems().contains(+Integer.parseInt(logicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00") || comboBoxHora.getItems().contains(+i + ":00")) {
                                    comboBoxHora.getItems().removeAll(+Integer.parseInt(logicaCliente.leeArchivoHoraFecha(dT_DateFligth.getValue().toString()).get(j)) + ":00");
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

            dT_DateFligth.setDisable(false);
            buttonCancelarCita.setDisable(true);
            buttonModificar.setDisable(true);

        });//end setOnAction

        buttonCancelarCita = new Button("Cancelar cita");
        buttonCancelarCita.setTextFill(Color.WHITE);
        buttonCancelarCita.setStyle("-fx-background-color: BLACK");
        buttonCancelarCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonCancelarCita, 1, 1);
        buttonCancelarCita.setDisable(true);
        buttonCancelarCita.setOnAction((event) -> {

            Cita cita = logicaCliente.stringTokenizer(logicaCliente.leeLinea(textFieldId.getText()));
            logicaCliente.leeArchivoSolicitudCita();

            logicaCliente.elimina(cita);
            logicaCliente.remueveLineaDelArchivo(cita.getIDCita());

            Acciones acciones = new Acciones(iniciarSesion.ID, "Eliminó su cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);
            alerta.alertInformation("Se cancelo su cita, correctamente");
            textFieldId.clear();
            buttonModificar.setDisable(true);
            buttonCancelarCita.setDisable(true);

        });//end setOnAction

        buttonAceparModifi = new Button("Aceptar cambios");
        buttonAceparModifi.setTextFill(Color.WHITE);
        buttonAceparModifi.setStyle("-fx-background-color: BLACK");
        buttonAceparModifi.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonAceparModifi, 2, 2);
        buttonAceparModifi.setDisable(true);
        buttonAceparModifi.setOnAction((event) -> {

            Cita cita = logicaCliente.stringTokenizer(logicaCliente.leeLinea(textFieldId.getText()));
            Cita citaAux = new Cita(textFieldId.getText(), cita.getNombre(),
                    dT_DateFligth.getValue().toString(), comboBoxHora.getValue().toString(), cita.getDoctora());

            logicaCliente.leeArchivoSolicitudCita();
            logicaCliente.remueveLineaDelArchivo(cita.getIDCita());
            logicaCliente.EscribeArchivoSolicitudCita(citaAux);

            Acciones acciones = new Acciones(iniciarSesion.ID, "Modificó su cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);
            alerta.alertInformation("Se modifico su cita, correctamente");
            buttonAceparModifi.setDisable(true);
            comboBoxHora.setDisable(true);
            comboBoxHora.setValue("Hora de la cita");
            dT_DateFligth.setDisable(true);
            dT_DateFligth.setValue(LocalDate.now());
            textFieldId.clear();

        });//end setOnAction

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
    }//end GridPane createCatalogue()
}
