package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

// en esta clase se podra tener acceso a los reportes de acciones
public class ReportesAcciones {

    TextField textFieldContra;
    TextArea textAreaHistorial;
    Button buttonModiUsu;
    LogicaListas logic = new LogicaListas();
    Usuario uwu = logic.stringTokenizer(logic.leeLinea("ë"));

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane historial() {

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);

        gridPaneCitaNue.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldContra = new TextField();
        textFieldContra.setPromptText("Contraseña");
        textFieldContra.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldContra, 0, 1); /// columna fila
        textFieldContra.setFocusTraversable(false);

        textAreaHistorial = new TextArea();
        textAreaHistorial.setText("TODO poner histo aqui con AVL");
        textAreaHistorial.setVisible(false);
        gridPaneCitaNue.add(textAreaHistorial, 0, 4);

        buttonModiUsu = new Button("Mostrar historial");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setOnAction((event) -> {

            if (textFieldContra.getText().equals(uwu.getName())) {

                textAreaHistorial.setVisible(true);
            }
        });//end setOnAction

        //***
        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();
        //***
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneCitaNue.getChildren().clear();
            gridPaneCitaNue.setBackground(Background.EMPTY);
            gridPaneCitaNue.getChildren().add(barSuper.menuSuperAdmi());

        });//end btn cerrar

        return gridPaneCitaNue;
    }//end GridPane createCatalogue()

}
