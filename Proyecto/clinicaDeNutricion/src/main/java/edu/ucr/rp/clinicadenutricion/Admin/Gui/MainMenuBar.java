package edu.ucr.rp.clinicadenutricion.Admin.Gui;

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

    InfoPaciente infoPaciente = new InfoPaciente();
    PlanAlimentos planAlimentos = new PlanAlimentos();
    ReservaCita reservarCita = new ReservaCita();
   
    VBox vBoxWindows, vBoxMain;

    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
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
        Menu menuPaciente = new Menu("Pacientes", new ImageView(new Image("file:src/image/pacien.png")));
        menuPaciente.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemInfoPaciente = new MenuItem("Acceder a informacion", new ImageView(new Image("file:src/image/infoPaci.png")));
        menuItemInfoPaciente.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));


        menuItemInfoPaciente.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            // vBoxWindows.getChildren().addAll(about.getGraphicalUserInterfaceAbout());
        });


        menuItemExit.setOnAction((event) -> Platform.exit());

        menuPaciente.getItems().addAll(menuItemInfoPaciente, menuItemExit);//agregados a m_SIstema

        Menu menuCita = new Menu("Citas", new ImageView(new Image("file:src/image/cita.png")));
        menuCita.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemReservarCita = new MenuItem("Reservar cita", new ImageView(new Image("file:src/image/reservaCita.png")));
        menuItemReservarCita.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        menuItemReservarCita.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            // vBoxWindows.getChildren().addAll(createNewCatalog.createCatalogue());
        });

        menuCita.getItems().addAll(menuItemReservarCita);

        Menu menuAlimentacion = new Menu("Planes de alimentacion", new ImageView(new Image("file:src/image/planAli.png")));
        menuAlimentacion.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemVerPlanes = new MenuItem("Ver planes de alimentacion", new ImageView(new Image("file:src/image/verPlan.png")));
        //Funcionamiento
        menuItemVerPlanes.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            // vBoxWindows.getChildren().addAll(deleteCatalogs.deleteCatalogues());
        });
        menuAlimentacion.getItems().addAll(menuItemVerPlanes);//agregado a menuMaintenance


        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });
        menuBarMenu.getMenus().addAll(menuPaciente, menuCita, menuAlimentacion);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);
        return scene;

    }//end Scene getMainScene()
}//end class MainMenuBar 

