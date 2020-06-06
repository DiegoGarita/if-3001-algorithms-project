package edu.ucr.rp.clinicadenutricion.Admin.Gui;

//en esta clase el admin podra apartar una cita para su cliente

import java.io.File;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ReservaCita {
    
    
  //  SaveObject saveObject = new SaveObject();
  //  ConstantsElements constantsElements = new ConstantsElements();
    Object object;
    

    ArrayList<TextField> textFieldProperties;
    TextField textFieldCatalogueName;
    TextField textFieldPropertiesQuantity;
    Button botonGuardar;
    String fileName;
    int quantityOfProperties;

//    public ReservaCita(String fileName) {
//        this.fileName = fileName;
//    }

    /**
     * 
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane reservar() {

      //  File file = new File(fileName);
        GridPane gridPaneNewCatalogue = new GridPane();
        gridPaneNewCatalogue.setMinSize(600, 700);
        gridPaneNewCatalogue.setVgap(15);
        gridPaneNewCatalogue.setHgap(15);
        gridPaneNewCatalogue.setAlignment(Pos.CENTER);
        gridPaneNewCatalogue.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        textFieldCatalogueName = new TextField();
        textFieldCatalogueName.setPromptText("Nombre del paciente");
        textFieldCatalogueName.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneNewCatalogue.add(textFieldCatalogueName, 0, 1);
        textFieldCatalogueName.setFocusTraversable(false);
        textFieldCatalogueName.setOnKeyPressed((event) -> {
            textFieldPropertiesQuantity.setDisable(false);
        });
        
        Label labelFechHora = new Label("Hacer algo con Hora y fecha");
        gridPaneNewCatalogue.add(labelFechHora, 0, 2);

        textFieldPropertiesQuantity = new TextField();
        textFieldPropertiesQuantity.setPromptText("Doctora");
        textFieldPropertiesQuantity.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneNewCatalogue.add(textFieldPropertiesQuantity, 0, 3); /// columna fila
        textFieldPropertiesQuantity.setFocusTraversable(false);
        textFieldPropertiesQuantity.setDisable(true);


        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneNewCatalogue.add(botonGuardar, 0, 7);
        botonGuardar.setDisable(true);
        botonGuardar.setOnAction((event) -> {
          
        });//END BUTTON

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneNewCatalogue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {
            
            gridPaneNewCatalogue.getChildren().clear();
            gridPaneNewCatalogue.setBackground(Background.EMPTY);  //limpia color para que quede el color

        });//end btn cerrar

        return gridPaneNewCatalogue;
    }//end GridPane createCatalogue()
    
}
