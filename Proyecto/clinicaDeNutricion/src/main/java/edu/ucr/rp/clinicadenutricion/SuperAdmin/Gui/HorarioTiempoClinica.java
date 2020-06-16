package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

//en esta clase se colocaran para realizar los ajustes en tiempos de consulta y en horarios de atencion
import edu.ucr.rp.clinicadenutricion.Utilitario.EncryptMD5;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
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
    public int intervalo = 1;
    public int abre = 9;
    public int cierra = 17;
    public String inter = "";

    LogicaListas logic = new LogicaListas();
    EncryptMD5 encrypt = new EncryptMD5();

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

        TextField textField = new TextField();
        textField.setText(usuarioTemp.getTipo());
        gridPaneHorarioTiempoClinica.add(textField, 2, 1);
        
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
        textFieldIntervalo.setText(usuarioTemp.getDireccion());
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
        textFieldAbreClinica.setText(usuarioTemp.getCorreo());
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
        textFieldCierraClinica.setText(usuarioTemp.getTelefono());
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

        buttonModificar = new Button("Modificar usuario");
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

        });//end setOnAction

        buttonGuardar = new Button("Guardar");
        buttonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneHorarioTiempoClinica.add(buttonGuardar, 0, 7);

        buttonGuardar.setOnAction((event) -> {

            Usuario usuario = logic.stringTokenizer(logic.leeLinea("ë"));
            Usuario usuario1 = new Usuario(textField.getText(), usuario.getId(), usuario.getName(), usuario.getContraseña(), textFieldAbreClinica.getText(),
                    textFieldCierraClinica.getText(), textFieldIntervalo.getText());

            logic.leerArchivo();
            logic.remueveLineaDeArchivo(usuario.getTipo());
            logic.escribirArchivo(usuario1);

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