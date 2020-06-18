package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;

public class MainMenuBarAdministrador {

    InformacionPaciente informacionPaciente = new InformacionPaciente();
    PlanesAlimenticios planesAlimenticios = new PlanesAlimenticios();
    ReservaCita reservarCita = new ReservaCita();
    Formulario formulario = new Formulario();
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
     */
    public GridPane menuAdministrador() {

        GridPane gridPaneAdministrador = new GridPane();
        gridPaneAdministrador.setMinSize(900, 700);

       SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));

        gridPaneAdministrador.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MenuBar menuBarMenu = new MenuBar();
        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        Menu menuPaciente = new Menu("Pacientes", new ImageView(new Image("file:src/image/pacien.png")));
        menuPaciente.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemInformacionPaciente = new MenuItem("Acceder a informacion", new ImageView(new Image("file:src/image/infoPaci.png")));
        menuItemInformacionPaciente.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemFormulario = new MenuItem("Form nuevo", new ImageView(new Image("file:src/image/formDo.png")));
        menuItemFormulario.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));

        menuItemInformacionPaciente.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(informacionPaciente.informacionPaciente());
        });

        menuItemFormulario.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(formulario.formulario());
        });

        menuPaciente.getItems().addAll(menuItemInformacionPaciente, menuItemFormulario);

        Menu menuCita = new Menu("Citas", new ImageView(new Image("file:src/image/cita.png")));
        menuCita.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemReservarCita = new MenuItem("Reservar cita", new ImageView(new Image("file:src/image/reservaCita.png")));
        menuItemReservarCita.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        menuItemReservarCita.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(reservarCita.reservarCita());
        });

        menuCita.getItems().addAll(menuItemReservarCita);

        Menu menuAlimentacion = new Menu("Planes de alimentacion", new ImageView(new Image("file:src/image/planAli.png")));
        menuAlimentacion.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemVerPlanes = new MenuItem("Ver planes de alimentacion", new ImageView(new Image("file:src/image/verPlan.png")));
        //Funcionamiento
        menuItemVerPlanes.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(planesAlimenticios.planesAlimenticios());
        });
        menuAlimentacion.getItems().addAll(menuItemVerPlanes);

        Menu menuUsuario = new Menu("                                                      "
                + "                                                                                        Usuario");
        MenuItem menuItemSalir = new MenuItem("Cerrar sesion", new ImageView(new Image("file:src/image/salir.png")));
        menuItemSalir.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemSalir.setOnAction((event) -> Platform.exit());

        menuUsuario.getItems().addAll(menuItemSalir);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        menuBarMenu.getMenus().addAll(menuPaciente, menuCita, menuAlimentacion, menuUsuario);
        gridPaneAdministrador.add(menuBarMenu, 0, 0);

        return gridPaneAdministrador;

    }//end Scene getMainScene()
}//end class MainMenuBarAdministrador 

