package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class FormuDoctor {

    TextField textFieldPorAgua;        //--> %Agua
    TextField textFieldPormasaMuscular;
    TextField textFieldGrasa;
    TextField textFieldGrasaVisceral;

    TextField textFieldHueso;
    TextField textFieldPeso;
    TextField textFieldEdadMetab;
    TextField textFieldEdad;

    TextField textFieldAltura;
    TextField textFieldHorasDescanso;
    TextField textFieldActividadFisica;

    TextArea textAreaNotas = new TextArea();

    Button buttonAceptar;
    String fileName;
    LogoApp logo = new LogoApp();

//////////    public CrearUsuarioNuevo(String fileName) {
//////////        this.fileName = fileName;
//////////    }
    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane formulario() {

        /// File file = new File(fileName);
        GridPane gridPaneForm = new GridPane();
        gridPaneForm.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPaneForm.setVgap(15);   //espacio
        gridPaneForm.setHgap(15);    // espacio
        // alinear el grip
        gridPaneForm.setAlignment(Pos.CENTER);

        gridPaneForm.setStyle(("-fx-background-image:url('file:src/image/"+logo.NombreLogo+".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldPorAgua = new TextField();
        textFieldPorAgua.setPromptText("% de agua");
        textFieldPorAgua.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");

        gridPaneForm.add(textFieldPorAgua, 0, 1);
        GridPane.setColumnSpan(textAreaNotas, Integer.BYTES);
        textFieldPorAgua.setFocusTraversable(false);

        textFieldPormasaMuscular = new TextField();
        textFieldPormasaMuscular.setPromptText("% masa musc");
        textFieldPormasaMuscular.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldPormasaMuscular, 1, 1);
        textFieldPormasaMuscular.setFocusTraversable(false);

        textFieldGrasa = new TextField();
        textFieldGrasa.setPromptText("Grasa");
        textFieldGrasa.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldGrasa, 2, 1);
        textFieldGrasa.setFocusTraversable(false);

        textFieldGrasaVisceral = new TextField();
        textFieldGrasaVisceral.setPromptText("Grasa Visceral");
        textFieldGrasaVisceral.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldGrasaVisceral, 3, 1);
        textFieldGrasaVisceral.setFocusTraversable(false);

        textFieldHueso = new TextField();
        textFieldHueso.setPromptText("Hueso");
        textFieldHueso.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldHueso, 0, 2);
        textFieldHueso.setFocusTraversable(false);

        textFieldPeso = new TextField();
        textFieldPeso.setPromptText("Peso");
        textFieldPeso.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldPeso, 1, 2);
        textFieldPeso.setFocusTraversable(false);

        textFieldEdadMetab = new TextField();
        textFieldEdadMetab.setPromptText("Edad metabolica");
        textFieldEdadMetab.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldEdadMetab, 2, 2);
        textFieldEdadMetab.setFocusTraversable(false);

        textFieldEdad = new TextField();
        textFieldEdad.setPromptText("Edad");
        textFieldEdad.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldEdad, 3, 2);
        textFieldEdad.setFocusTraversable(false);

        textFieldAltura = new TextField();
        textFieldAltura.setPromptText("Altura");
        textFieldAltura.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldAltura, 0, 3);
        textFieldAltura.setFocusTraversable(false);

        textFieldHorasDescanso = new TextField();
        textFieldHorasDescanso.setPromptText("Horas de descanso");
        textFieldHorasDescanso.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldHorasDescanso, 1, 3);
        textFieldHorasDescanso.setFocusTraversable(false);

        textFieldActividadFisica = new TextField();
        textFieldActividadFisica.setPromptText("Actividad fisica");
        textFieldActividadFisica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneForm.add(textFieldActividadFisica, 2, 3);
        textFieldActividadFisica.setFocusTraversable(false);

        textAreaNotas.setText("TODO Notas here");
        textAreaNotas.setMinSize(650, 75);
        gridPaneForm.add(textAreaNotas, 0, 4);

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneForm.add(buttonAceptar, 0, 5);
        buttonAceptar.setOnAction((event) -> {

        });//end setOnAction

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneForm.add(buttonClose, 0, 8);
        MainMenuBarAdmi n = new MainMenuBarAdmi();
        //***
        MainMenuBarAdmi o = new MainMenuBarAdmi();
        //***
        buttonClose.setOnAction((event) -> {

            gridPaneForm.getChildren().clear();

            gridPaneForm.setBackground(Background.EMPTY);

            gridPaneForm.getChildren().add(o.menuAdmi());
            /// gridPaneForm.getColumnConstraints().add(new ColumnConstraints(0));// --------> GRAN PROBLEMA

        });//end btn cerrar

        return gridPaneForm;
    }//end GridPane createCatalogue()
}
