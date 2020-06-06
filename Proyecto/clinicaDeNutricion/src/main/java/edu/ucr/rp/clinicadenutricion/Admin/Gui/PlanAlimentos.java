package edu.ucr.rp.clinicadenutricion.Admin.Gui;

//en etsa clase el admin tendra acceso a los planes de alimentacion
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class PlanAlimentos {

    TextField textFieldNombreUsu;
    Button buttonDesplegarInfo;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxRol = new ComboBox();
    String fileName;

//////////    public CrearUsuarioNuevo(String fileName) {
//////////        this.fileName = fileName;
//////////    }
    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane planesAlimentos() {

        /// File file = new File(fileName);
        GridPane gridPanecreaUsuario = new GridPane();
        gridPanecreaUsuario.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanecreaUsuario.setVgap(15);   //espacio
        gridPanecreaUsuario.setHgap(15);    // espacio
        // alinear el grip
        gridPanecreaUsuario.setAlignment(Pos.CENTER);
        gridPanecreaUsuario.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        comboBoxRol.setValue("Elige una opcion");
        comboBoxRol.setStyle("-fx-background-color: lightblue");
        ObservableList<String> Roles
                = FXCollections.observableArrayList(
                        "Planes alimenticios",
                        "Recetas"
                );
        comboBoxRol.setItems(Roles);
        gridPanecreaUsuario.add(comboBoxRol, 0, 1);

        textFieldNombreUsu = new TextField();
        textFieldNombreUsu.setPromptText("Especifica");
        textFieldNombreUsu.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanecreaUsuario.add(textFieldNombreUsu, 0, 2);
        textFieldNombreUsu.setFocusTraversable(false);


        textAreaMostrar.setText("TODO info aqui");
        textAreaMostrar.setEditable(false);
         gridPanecreaUsuario.add(textAreaMostrar, 0, 3);

        buttonDesplegarInfo = new Button("Desplegar");
        buttonDesplegarInfo.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonDesplegarInfo.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonDesplegarInfo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonDesplegarInfo, 0, 4);
        buttonDesplegarInfo.setOnAction((event) -> {

        });//end setOnAction

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanecreaUsuario.getChildren().clear();
            gridPanecreaUsuario.setBackground(Background.EMPTY);  //limpia color para que quede el color

        });//end btn cerrar

        return gridPanecreaUsuario;
    }//end GridPane createCatalogue()

}
