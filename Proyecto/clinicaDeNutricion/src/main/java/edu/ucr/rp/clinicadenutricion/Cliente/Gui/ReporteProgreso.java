package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Utilitario.Grafico;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase el cliente podra ver su avance
public class ReporteProgreso {

    IniciarSesion iniciarSesion;
    Button buttonGrafico;
    String repoPro = "Vio su progreso";
    Grafico grafico = new Grafico();
    LogicaListas logicaListas = new LogicaListas();
    LogoApp logo = new LogoApp();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane reporteProgreso() {

        GridPane gridPaneReportePorgreso = new GridPane();
        gridPaneReportePorgreso.setMinSize(600, 700);
        gridPaneReportePorgreso.setVgap(15);
        gridPaneReportePorgreso.setHgap(15);
        gridPaneReportePorgreso.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
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

        buttonGrafico = new Button("Ver grafica");
        buttonGrafico.setTextFill(Color.WHITE);
        buttonGrafico.setStyle("-fx-background-color: BLACK");
        buttonGrafico.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReportePorgreso.add(buttonGrafico, 0, 7);

        buttonGrafico.setOnAction((event) -> {

            grafico.MuestraGrafico(); //--> %agua, %masMusc, grasa , grasaVisc
            Acciones acciones = new Acciones(iniciarSesion.ID, "Revisó su progreso graficamente", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);
        });//END BUTTON

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
    }//end GridPane createCatalogue()
}
