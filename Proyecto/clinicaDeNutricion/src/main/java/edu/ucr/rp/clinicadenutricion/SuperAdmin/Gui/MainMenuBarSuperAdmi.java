package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
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
        gridPaneSuperAdmi.setStyle("-fx-background-color: dodgerblue");

        MenuBar menuBarMenu = new MenuBar();
        //mB_Menu.setStyle("-fx-background-color: #0a5ba0;");
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
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemHorario.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            //   vBoxWindows.getChildren().addAll(about.getGraphicalUserInterfaceAbout());
        });

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuAjustes.getItems().addAll(menuItemHorario, menuItemExit);

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
        MenuItem menuItemPropertiesList = new MenuItem("Listado de propiedades por catalogo");
        MenuItem menuItemCataloguesList = new MenuItem("Listado de catalogos");

        menuItemSearchCatalogue.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            // vBoxWindows.getChildren().addAll(catalogSearch.catalogueSearching());
        });

        menuItemModifyCatalogue.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            //  vBoxWindows.getChildren().addAll(modifyCatalog.modifyProperties());
        });

        menuItemPropertiesList.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            //  vBoxWindows.getChildren().addAll(showPropertiesOfElements.showInformationByCatalogue());
        });

        menuItemCataloguesList.setOnAction((event) -> {
            gridPaneSuperAdmi.getChildren().clear();
            //  vBoxWindows.getChildren().addAll(showCatalog.showExistingCatalogues());
        });

        menuOtros.getItems().addAll(menuItemSearchCatalogue, menuItemModifyCatalogue, separator);
        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });
        menuBarMenu.getMenus().addAll(menuAjustes, menuRegistros, menuOtros);
        gridPaneSuperAdmi.add(menuBarMenu, 0, 0);

        return gridPaneSuperAdmi;

    }//end Scene getMainScene()
}
