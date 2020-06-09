package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

//clase para que el cliente modifique o cancel su cita
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ModificaCancelaCita {

    TextField textFieldNombreUsu;
    Button buttonDesplegar;
    Button buttonModiCita;
    Button buttonCanceCita;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxRol = new ComboBox();
    String fileName;
    String modiCita= "Modifico cita";
    String cancelCita= "Cancelo cita";

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane modiCancel() {

        /// File file = new File(fileName);
        GridPane gridPaneModiCan = new GridPane();
        gridPaneModiCan.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPaneModiCan.setVgap(15);   //espacio
        gridPaneModiCan.setHgap(15);    // espacio
        // alinear el grip
        gridPaneModiCan.setAlignment(Pos.CENTER);
        gridPaneModiCan.setStyle("-fx-background-color: dodgerblue");
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
        gridPaneModiCan.add(comboBoxRol, 0, 1);

        textAreaMostrar.setText("TODO info aqui");
        textAreaMostrar.setEditable(false);
        gridPaneModiCan.add(textAreaMostrar, 0, 3);

        buttonDesplegar = new Button("Desplegar Info");
        buttonDesplegar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonDesplegar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonDesplegar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonDesplegar, 0, 4);
        buttonDesplegar.setOnAction((event) -> {

        });//end setOnAction

        buttonModiCita = new Button("Modificar");
        buttonModiCita.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiCita.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonModiCita, 1, 5);
        buttonModiCita.setOnAction((event) -> {

        });//end setOnAction

        buttonCanceCita = new Button("Cancelar");
        buttonCanceCita.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonCanceCita.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonCanceCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonCanceCita, 2, 5);
        buttonCanceCita.setOnAction((event) -> {

        });//end setOnAction
        
                //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonClose, 0, 8);
        buttonClose.setOnAction((event) -> {

            gridPaneModiCan.getChildren().clear();
            gridPaneModiCan.setBackground(Background.EMPTY); 
            gridPaneModiCan.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPaneModiCan;
    }//end GridPane createCatalogue()
}
