package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;


public class MainMenuBar {

    ReporteCitas reporteCitas = new ReporteCitas();
    ReporteProgreso reporteProgreso = new ReporteProgreso();
    
    ApartarCita apartarCita = new ApartarCita();
    ModificaCancela modifCancela = new ModificaCancela();
    
    PlanesAlimentacion planAlimentos = new PlanesAlimentacion();
    
    AjustesCliente ajustes = new AjustesCliente();
    
     VBox vBoxWindows, vBoxMain;

     /**
      * 
      * @return Nos da la GUI que contiene todos los elementos por mostrar en la barra de menú
      */
    public Scene getMainScene() {

        vBoxMain = new VBox();
//        vBoxMain.setStyle(("-fx-background-image:url('file:src/image/inicio1.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        Scene scene = new Scene(vBoxMain, 900, 700);
        vBoxWindows = new VBox();

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
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(credits.getGraphicalUserInterfaceCredits());
        });

        menuItemProgreso.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(about.getGraphicalUserInterfaceAbout());
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
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(createNewCatalog.createCatalogue());
        });
        menuItemModiCancela.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
//            try {
//                vBoxWindows.getChildren().addAll(defineProperties.defineProperties());
//            } catch (IOException ex) {
//                Logger.getLogger(MainMenuBar.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
        menuNuevaCita.getItems().addAll(menuItemSolicitaCita, menuItemModiCancela);//agregados a m_Paises

        Menu menuPlanes = new Menu("Planes alimentarios", new ImageView(new Image("file:src/image/planAli.png")));
        menuPlanes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemDeleteCatalogue = new MenuItem("Ver planes", new ImageView(new Image("file:src/image/verPlan.png")));
        //Funcionamiento
        menuItemDeleteCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(deleteCatalogs.deleteCatalogues());
        });
        menuPlanes.getItems().addAll(menuItemDeleteCatalogue);//agregado a menuMaintenance

        Menu menuAjustes = new Menu("Ajustes", new ImageView(new Image("file:src/image/ajus.png")));
        menuAjustes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        MenuItem menuItemCuenta = new MenuItem("Cuenta", new ImageView(new Image("file:src/image/usua.png")));
        menuItemCuenta.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));


        menuItemCuenta.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(catalogSearch.catalogueSearching());
        });

      
       
        menuAjustes.getItems().addAll(menuItemCuenta, separator);//agregados a menuReports
        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });
        menuBarMenu.getMenus().addAll(menuReportes, menuNuevaCita, menuPlanes, menuAjustes);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);
        return scene;

    }//end Scene getMainScene()
}//end class MainMenuBar 
