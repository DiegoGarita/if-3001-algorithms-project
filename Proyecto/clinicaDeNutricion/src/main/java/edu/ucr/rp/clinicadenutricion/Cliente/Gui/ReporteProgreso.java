package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.Cliente.Logic.Grafico;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

//en esta clase el cliente podra ver su avance
public class ReporteProgreso {
    
    TextField textFieldDoctora;
    TextField textFieldHora;
    Button botonGrafico;
    Grafico grafico = new Grafico();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane reporAvan() {

        GridPane gridPanePorgreso = new GridPane();
        gridPanePorgreso.setMinSize(600, 700);
        gridPanePorgreso.setVgap(15);
        gridPanePorgreso.setHgap(15);
        gridPanePorgreso.setAlignment(Pos.CENTER);
        gridPanePorgreso.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        Label labelFechHora = new Label("TODO TRAER INFO DEL MAN EN LABEL'S");
         gridPanePorgreso.add(labelFechHora, 0, 2);




        botonGrafico = new Button("Ver grafica");
        botonGrafico.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGrafico.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGrafico.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePorgreso.add(botonGrafico, 0, 7);
        botonGrafico.setOnAction((event) -> {
   
            grafico.showGraficMethods(66.5, 20.5 ,6.5 , 6.5); //--> %agua, %masMusc, grasa , grasaVisc

        });//END BUTTON

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePorgreso.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPanePorgreso.getChildren().clear();
            gridPanePorgreso.setBackground(Background.EMPTY);
            gridPanePorgreso.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPanePorgreso;
    }//end GridPane createCatalogue()
}
