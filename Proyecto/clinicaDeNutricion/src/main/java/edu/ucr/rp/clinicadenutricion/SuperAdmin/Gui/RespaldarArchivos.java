package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.Respaldo;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

// en esta clase se podra realizar un respaldo de la informacion contenida en archivos
public class RespaldarArchivos {

    TextField textFieldContra;
    Button buttonModiUsu;
    Button buttonRespaldo;
    LogicaListas logic = new LogicaListas();
    Usuario uwu = logic.stringTokenizer(logic.leeLinea("ë"));
    Alertas alerta = new Alertas();
    EncryptMD5 encrypt = new EncryptMD5();

    public GridPane respaldo() {

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
        textFieldContra.setOnKeyPressed((event) -> {
            buttonModiUsu.setDisable(false);
        });

        buttonModiUsu = new Button("Aceptar");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setDisable(true);
        buttonModiUsu.setOnAction((event) -> {

            if (encrypt.encriptar("SusanaDistancia", textFieldContra.getText()).equals(uwu.getName())) {

                buttonRespaldo.setVisible(true);
            }
            buttonModiUsu.setDisable(true);
            textFieldContra.setDisable(true);
        });//end setOnAction

        Respaldo resUsuarios = new Respaldo();
        Respaldo resHistorial = new Respaldo();
        Respaldo resApartaCita = new Respaldo();

        buttonRespaldo = new Button("Respaldar informacion");
        buttonRespaldo.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonRespaldo.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonRespaldo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(buttonRespaldo, 0, 5);
        buttonRespaldo.setVisible(false);
        buttonRespaldo.setOnAction((event) -> {

            try {
                resUsuarios.createZipFile("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\usuarios.txt", "usuario");
                resHistorial.createZipFile("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\Historial.txt", "historial");
                resApartaCita.createZipFile("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\ApartaCita.txt", "citas");
            } catch (java.io.FileNotFoundException jio) {
                alerta.alertWarning("No se pudo realizar todos los respaldos\nNo se encontraron todos los archivos");
            } catch (IOException ex) {
                alerta.alertWarning("No se pudo realizar todos los respaldos\nNo se encontraron todos los archivos");
            }

            buttonModiUsu.setDisable(true);
            textFieldContra.setDisable(true);
            alerta.alertInformation("Respaldo creado correctamente");
            buttonRespaldo.setDisable(true);
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
