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
    Label labelInter;
    Label labelAbre;
    Label labelCierra;
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
        textFieldContraseña.setOnKeyPressed((event) -> {
            buttonModificar.setDisable(false);
        });

        labelInter = new Label();
        labelInter.setText("Intervalo entre citas");
        gridPaneHorarioTiempoClinica.add(labelInter, 0, 2);
        labelInter.setFont(new Font("Arial", 15));
        labelInter.setTextFill(Color.web("#0076a3"));
        labelInter.setStyle("-fx-font-weight: bold");
        labelInter.setStyle("-fx-background-color: rgb(111, 210, 170);");
        labelInter.setVisible(false);

        textFieldIntervalo = new TextField();
        textFieldIntervalo.setText(configuracion.getTiempoConsulta());
        textFieldIntervalo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneHorarioTiempoClinica.add(textFieldIntervalo, 1, 2);
        textFieldIntervalo.setFocusTraversable(false);
        textFieldIntervalo.setVisible(false);

        labelAbre = new Label();
        labelAbre.setText("Abre a las: ");
        gridPaneHorarioTiempoClinica.add(labelAbre, 0, 3);
        labelAbre.setFont(new Font("Arial", 15));
        labelAbre.setTextFill(Color.web("#0076a3"));
        labelAbre.setStyle("-fx-font-weight: bold");
        labelAbre.setStyle("-fx-background-color: rgb(111, 210, 170);");
        labelAbre.setVisible(false);

        textFieldAbreClinica = new TextField();
        textFieldAbreClinica.setText(configuracion.getAbreClinica());
        textFieldAbreClinica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneHorarioTiempoClinica.add(textFieldAbreClinica, 1, 3);
        textFieldAbreClinica.setFocusTraversable(false);
        textFieldAbreClinica.setVisible(false);

        labelCierra = new Label();
        labelCierra.setText("Cierra a las: ");
        gridPaneHorarioTiempoClinica.add(labelCierra, 0, 4);
        labelCierra.setFont(new Font("Arial", 15));
        labelCierra.setTextFill(Color.web("#0076a3"));
        labelCierra.setStyle("-fx-font-weight: bold");
        labelCierra.setStyle("-fx-background-color: rgb(111, 210, 170);");
        labelCierra.setVisible(false);

        textFieldCierraClinica = new TextField();
        textFieldCierraClinica.setText(configuracion.getCierreClinica());
        textFieldCierraClinica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneHorarioTiempoClinica.add(textFieldCierraClinica, 1, 4);
        textFieldCierraClinica.setFocusTraversable(false);
        textFieldCierraClinica.setVisible(false);
        textFieldCierraClinica.setOnKeyPressed((event) -> {
            buttonGuardar.setDisable(false);
        });

        buttonModificar = new Button("Modificar valores");
        buttonModificar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModificar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneHorarioTiempoClinica.add(buttonModificar, 1, 1);
        buttonModificar.setDisable(true);
        buttonModificar.setOnAction((event) -> {

            if (textFieldContraseña.getText().equals(usuarioTemp.getName())) {
                textFieldIntervalo.setVisible(true);
                textFieldAbreClinica.setVisible(true);
                textFieldCierraClinica.setVisible(true);
                labelCierra.setVisible(true);
                labelAbre.setVisible(true);
                labelInter.setVisible(true);
                buttonModificar.setDisable(true);
            }
            textFieldContraseña.setDisable(true);

        });//end setOnAction

        buttonGuardar = new Button("Guardar");
        buttonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneHorarioTiempoClinica.add(buttonGuardar, 0, 7);
        buttonGuardar.setDisable(true);
        buttonGuardar.setOnAction((event) -> {
            try {
                if (!textFieldAbreClinica.getText().trim().equals("")
                        && !textFieldCierraClinica.getText().trim().equals("")
                        && !textFieldIntervalo.getText().trim().equals("")
                        && Integer.parseInt(textFieldAbreClinica.getText()) < Integer.parseInt(textFieldCierraClinica.getText())) {

                    SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), textFieldAbreClinica.getText(),
                            textFieldCierraClinica.getText(), textFieldIntervalo.getText(),
                            configuracion.getNombreLogo(),
                            configuracion.getPathDeGuardado(), configuracion.getPaginacion());

                    logiSuper.readInFile();
                    logiSuper.removeLineFromFile(configuracion.getIdentificadorSA()); //-->>Here esta vara me cae
                    logiSuper.writeInFile(configuracion);
                    textFieldAbreClinica.clear();
                    textFieldAbreClinica.setDisable(true);
                    textFieldCierraClinica.clear();
                    textFieldCierraClinica.setDisable(true);
                    textFieldIntervalo.clear();
                    textFieldIntervalo.setDisable(true);
                    textFieldContraseña.clear();
                    alerta.alertInformation("Horario cambiado, correctamente");
                    buttonGuardar.setDisable(true);

                }//end if
                else {
                    alerta.alertWarning("Campos vacios o error de formato\nIntente de nuevo");
                }//end else
            }//end try
            catch (java.lang.NumberFormatException jLNFE) {
                alerta.alertWarning("Campos vacios o error de formato\nIntente de nuevo");
            }//end catch
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

        Label aclaracion1 = new Label();
        aclaracion1.setText("* Formato de horario a utilizar es de 24 horas");
        aclaracion1.setFont(new Font("Arial", 15));
        aclaracion1.setTextFill(Color.web("#0076a3"));
        aclaracion1.setStyle("-fx-font-weight: bold");
        aclaracion1.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneHorarioTiempoClinica.add(aclaracion1, 0, 9);

        Label aclaracion2 = new Label();
        aclaracion2.setText("** Las citas no pueden durar mas del horario de atencion de la clinica");
        aclaracion2.setFont(new Font("Arial", 15));
        aclaracion2.setTextFill(Color.web("#0076a3"));
        aclaracion2.setStyle("-fx-font-weight: bold");
        aclaracion2.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneHorarioTiempoClinica.add(aclaracion2, 0, 10);

        Label aclaracion3 = new Label();
        aclaracion3.setText("*** Hora de apertura no puede ser mayor a hora de cierre, lapsos de 1 o 2 horas maximo");
        aclaracion3.setFont(new Font("Arial", 15));
        aclaracion3.setTextFill(Color.web("#0076a3"));
        aclaracion3.setStyle("-fx-font-weight: bold");
        aclaracion3.setStyle("-fx-background-color: rgb(111, 210, 170);");
        gridPaneHorarioTiempoClinica.add(aclaracion3, 0, 11);

        GridPane.setColumnSpan(aclaracion1, Integer.BYTES);
        GridPane.setColumnSpan(aclaracion2, Integer.BYTES);
        GridPane.setColumnSpan(aclaracion3, Integer.BYTES);

        return gridPaneHorarioTiempoClinica;
    }//end GridPane createCatalogue()
}
