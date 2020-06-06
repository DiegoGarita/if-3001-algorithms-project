package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

//clase para que el cliente modifique o cancel su cita

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

public class ModificaCancelaCita {
      TextField textFieldNombreUsu;
    Button buttonDesplegar;
    Button buttonModiCita;
    Button buttonCanceCita;
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
    public GridPane modiCancel() {

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

        comboBoxRol.setValue("Citas futuras");
        comboBoxRol.setStyle("-fx-background-color: lightblue");
        ObservableList<String> Roles
                = FXCollections.observableArrayList(
                        "x",
                        "x"
                );
        comboBoxRol.setItems(Roles);
        gridPanecreaUsuario.add(comboBoxRol, 0, 1);

        textAreaMostrar.setText("TODO info aqui");
        textAreaMostrar.setEditable(false);
        gridPanecreaUsuario.add(textAreaMostrar, 0, 3);

        buttonDesplegar = new Button("Desplegar Info");
        buttonDesplegar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonDesplegar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonDesplegar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonDesplegar, 0, 4);
        buttonDesplegar.setOnAction((event) -> {

        });//end setOnAction

        buttonModiCita = new Button("Modificar");
        buttonModiCita.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiCita.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonModiCita, 1, 5);
        buttonModiCita.setOnAction((event) -> {

        });//end setOnAction

        buttonCanceCita = new Button("Cancelar");
        buttonCanceCita.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonCanceCita.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonCanceCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonCanceCita, 2, 5);
        buttonCanceCita.setOnAction((event) -> {

        });//end setOnAction

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanecreaUsuario.add(buttonClose, 0, 8);
        buttonClose.setOnAction((event) -> {

            gridPanecreaUsuario.getChildren().clear();
            gridPanecreaUsuario.setBackground(Background.EMPTY);  //limpia color para que quede el color

        });//end btn cerrar

        return gridPanecreaUsuario;
    }//end GridPane createCatalogue()
}
