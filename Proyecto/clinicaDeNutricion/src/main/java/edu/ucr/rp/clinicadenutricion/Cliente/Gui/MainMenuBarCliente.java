package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.application.Platform;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class MainMenuBarCliente {

    ReporteCitas reporteCitas = new ReporteCitas();
    ReporteProgreso reporteProgreso = new ReporteProgreso();
    SolicitaCita solicitaCita = new SolicitaCita();
    ModificaCancelaCita modificaCancelaCita = new ModificaCancelaCita();
    PlanesAlimenticios planesAlimenticios = new PlanesAlimenticios();
    AjustesCliente ajustesCliente = new AjustesCliente();
    Alertas alerta = new Alertas();
    
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane menuCliente() {

        GridPane gridPaneUsuario = new GridPane();
        gridPaneUsuario.setMinSize(900, 700);

        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));

        gridPaneUsuario.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MenuBar menuBarMenu = new MenuBar();

        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        SeparatorMenuItem separator = new SeparatorMenuItem();
        Menu menuReportes = new Menu("Reportes", new ImageView(new Image("file:src/image/reporte.png")));
        menuReportes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemProgreso = new MenuItem("Progreso", new ImageView(new Image("file:src/image/progre.png")));
        menuItemProgreso.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemCitas = new MenuItem("Historial de citas", new ImageView(new Image("file:src/image/histo.png")));
        menuItemCitas.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));

        menuItemCitas.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(reporteCitas.reporteCita());
        });

        menuItemProgreso.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(reporteProgreso.reporteProgreso());
        });

        menuReportes.getItems().addAll(menuItemProgreso, menuItemCitas);

        Menu menuNuevaCita = new Menu("Citas", new ImageView(new Image("file:src/image/cita.png")));
        menuNuevaCita.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemSolicitaCita = new MenuItem("Solicitar cita", new ImageView(new Image("file:src/image/reservaCita.png")));
        menuItemSolicitaCita.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemModiCancela = new MenuItem("Modificar/Cancelar cita", new ImageView(new Image("file:src/image/canModi.png")));

        menuItemSolicitaCita.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(solicitaCita.solicitaCita());
        });
        menuItemModiCancela.setOnAction((event) -> {
            try {
                gridPaneUsuario.getChildren().clear();
                gridPaneUsuario.getChildren().addAll(modificaCancelaCita.modificaCancelaCita());
            } catch (java.lang.NullPointerException e) {
                alerta.alertWarning("Error, primero debe agendar una cita\nsi desea ingresar aquí");
                Platform.exit();
            }

        });
        menuNuevaCita.getItems().addAll(menuItemSolicitaCita, menuItemModiCancela);

        Menu menuPlanes = new Menu("Planes alimentarios", new ImageView(new Image("file:src/image/planAli.png")));
        menuPlanes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemPalnes = new MenuItem("Ver planes", new ImageView(new Image("file:src/image/verPlan.png")));
        menuItemPalnes.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(planesAlimenticios.misPlanesAlimentos());
        });
        menuPlanes.getItems().addAll(menuItemPalnes);

        Menu menuAjustes = new Menu("Ajustes", new ImageView(new Image("file:src/image/ajus.png")));
        menuAjustes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemCuenta = new MenuItem("Cuenta", new ImageView(new Image("file:src/image/usua.png")));
        menuItemCuenta.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));

        menuItemCuenta.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(ajustesCliente.ajustesCliente());
        });
        menuAjustes.getItems().addAll(menuItemCuenta, separator);

        Menu menuMas = new Menu("Mas", new ImageView(new Image("file:src/image/ma.png")));
        menuMas.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemMasInfo = new MenuItem("Encuentra más información", new ImageView(new Image("file:src/image/pagW.png")));
        menuItemMasInfo.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));

        //  link.setText("");
        menuItemMasInfo.setOnAction((event) -> {
            System.out.println("entro pero no voy");
            Hyperlink link = new Hyperlink();
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://clinicasusanadistancia.wordpress.com/"));
                } catch (IOException | URISyntaxException io) {
                    System.out.println("No sirvo");
                }
            }
        });

        menuMas.getItems().addAll(menuItemMasInfo);

        Menu menuUsuario = new Menu("                                               "
                + "                                                Usuario");
        MenuItem menuItemExit = new MenuItem("Cerrar sesion", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuUsuario.getItems().addAll(menuItemExit);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        menuBarMenu.getMenus().addAll(menuReportes, menuNuevaCita, menuPlanes, menuAjustes, menuMas, menuUsuario);
        gridPaneUsuario.add(menuBarMenu, 0, 0);

        return gridPaneUsuario;

    }//end Scene getMainScene()
}//end class MainMenuBarCliente 
