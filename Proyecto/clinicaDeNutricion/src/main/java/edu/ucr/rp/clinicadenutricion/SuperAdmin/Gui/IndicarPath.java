package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.DirectoryChooser;

//en esta clase se podra realizar un cambio en el path
public class IndicarPath {

    TextField textFieldContra;
    Button botonGuardar;
    Button botonLogo;
    Button buttonModiUsu;
    LogicaListas logic = new LogicaListas();
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    Alertas alerta = new Alertas();
    EncryptMD5 encrypt = new EncryptMD5();

    public GridPane path() {

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

        Usuario uwu = logic.stringTokenizer(logic.leeLinea("ë"));

        buttonModiUsu = new Button("Modificar ubicacion");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setDisable(true);
        buttonModiUsu.setOnAction((event) -> {

            if (encrypt.encriptar("SusanaDistancia", textFieldContra.getText()).equals(uwu.getName())) {
                botonLogo.setVisible(true);
                botonGuardar.setVisible(true);
                buttonModiUsu.setDisable(true);
            }

            textFieldContra.setDisable(true);
            buttonModiUsu.setDisable(true);
        });//end setOnAction

        Label label = new Label("no files selected");
        botonLogo = new Button("Path archivos");
        botonLogo.setTextFill(Color.WHITE);//Color de la letra del boton
        botonLogo.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonLogo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonLogo, 0, 6);
        botonLogo.setVisible(false);
        botonLogo.setOnAction((event) -> {

            File file1 = setPath().showDialog(null);
            if (file1 != null) {
                label.setText(file1.getAbsolutePath());
                System.out.println(label.getText());
            }
            botonLogo.setDisable(true);
        });//END BUTTON
        botonLogo.setOnMousePressed((event) -> {
            botonGuardar.setDisable(false);
        });

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonGuardar, 0, 7);
        botonGuardar.setVisible(false);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {

            SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
            SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), configuracion.getAbreClinica(),
                    configuracion.getCierreClinica(), configuracion.getTiempoConsulta(),
                    configuracion.getNombreLogo(),
                    label.getText(), configuracion.getPaginacion());

            logiSuper.replacefromfile(configuracion2);

            textFieldContra.clear();
            botonGuardar.setDisable(true);
            alerta.alertInformation("Path cambiado correctamente");

        });//END BUTTON

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

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

    public DirectoryChooser setPath() {

        DirectoryChooser direcChooser = new DirectoryChooser();
        direcChooser.setTitle("Path");
        direcChooser.setInitialDirectory(new File("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion"));

        return direcChooser;
    }//end setPATH

}
