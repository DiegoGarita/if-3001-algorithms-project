package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReporteCitas {

    String repoCita = "Vio su reporte de citas";
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaPila logicaCliente = new LogicaPila();

    LogicaListas logicaListas = new LogicaListas();
    IniciarSesion iniciarSesion;
    LogoApp logo = new LogoApp();

    public GridPane reporteCita() {

  
        GridPane gridPaneReporteCitas = new GridPane();
        gridPaneReporteCitas.setMinSize(300, 350);
        gridPaneReporteCitas.setVgap(15);
        gridPaneReporteCitas.setHgap(15); 
        gridPaneReporteCitas.setAlignment(Pos.CENTER);
        Usuario usuarioTemp = logicaListas.stringTokenizer(logicaListas.leeLinea("ë"));
        gridPaneReporteCitas.setStyle(("-fx-background-image:url('file:src/image/" + usuarioTemp.getContraseña() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }


        Acciones acciones = new Acciones(usuario.getName(), repoCita, fechaHora.histoFechaHora());
        logicaAVL.escribeHistorial(acciones);

        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        
        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReporteCitas.add(buttonCerrar, 0, 6);
        buttonCerrar.setOnAction((event) -> {
            gridPaneReporteCitas.getChildren().clear();
            gridPaneReporteCitas.setBackground(Background.EMPTY);
            gridPaneReporteCitas.getChildren().add(barCliente.menuCliente());
        });

        logicaCliente.leeArchivoSolicitudCita();

        return gridPaneReporteCitas;

    }
}//end class reporte citas
