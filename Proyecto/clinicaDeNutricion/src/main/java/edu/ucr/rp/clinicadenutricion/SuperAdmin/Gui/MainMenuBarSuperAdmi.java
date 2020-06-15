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

    HorarioTiempoClinica horarioTiempo = new HorarioTiempoClinica();

    LogoApp logo = new LogoApp();
    IndicarPath indicadorPath = new IndicarPath();

    ReportesAcciones reportesAcciones = new ReportesAcciones();
    RespaldarArchivos respaldarArchivos = new RespaldarArchivos();
    ResgistrosPaginacion registrosPag = new ResgistrosPaginacion();

    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
     */
    public GridPane menuSuperAdmi() {

        /// File file = new File(fileName);
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
        //Menu Sistema
        Menu menuAjustes = new Menu("Ajustes", new ImageView(new Image("file:src/image/ajus.png")));
        menuAjustes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemHorario = new MenuItem("Horario clinica y tiempo de consulta",
                new ImageView(new Image("file:src/image/tiempo.png")));
        menuItemHorario.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));

        menuItemHorario.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            gridPaneSuperAdmi.getChildren().addAll(horarioTiempo.horarioClinica());
        });
        
        menuAjustes.getItems().addAll(menuItemHorario);

        Menu menuRegistros = new Menu("Registros", new ImageView(new Image("file:src/image/reporte.png")));
        menuRegistros.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemReporAcciones = new MenuItem("Reportes de acciones", new ImageView(new Image("file:src/image/histo.png")));
        menuItemReporAcciones.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemRespaldar = new MenuItem("Respaldar archivos", new ImageView(new Image("file:src/image/respal.png")));
        MenuItem menuItemNumPag = new MenuItem("Numero de registros, paginacion", new ImageView(new Image("file:src/image/numRegis.png")));

        menuItemReporAcciones.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            // vBoxWindows.getChildren().addAll(createNewCatalog.createCatalogue());
        });
        menuItemRespaldar.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
//            try {
//                vBoxWindows.getChildren().addAll(defineProperties.defineProperties());
//            } catch (IOException ex) {
//                Logger.getLogger(MainMenuBarSuperAdmi.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
        menuItemNumPag.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            // vBoxWindows.getChildren().addAll(createNewCatalog.createCatalogue());
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
            gridPaneSuperAdmi.getChildren().addAll(logo.logoClinica());
        });

        menuItemModifyCatalogue.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            //  vBoxWindows.getChildren().addAll(modifyCatalog.modifyProperties());
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
