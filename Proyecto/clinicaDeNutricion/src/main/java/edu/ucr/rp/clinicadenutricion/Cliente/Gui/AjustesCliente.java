package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.EnviarCorreo;
import java.io.File;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class AjustesCliente {

    TextField textFieldTipo;
    TextField textFieldID;
    TextField textFieldNombreUsuario;
    TextField textFieldContraseña;
    TextField textFieldCorreo;
    TextField textFieldTelefono;
    TextField textFieldDireccion;
    Label labelTipo;
    Label labelID;
    Label labelNombreUsuario;
    Label labelContraseña;
    Label labelCorreo;
    Label labelTelefono;
    Label labelDireccion;
    Button buttonModificar;
    Button buttonEliminar;
    Button buttonAceptar;

    EncryptMD5 encrypt = new EncryptMD5();
    LogicaListas logicaLista = new LogicaListas();
    IniciarSesion iniciarSesion;

    Alertas alertas = new Alertas();

    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    EnviarCorreo enviarCorreo = new EnviarCorreo();

    public GridPane ajustesCliente() {

        GridPane gridPaneAjustesCliente = new GridPane();
        gridPaneAjustesCliente.setMinSize(600, 700);
        gridPaneAjustesCliente.setVgap(15);
        gridPaneAjustesCliente.setHgap(15);
        gridPaneAjustesCliente.setAlignment(Pos.CENTER);
        Usuario supAdmConfi = logicaLista.stringTokenizer(logicaLista.leeLinea("ë"));
        gridPaneAjustesCliente.setStyle(("-fx-background-image:url('file:src/image/" + supAdmConfi.getContraseña() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuarioTemp = logicaLista.stringTokenizer(logicaLista.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuarioTemp.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuarioTemp.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        labelTipo = new Label("Tipo");
        gridPaneAjustesCliente.add(labelTipo, 0, 0);

        textFieldTipo = new TextField(tipo);
        textFieldTipo.setPromptText("Tipo");
        textFieldTipo.setDisable(true);
        textFieldTipo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldTipo, 1, 0);
        textFieldTipo.setFocusTraversable(false);

        labelID = new Label("ID: ");
        gridPaneAjustesCliente.add(labelID, 0, 1);
        textFieldID = new TextField(usuarioTemp.getId());
        textFieldID.setPromptText("ID");
        textFieldID.setDisable(true);
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldID, 1, 1);
        textFieldID.setFocusTraversable(false);

        labelNombreUsuario = new Label("Nombre: ");
        gridPaneAjustesCliente.add(labelNombreUsuario, 0, 2);

        textFieldNombreUsuario = new TextField(usuarioTemp.getName());
        textFieldNombreUsuario.setPromptText("Nombre");
        textFieldNombreUsuario.setDisable(true);
        textFieldNombreUsuario.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldNombreUsuario, 1, 2);
        textFieldNombreUsuario.setFocusTraversable(false);

        labelContraseña = new Label("Contraseña: ");
        gridPaneAjustesCliente.add(labelContraseña, 0, 3);

        textFieldContraseña = new TextField();
        textFieldContraseña.setPromptText("Contraseña");
        textFieldContraseña.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldContraseña, 1, 3);
        textFieldContraseña.setFocusTraversable(false);
        textFieldContraseña.setOnMouseClicked((event) -> {
            buttonModificar.setDisable(false);
            buttonEliminar.setDisable(false);
        });

        labelCorreo = new Label("Correo: ");
        labelCorreo.setVisible(false);
        gridPaneAjustesCliente.add(labelCorreo, 0, 4);

        textFieldCorreo = new TextField(usuarioTemp.getCorreo());
        textFieldCorreo.setPromptText("correo");
        textFieldCorreo.setVisible(false);
        textFieldCorreo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldCorreo, 1, 4);
        textFieldCorreo.setFocusTraversable(false);

        labelTelefono = new Label("Teléfono: ");
        labelTelefono.setVisible(false);
        gridPaneAjustesCliente.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField(usuarioTemp.getTelefono());
        textFieldTelefono.setPromptText("telefono");
        textFieldTelefono.setVisible(false);
        textFieldTelefono.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldTelefono, 1, 5);
        textFieldTelefono.setFocusTraversable(false);

        labelDireccion = new Label("Dirección: ");
        labelDireccion.setVisible(false);
        gridPaneAjustesCliente.add(labelDireccion, 0, 6);

        textFieldDireccion = new TextField(usuarioTemp.getDireccion());
        textFieldDireccion.setPromptText("direccion");
        textFieldDireccion.setVisible(false);
        textFieldDireccion.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneAjustesCliente.add(textFieldDireccion, 1, 6);
        textFieldDireccion.setFocusTraversable(false);

        buttonModificar = new Button("Modificar usuario");
        buttonModificar.setTextFill(Color.WHITE);
        buttonModificar.setStyle("-fx-background-color: BLACK");
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAjustesCliente.add(buttonModificar, 2, 3);
        buttonModificar.setDisable(true);
        buttonModificar.setOnAction((event) -> {

            if (!textFieldContraseña.getText().trim().equals("")) {

                Acciones acciones = new Acciones(iniciarSesion.ID, "Modificó su perfil", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);

                if (usuarioTemp.getContraseña().equals(encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()))) {
                    textFieldCorreo.setVisible(true);
                    textFieldDireccion.setVisible(true);
                    textFieldTelefono.setVisible(true);
                    labelTelefono.setVisible(true);
                    labelCorreo.setVisible(true);
                    labelDireccion.setVisible(true);

                    buttonAceptar.setVisible(true);
                    buttonEliminar.setVisible(false);
                    buttonModificar.setVisible(false);
                } else {
                    buttonEliminar.setDisable(true);
                    buttonModificar.setDisable(true);
                    textFieldContraseña.clear();
                    alertas.alertWarning("Contraseña incorrecta\nIntente de nuevo");
                }//end else

            }//end if
            else {
                alertas.alertWarning("Espacio vacio\nIntente de nuevo");
            }//end else

        });//end setOnAction

        buttonEliminar = new Button("Eliminar usuario");
        buttonEliminar.setTextFill(Color.WHITE);
        buttonEliminar.setStyle("-fx-background-color: BLACK");
        buttonEliminar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAjustesCliente.add(buttonEliminar, 3, 3);
        buttonEliminar.setDisable(true);
        buttonEliminar.setOnAction((event) -> {

            if (!textFieldContraseña.getText().trim().equals("")) {

                Acciones acciones = new Acciones(iniciarSesion.ID, "Eliminó su perfil", fechaHora.histoFechaHora());
                logicaAVL.escribeHistorial(acciones);

                if (usuarioTemp.getContraseña().equals(encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()))) {
                    Usuario usuario = logicaLista.stringTokenizer(logicaLista.leeLinea(textFieldID.getText()));
                    logicaLista.leerArchivo();
                    logicaLista.remueve(usuario);
                    logicaLista.remueveLineaDeArchivo(usuario.getId());
                    buttonModificar.setDisable(true);
                    File archivotxt = new File("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\Solicitud de cita para " + usuario.getId() + ".txt");
                    File archivopdf = new File("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\Reporte " + usuario.getId() + ".pdf");
                    archivotxt.delete();
                    archivopdf.delete();
                    Platform.exit();
                } else {
                    buttonEliminar.setDisable(true);
                    buttonModificar.setDisable(true);
                    textFieldContraseña.clear();
                    alertas.alertWarning("Contraseña incorrecta\nIntente de nuevo");
                }
                buttonEliminar.setDisable(true);
                buttonModificar.setDisable(true);
                textFieldContraseña.clear();

            }//end if
            else {
                alertas.alertWarning("Espacio vacio\nIntente de nuevo");
            }//end else

        });//end setOnAction

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);
        buttonAceptar.setStyle("-fx-background-color: BLACK");
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAjustesCliente.add(buttonAceptar, 1, 8);
        buttonAceptar.setVisible(false);
        buttonAceptar.setOnAction((event) -> {

            try {

                if (!textFieldCorreo.getText().trim().equals("")
                        && !textFieldContraseña.getText().trim().equals("")
                        && !textFieldTelefono.getText().trim().equals("")
                        && !textFieldDireccion.getText().trim().equals("")
                        && textFieldCorreo.getText().contains("@gmail.com")
                        && Integer.parseInt(textFieldTelefono.getText()) % 2 == 0
                        || Integer.parseInt(textFieldTelefono.getText()) % 2 == 1) {

                    enviarCorreo.sendMessage(textFieldCorreo.getText(), "Clínica Susana Distancia",
                            "Mensaje de confirmación:\n\nSus datos han sido actualizados correctamente.\n"
                            + "\nSi usted no modificó sus datos recientemente por favor contactese con nosotros.");

                    alertas.alertInformation("Usuario modificado correctamente");
                    Usuario usuario = logicaLista.stringTokenizer(logicaLista.leeLinea(textFieldID.getText()));
                    Usuario usuario1 = new Usuario(textFieldTipo.getText(), textFieldID.getText(),
                            textFieldNombreUsuario.getText(),
                            encrypt.encriptar("SusanaDistancia",
                                    textFieldContraseña.getText()),
                            textFieldCorreo.getText(), textFieldTelefono.getText(), textFieldDireccion.getText());

                    logicaLista.leerArchivo();
                    logicaLista.modificado(usuario, encrypt.encriptar("SusanaDistancia", textFieldCorreo.getText()));
                    logicaLista.remueveLineaDeArchivo(usuario.getId());
                    logicaLista.escribirArchivo(usuario1);

                    textFieldDireccion.setDisable(true);
                    textFieldCorreo.setDisable(true);
                    textFieldTelefono.setDisable(true);
                    textFieldDireccion.clear();
                    textFieldCorreo.clear();
                    textFieldTelefono.clear();
                    textFieldContraseña.clear();

                    buttonAceptar.setDisable(true);

                }//end if
                else {
                    alertas.alertWarning("Espacio vacio o error en formato\nIntente de nuevo");
                }//end else
            }//end try
            catch (java.lang.NumberFormatException jlNFE) {
                alertas.alertWarning("Espacio vacio o error en formato\nIntente de nuevo");
            }//end catch

            alertas.alertInformation("Ingrese de nuevo a su cuenta para\ncomprobar los cambios realizados");
            Platform.exit();

        });//end setOnAction

        MainMenuBarCliente barCliente = new MainMenuBarCliente();

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneAjustesCliente.add(buttonCerrar, 1, 9);
        buttonCerrar.setOnAction((event) -> {

            gridPaneAjustesCliente.getChildren().clear();
            gridPaneAjustesCliente.setBackground(Background.EMPTY);
            gridPaneAjustesCliente.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPaneAjustesCliente;
    }//end GridPane createCatalogue()
}
