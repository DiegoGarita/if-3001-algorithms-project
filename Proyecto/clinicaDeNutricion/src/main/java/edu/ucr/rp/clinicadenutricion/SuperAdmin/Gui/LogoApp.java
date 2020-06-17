package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;

public class LogoApp {

    TextField textFieldContraseña;
    Button buttonGuardar;
    Button buttonLogo;
    Button buttonModifica;
    public String NombreLogo = "3";
    LogicaListas logic = new LogicaListas();
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane logoApp() {

        GridPane gridPaneLogoApp = new GridPane();
        gridPaneLogoApp.setMinSize(600, 700);
        gridPaneLogoApp.setVgap(15);
        gridPaneLogoApp.setHgap(15);
        gridPaneLogoApp.setAlignment(Pos.CENTER);

        gridPaneLogoApp.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuarioTemp = logic.stringTokenizer(logic.leeLinea("ë"));
         SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));

        textFieldContraseña = new TextField();
        textFieldContraseña.setPromptText("Contraseña");
        textFieldContraseña.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneLogoApp.add(textFieldContraseña, 0, 1);
        textFieldContraseña.setFocusTraversable(false);

        buttonModifica = new Button("Modificar logo");
        buttonModifica.setTextFill(Color.WHITE);
        buttonModifica.setStyle("-fx-background-color: BLACK");
        buttonModifica.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneLogoApp.add(buttonModifica, 1, 1);
        buttonModifica.setOnAction((event) -> {

            if (textFieldContraseña.getText().equals(usuarioTemp.getName())) {
                buttonLogo.setVisible(true);
                buttonGuardar.setVisible(true);
                buttonModifica.setDisable(true);
            }

        });//end setOnAction

        Label label = new Label("no files selected");
        buttonLogo = new Button("Elegir logo");
        buttonLogo.setTextFill(Color.WHITE);
        buttonLogo.setStyle("-fx-background-color: BLACK");
        buttonLogo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneLogoApp.add(buttonLogo, 0, 6);
        buttonLogo.setVisible(false);
        buttonLogo.setOnAction((event) -> {
            File file1 = setFileChooser().showOpenDialog(null);
            if (file1 != null) {

                label.setText(file1.getName());
            }
        });//END BUTTON

        buttonGuardar = new Button("Guardar");
        buttonGuardar.setTextFill(Color.WHITE);
        buttonGuardar.setStyle("-fx-background-color: BLACK");
        buttonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneLogoApp.add(buttonGuardar, 0, 7);
        buttonGuardar.setVisible(false);
        buttonGuardar.setOnAction((event) -> {

            SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), configuracion.getAbreClinica(),
                    configuracion.getCierreClinica(), configuracion.getTiempoConsulta(),
                    label.getText(),
                    configuracion.getPathDeGuardado(), configuracion.getPaginacion());

            logiSuper.readInFile();
            logiSuper.removeLineFromFile(configuracion.getIdentificadorSA()); //-->>Here esta vara me cae
            logiSuper.writeInFile(configuracion2);
        });//END BUTTON

        MainMenuBarSuperAdmi mainMenuBarSuperAdmi = new MainMenuBarSuperAdmi();
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneLogoApp.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneLogoApp.getChildren().clear();
            gridPaneLogoApp.setBackground(Background.EMPTY);
            gridPaneLogoApp.getChildren().add(mainMenuBarSuperAdmi.menuSuperAdmi());

        });//end btn cerrar

        return gridPaneLogoApp;
    }//end GridPane createCatalogue()

      public FileChooser setFileChooser() {
        //Este metodo crea el fileChooser que va a escoger las imagenes
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.setInitialDirectory(new File("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\src\\image"));

        //Filtros de lo que muestra la ventana
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
        );//fin filtro

        return fileChooser;
    }//end method setFileChooser

}
