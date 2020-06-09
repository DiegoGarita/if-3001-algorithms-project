package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

// clase para que el cliente aparte una cita
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.ClienteLogic;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.PilaImplementacion;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ApartarCita {

    TextField textFieldDoctora;
    TextField textFieldHora;
    Button botonGuardar;
    String agendo = "Agendo cita";
    ClienteLogic clienteLogic = new ClienteLogic();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane reservar() {

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);
        gridPaneCitaNue.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        // Label labelFechHora = new Label("Hacer algo con Hora y fecha");
        //  gridPaneNewCatalogue.add(labelFechHora, 0, 2);
        gridPaneCitaNue.add(new Label("Fecha de cita"), 0, 2);
        DatePicker dT_DateFligth = new DatePicker(LocalDate.now());
        dT_DateFligth.setEditable(false);
        gridPaneCitaNue.add(dT_DateFligth, 1, 2);

        textFieldHora = new TextField();
        textFieldHora.setPromptText("Hore");
        textFieldHora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldHora, 0, 3); /// columna fila
        textFieldHora.setFocusTraversable(false);

        textFieldDoctora = new TextField();
        textFieldDoctora.setPromptText("Doctora");
        textFieldDoctora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldDoctora, 0, 4); /// columna fila
        textFieldDoctora.setFocusTraversable(false);

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonGuardar, 0, 7);
        
        Cita cita = new Cita("traer por detras",  dT_DateFligth.getValue().toString(),
                    textFieldHora.getText(), textFieldDoctora.getText());
        
        botonGuardar.setOnAction((event) -> {

           clienteLogic.writeFileCitas(cita);
         

        });//END BUTTON

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneCitaNue.getChildren().clear();
            gridPaneCitaNue.setBackground(Background.EMPTY);
            gridPaneCitaNue.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPaneCitaNue;
    }//end GridPane createCatalogue()
}
