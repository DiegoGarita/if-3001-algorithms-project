package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Admin.Gui.MainMenuBarAdmi;
import edu.ucr.rp.clinicadenutricion.Cliente.Gui.MainMenuBarCliente;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.MainMenuBarSuperAdmi;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Entrar {

    TextField textFieldNombreUsu;
    PasswordField textFieldContra;
    Button buttonCreaUsuario;
    ComboBox comboBoxRol = new ComboBox();
    String fileName;

    MainMenuBarSuperAdmi mm = new MainMenuBarSuperAdmi();
    MainMenuBarAdmi nn = new MainMenuBarAdmi();
    MainMenuBarCliente zz = new MainMenuBarCliente();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane ingresaCuenta() {

        /// File file = new File(fileName);
        GridPane gridPaneEntrar = new GridPane();
        gridPaneEntrar.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPaneEntrar.setVgap(15);   //espacio
        gridPaneEntrar.setHgap(15);    // espacio
        // alinear el grip
        gridPaneEntrar.setAlignment(Pos.CENTER);
        ///   gridPanecreaUsuario.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        textFieldNombreUsu = new TextField();
        textFieldNombreUsu.setPromptText("Nombre de usuario");
        textFieldNombreUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneEntrar.add(textFieldNombreUsu, 0, 2);
        textFieldNombreUsu.setFocusTraversable(false);

        textFieldContra = new PasswordField();
        textFieldContra.setPromptText("Contraseña");
        textFieldContra.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneEntrar.add(textFieldContra, 0, 3); /// columna fila
        textFieldContra.setFocusTraversable(false);

        buttonCreaUsuario = new Button("Aceptar");
        buttonCreaUsuario.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonCreaUsuario.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonCreaUsuario.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneEntrar.add(buttonCreaUsuario, 0, 4);
        buttonCreaUsuario.setOnAction((event) -> {

            //   gridPaneEntrar.getChildren().clear();
            //vBoxWindows.getChildren().removeAll(vBoxWindows);
            //   menuBarMenu.setVisible(false);
            //vBoxWindows.getChildren().add(zz.menuCliente());
            // vBoxWindows.getChildren().add(mm.menuSuperAdmi());
            Node node = gridPaneEntrar.getChildren().get(2);
            gridPaneEntrar.getChildren().clear();
            gridPaneEntrar.getChildren().add(0, node);
            gridPaneEntrar.getChildren().add(zz.menuCliente());

        });//end setOnAction

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneEntrar.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPaneEntrar.getChildren().clear();
            gridPaneEntrar.setBackground(Background.EMPTY);  //limpia color para que quede el color

        });//end btn cerrar

        return gridPaneEntrar;
    }//end GridPane createCatalogue()
}
