package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import javafx.application.Platform;
import javafx.scene.control.Label;
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

    ApartarCita apartarCita = new ApartarCita();
    ModificaCancelaCita modifCancela = new ModificaCancelaCita();

    PlanesAlimentacion planAlimentos = new PlanesAlimentacion();

    AjustesCliente ajustes = new AjustesCliente();

    // VBox vBoxWindows, vBoxMain;
    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
     */
    public GridPane menuCliente() {

        /// File file = new File(fileName);
        GridPane gridPaneUsuario = new GridPane();
        gridPaneUsuario.setMinSize(900, 700);
        gridPaneUsuario.setStyle("-fx-background-color: dodgerblue");

        MenuBar menuBarMenu = new MenuBar();
        //mB_Menu.setStyle("-fx-background-color: #0a5ba0;");
        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        SeparatorMenuItem separator = new SeparatorMenuItem();
        Menu menuReportes = new Menu("Reportes", new ImageView(new Image("file:src/image/reporte.png")));
        menuReportes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemProgreso = new MenuItem("Progreso", new ImageView(new Image("file:src/image/progre.png")));
        menuItemProgreso.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemCitas = new MenuItem("Historial de citas", new ImageView(new Image("file:src/image/histo.png")));
        menuItemCitas.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemCitas.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(reporteCitas.reporteCita());
        });

        menuItemProgreso.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(reporteProgreso.reporAvan());
        });

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuReportes.getItems().addAll(menuItemProgreso, menuItemCitas, menuItemExit);

        Menu menuNuevaCita = new Menu("Citas", new ImageView(new Image("file:src/image/cita.png")));
        menuNuevaCita.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemSolicitaCita = new MenuItem("Solicitar cita", new ImageView(new Image("file:src/image/reservaCita.png")));
        menuItemSolicitaCita.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemModiCancela = new MenuItem("Modificar/Cancelar cita", new ImageView(new Image("file:src/image/canModi.png")));

        menuItemSolicitaCita.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(apartarCita.reservar());
        });
        menuItemModiCancela.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(modifCancela.modiCancel());

        });
        menuNuevaCita.getItems().addAll(menuItemSolicitaCita, menuItemModiCancela);//agregados a m_Paises

        Menu menuPlanes = new Menu("Planes alimentarios", new ImageView(new Image("file:src/image/planAli.png")));
        menuPlanes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemPalnes = new MenuItem("Ver planes", new ImageView(new Image("file:src/image/verPlan.png")));
        //Funcionamiento
        menuItemPalnes.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(planAlimentos.misPlanesAlimentos());
        });
        menuPlanes.getItems().addAll(menuItemPalnes);//agregado a menuMaintenance

        Menu menuAjustes = new Menu("Ajustes", new ImageView(new Image("file:src/image/ajus.png")));
        menuAjustes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemCuenta = new MenuItem("Cuenta", new ImageView(new Image("file:src/image/usua.png")));
        menuItemCuenta.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));

        menuItemCuenta.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            gridPaneUsuario.getChildren().addAll(ajustes.ajustes());
        });
        menuAjustes.getItems().addAll(menuItemCuenta, separator);

        Menu menuMas = new Menu("Mas", new ImageView(new Image("file:src/image/ma.png")));
        menuMas.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemMasInfo = new MenuItem("Encuentra más info", new ImageView(new Image("file:src/image/pagW.png")));
        menuItemMasInfo.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));

        menuItemMasInfo.setOnAction((event) -> {
            gridPaneUsuario.getChildren().clear();
            // vBoxWindows.getChildren().addAll(catalogSearch.catalogueSearching());
        });
        menuMas.getItems().addAll(menuItemMasInfo);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        menuBarMenu.getMenus().addAll(menuReportes, menuNuevaCita, menuPlanes, menuAjustes, menuMas);
        gridPaneUsuario.add(menuBarMenu, 0, 0);

        return gridPaneUsuario;

    }//end Scene getMainScene()
}//end class MainMenuBarCliente 
