package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
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
    ModificaCancela modificaCancelaCita = new ModificaCancela();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Alertas alerta = new Alertas();
    PaginacionAdmin paginacionAdmin = new PaginacionAdmin();
    AjustesAdmin ajustesAdmin = new AjustesAdmin();

    public GridPane menuAdministrador() {

        GridPane gridPaneAdministrador = new GridPane();
        gridPaneAdministrador.setMinSize(900, 700);

        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));

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

        MenuItem menuItemInformacionPaciente = new MenuItem("Acceder a información", new ImageView(new Image("file:src/image/infoPaci.png")));
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

        MenuItem menuItemNumPag = new MenuItem("Número de registros, paginación", new ImageView(new Image("file:src/image/numRegis.png")));
        menuItemNumPag.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(paginacionAdmin.PaginacionAdmin());
        });

        menuPaciente.getItems().addAll(menuItemInformacionPaciente, menuItemFormulario, menuItemNumPag);

        Menu menuCita = new Menu("Citas", new ImageView(new Image("file:src/image/cita.png")));
        menuCita.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemReservarCita = new MenuItem("Reservar cita", new ImageView(new Image("file:src/image/reservaCita.png")));
        menuItemReservarCita.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        MenuItem menuItemModiCancela = new MenuItem("Modificar/Cancelar cita", new ImageView(new Image("file:src/image/canModi.png")));

        menuItemReservarCita.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(reservarCita.reservarCita());
        });

        menuItemModiCancela.setOnAction((event) -> {
            try {
                gridPaneAdministrador.getChildren().clear();
                gridPaneAdministrador.getChildren().addAll(modificaCancelaCita.modificaCancela());
            } catch (java.lang.NullPointerException e) {
                alerta.alertWarning("Error, primero deben existir citas agendadas\nsi desea ingresar aquí");
                Platform.exit();
            }

        });

        menuCita.getItems().addAll(menuItemReservarCita, menuItemModiCancela);

        Menu menuAlimentacion = new Menu("Planes de alimentación", new ImageView(new Image("file:src/image/planAli.png")));
        menuAlimentacion.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemVerPlanes = new MenuItem("Ver planes de alimentación", new ImageView(new Image("file:src/image/verPlan.png")));
        //Funcionamiento
        menuItemVerPlanes.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(planesAlimenticios.planesAlimenticios());
        });
        menuAlimentacion.getItems().addAll(menuItemVerPlanes);

        Menu menuAjustes = new Menu("Ajustes", new ImageView(new Image("file:src/image/ajus.png")));
        menuAjustes.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemCuenta = new MenuItem("Cuenta", new ImageView(new Image("file:src/image/usua.png")));
        menuItemCuenta.setAccelerator(KeyCombination.keyCombination("Ctrl+V"));

        menuItemCuenta.setOnAction((event) -> {
            gridPaneAdministrador.getChildren().clear();
            gridPaneAdministrador.getChildren().addAll(ajustesAdmin.ajustesAdministracion());
        });
        menuAjustes.getItems().addAll(menuItemCuenta);

        Menu menuUsuario = new Menu("                                          "
                + "                                                       Usuario");
        MenuItem menuItemSalir = new MenuItem("Cerrar sesión", new ImageView(new Image("file:src/image/salir.png")));
        menuItemSalir.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemSalir.setOnAction((event) -> Platform.exit());

        menuUsuario.getItems().addAll(menuItemSalir);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

        menuBarMenu.getMenus().addAll(menuPaciente, menuCita, menuAlimentacion, menuAjustes ,menuUsuario);
        gridPaneAdministrador.add(menuBarMenu, 0, 0);

        return gridPaneAdministrador;

    }//end menuAdministrador()
}//end class MainMenuBarAdministrador 

