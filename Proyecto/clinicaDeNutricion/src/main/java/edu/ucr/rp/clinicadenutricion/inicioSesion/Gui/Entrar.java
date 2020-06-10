package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

import edu.ucr.rp.clinicadenutricion.Admin.Gui.MainMenuBarAdmi;
import edu.ucr.rp.clinicadenutricion.Cliente.Gui.MainMenuBarCliente;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.MainMenuBarSuperAdmi;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.EncripMD5;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javax.swing.JOptionPane;

public class Entrar {

    public static String ID;

    TextField textFieldID;
    public TextField textFieldNombreUsu;

    PasswordField textFieldContra;
    Button buttonCreaUsuario;
    ComboBox comboBoxRol = new ComboBox();
    Logic logic = new Logic();
    String fileName;

    MainMenuBarSuperAdmi mm = new MainMenuBarSuperAdmi();
    MainMenuBarAdmi nn = new MainMenuBarAdmi();
    MainMenuBarCliente zz = new MainMenuBarCliente();
    EncripMD5 e = new EncripMD5();

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

        textFieldID = new TextField();
        textFieldID.setPromptText("Ingrese ID del usuario");
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneEntrar.add(textFieldID, 0, 2);
        textFieldID.setFocusTraversable(false);

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
            Node node = gridPaneEntrar.getChildren().get(2);
            logic.readInFile();

            if (textFieldID.getText().equals("Super") && textFieldContra.getText().equals("1234")) {

                gridPaneEntrar.getChildren().clear();
                gridPaneEntrar.getChildren().add(0, node);
                gridPaneEntrar.getChildren().add(mm.menuSuperAdmi());
            } else if (logic.search(textFieldID.getText())) {

                gridPaneEntrar.getChildren().clear();

                if (logic.readLine(textFieldID.getText()).substring(0, 1).equals("ä")) {
                    if (logic.stringTokenizer(logic.readLine(textFieldID.getText())).getId().equals(textFieldID.getText())) {
                        if (logic.stringTokenizer(logic.readLine(textFieldID.getText())).getContraseña().equals(e.encriptar("SusanaDistancia", textFieldContra.getText()))) {
                            ID = textFieldID.getText();
                            gridPaneEntrar.getChildren().add(0, node);
                            gridPaneEntrar.getChildren().add(zz.menuCliente());
                        }
                    }
                } else if (logic.readLine(textFieldID.getText()).substring(0, 1).equals("ö")) {
                    if (logic.stringTokenizer(logic.readLine(textFieldID.getText())).getId().equals(textFieldID.getText())) {
                        if (logic.stringTokenizer(logic.readLine(textFieldID.getText())).getContraseña().equals(e.encriptar("SusanaDistancia", textFieldContra.getText()))) {
                            ID = textFieldID.getText();
                            gridPaneEntrar.getChildren().add(0, node);
                            gridPaneEntrar.getChildren().add(nn.menuAdmi());

                        }
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe");

            }

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
