package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;

public class MainMenuBarSesion {

    AcercaDe acercaDe = new AcercaDe();
    Ayuda ayuda = new Ayuda();
    Creditos creditos = new Creditos();
    CrearUsuarioNuevo crearUsuarionuevo = new CrearUsuarioNuevo();
    IniciarSesion entra = new IniciarSesion();
    VBox vBoxWindows, vBoxMain;
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    Alertas alerta = new Alertas();

    public Scene getMainScene() {

        vBoxMain = new VBox();
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        vBoxMain.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Scene scene = new Scene(vBoxMain, 900, 700);
        vBoxWindows = new VBox();

        MenuBar menuBarMenu = new MenuBar();
        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        Menu menuSystem = new Menu("Sistema", new ImageView(new Image("file:src/image/sistema.png")));
        menuSystem.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemAbout = new MenuItem("Acerca de", new ImageView(new Image("file:src/image/aD.png")));
        MenuItem menuItemCredits = new MenuItem("Créditos", new ImageView(new Image("file:src/image/credi.png")));
        menuItemCredits.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        MenuItem menuItemPerformance = new MenuItem("Funcionamiento", new ImageView(new Image("file:src/image/preg.png")));
        menuItemPerformance.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemCredits.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(creditos.getGraphicalUserInterfaceCreditos());
        });

        menuItemAbout.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(acercaDe.getGraphicalUserInterfaceAcercaDe());
        });

        menuItemPerformance.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(ayuda.getGraphicalUserInterfaceAyuda());
        });

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuSystem.getItems().addAll(menuItemAbout, menuItemCredits, menuItemPerformance, menuItemExit);

        Menu menuCrearUsuario = new Menu("Cuenta", new ImageView(new Image("file:src/image/regis.png")));
        menuCrearUsuario.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemCreaCuenta = new MenuItem("Crear cuenta", new ImageView(new Image("file:src/image/nuevo.png")));
        menuItemCreaCuenta.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

        MenuItem menuItemIngresar = new MenuItem("Ingresar", new ImageView(new Image("file:src/image/ingr.png")));
        menuItemIngresar.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));

        menuItemCreaCuenta.setOnAction((event) -> {
            try {
                vBoxWindows.getChildren().clear();
                vBoxWindows.getChildren().addAll(crearUsuarionuevo.creaUsuario());
            } catch (java.lang.NullPointerException jlnpe) {
                alerta.alertWarning("Se esta usando por primera el app\nIngrese como SuperAdmin");
            }
        });

        menuItemIngresar.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(entra.iniciarSesion());
        });

        menuCrearUsuario.getItems().addAll(menuItemCreaCuenta, menuItemIngresar);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        menuBarMenu.getMenus().addAll(menuSystem, menuCrearUsuario);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);

        return scene;

    }//end Scene getMainScene()

}//end MainMenuBarSesion
