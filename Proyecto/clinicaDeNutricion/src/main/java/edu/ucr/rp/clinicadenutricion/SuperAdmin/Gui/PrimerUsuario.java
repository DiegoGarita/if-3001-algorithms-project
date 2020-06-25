package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.EnviarCorreo;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.*;
import java.util.Optional;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PrimerUsuario {

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
    Alertas alertas = new Alertas();
    EnviarCorreo enviarCorreo = new EnviarCorreo();

    public GridPane creaUsuario() {

        if (logic.cantidadDeClientes("|") >= 3) {
            alertas.alertWarning("Ya se registo el primer usuario y el primer Administrador\nDirigase a la parte de registro");
            System.out.println(logic.cantidadDeClientes("|") + "if");
        } else {
            System.out.println(logic.cantidadDeClientes("|") + "else");
            GridPane gridPaneCreaUsuario = new GridPane();
            gridPaneCreaUsuario.setMinSize(600, 700);
            SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
            gridPaneCreaUsuario.setVgap(15);
            gridPaneCreaUsuario.setHgap(15);
            gridPaneCreaUsuario.setAlignment(Pos.CENTER);

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
            textFieldTelefono.setPromptText("Teléfono");
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
            textFieldDireccion.setPromptText("Dirección");
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

                try {
                    if (textFieldCorreo.getText().contains("@") && textFieldContraseña.getText().length() >= 5
                            && !textFieldID.getText().trim().equals("") && !textFieldNombre.getText().trim().equals("")
                            && !textFieldContraseña.getText().trim().equals("") && !textFieldCorreo.getText().trim().equals("")
                            && !textFieldTelefono.getText().trim().equals("") && !textFieldDireccion.getText().trim().equals("")) {
                        //  && Integer.parseInt(textFieldTelefono.getText()) % 2 == 0
                        //   && Integer.parseInt(textFieldTelefono.getText()) % 3 == 1) {

                        alertas.alertConfirmation("");
                        Optional<ButtonType> result = alertas.alertConfirmation("").showAndWait();
                        if (result.get() == ButtonType.OK) {

                            logic.leerArchivo();
                            if (logic.busca(textFieldID.getText()) == false) {
                                enviarCorreo.sendMessage(textFieldCorreo.getText(), "Clínica Susana Distancia",
                                        "Mensaje de confirmación de creación de nuevo usuario en nuestra clínica Susana Distancia.\n"
                                        + "¡Bienvenido! " + textFieldNombre.getText() + " es un gusto atenderle.\n"
                                        + "Si desea realizar consultas directamente con nuestro soporte de aplicación deberá realizarlas"
                                        + " por este medio a este correo electrónico.\nSerá un gusto atenderle.");

                                Usuario usuario = new Usuario(comboBoxRol.getValue().toString(), textFieldID.getText(),
                                        textFieldNombre.getText(), encrypt.encriptar("SusanaDistancia", textFieldContraseña.getText()),
                                        textFieldCorreo.getText(), textFieldTelefono.getText(), textFieldDireccion.getText());

                                logic.escribirArchivo(usuario);
                                Acciones acciones = new Acciones(textFieldID.getText(), "Se registró como nuevo usuario", fechaHora.histoFechaHora());
                                logicaAVL.escribeHistorial(acciones);

                            } else {
                                System.out.println("Ya existe alguien con este ID");
                                alertas.alertWarning("Su ID ya esta registrado en sistema, intentelo de nuevo");
                                textFieldID.clear();
                                Acciones acciones = new Acciones(textFieldID.getText(), "Intentó registrarse cuando ya estaba registrado", fechaHora.histoFechaHora());
                                logicaAVL.escribeHistorial(acciones);
                            }
                        }//end if alert
                        textFieldNombre.clear();
                        textFieldContraseña.clear();
                        textFieldID.clear();
                        textFieldTelefono.clear();
                        textFieldDireccion.clear();
                        textFieldCorreo.clear();
                    }//end if validaciones basicas
                    else {
                        alertas.alertWarning("correo,contraseña y/o teléfono no validos");
                    }//end else validaciones
                } catch (NumberFormatException nfe) {
                    alertas.alertWarning("correo,contraseña y/o teléfono no validos\nO espacios vacios");
                }
            });//end setOnAction

            Label labelAclaracion = new Label();
            labelAclaracion.setText("* La contraseña debe tener 5 o mas caracteres \n* El teléfono de incluir solo números \n* Y el correo debe ser válido");
            labelAclaracion.setFont(new Font("Arial", 15));
            labelAclaracion.setStyle("-fx-font-weight: bold");
            labelAclaracion.setTextFill(Color.web("#0076a3"));
            labelAclaracion.setStyle("-fx-background-color: rgb(111, 210, 170);");
            gridPaneCreaUsuario.add(labelAclaracion, 0, 9);
            GridPane.setColumnSpan(labelAclaracion, Integer.BYTES);

            MainMenuBarSuperAdmi mainMenuBarSuperAdmi = new MainMenuBarSuperAdmi();
            Button buttonCerrar = new Button("Cerrar");
            buttonCerrar.setTextFill(Color.WHITE);
            buttonCerrar.setStyle("-fx-background-color: BLACK");
            buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
            gridPaneCreaUsuario.add(buttonCerrar, 2, 8);
            buttonCerrar.setOnAction((event) -> {

                gridPaneCreaUsuario.getChildren().clear();
                gridPaneCreaUsuario.setBackground(Background.EMPTY);
                gridPaneCreaUsuario.getChildren().add(mainMenuBarSuperAdmi.menuSuperAdmi());

            });//end btn cerrar

            return gridPaneCreaUsuario;   //---> cambio
        }//end else 
        return null;   //---> cambio
    }//end GridPane createCatalogue()

}
