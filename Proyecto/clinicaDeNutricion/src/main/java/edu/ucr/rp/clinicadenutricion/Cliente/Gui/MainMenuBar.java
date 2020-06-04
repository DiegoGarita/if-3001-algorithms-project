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

////    About about = new About();
////    Credits credits = new Credits();
////    Help help = new Help();
////    CreateNewCatalogue createNewCatalog = new CreateNewCatalogue("");
////    DefineProperties defineProperties = new DefineProperties("");
////    DeleteCatalogues deleteCatalogs = new DeleteCatalogues();
////    CatalogueSearch catalogSearch = new CatalogueSearch();
////    ModifyProperties modifyCatalog = new ModifyProperties();
////    ShowPropertiesOfElements showPropertiesOfElements = new ShowPropertiesOfElements();
////    ShowCatalogue showCatalog = new ShowCatalogue();
    
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
        
          //Menu Sistema
        Menu menuAlimentacion = new Menu("Alimentacion", new ImageView(new Image("file:src/image/sistema.png")));
        menuAlimentacion.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemPlan = new MenuItem("Planes de alimentacion", new ImageView(new Image("file:src/image/aD.png")));
        menuItemPlan.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/exit.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemPlan.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(credits.getGraphicalUserInterfaceCredits());
        });


        menuItemExit.setOnAction((event) -> Platform.exit());

        menuAlimentacion.getItems().addAll(menuItemPlan);//agregados a m_SIstema
       

        Menu menuCliente = new Menu("Citas", new ImageView(new Image("file:src/image/catal.png")));
        menuCliente.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemDefineCatalogue = new MenuItem("Solicitar cita", new ImageView(new Image("file:src/image/ADD.png")));
        menuItemDefineCatalogue.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemDefineProperties = new MenuItem("Modificar/Cancelar", new ImageView(new Image("file:src/image/prop.png")));

        menuItemDefineCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(createNewCatalog.createCatalogue());
        });
        menuItemDefineProperties.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
//            try {
//                vBoxWindows.getChildren().addAll(defineProperties.defineProperties());
//            } catch (IOException ex) {
//                Logger.getLogger(MainMenuBar.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
        menuCliente.getItems().addAll(menuItemDefineCatalogue, menuItemDefineProperties);//agregados a m_Paises

        Menu menuInfo = new Menu("Informacion relevante", new ImageView(new Image("file:src/image/mantenimiento.png")));
        menuInfo.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemDeleteCatalogue = new MenuItem("Eliminar catalogos", new ImageView(new Image("file:src/image/elim.png")));
        //Funcionamiento
        menuItemDeleteCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(deleteCatalogs.deleteCatalogues());
        });
        menuInfo.getItems().addAll(menuItemDeleteCatalogue);//agregado a menuMaintenance

        Menu menuReports = new Menu("Reportes", new ImageView(new Image("file:src/image/rep.png")));
        menuReports.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        Menu menuCitas = new Menu("Citas", new ImageView(new Image("file:src/image/list.png")));
        menuReports.getItems().addAll(menuCitas);
        MenuItem menuItemSearchCatalogue = new MenuItem("Porgreso", new ImageView(new Image("file:src/image/sear.png")));
        menuItemSearchCatalogue.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));
        MenuItem menuItemModifyCatalogue = new MenuItem("Modificar catalogo", new ImageView(new Image("file:src/image/edita.png")));
        MenuItem menuItemPropertiesList = new MenuItem("Listado de propiedades por catalogo");
        MenuItem menuItemCataloguesList = new MenuItem("Listado de catalogos");

        menuItemSearchCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
          //  vBoxWindows.getChildren().addAll(catalogSearch.catalogueSearching());
        });

        menuItemModifyCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
          //  vBoxWindows.getChildren().addAll(modifyCatalog.modifyProperties());
        });

        menuItemPropertiesList.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(showPropertiesOfElements.showInformationByCatalogue());
        });

        menuItemCataloguesList.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(showCatalog.showExistingCatalogues());
        });

        menuCitas.getItems().addAll(menuItemPropertiesList, menuItemCataloguesList);
        menuReports.getItems().addAll(menuItemSearchCatalogue, menuItemModifyCatalogue, separator, menuCitas);//agregados a menuReports
        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });
        menuBarMenu.getMenus().addAll(menuAlimentacion, menuCliente, menuInfo, menuReports);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);
        return scene;

    }//end Scene getMainScene()
}//end class MainMenuBar 
