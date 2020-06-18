package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ModificaCancelaCita {

    TextField textFieldNombre;
    Button buttonDesplegar;
    TextField textFieldId;

    Button buttonModificar;
    Button buttonCancelarCita;
    Button buttonAceparModifi;
    Button buttonAcepId;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxHora = new ComboBox();
    String modiCita = "Modifico cita";
    String cancelCita = "Cancelo cita";

    LogicaListas logica = new LogicaListas();
    IniciarSesion iniciarSesion;
    LogoApp logo = new LogoApp();
    LogicaPila logicaCliente = new LogicaPila();

    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane modificaCancelaCita() {
        GridPane gridPaneModificaCancela = new GridPane();
        gridPaneModificaCancela.setMinSize(600, 700);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        gridPaneModificaCancela.setVgap(15);
        gridPaneModificaCancela.setHgap(15);
        gridPaneModificaCancela.setAlignment(Pos.CENTER);
        Usuario usuarioTemp = logica.stringTokenizer(logica.leeLinea("ë"));

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

        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);
        gridPaneModificaCancela.add(datePicker, 0, 2);
        datePicker.setDisable(true);

        for (int i = Integer.parseInt(configuracion.getAbreClinica());
                i < Integer.parseInt(configuracion.getCierreClinica());
                i = i + Integer.parseInt(configuracion.getTiempoConsulta())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
            // que vengan desde superAdmin -->> Consultas cada hora
            comboBoxHora.getItems().addAll(i + ":00");
        }
        comboBoxHora.setDisable(true);
        gridPaneModificaCancela.add(comboBoxHora, 1, 2);

        buttonModificar = new Button("Modificar");
        buttonModificar.setTextFill(Color.WHITE);
        buttonModificar.setStyle("-fx-background-color: BLACK");
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonModificar, 0, 1);
        buttonModificar.setDisable(true);
        buttonModificar.setOnAction((event) -> {

            datePicker.setDisable(false);
            comboBoxHora.setDisable(false);
            buttonAceparModifi.setDisable(false);

        });//end setOnAction

        buttonCancelarCita = new Button("Cancelar cita");
        buttonCancelarCita.setTextFill(Color.WHITE);
        buttonCancelarCita.setStyle("-fx-background-color: BLACK");
        buttonCancelarCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonCancelarCita, 1, 1);
        buttonCancelarCita.setDisable(true);
        buttonCancelarCita.setOnAction((event) -> {

            Cita cita = logicaCliente.stringTokenizer(logicaCliente.leeLinea(textFieldId.getText()));
            logicaCliente.leeArchivoSolicitudCita();   // ------------>>> Linea cerda del problema -805306369
            logicaCliente.elimina(cita);
            logicaCliente.remueveLineaDelArchivo(cita.getIDCita()); //----->> Linea que me duplica

            Acciones acciones = new Acciones(iniciarSesion.ID, "Eliminó su cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);

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
                    datePicker.getValue().toString(), comboBoxHora.getValue().toString(), cita.getDoctora());

            logicaCliente.leeArchivoSolicitudCita();
            logicaCliente.remueveLineaDelArchivo(cita.getIDCita());
            logicaCliente.EscribeArchivoSolicitudCita(citaAux);

            Acciones acciones = new Acciones(iniciarSesion.ID, "Modificó su cita", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);

        });//end setOnAction

        buttonAcepId = new Button("Aceptar");
        buttonAcepId.setTextFill(Color.WHITE);
        buttonAcepId.setStyle("-fx-background-color: BLACK");
        buttonAcepId.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneModificaCancela.add(buttonAcepId, 1, 0);
        buttonAcepId.setOnAction((event) -> {

            buttonModificar.setDisable(false);
            buttonCancelarCita.setDisable(false);

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
