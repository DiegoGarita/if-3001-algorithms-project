package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.Gui.MainMenuBarAdministrador;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Cliente.Gui.MainMenuBarCliente;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaArbol;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.MainMenuBarSuperAdmi;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ImplementacionCola;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class IniciarSesion {

    public static String ID;

    TextField textFieldID;
    PasswordField textFieldContraseña;
    Button buttonCreaUsuario;

    LogicaListas logicaListas = new LogicaListas();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    MainMenuBarSuperAdmi mainMenuBarSuperAdmi = new MainMenuBarSuperAdmi();
    MainMenuBarAdministrador mainMenuBarAdministrador = new MainMenuBarAdministrador();
    MainMenuBarCliente mainMenuBarCliente = new MainMenuBarCliente();
    EncryptMD5 encrypt = new EncryptMD5();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Alertas alertas = new Alertas();

    public GridPane iniciarSesion() {

        GridPane gridPaneIniciarSesion = new GridPane();
        gridPaneIniciarSesion.setMinSize(600, 700);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPaneIniciarSesion.setVgap(15);
        gridPaneIniciarSesion.setHgap(15);
        gridPaneIniciarSesion.setAlignment(Pos.CENTER);
        gridPaneIniciarSesion.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldID = new TextField();
        textFieldID.setPromptText("Ingrese ID del usuario");
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneIniciarSesion.add(textFieldID, 0, 2);
        textFieldID.setFocusTraversable(false);
        textFieldID.setOnKeyPressed((event) -> {
            textFieldContraseña.setDisable(false);
        });

        textFieldContraseña = new PasswordField();
        textFieldContraseña.setPromptText("Contraseña");
        textFieldContraseña.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        textFieldContraseña.setDisable(true);
        gridPaneIniciarSesion.add(textFieldContraseña, 0, 3);
        textFieldContraseña.setFocusTraversable(false);
        textFieldContraseña.setOnKeyPressed((event) -> {
            buttonCreaUsuario.setDisable(false);
        });

        buttonCreaUsuario = new Button("Aceptar");
        buttonCreaUsuario.setTextFill(Color.WHITE);
        buttonCreaUsuario.setStyle("-fx-background-color: BLACK");
        buttonCreaUsuario.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        buttonCreaUsuario.setDisable(true);
        gridPaneIniciarSesion.add(buttonCreaUsuario, 0, 4);
        buttonCreaUsuario.setOnAction((event) -> {

            ///////////////////////////////////////////////////////////////////////////
//            System.out.println("\n Listas: \n");
//            logicaListas.leerArchivo();
//            logicaListas.muestra();
//            System.out.println("\n Colas: \n");
//            logicaSuperAdmin.readInFile();
//            logicaSuperAdmin.muestra();
//            System.out.println("\n Arbol binario: \n");
//            LogicaArbol l = new LogicaArbol();
//            l.leeArchivo("44444", 0);
//            l.muestra();
//            System.out.println("\n Pila: \n");
//            LogicaPila lp = new LogicaPila();
//            lp.leeArchivoSolicitudCita();
//            lp.muestra();
//            System.out.println("\n Arbol AVL: \n");
//            LogicaAVL lAVL = new LogicaAVL();
//            lAVL.leerHistorial();
//            lAVL.muestra();

            ////////////////////////////////////////////////////////////////////////////
            Node node = gridPaneIniciarSesion.getChildren().get(2);
            logicaListas.leerArchivo();

            if (textFieldID.getText().equals("Super") && encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()).equals("aWWPEVnhogU=")) {
                alertas.alertInformation("Bienvenido super administrador");
                gridPaneIniciarSesion.getChildren().clear();
                gridPaneIniciarSesion.getChildren().add(0, node);
                gridPaneIniciarSesion.getChildren().add(mainMenuBarSuperAdmi.menuSuperAdmi());
            } else if (logicaListas.busca(textFieldID.getText())) {

                gridPaneIniciarSesion.getChildren().clear();

                if (logicaListas.leeLinea(textFieldID.getText()).substring(0, 1).equals("ä")) {
                    if (logicaListas.stringTokenizer(logicaListas.leeLinea(textFieldID.getText())).getId().equals(textFieldID.getText())
                            && !textFieldID.getText().trim().equals("") && !textFieldContraseña.getText().trim().equals("")) {
                        if (logicaListas.stringTokenizer(logicaListas.leeLinea(textFieldID.getText())).getContraseña().equals(encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()))) {
                            alertas.alertInformation("Bienvenido usuario: " + logicaListas.stringTokenizer(logicaListas.leeLinea(textFieldID.getText())).getName());
                            ID = textFieldID.getText();
                            Acciones acciones = new Acciones(ID, "Inició sesión como cliente", fechaHora.histoFechaHora());
                            logicaAVL.escribeHistorial(acciones);
                            gridPaneIniciarSesion.getChildren().clear();
                            gridPaneIniciarSesion.getChildren().add(0, node);
                            gridPaneIniciarSesion.getChildren().add(mainMenuBarCliente.menuCliente());
                        } else {
                            alertas.alertInformation("Contraseña invalida, o espacios vacios\nPor favor intente de nuevo");
                            Acciones acciones = new Acciones(textFieldID.getText(), "Intentó iniciar sesión pero falló la contraseña", fechaHora.histoFechaHora());
                            logicaAVL.escribeHistorial(acciones);

                        }
                    }
                } else if (logicaListas.leeLinea(textFieldID.getText()).substring(0, 1).equals("ö")) {
                    if (logicaListas.stringTokenizer(logicaListas.leeLinea(textFieldID.getText())).getId().equals(textFieldID.getText())) {
                        if (logicaListas.stringTokenizer(logicaListas.leeLinea(textFieldID.getText())).getContraseña().equals(encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()))) {
                            alertas.alertInformation("Bienvenido administrador: " + logicaListas.stringTokenizer(logicaListas.leeLinea(textFieldID.getText())).getName());
                            ID = textFieldID.getText();
                            Acciones acciones = new Acciones(ID, "Inició sesión como admistrador", fechaHora.histoFechaHora());
                            logicaAVL.escribeHistorial(acciones);
                            gridPaneIniciarSesion.getChildren().add(0, node);
                            gridPaneIniciarSesion.getChildren().add(mainMenuBarAdministrador.menuAdministrador());

                        } else {
                            alertas.alertInformation("Contraseña invalida, por favor intente de nuevo");
                            Acciones acciones = new Acciones(textFieldID.getText(), "Intentó iniciar sesión pero falló la contraseña", fechaHora.histoFechaHora());
                            logicaAVL.escribeHistorial(acciones);

                        }
                    }

                }

            } else {
                Acciones acciones = new Acciones(textFieldID.getText(), ", usuario no registrado intentó iniciar sesión", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);
                alertas.alertInformation("Usuario: " + textFieldID.getText() + " no existe, registrese primero");
            }

        });

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneIniciarSesion.add(buttonCerrar, 2, 8);
        buttonCerrar.setOnAction((event) -> {

            gridPaneIniciarSesion.getChildren().clear();
            gridPaneIniciarSesion.setBackground(Background.EMPTY);

        });

        return gridPaneIniciarSesion;
    }//end iniciarSesion
}
