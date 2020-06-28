package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Utilitario.Grafico;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReporteProgreso {

    Button buttonGraficoActual;
    Button buttonGraficoInicial;
    Grafico grafico = new Grafico();

    IniciarSesion iniciarSesion;
    LogicaListas logicaListas = new LogicaListas();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Alertas alertas = new Alertas();

    public GridPane reporteProgreso() {

        GridPane gridPaneReportePorgreso = new GridPane();
        gridPaneReportePorgreso.setMinSize(600, 700);
        gridPaneReportePorgreso.setVgap(15);
        gridPaneReportePorgreso.setHgap(15);
        gridPaneReportePorgreso.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPaneReportePorgreso.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));
        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        Label labelNombre = new Label("Nombre: " + usuario.getName());
        labelNombre.setFont(new Font("Arial", 15));
        labelNombre.setStyle("-fx-font-weight: bold");
        labelNombre.setTextFill(Color.web("#0076a3"));
        labelNombre.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneReportePorgreso.add(labelNombre, 0, 0);

        Label labelCedula = new Label("Cédula: " + usuario.getId());
        labelCedula.setFont(new Font("Arial", 15));
        labelCedula.setStyle("-fx-font-weight: bold");
        labelCedula.setTextFill(Color.web("#0076a3"));
        labelCedula.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneReportePorgreso.add(labelCedula, 0, 1);

        Label labelTelefono = new Label("Teléfono: " + usuario.getTelefono());
        labelTelefono.setFont(new Font("Arial", 15));
        labelTelefono.setStyle("-fx-font-weight: bold");
        labelTelefono.setTextFill(Color.web("#0076a3"));
        labelTelefono.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneReportePorgreso.add(labelTelefono, 0, 2);

        buttonGraficoActual = new Button("Ver datos recientes");
        buttonGraficoActual.setTextFill(Color.WHITE);
        buttonGraficoActual.setStyle("-fx-background-color: BLACK");
        buttonGraficoActual.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReportePorgreso.add(buttonGraficoActual, 3, 3);
        buttonGraficoActual.setOnAction((event) -> {
            try {
                grafico.MuestraGraficoActual();
                Acciones acciones = new Acciones(iniciarSesion.ID, "Revisó su progreso graficamente", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);
                buttonGraficoActual.setDisable(true);
            }
            catch (java.lang.NumberFormatException kk) {
                alertas.alertWarning("No hay informacion por mostrar, debe tener una primer cita\nO no se hizo un registro correcto");
            }
        });

        buttonGraficoInicial = new Button("Ver datos iniciales");
        buttonGraficoInicial.setTextFill(Color.WHITE);
        buttonGraficoInicial.setStyle("-fx-background-color: BLACK");
        buttonGraficoInicial.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReportePorgreso.add(buttonGraficoInicial, 1, 3);
        buttonGraficoInicial.setOnAction((event) -> {
            try {
                grafico.MuestraGraficoInicial();
                buttonGraficoInicial.setDisable(true);
            }
            catch (java.lang.NumberFormatException nfe) {
                alertas.alertWarning("No hay informacion por mostrar, debe tener una primer cita\nO no se hizo un registro correcto");
            }
        });

        MainMenuBarCliente mainMenuBarCliente = new MainMenuBarCliente();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReportePorgreso.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneReportePorgreso.getChildren().clear();
            gridPaneReportePorgreso.setBackground(Background.EMPTY);
            gridPaneReportePorgreso.getChildren().add(mainMenuBarCliente.menuCliente());

        });

        return gridPaneReportePorgreso;
    }//end gridPaneReportePorgreso()
}
