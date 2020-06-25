package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class MainMenuBarSuperAdmi {

    HorarioTiempoClinica horarioTiempoClinica = new HorarioTiempoClinica();

    LogoApp logo = new LogoApp();
    IndicarPath indicadorPath = new IndicarPath();
    ReportesAcciones reportesAcciones = new ReportesAcciones();
    RespaldarArchivos respaldarArchivos = new RespaldarArchivos();
    ResgistrosPaginacion registrosPaginacion = new ResgistrosPaginacion();

    public GridPane menuSuperAdmi() {

        GridPane gridPaneSuperAdmi = new GridPane();
        gridPaneSuperAdmi.setMinSize(900, 700);
        gridPaneSuperAdmi.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MenuBar menuBarMenu = new MenuBar();

        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        SeparatorMenuItem separator = new SeparatorMenuItem();
        
        Menu menuAjustes = new Menu("Ajustes", new ImageView(new Image("file:src/image/ajus.png")));
        menuAjustes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        
        MenuItem menuItemHorario = new MenuItem("Horario clínica y tiempo de consulta",
                new ImageView(new Image("file:src/image/tiempo.png")));
        menuItemHorario.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));

        menuItemHorario.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            gridPaneSuperAdmi.getChildren().addAll(horarioTiempoClinica.horarioClinica());
        });
        
        menuAjustes.getItems().addAll(menuItemHorario);

        Menu menuRegistros = new Menu("Registros", new ImageView(new Image("file:src/image/reporte.png")));
        menuRegistros.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemReporAcciones = new MenuItem("Reportes de acciones", new ImageView(new Image("file:src/image/histo.png")));
        menuItemReporAcciones.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemRespaldar = new MenuItem("Respaldar archivos", new ImageView(new Image("file:src/image/respal.png")));
        MenuItem menuItemNumPag = new MenuItem("Número de registros, paginacion", new ImageView(new Image("file:src/image/numRegis.png")));

        menuItemReporAcciones.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            gridPaneSuperAdmi.getChildren().addAll(reportesAcciones.historial());
        });
        menuItemRespaldar.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            gridPaneSuperAdmi.getChildren().addAll(respaldarArchivos.respaldo());

        });
        menuItemNumPag.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
        });

        menuRegistros.getItems().addAll(menuItemReporAcciones, menuItemRespaldar, menuItemNumPag);

        Menu menuOtros = new Menu("Otros", new ImageView(new Image("file:src/image/otros.png")));
        menuOtros.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemSearchCatalogue = new MenuItem("Logo del app", new ImageView(new Image("file:src/image/logo.png")));
        menuItemSearchCatalogue.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        MenuItem menuItemModifyCatalogue = new MenuItem("Seleccionar path", new ImageView(new Image("file:src/image/pathS.png")));

        menuItemSearchCatalogue.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            gridPaneSuperAdmi.getChildren().addAll(logo.logoApp());
        });

        menuItemModifyCatalogue.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            gridPaneSuperAdmi.getChildren().addAll(indicadorPath.path());
        });

        menuOtros.getItems().addAll(menuItemSearchCatalogue, menuItemModifyCatalogue, separator);

        Menu menuUsuario = new Menu("                                                      "
                + "                                                                                                      Usuario");
        MenuItem menuItemExit = new MenuItem("Cerrar sesion", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuUsuario.getItems().addAll(menuItemExit);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });
        menuBarMenu.getMenus().addAll(menuAjustes, menuRegistros, menuOtros, menuUsuario);
        gridPaneSuperAdmi.add(menuBarMenu, 0, 0);

        return gridPaneSuperAdmi;

    }//end Scene getMainScene()
}
