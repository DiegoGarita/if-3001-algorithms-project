package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class HorarioTiempoClinica {

    TextField textFieldContraseña;
    TextField textFieldIntervalo;
    TextField textFieldAbreClinica;
    TextField textFieldCierraClinica;
    Button buttonGuardar;
    Button buttonModificar;

    LogicaListas logic = new LogicaListas();
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    Alertas alerta = new Alertas();

    public GridPane horarioClinica() {

        GridPane gridPaneHorarioTiempoClinica = new GridPane();
        gridPaneHorarioTiempoClinica.setMinSize(600, 700);
        gridPaneHorarioTiempoClinica.setVgap(15);
        gridPaneHorarioTiempoClinica.setHgap(15);
        gridPaneHorarioTiempoClinica.setAlignment(Pos.CENTER);

        gridPaneHorarioTiempoClinica.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
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
        gridPaneHorarioTiempoClinica.add(textFieldContraseña, 0, 1);
        textFieldContraseña.setFocusTraversable(false);

        textFieldIntervalo = new TextField();
        textFieldIntervalo.setText(configuracion.getTiempoConsulta() + "<- Intervalo");
        textFieldIntervalo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneHorarioTiempoClinica.add(textFieldIntervalo, 0, 2);
        textFieldIntervalo.setFocusTraversable(false);
        textFieldIntervalo.setVisible(false);

        textFieldAbreClinica = new TextField();
        textFieldAbreClinica.setText(configuracion.getAbreClinica() + "<- Abre a las");
        textFieldAbreClinica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneHorarioTiempoClinica.add(textFieldAbreClinica, 0, 3);
        textFieldAbreClinica.setFocusTraversable(false);
        textFieldAbreClinica.setVisible(false);

        textFieldCierraClinica = new TextField();
        textFieldCierraClinica.setText(configuracion.getCierreClinica() + "<- Cierra a las");
        textFieldCierraClinica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneHorarioTiempoClinica.add(textFieldCierraClinica, 0, 4);
        textFieldCierraClinica.setFocusTraversable(false);
        textFieldCierraClinica.setVisible(false);

        buttonModificar = new Button("Modificar valores");
        buttonModificar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModificar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneHorarioTiempoClinica.add(buttonModificar, 1, 1);
        buttonModificar.setOnAction((event) -> {

            if (textFieldContraseña.getText().equals(usuarioTemp.getName())) {
                textFieldIntervalo.setVisible(true);
                textFieldAbreClinica.setVisible(true);
                textFieldCierraClinica.setVisible(true);
                buttonModificar.setDisable(true);
            }
            textFieldContraseña.setDisable(true);

        });//end setOnAction

        buttonGuardar = new Button("Guardar");
        buttonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneHorarioTiempoClinica.add(buttonGuardar, 0, 7);

        buttonGuardar.setOnAction((event) -> {

            SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), textFieldAbreClinica.getText(),
                    textFieldCierraClinica.getText(), textFieldIntervalo.getText(),
                    configuracion.getNombreLogo(),
                    configuracion.getPathDeGuardado(), configuracion.getPaginacion());

            logiSuper.readInFile();
            logiSuper.removeLineFromFile(configuracion.getIdentificadorSA()); //-->>Here esta vara me cae
            logiSuper.writeInFile(configuracion2);
            textFieldContraseña.setDisable(false);
            alerta.alertInformation("Horario cambiado, correctamente");

        });//END BUTTON

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneHorarioTiempoClinica.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneHorarioTiempoClinica.getChildren().clear();
            gridPaneHorarioTiempoClinica.setBackground(Background.EMPTY);
            gridPaneHorarioTiempoClinica.getChildren().add(barSuper.menuSuperAdmi());

        });//end btn cerrar

        return gridPaneHorarioTiempoClinica;
    }//end GridPane createCatalogue()
}
