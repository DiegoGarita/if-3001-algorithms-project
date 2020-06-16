package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Formulario{

    ComboBox comboBoxClientes = new ComboBox();

    TextField textFieldID;
    TextField textFieldNombre;
    TextField textFieldFecha;
    TextField textFieldHora;
    TextField textFieldEdad;
    TextField textFieldEdadMetabolica;
    TextField textFieldAltura;
    TextField textFieldPeso;
    TextField textFieldPorcentajeMasaMuscular;
    TextField textFieldGrasa;
    TextField textFieldGrasaVisceral;
    TextField textFieldHueso;
    TextField textFieldPorcentajeAgua;
    TextField textFieldActividadFisica;
    TextField textFieldHorasDescanso;

    TextArea textAreaNotas = new TextArea();

    Button buttonAceptar;
    Button buttonIngresar;

    LogicaCola adminLogic = new LogicaCola();
     LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();

   IniciarSesion iniciarSesion;
    
            

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane formulario() {

        GridPane gridPaneFormulario = new GridPane();
        gridPaneFormulario.setMinSize(600, 700);
        gridPaneFormulario.setVgap(15);
        gridPaneFormulario.setHgap(15);
        gridPaneFormulario.setAlignment(Pos.CENTER);
        gridPaneFormulario.setStyle("-fx-background-color: dodgerblue");

        comboBoxClientes.setValue("Clientes");
        comboBoxClientes.setStyle("-fx-background-color: lightblue");
        gridPaneFormulario.add(comboBoxClientes, 0, 0);

        for (int i = 0; i < adminLogic.cantidadDeClientes("ä"); i++) {
            comboBoxClientes.getItems().addAll(adminLogic.arrayListClientes.get(i).getId());
        }

        buttonIngresar = new Button("Ingresar");
        buttonIngresar.setTextFill(Color.WHITE);
        buttonIngresar.setStyle("-fx-background-color: BLACK");
        buttonIngresar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttonIngresar, 1, 0);
        buttonIngresar.setOnAction((event) -> {

            if (!comboBoxClientes.getValue().toString().equals("")) {
                textFieldID.setVisible(true);
                textFieldNombre.setVisible(true);
                textFieldFecha.setVisible(true);
                textFieldHora.setVisible(true);
                textFieldEdad.setVisible(true);
                textFieldEdadMetabolica.setVisible(true);
                textFieldAltura.setVisible(true);
                textFieldPeso.setVisible(true);
                textFieldPorcentajeMasaMuscular.setVisible(true);
                textFieldGrasa.setVisible(true);
                textFieldGrasaVisceral.setVisible(true);
                textFieldHueso.setVisible(true);
                textFieldPorcentajeAgua.setVisible(true);
                textFieldActividadFisica.setVisible(true);
                textFieldHorasDescanso.setVisible(true);

                textAreaNotas.setVisible(true);

                buttonAceptar.setVisible(true);

                textFieldID.setText(adminLogic.obtieneUsuario(comboBoxClientes.getValue().toString()).getId());
                textFieldNombre.setText(adminLogic.obtieneUsuario(comboBoxClientes.getValue().toString()).getName());
                textFieldFecha.setText("Ingresar fecha de cita*");
                textFieldHora.setText("Ingresar hora de cita*");

            }

        });//end setOnAction

        textFieldID = new TextField();
        textFieldID.setDisable(true);
        textFieldID.setVisible(false);
        textFieldID.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldID, 0, 1);
        textFieldID.setFocusTraversable(false);

        textFieldNombre = new TextField();
        textFieldNombre.setDisable(true);
        textFieldNombre.setVisible(false);
        textFieldNombre.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldNombre, 1, 1);
        textFieldNombre.setFocusTraversable(false);

        textFieldFecha = new TextField();
        textFieldFecha.setDisable(true);
        textFieldFecha.setVisible(false);
        textFieldFecha.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldFecha, 2, 1);
        textFieldFecha.setFocusTraversable(false);

        textFieldHora = new TextField();
        textFieldHora.setDisable(true);
        textFieldHora.setVisible(false);
        textFieldHora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldHora, 3, 1);
        textFieldHora.setFocusTraversable(false);

        textFieldEdad = new TextField();
        textFieldEdad.setPromptText("Edad");
        textFieldEdad.setVisible(false);
        textFieldEdad.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldEdad, 0, 2);
        textFieldEdad.setFocusTraversable(false);

        textFieldEdadMetabolica = new TextField();
        textFieldEdadMetabolica.setPromptText("Edad metabolica");
        textFieldEdadMetabolica.setVisible(false);
        textFieldEdadMetabolica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldEdadMetabolica, 1, 2);
        textFieldEdadMetabolica.setFocusTraversable(false);

        textFieldAltura = new TextField();
        textFieldAltura.setPromptText("Altura");
        textFieldAltura.setVisible(false);
        textFieldAltura.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldAltura, 2, 2);
        textFieldAltura.setFocusTraversable(false);

        textFieldPeso = new TextField();
        textFieldPeso.setPromptText("Peso");
        textFieldPeso.setVisible(false);
        textFieldPeso.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldPeso, 3, 2);
        textFieldPeso.setFocusTraversable(false);

        textFieldPorcentajeMasaMuscular = new TextField();
        textFieldPorcentajeMasaMuscular.setPromptText("% masa muscular");
        textFieldPorcentajeMasaMuscular.setVisible(false);
        textFieldPorcentajeMasaMuscular.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldPorcentajeMasaMuscular, 0, 3);
        textFieldPorcentajeMasaMuscular.setFocusTraversable(false);

        textFieldGrasa = new TextField();
        textFieldGrasa.setPromptText("Grasa");
        textFieldGrasa.setVisible(false);
        textFieldGrasa.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldGrasa, 1, 3);
        textFieldGrasa.setFocusTraversable(false);

        textFieldGrasaVisceral = new TextField();
        textFieldGrasaVisceral.setPromptText("Grasa Visceral");
        textFieldGrasaVisceral.setVisible(false);

        textFieldGrasaVisceral.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldGrasaVisceral, 2, 3);
        textFieldGrasaVisceral.setFocusTraversable(false);

        textFieldHueso = new TextField();
        textFieldHueso.setPromptText("Hueso");
        textFieldHueso.setVisible(false);
        textFieldHueso.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldHueso, 3, 3);
        textFieldHueso.setFocusTraversable(false);

        textFieldPorcentajeAgua = new TextField();
        textFieldPorcentajeAgua.setPromptText("% de agua");
        textFieldPorcentajeAgua.setVisible(false);
        textFieldPorcentajeAgua.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldPorcentajeAgua, 0, 4);
        textFieldPorcentajeAgua.setFocusTraversable(false);

        textFieldActividadFisica = new TextField();
        textFieldActividadFisica.setPromptText("Actividad fisica");
        textFieldActividadFisica.setVisible(false);
        textFieldActividadFisica.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldActividadFisica, 1, 4);
        textFieldActividadFisica.setFocusTraversable(false);

        textFieldHorasDescanso = new TextField();
        textFieldHorasDescanso.setPromptText("Horas de descanso");
        textFieldHorasDescanso.setVisible(false);
        textFieldHorasDescanso.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneFormulario.add(textFieldHorasDescanso, 2, 4);
        textFieldHorasDescanso.setFocusTraversable(false);

        GridPane.setColumnSpan(textAreaNotas, Integer.BYTES);
        textAreaNotas.setVisible(false);
        textAreaNotas.setMinSize(650, 75);
        gridPaneFormulario.add(textAreaNotas, 0, 5);

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setVisible(false);
        buttonAceptar.setTextFill(Color.WHITE);
        buttonAceptar.setStyle("-fx-background-color: BLACK");
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttonAceptar, 0, 6);
        buttonAceptar.setOnAction((event) -> {

            ReporteMedico reporteMedico = new ReporteMedico(textFieldID.getText(), textFieldNombre.getText(),
                    textFieldFecha.getText(), textFieldHora.getText(), textFieldEdad.getText(), textFieldEdadMetabolica.getText(),
                    textFieldAltura.getText(), textFieldPeso.getText(), textFieldPorcentajeMasaMuscular.getText(), textFieldGrasa.getText(),
                    textFieldGrasaVisceral.getText(), textFieldHueso.getText(), textFieldPorcentajeAgua.getText(), textFieldActividadFisica.getText(),
                    textFieldHorasDescanso.getText(), textAreaNotas.getText());
            adminLogic.escribeCitas(reporteMedico);
            
             Acciones acciones = new Acciones(iniciarSesion.ID, "Ingresó nuevo formulario para un paciente", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);
            
        });//end setOnAction

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttonCerrar, 0, 8);
        MainMenuBarAdministrador n = new MainMenuBarAdministrador();

        MainMenuBarAdministrador o = new MainMenuBarAdministrador();

        buttonCerrar.setOnAction((event) -> {

            gridPaneFormulario.getChildren().clear();

            gridPaneFormulario.setBackground(Background.EMPTY);

            gridPaneFormulario.getChildren().add(o.menuAdministrador());

        });//end btn cerrar

        return gridPaneFormulario;
    }//end GridPane createCatalogue()
}
