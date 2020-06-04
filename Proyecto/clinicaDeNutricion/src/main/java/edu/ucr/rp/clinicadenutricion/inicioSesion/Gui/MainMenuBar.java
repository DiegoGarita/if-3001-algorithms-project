package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

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

   // About about = new About();
  //  Credits credits = new Credits();
  //  CreateNewCatalogue createNewCatalog = new CreateNewCatalogue("");
  //  DefineProperties defineProperties = new DefineProperties("");
  //  DeleteCatalogues deleteCatalogs = new DeleteCatalogues();
  //  CatalogueSearch catalogSearch = new CatalogueSearch();
  //  ModifyProperties modifyCatalog = new ModifyProperties();
  //  ShowPropertiesOfElements showPropertiesOfElements = new ShowPropertiesOfElements();
 //   ShowCatalogue showCatalog = new ShowCatalogue();

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
        //mB_Menu.setStyle("-fx-background-color: #0a5ba0;");
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
        MenuItem menuItemCredits = new MenuItem("Créditos", new ImageView(new Image("file:src/image/ojo.png")));
        menuItemCredits.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        MenuItem menuItemPerformance = new MenuItem("Funcionamiento", new ImageView(new Image("file:src/image/preg.png")));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/exit.png")));
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

        menuSystem.getItems().addAll(menuItemAbout, menuItemCredits, menuItemPerformance, menuItemExit);//agregados a m_SIstema

        Menu menuCrearUsuario = new Menu("Registrarse", new ImageView(new Image("file:src/image/catal.png")));
        menuCrearUsuario.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemDefineCatalogue = new MenuItem("Definir Catalogo", new ImageView(new Image("file:src/image/ADD.png")));
        menuItemDefineCatalogue.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemDefineProperties = new MenuItem("Definir propiedades", new ImageView(new Image("file:src/image/prop.png")));

        menuItemDefineCatalogue.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
           // vBoxWindows.getChildren().addAll(createNewCatalog.createCatalogue());
        });
        menuItemDefineProperties.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
//            try {
//              //  vBoxWindows.getChildren().addAll(defineProperties.defineProperties());
//            } catch (IOException ex) {
//                Logger.getLogger(MainMenuBar.class.getName()).log(Level.SEVERE, null, ex);
//            }
        });
        menuCrearUsuario.getItems().addAll(menuItemDefineCatalogue, menuItemDefineProperties);//agregados a m_Paises

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });
        menuBarMenu.getMenus().addAll(menuSystem, menuCrearUsuario);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);
        return scene;

    }//end Scene getMainScene()

}
