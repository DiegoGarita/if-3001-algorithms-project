package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.*;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase se colocara la GUI para crear un usuario nuevo, de cualquier de los 3 tipos posibles
public class CrearUsuarioNuevo {

    TextField textFieldNombreUsu;
    TextField textFieldContra;
    TextField textFieldTel;
    TextField textFieldDirec;
    TextField textFieldCorreo;
    Button buttonCreaUsuario;
    ComboBox comboBoxRol = new ComboBox();
    String fileName;
    Logic l = new Logic();
    EncripMD5 e = new EncripMD5();
    CRUD c = new CRUD();

//////////    public CrearUsuarioNuevo(String fileName) {
//////////        this.fileName = fileName;
//////////    }
    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane creaUsuario() {

        /// File file = new File(fileName);
        GridPane gridPanecreaUsuario = new GridPane();
        gridPanecreaUsuario.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanecreaUsuario.setVgap(15);   //espacio
        gridPanecreaUsuario.setHgap(15);    // espacio
        // alinear el grip
        gridPanecreaUsuario.setAlignment(Pos.CENTER);
        ///   gridPanecreaUsuario.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        comboBoxRol.setValue("Elige un rol");
        comboBoxRol.setStyle("-fx-background-color: lightblue");
        ObservableList<String> Roles
                = FXCollections.observableArrayList(
                        "Administrador",
                        "Cliente"
                );
        comboBoxRol.setItems(Roles);
        gridPanecreaUsuario.add(comboBoxRol, 0, 1);

        textFieldNombreUsu = new TextField();
        textFieldNombreUsu.setPromptText("Nombre de usuario");
        textFieldNombreUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldNombreUsu, 0, 2);
        textFieldNombreUsu.setFocusTraversable(false);

        textFieldContra = new TextField();
        textFieldContra.setPromptText("Contraseña");
        textFieldContra.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldContra, 0, 3); /// columna fila
        textFieldContra.setFocusTraversable(false);

        textFieldTel = new TextField();
        textFieldTel.setPromptText("Telefono");
        textFieldTel.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldTel, 0, 4); /// columna fila
        textFieldTel.setFocusTraversable(false);

        textFieldDirec = new TextField();
        textFieldDirec.setPromptText("Direccion");
        textFieldDirec.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldDirec, 0, 5); /// columna fila
        textFieldDirec.setFocusTraversable(false);

        textFieldCorreo = new TextField();
        textFieldCorreo.setPromptText("Correo");
        textFieldCorreo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldCorreo, 0, 6); /// columna fila
        textFieldCorreo.setFocusTraversable(false);

        buttonCreaUsuario = new Button("Crear usuario");
        buttonCreaUsuario.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonCreaUsuario.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonCreaUsuario.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonCreaUsuario, 0, 8);
        buttonCreaUsuario.setOnAction((event) -> {

            Usuario usuario = new Usuario(textFieldNombreUsu.getText(), textFieldContra.getText(), "", "", "", comboBoxRol.getValue().toString());
            l.writeInFile(usuario);

        });//end setOnAction

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanecreaUsuario.getChildren().clear();
            gridPanecreaUsuario.setBackground(Background.EMPTY);  //limpia color para que quede el color

        });//end btn cerrar

        return gridPanecreaUsuario;
    }//end GridPane createCatalogue()
}
