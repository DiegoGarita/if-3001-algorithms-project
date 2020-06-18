package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.*;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase se colocara la GUI para crear un usuario nuevo, de cualquier de los 3 tipos posibles
public class CrearUsuarioNuevo {

    TextField textFieldNombre;
    TextField textFieldContraseña;
    TextField textFieldID;
    TextField textFieldTelefono;
    TextField textFieldDireccion;
    TextField textFieldCorreo;
    Button buttonCreaUsuario;
    ComboBox comboBoxRol = new ComboBox();
    LogicaListas logic = new LogicaListas();
    EncryptMD5 encrypt = new EncryptMD5();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane creaUsuario() {

        GridPane gridPaneCreaUsuario = new GridPane();
        gridPaneCreaUsuario.setMinSize(600, 700);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        gridPaneCreaUsuario.setVgap(15);
        gridPaneCreaUsuario.setHgap(15);
        gridPaneCreaUsuario.setAlignment(Pos.CENTER);

        LogoApp logo = new LogoApp();

        gridPaneCreaUsuario.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        comboBoxRol.setValue("Elige un rol");
        comboBoxRol.setStyle("-fx-background-color: lightblue");
        ObservableList<String> Roles
                = FXCollections.observableArrayList(
                        "Administrador",
                        "Cliente"
                );
        comboBoxRol.setItems(Roles);
        gridPaneCreaUsuario.add(comboBoxRol, 0, 0);

        textFieldID = new TextField();
        textFieldID.setPromptText("Número de identificación");
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCreaUsuario.add(textFieldID, 0, 1);
        textFieldID.setFocusTraversable(false);

        textFieldNombre = new TextField();
        textFieldNombre.setPromptText("Nombre de usuario");
        textFieldNombre.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCreaUsuario.add(textFieldNombre, 0, 2);
        textFieldNombre.setFocusTraversable(false);

        textFieldContraseña = new TextField();
        textFieldContraseña.setPromptText("Contraseña");
        textFieldContraseña.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCreaUsuario.add(textFieldContraseña, 0, 3);
        textFieldContraseña.setFocusTraversable(false);

        textFieldCorreo = new TextField();
        textFieldCorreo.setPromptText("Correo");
        textFieldCorreo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCreaUsuario.add(textFieldCorreo, 0, 4);
        textFieldCorreo.setFocusTraversable(false);

        textFieldTelefono = new TextField();
        textFieldTelefono.setPromptText("Telefono");
        textFieldTelefono.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCreaUsuario.add(textFieldTelefono, 0, 5);
        textFieldTelefono.setFocusTraversable(false);

        textFieldDireccion = new TextField();
        textFieldDireccion.setPromptText("Direccion");
        textFieldDireccion.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCreaUsuario.add(textFieldDireccion, 0, 6);
        textFieldDireccion.setFocusTraversable(false);
        textFieldDireccion.setOnKeyPressed((event) -> {
            buttonCreaUsuario.setDisable(false);
        });

        buttonCreaUsuario = new Button("Crear usuario");
        buttonCreaUsuario.setTextFill(Color.WHITE);
        buttonCreaUsuario.setStyle("-fx-background-color: BLACK");
        buttonCreaUsuario.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneCreaUsuario.add(buttonCreaUsuario, 0, 8);
        buttonCreaUsuario.setDisable(true);
        buttonCreaUsuario.setOnAction((event) -> {

            logic.leerArchivo();
            if (logic.busca(textFieldID.getText()) == false) {
                Usuario usuario = new Usuario(comboBoxRol.getValue().toString(), textFieldID.getText(),
                        textFieldNombre.getText(), encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()),
                        textFieldCorreo.getText(), textFieldTelefono.getText(), textFieldDireccion.getText());

                logic.escribirArchivo(usuario);
                Acciones acciones = new Acciones(textFieldID.getText(), "Se registró como nuevo usuario", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);

            } else {
                System.out.println("Ya existe alguien con este ID");
                Acciones acciones = new Acciones(textFieldID.getText(), "Intentó registrarse cuando ya estaba registrado", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);
            }

            textFieldNombre.clear();
            textFieldContraseña.clear();
            textFieldID.clear();
            textFieldTelefono.clear();
            textFieldDireccion.clear();
            textFieldCorreo.clear();

        });//end setOnAction

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneCreaUsuario.add(buttonCerrar, 2, 8);
        buttonCerrar.setOnAction((event) -> {
            gridPaneCreaUsuario.getChildren().clear();
            gridPaneCreaUsuario.setBackground(Background.EMPTY);

        });//end btn cerrar

        return gridPaneCreaUsuario;
    }//end GridPane createCatalogue()
}
