package edu.ucr.rp.clinicadenutricion.Admin.Gui;

//en etsa clase el admin tendra acceso a los planes de alimentacion
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PlanAlimentos {

    TextField textFieldEspecificar;
    Button buttonDesplegarInfo;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxOp = new ComboBox();

//////////    public CrearUsuarioNuevo(String fileName) {
//////////        this.fileName = fileName;
//////////    }
    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane planesAlimentos() {

        /// File file = new File(fileName);
        GridPane gridPanePlanRece = new GridPane();
        gridPanePlanRece.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanePlanRece.setVgap(15);   //espacio
        gridPanePlanRece.setHgap(15);    // espacio
        // alinear el grip
        gridPanePlanRece.setAlignment(Pos.CENTER);
        gridPanePlanRece.setStyle("-fx-background-color: dodgerblue");
//        gridPaneNewCatalogue.setStyle(("-fx-background-image:url('file:src/image/FCrear.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        comboBoxOp.setValue("Elige una opcion");
        comboBoxOp.setStyle("-fx-background-color: lightblue");
        ObservableList<String> Roles
                = FXCollections.observableArrayList(
                        "Planes alimenticios",
                        "Recetas"
                );
        comboBoxOp.setItems(Roles);
        gridPanePlanRece.add(comboBoxOp, 0, 1);

        textFieldEspecificar = new TextField();
        textFieldEspecificar.setPromptText("Especifica");
        textFieldEspecificar.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanePlanRece.add(textFieldEspecificar, 0, 2);
        textFieldEspecificar.setFocusTraversable(false);

        textAreaMostrar.setText("TODO info aqui");
        textAreaMostrar.setEditable(false);
        gridPanePlanRece.add(textAreaMostrar, 0, 3);

        buttonDesplegarInfo = new Button("Desplegar");
        buttonDesplegarInfo.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonDesplegarInfo.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonDesplegarInfo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanRece.add(buttonDesplegarInfo, 0, 4);
        buttonDesplegarInfo.setOnAction((event) -> {

        });//end setOnAction

        //***
        MainMenuBarAdmi o = new MainMenuBarAdmi();
        //***
        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanRece.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanePlanRece.getChildren().clear();
            gridPanePlanRece.setBackground(Background.EMPTY);  //limpia color para que quede el color
            gridPanePlanRece.getChildren().add(o.menuAdmi());

        });//end btn cerrar

        return gridPanePlanRece;
    }//end GridPane createCatalogue()

}
