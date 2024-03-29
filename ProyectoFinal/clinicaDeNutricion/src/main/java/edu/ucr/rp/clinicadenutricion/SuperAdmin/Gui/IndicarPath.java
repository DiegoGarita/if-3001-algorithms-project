package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
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

public class IndicarPath {

    TextField textFieldContra;
    Button botonGuardar;
    Button botonLogo;
    Button buttonModiUsu;

    LogicaListas logicaListas = new LogicaListas();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Alertas alerta = new Alertas();
    EncryptMD5 encrypt = new EncryptMD5();

    public GridPane path() {

        GridPane gridPaneIndicarPath = new GridPane();
        gridPaneIndicarPath.setMinSize(600, 700);
        gridPaneIndicarPath.setVgap(15);
        gridPaneIndicarPath.setHgap(15);
        gridPaneIndicarPath.setAlignment(Pos.CENTER);

        gridPaneIndicarPath.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
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
        gridPaneIndicarPath.add(textFieldContra, 0, 1);
        textFieldContra.setFocusTraversable(false);
        textFieldContra.setOnKeyPressed((event) -> {
            buttonModiUsu.setDisable(false);
        });

        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea("ë"));

        buttonModiUsu = new Button("Modificar ubicacion");
        buttonModiUsu.setTextFill(Color.WHITE);
        buttonModiUsu.setStyle("-fx-background-color: BLACK");
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneIndicarPath.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setDisable(true);
        buttonModiUsu.setOnAction((event) -> {
            if (encrypt.encriptar("SusanaDistancia", textFieldContra.getText()).equals(usuario.getName())) {
                botonLogo.setVisible(true);
                botonGuardar.setVisible(true);
                buttonModiUsu.setDisable(true);
            }

            textFieldContra.setDisable(true);
            buttonModiUsu.setDisable(true);
        });

        Label label = new Label("no files selected");
        botonLogo = new Button("Path archivos");
        botonLogo.setTextFill(Color.WHITE);
        botonLogo.setStyle("-fx-background-color: BLACK");
        botonLogo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneIndicarPath.add(botonLogo, 0, 6);
        botonLogo.setVisible(false);
        botonLogo.setOnAction((event) -> {

            File file1 = setPath().showDialog(null);
            if (file1 != null) {
                label.setText(file1.getAbsolutePath());
                System.out.println(label.getText());
            }
            botonLogo.setDisable(true);
        });
        botonLogo.setOnMousePressed((event) -> {
            botonGuardar.setDisable(false);
        });

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);
        botonGuardar.setStyle("-fx-background-color: BLACK");
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneIndicarPath.add(botonGuardar, 0, 7);
        botonGuardar.setVisible(false);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {

            SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
            SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), configuracion.getAbreClinica(),
                    configuracion.getCierreClinica(), configuracion.getTiempoConsulta(),
                    configuracion.getNombreLogo(),
                    label.getText(), configuracion.getPaginacion());

            logicaSuperAdmin.replacefromfile(configuracion2);

            textFieldContra.clear();
            botonGuardar.setDisable(true);
            alerta.alertInformation("Path cambiado correctamente");

        });

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneIndicarPath.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneIndicarPath.getChildren().clear();
            gridPaneIndicarPath.setBackground(Background.EMPTY);
            gridPaneIndicarPath.getChildren().add(barSuper.menuSuperAdmi());

        });

        return gridPaneIndicarPath;
    }//end gridPaneIndicarPath()

    /**
     * método que toma el directorio seleccionado
     * @return la direccion seleccionada
     */
    public DirectoryChooser setPath() {

        DirectoryChooser direcChooser = new DirectoryChooser();
        direcChooser.setTitle("Path");
        direcChooser.setInitialDirectory(new File("C:\\source-code\\if-3001-algorithms-project\\ProyectoFinal\\clinicaDeNutricion"));

        return direcChooser;
    }//end setPATH()

}
