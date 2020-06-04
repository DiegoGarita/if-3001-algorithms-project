package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.EncripMD5;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

public class MainMenuBar {

    AcercaDe acercaDe = new AcercaDe();
    Ayuda ayuda = new Ayuda();
    Creditos creditos = new Creditos();

    CrearUsuarioNuevo crearUsuarionuevo = new CrearUsuarioNuevo();

    EncripMD5 encriptar = new EncripMD5();

    VBox vBoxWindows, vBoxMain;

    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
     */
    public Scene getMainScene() {

        vBoxMain = new VBox();
        //  vBoxMain.setStyle(("-fx-background-image:url('file:src/image/inicio1.jpg');"
        //           + "-fx-background-repeat : no-repeat;"
        //          + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        Scene scene = new Scene(vBoxMain, 900, 700);
        vBoxWindows = new VBox();

        MenuBar menuBarMenu = new MenuBar();
        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        SeparatorMenuItem separator = new SeparatorMenuItem();
        //Menu Sistema
        Menu menuSystem = new Menu("Sistema", new ImageView(new Image("file:src/image/sistema.png")));
        menuSystem.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemAbout = new MenuItem("Acerca de", new ImageView(new Image("file:src/image/aD.png")));
        menuItemAbout.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemCredits = new MenuItem("Créditos", new ImageView(new Image("file:src/image/credi.png")));
        menuItemCredits.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        MenuItem menuItemPerformance = new MenuItem("Funcionamiento", new ImageView(new Image("file:src/image/preg.png")));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemCredits.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            // vBoxWindows.getChildren().addAll(credits.getGraphicalUserInterfaceCredits());
        });

        menuItemAbout.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            // vBoxWindows.getChildren().addAll(about.getGraphicalUserInterfaceAbout());
        });

        menuItemPerformance.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            //  vBoxWindows.getChildren().addAll(help.getGraphicalUserInterfaceHelper());
        });

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuSystem.getItems().addAll(menuItemAbout, menuItemCredits, menuItemPerformance, menuItemExit);

        Menu menuCrearUsuario = new Menu("Registrarse", new ImageView(new Image("file:src/image/regis.png")));
        menuCrearUsuario.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemDefineCatalogue = new MenuItem("Crear cuenta", new ImageView(new Image("file:src/image/nuevo.png")));
        menuItemDefineCatalogue.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        menuItemDefineCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(crearUsuarionuevo.creaUsuario());
        });

        menuCrearUsuario.getItems().addAll(menuItemDefineCatalogue);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        TextField textFieldNombre = new TextField();
        textFieldNombre.setPromptText("Ingrese su nombre de usuario");

        TextField textFieldContraseña = new TextField();
        textFieldContraseña.setPromptText("Ingrese su contraseña");

        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setOnAction((event) -> {

            //encriptar.encriptar("clinicaSusanaDistancia", textFieldContraseña.getText());
            String cadenaEncriptada = encriptar.encriptar("clinicaSusanaDistancia", textFieldContraseña.getText());
            JOptionPane.showMessageDialog(null, "Cadena encriptada: " + cadenaEncriptada);
            String cadenaDesencriptada = encriptar.desencriptar("clinicaSusanaDistancia", cadenaEncriptada);
            JOptionPane.showMessageDialog(null, "Cadena desencriptada: " + cadenaDesencriptada);

        });

        menuBarMenu.getMenus().addAll(menuSystem, menuCrearUsuario);
        vBoxWindows.getChildren().add(textFieldNombre);
        vBoxWindows.getChildren().add(textFieldContraseña);
        vBoxWindows.getChildren().add(botonAceptar);

        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);
        return scene;

    }//end Scene getMainScene()

}//end MainMenuBar
