package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class AjustesCliente {

    TextField textFieldNombreUsu;
    TextField textFieldContraUsu;
    TextField textFieldNuevaContraUsu;
    Button buttonModiUsu;
    Button buttonElimUsu;
    Button buttonAceptar;
    String fileName;
    Logic l = new Logic();

//////////    public CrearUsuarioNuevo(String fileName) {
//////////        this.fileName = fileName;
//////////    }
    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane ajustes() {

        /// File file = new File(fileName);
        GridPane gridPanecreaUsuario = new GridPane();
        gridPanecreaUsuario.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanecreaUsuario.setVgap(15);   //espacio
        gridPanecreaUsuario.setHgap(15);    // espacio
        // alinear el grip
        gridPanecreaUsuario.setAlignment(Pos.CENTER);
        gridPanecreaUsuario.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        textFieldNombreUsu = new TextField();
        textFieldNombreUsu.setPromptText("usuario");
        textFieldNombreUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldNombreUsu, 0, 1);
        textFieldNombreUsu.setFocusTraversable(false);

        textFieldContraUsu = new TextField();
        textFieldContraUsu.setPromptText("Contra");
        textFieldContraUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldContraUsu, 0, 2);
        textFieldContraUsu.setFocusTraversable(false);

        textFieldNuevaContraUsu = new TextField();
        textFieldNuevaContraUsu.setPromptText("Nueva contra");
        textFieldNuevaContraUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldNuevaContraUsu, 0, 4);
        textFieldNuevaContraUsu.setFocusTraversable(false);

        buttonModiUsu = new Button("Modificar usuario");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonModiUsu, 1, 3);
        buttonModiUsu.setOnAction((event) -> {

            Usuario usuario = new Usuario(textFieldNombreUsu.getText(), textFieldContraUsu.getText(), "", "", "", l.readType(textFieldNombreUsu.getText() + "|" + textFieldContraUsu.getText()));
            Usuario usuario1 = new Usuario(textFieldNombreUsu.getText(), textFieldNuevaContraUsu.getText(), "", "", "", l.readType(textFieldNombreUsu.getText() + "|" + textFieldContraUsu.getText()));
            l.writeInFile(usuario1);
            l.readInFile();
            l.modified(usuario, textFieldNuevaContraUsu.getText());
            l.removeLineFromFile(textFieldNombreUsu.getText() + "|" + textFieldContraUsu.getText());

        });//end setOnAction

        buttonElimUsu = new Button("Eliminar usuario");
        buttonElimUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonElimUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonElimUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonElimUsu, 2, 3);
        buttonElimUsu.setOnAction((event) -> {
            Usuario usuario = new Usuario(textFieldNombreUsu.getText(), textFieldContraUsu.getText(), "", "", "", l.readType(textFieldNombreUsu.getText() + "|" + textFieldContraUsu.getText()));
            l.readInFile();
            l.modidelete(usuario);
            l.removeLineFromFile(textFieldNombreUsu.getText() + "|" + textFieldContraUsu.getText());

        });//end setOnAction

//        buttonAceptar = new Button("Aceptar");
//        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
//        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
//        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
//        gridPanecreaUsuario.add(buttonAceptar, 0, 5);
//        buttonAceptar.setOnAction((event) -> {
//
//        });//end setOnAction

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonClose, 0, 8);
        buttonClose.setOnAction((event) -> {

            gridPanecreaUsuario.getChildren().clear();
            gridPanecreaUsuario.setBackground(Background.EMPTY);  //limpia color para que quede el color

        });//end btn cerrar

        return gridPanecreaUsuario;
    }//end GridPane createCatalogue()
}
