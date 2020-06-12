package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class MainMenuBarAdmi {

    InfoPaciente infoPaciente = new InfoPaciente();
    PlanAlimentos planAlimentos = new PlanAlimentos();
    ReservaCita reservarCita = new ReservaCita();
    FormuDoctor formulario = new FormuDoctor();
        LogoApp logo = new LogoApp();

    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
     */
    public GridPane menuAdmi() {

        /// File file = new File(fileName);
        GridPane gridPaneAdmi = new GridPane();
        gridPaneAdmi.setMinSize(900, 700);

        gridPaneAdmi.setStyle(("-fx-background-image:url('file:src/image/"+logo.NombreLogo+".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MenuBar menuBarMenu = new MenuBar();
        //mB_Menu.setStyle("-fx-background-color: #0a5ba0;");
        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        SeparatorMenuItem separator = new SeparatorMenuItem();

        Menu menuPaciente = new Menu("Pacientes", new ImageView(new Image("file:src/image/pacien.png")));
        menuPaciente.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemInfoPaciente = new MenuItem("Acceder a informacion", new ImageView(new Image("file:src/image/infoPaci.png")));
        menuItemInfoPaciente.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemForm = new MenuItem("Form nuevo", new ImageView(new Image("file:src/image/formDo.png")));
        menuItemForm.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemInfoPaciente.setOnAction((event) -> {
            gridPaneAdmi.getChildren().clear();
            gridPaneAdmi.getChildren().addAll(infoPaciente.infoCliente());
        });

        menuItemForm.setOnAction((event) -> {
            gridPaneAdmi.getChildren().clear();
            gridPaneAdmi.getChildren().addAll(formulario.formulario());
        });

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuPaciente.getItems().addAll(menuItemInfoPaciente,menuItemForm, menuItemExit);//agregados a m_SIstema

        Menu menuCita = new Menu("Citas", new ImageView(new Image("file:src/image/cita.png")));
        menuCita.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemReservarCita = new MenuItem("Reservar cita", new ImageView(new Image("file:src/image/reservaCita.png")));
        menuItemReservarCita.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        menuItemReservarCita.setOnAction((event) -> {
            gridPaneAdmi.getChildren().clear();
            gridPaneAdmi.getChildren().addAll(reservarCita.reservar());
        });

        menuCita.getItems().addAll(menuItemReservarCita);

        Menu menuAlimentacion = new Menu("Planes de alimentacion", new ImageView(new Image("file:src/image/planAli.png")));
        menuAlimentacion.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemVerPlanes = new MenuItem("Ver planes de alimentacion", new ImageView(new Image("file:src/image/verPlan.png")));
        //Funcionamiento
        menuItemVerPlanes.setOnAction((event) -> {
            gridPaneAdmi.getChildren().clear();
            gridPaneAdmi.getChildren().addAll(planAlimentos.planesAlimentos());
        });
        menuAlimentacion.getItems().addAll(menuItemVerPlanes);//agregado a menuMaintenance

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        menuBarMenu.getMenus().addAll(menuPaciente, menuCita, menuAlimentacion);
        gridPaneAdmi.add(menuBarMenu, 0, 0);

        return gridPaneAdmi;

    }//end Scene getMainScene()
}//end class MainMenuBarAdmi 

