package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;

import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.HoraFecha;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.EncripMD5;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class AjustesCliente {

    TextField textFieldType;
    TextField textFieldID;
    TextField textFieldNombreUsu;
    TextField textFieldContraUsu;
    TextField textFieldCorreo;
    TextField textFieldPhone;
    TextField textFieldDirection;

    Label labelType;
    Label labelID;
    Label labelNombreUsu;
    Label labelContraUsu;
    Label labelCorreo;
    Label labelPhone;
    Label labelDirection;

    Button buttonModiUsu;
    Button buttonElimUsu;
    Button buttonAceptar;

    String fileName;
    String accionBorra = "Borro su usuario";
    String accionModi = "Modifico su usuario";

    EncripMD5 e = new EncripMD5();
    Logic l = new Logic();
    Entrar en;

    AVLArchivo histo = new AVLArchivo();
    HoraFecha horaFecha = new HoraFecha();

    LogoApp logo = new LogoApp();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane ajustes() {

        GridPane gridPaneAjustes = new GridPane();
        gridPaneAjustes.setMinSize(600, 700);
        gridPaneAjustes.setVgap(15);   //espacio
        gridPaneAjustes.setHgap(15);    // espacio
        gridPaneAjustes.setAlignment(Pos.CENTER);
        gridPaneAjustes.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario uwu = l.stringTokenizer(l.readLine(en.ID));
        String tipo = "";
        if (uwu.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (uwu.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        labelType = new Label("Tipo");
        gridPaneAjustes.add(labelType, 0, 0);

        textFieldType = new TextField(tipo);
        textFieldType.setPromptText("Tipo");
        textFieldType.setDisable(true);
        textFieldType.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldType, 1, 0);
        textFieldType.setFocusTraversable(false);

        labelID = new Label("ID: ");
        gridPaneAjustes.add(labelID, 0, 1);
        textFieldID = new TextField(uwu.getId());
        textFieldID.setPromptText("ID");
        textFieldID.setDisable(true);
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldID, 1, 1);
        textFieldID.setFocusTraversable(false);

        labelNombreUsu = new Label("Nombre: ");
        gridPaneAjustes.add(labelNombreUsu, 0, 2);

        textFieldNombreUsu = new TextField(uwu.getName());
        textFieldNombreUsu.setPromptText("Nombre");
        textFieldNombreUsu.setDisable(true);
        textFieldNombreUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldNombreUsu, 1, 2);
        textFieldNombreUsu.setFocusTraversable(false);

        labelContraUsu = new Label("Contraseña: ");
        gridPaneAjustes.add(labelContraUsu, 0, 3);

        textFieldContraUsu = new TextField();
        textFieldContraUsu.setPromptText("Contraseña");
        textFieldContraUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldContraUsu, 1, 3);
        textFieldContraUsu.setFocusTraversable(false);
        textFieldContraUsu.setOnMouseClicked((event) -> {
            buttonModiUsu.setDisable(false);
            buttonElimUsu.setDisable(false);
        });

        labelCorreo = new Label("Correo: ");
        labelCorreo.setVisible(false);
        gridPaneAjustes.add(labelCorreo, 0, 4);

        textFieldCorreo = new TextField(uwu.getCorreo());
        textFieldCorreo.setPromptText("correo");
        textFieldCorreo.setVisible(false);
        textFieldCorreo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldCorreo, 1, 4);
        textFieldCorreo.setFocusTraversable(false);

        labelPhone = new Label("Teléfono: ");
        labelPhone.setVisible(false);
        gridPaneAjustes.add(labelPhone, 0, 5);

        textFieldPhone = new TextField(uwu.getTelefono());
        textFieldPhone.setPromptText("telefono");
        textFieldPhone.setVisible(false);
        textFieldPhone.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldPhone, 1, 5);
        textFieldPhone.setFocusTraversable(false);

        labelDirection = new Label("Dirección: ");
        labelDirection.setVisible(false);
        gridPaneAjustes.add(labelDirection, 0, 6);

        textFieldDirection = new TextField(uwu.getDireccion());
        textFieldDirection.setPromptText("direccion");
        textFieldDirection.setVisible(false);
        textFieldDirection.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustes.add(textFieldDirection, 1, 6);
        textFieldDirection.setFocusTraversable(false);

        buttonModiUsu = new Button("Modificar usuario");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneAjustes.add(buttonModiUsu, 2, 3);
        buttonModiUsu.setDisable(true);
        buttonModiUsu.setOnAction((event) -> {

            if (uwu.getContraseña().equals(e.encriptar("SusanaDistancia", textFieldContraUsu.getText()))) {
                textFieldCorreo.setVisible(true);
                textFieldDirection.setVisible(true);
                textFieldPhone.setVisible(true);
                buttonAceptar.setVisible(true);
                buttonElimUsu.setDisable(true);
                buttonModiUsu.setDisable(true);
            }

        });//end setOnAction

        buttonElimUsu = new Button("Eliminar usuario");
        buttonElimUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonElimUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonElimUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneAjustes.add(buttonElimUsu, 3, 3);
        buttonElimUsu.setDisable(true);
        buttonElimUsu.setOnAction((event) -> {

            Acciones acc = new Acciones(uwu.getName(), accionBorra, horaFecha.histoFechaHora());
            histo.writeFileCitas(acc);

            if (uwu.getContraseña().equals(e.encriptar("SusanaDistancia", textFieldContraUsu.getText()))) {
                Usuario usuario = l.stringTokenizer(l.readLine(textFieldID.getText()));
                l.readInFile();
                l.modidelete(usuario);
                l.removeLineFromFile(usuario.getId());
                buttonModiUsu.setDisable(true);
            }
        });//end setOnAction

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneAjustes.add(buttonAceptar, 1, 8);
        buttonAceptar.setVisible(false);
        buttonAceptar.setOnAction((event) -> {

            Usuario usuario = l.stringTokenizer(l.readLine(textFieldID.getText()));
            Usuario usuario1 = new Usuario(textFieldType.getText(), textFieldID.getText(), textFieldNombreUsu.getText(), e.encriptar("SusanaDistancia", textFieldContraUsu.getText()), textFieldCorreo.getText(), textFieldPhone.getText(), textFieldDirection.getText());

            l.readInFile();
            l.modified(usuario, e.encriptar("SusanaDistancia", textFieldCorreo.getText()));
            l.removeLineFromFile(usuario.getId());
            l.writeInFile(usuario1);

            Acciones acc = new Acciones(uwu.getName(), accionModi, horaFecha.histoFechaHora());
            histo.writeFileCitas(acc);

            textFieldDirection.setDisable(true);
            textFieldCorreo.setDisable(true);
            textFieldPhone.setDisable(true);

            buttonAceptar.setDisable(true);
        });//end setOnAction

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneAjustes.add(buttonClose, 1, 9);
        buttonClose.setOnAction((event) -> {

            gridPaneAjustes.getChildren().clear();
            gridPaneAjustes.setBackground(Background.EMPTY);
            gridPaneAjustes.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPaneAjustes;
    }//end GridPane createCatalogue()
}
