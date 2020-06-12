package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

//en esta clase el usuario pued ver sus planes de alimentacion
import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.HoraFecha;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PlanesAlimentacion {

    TextField textFieldNombreUsu;
    Button buttonDesplegarInfo;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxRol = new ComboBox();
    String fileName;
    String consu = "Consulto planes/recetas";
    AVLArchivo histo = new AVLArchivo();
    HoraFecha horaFecha = new HoraFecha();

    Logic l = new Logic();
    Entrar en;
    LogoApp logo = new LogoApp();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane misPlanesAlimentos() {

        GridPane gridPanePlanAli = new GridPane();
        gridPanePlanAli.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanePlanAli.setVgap(15);   //espacio
        gridPanePlanAli.setHgap(15);    // espacio
        // alinear el grip
        gridPanePlanAli.setAlignment(Pos.CENTER);
        gridPanePlanAli.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario uwu = l.stringTokenizer(l.readLine(en.ID));
        String tipo = "";
        if (uwu.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (uwu.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        comboBoxRol.setValue("Elige una opcion");
        comboBoxRol.setStyle("-fx-background-color: lightblue");
        ObservableList<String> Roles
                = FXCollections.observableArrayList(
                        "Mis planes alimenticios",
                        "Recetas"
                );
        comboBoxRol.setItems(Roles);
        gridPanePlanAli.add(comboBoxRol, 0, 1);

        textFieldNombreUsu = new TextField();
        textFieldNombreUsu.setPromptText("Especifica");
        textFieldNombreUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanePlanAli.add(textFieldNombreUsu, 0, 2);
        textFieldNombreUsu.setFocusTraversable(false);

        textAreaMostrar.setText("TODO info aqui");
        textAreaMostrar.setEditable(false);
        gridPanePlanAli.add(textAreaMostrar, 0, 3);

        buttonDesplegarInfo = new Button("Desplegar");
        buttonDesplegarInfo.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonDesplegarInfo.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonDesplegarInfo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanAli.add(buttonDesplegarInfo, 0, 4);
        buttonDesplegarInfo.setOnAction((event) -> {

            Acciones acc = new Acciones(uwu.getName(), consu, horaFecha.histoFechaHora());
            histo.writeFileCitas(acc);

        });//end setOnAction

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanAli.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanePlanAli.getChildren().clear();
            gridPanePlanAli.setBackground(Background.EMPTY);
            gridPanePlanAli.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPanePlanAli;
    }//end GridPane createCatalogue()
}
