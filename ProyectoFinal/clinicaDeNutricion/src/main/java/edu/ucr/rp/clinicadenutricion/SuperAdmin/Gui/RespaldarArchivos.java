package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.Respaldo;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class RespaldarArchivos {

    TextField textFieldContra;
    Button buttonModiUsu;
    Button buttonRespaldo;

    LogicaListas logic = new LogicaListas();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Alertas alerta = new Alertas();
    EncryptMD5 encrypt = new EncryptMD5();

    public GridPane respaldo() {

        GridPane gridPaneRespaldarAchivos = new GridPane();
        gridPaneRespaldarAchivos.setMinSize(600, 700);
        gridPaneRespaldarAchivos.setVgap(15);
        gridPaneRespaldarAchivos.setHgap(15);
        gridPaneRespaldarAchivos.setAlignment(Pos.CENTER);

        gridPaneRespaldarAchivos.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
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
        gridPaneRespaldarAchivos.add(textFieldContra, 0, 1);
        textFieldContra.setFocusTraversable(false);
        textFieldContra.setOnKeyPressed((event) -> {
            buttonModiUsu.setDisable(false);
        });

        Usuario uwu = logic.stringTokenizer(logic.leeLinea("ë"));

        buttonModiUsu = new Button("Aceptar");
        buttonModiUsu.setTextFill(Color.WHITE);
        buttonModiUsu.setStyle("-fx-background-color: BLACK");
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneRespaldarAchivos.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setDisable(true);
        buttonModiUsu.setOnAction((event) -> {

            if (encrypt.encriptar("SusanaDistancia", textFieldContra.getText()).equals(uwu.getName())) {

                buttonRespaldo.setVisible(true);
            }
            buttonModiUsu.setDisable(true);
            textFieldContra.setDisable(true);
        });

        Respaldo resUsuarios = new Respaldo();
        Respaldo resHistorial = new Respaldo();
        Respaldo resApartaCita = new Respaldo();

        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));

        buttonRespaldo = new Button("Respaldar informacion");
        buttonRespaldo.setTextFill(Color.WHITE);
        buttonRespaldo.setStyle("-fx-background-color: BLACK");
        buttonRespaldo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneRespaldarAchivos.add(buttonRespaldo, 0, 5);
        buttonRespaldo.setVisible(false);
        buttonRespaldo.setOnAction((event) -> {

            try {
                resUsuarios.createZipFile("C:\\source-code\\if-3001-algorithms-project\\ProyectoFinal\\clinicaDeNutricion\\usuarios.txt", "usuario");
                resHistorial.createZipFile("C:\\source-code\\if-3001-algorithms-project\\ProyectoFinal\\clinicaDeNutricion\\Historial.txt", "historial");
                resApartaCita.createZipFile("C:\\source-code\\if-3001-algorithms-project\\ProyectoFinal\\clinicaDeNutricion\\ApartaCita.txt", "citas");
            } catch (java.io.FileNotFoundException fnfe) {
                alerta.alertWarning("No se pudo realizar todos los respaldos\nNo se encontraron todos los archivos");
            } catch (IOException ioe) {
                alerta.alertWarning("No se pudo realizar todos los respaldos\nNo se encontraron todos los archivos");
            }

            buttonModiUsu.setDisable(true);
            textFieldContra.setDisable(true);
            alerta.alertInformation("Respaldo creado correctamente");
            buttonRespaldo.setDisable(true);
        });

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneRespaldarAchivos.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneRespaldarAchivos.getChildren().clear();
            gridPaneRespaldarAchivos.setBackground(Background.EMPTY);
            gridPaneRespaldarAchivos.getChildren().add(barSuper.menuSuperAdmi());

        });

        return gridPaneRespaldarAchivos;
    }//end gridPaneRespaldarAchivos()

}
