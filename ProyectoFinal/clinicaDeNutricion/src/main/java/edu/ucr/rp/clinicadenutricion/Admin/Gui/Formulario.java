package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.Utilitario.Alertas;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.Utilitario.EnviarCorreo;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Formulario {

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
    Button buttonEnviarCorreo;
    Button buttongeneraPDF;
    Button buttonCerrar;

    LogicaCola logicaCola = new LogicaCola();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    Alertas alerta = new Alertas();
    EnviarCorreo enviarCorreo = new EnviarCorreo();
    IniciarSesion iniciarSesion;

    public GridPane formulario() {

        GridPane gridPaneFormulario = new GridPane();
        gridPaneFormulario.setMinSize(600, 700);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPaneFormulario.setVgap(15);
        gridPaneFormulario.setHgap(15);
        gridPaneFormulario.setAlignment(Pos.CENTER);
        gridPaneFormulario.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        comboBoxClientes.setValue("Clientes");
        comboBoxClientes.setStyle("-fx-background-color: lightblue");
        gridPaneFormulario.add(comboBoxClientes, 0, 0);
        for (int i = 0; i < logicaCola.cantidadDeClientes("ä"); i++) {
            comboBoxClientes.getItems().addAll(logicaCola.arrayListClientes.get(i).getId());
        }
        comboBoxClientes.setOnMouseClicked((event) -> {
            buttonIngresar.setDisable(false);
        });

        buttonIngresar = new Button("Ingresar");
        buttonIngresar.setTextFill(Color.WHITE);
        buttonIngresar.setStyle("-fx-background-color: BLACK");
        buttonIngresar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        buttonIngresar.setDisable(true);
        gridPaneFormulario.add(buttonIngresar, 1, 0);
        buttonIngresar.setOnAction((event) -> {

            if (comboBoxClientes.getSelectionModel().getSelectedItem().equals("Clientes") != true) {
                comboBoxClientes.setDisable(true);
                buttonIngresar.setDisable(true);
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
                    buttongeneraPDF.setVisible(true);
                    buttonEnviarCorreo.setVisible(true);

                    textFieldID.setText(logicaCola.obtieneUsuario(comboBoxClientes.getValue().toString()).getId());
                    textFieldNombre.setText(logicaCola.obtieneUsuario(comboBoxClientes.getValue().toString()).getName());
                    textFieldFecha.setText(fechaHora.histoFechaHora().substring(0, 10));
                    textFieldHora.setText(fechaHora.histoFechaHora().substring(11, 19));

                }
            }
            else {
                alerta.alertWarning("No selecciono un cliente\nIntente de nuevo");
            }
        });

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
        textFieldEdad.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldEdadMetabolica.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldAltura.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldPeso.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldPorcentajeMasaMuscular.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldGrasa.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldGrasaVisceral.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldHueso.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldPorcentajeAgua.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldActividadFisica.setOnKeyPressed((t) -> {
            buttonAceptar.setDisable(true);
        });

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
        textFieldHorasDescanso.setOnKeyPressed((event) -> {
            buttonEnviarCorreo.setDisable(false);
            buttongeneraPDF.setDisable(false);
            textAreaNotas.setDisable(false);
            textAreaNotas.setDisable(false);
            buttonAceptar.setDisable(true);
        });

        GridPane.setColumnSpan(textAreaNotas, Integer.BYTES);
        textAreaNotas.setVisible(false);
        textAreaNotas.setMinSize(650, 75);
        textAreaNotas.setDisable(true);
        gridPaneFormulario.add(textAreaNotas, 0, 5);
        textAreaNotas.setPromptText("");
        textAreaNotas.setFocusTraversable(false);
        textAreaNotas.setOnMouseClicked((t) -> {
            buttongeneraPDF.setDisable(false);
        });

        buttongeneraPDF = new Button("Generar PDF");
        buttongeneraPDF.setVisible(false);
        buttongeneraPDF.setTextFill(Color.WHITE);
        buttongeneraPDF.setStyle("-fx-background-color: BLACK");
        buttongeneraPDF.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttongeneraPDF, 0, 6);
        buttongeneraPDF.setDisable(true);
        buttongeneraPDF.setOnAction((event) -> {
            buttonAceptar.setDisable(false);

            if (!textFieldEdad.getText().trim().equals("") && !textFieldEdadMetabolica.getText().trim().equals("")
                    && !textFieldAltura.getText().trim().equals("") && !textFieldPeso.getText().trim().equals("")
                    && !textFieldPorcentajeMasaMuscular.getText().trim().equals("") && !textFieldGrasa.getText().trim().equals("")
                    && !textFieldGrasaVisceral.getText().trim().equals("") && !textFieldHueso.getText().trim().equals("")
                    && !textFieldPorcentajeAgua.getText().trim().equals("") && !textFieldActividadFisica.getText().trim().equals("")
                    && !textFieldHorasDescanso.getText().trim().equals("") && !textAreaNotas.getText().trim().equals("")) {

                Document document = new Document();
                try {
                    PdfWriter writer = PdfWriter.getInstance(document,
                            new FileOutputStream("Reporte " + comboBoxClientes.getValue().toString() + ".pdf"));
                    document.open();

                    Image image1 = Image.getInstance("file:src/image/" + configuracion.getNombreLogo());
                    image1.setAbsolutePosition(0f, 0f);
                    image1.scaleAbsolute(300, 300);
                    document.add(image1);

                    document.add(new Paragraph("Reporte médico del paciente: " + textFieldNombre.getText()));
                    document.add(new Paragraph("Id ------------------> " + textFieldID.getText()));
                    document.add(new Paragraph("Fecha ---------------> " + textFieldFecha.getText()));
                    document.add(new Paragraph("Hora ----------------> " + textFieldHora.getText()));
                    document.add(new Paragraph("Edad ----------------> " + textFieldEdad.getText()));
                    document.add(new Paragraph("Edad Metabólica -----> " + textFieldEdadMetabolica.getText()));
                    document.add(new Paragraph("Altura --------------> " + textFieldAltura.getText()));
                    document.add(new Paragraph("Peso ----------------> " + textFieldPeso.getText()));
                    document.add(new Paragraph("Masa muscular -------> " + textFieldPorcentajeMasaMuscular.getText()));
                    document.add(new Paragraph("Grasa ---------------> " + textFieldGrasa.getText()));
                    document.add(new Paragraph("Grasa visceral ------> " + textFieldGrasaVisceral.getText()));
                    document.add(new Paragraph("Hueso ---------------> " + textFieldHueso.getText()));
                    document.add(new Paragraph("Porcentaje de agua --> " + textFieldPorcentajeAgua.getText()));
                    document.add(new Paragraph("Actividad física ----> " + textFieldActividadFisica.getText()));
                    document.add(new Paragraph("Horas de descanso ---> " + textFieldHorasDescanso.getText()));
                    document.add(new Paragraph("Notas ---------------> " + textAreaNotas.getText()));

                    document.close();
                    writer.close();
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }

                buttongeneraPDF.setDisable(true);
            }
            else {
                alerta.alertWarning("Hay campos vacios\nIntentelo de nuevo");
            }
        });

        buttonEnviarCorreo = new Button("Enviar Correo");
        buttonEnviarCorreo.setVisible(false);
        buttonEnviarCorreo.setTextFill(Color.WHITE);
        buttonEnviarCorreo.setStyle("-fx-background-color: BLACK");
        buttonEnviarCorreo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttonEnviarCorreo, 1, 6);
        buttonEnviarCorreo.setDisable(true);
        buttonEnviarCorreo.setOnAction((event) -> {
            String correo = logicaCola.obtieneUsuario(comboBoxClientes.getValue().toString()).getCorreo();
            try {
                enviarCorreo.sendPDF(correo, "Clínica Susana Distancia", "Reporte " + comboBoxClientes.getValue().toString(), "Reporte de los datos tomados en formulario");
            } catch (IOException ex) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
            }
            buttonEnviarCorreo.setDisable(true);
        });

        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setVisible(false);
        buttonAceptar.setTextFill(Color.WHITE);
        buttonAceptar.setStyle("-fx-background-color: BLACK");
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttonAceptar, 0, 7);
        buttonAceptar.setDisable(true);
        buttonAceptar.setOnAction((event) -> {
            try {
                if (Integer.parseInt(textFieldGrasaVisceral.getText()) % 2 == 0
                        || Integer.parseInt(textFieldGrasaVisceral.getText()) % 2 == 1
                        && Integer.parseInt(textFieldGrasa.getText()) % 2 == 0
                        || Integer.parseInt(textFieldGrasa.getText()) % 2 == 1
                        && Integer.parseInt(textFieldPorcentajeMasaMuscular.getText()) % 2 == 0
                        || Integer.parseInt(textFieldPorcentajeMasaMuscular.getText()) % 2 == 1
                        && Integer.parseInt(textFieldPorcentajeAgua.getText()) % 2 == 0
                        || Integer.parseInt(textFieldPorcentajeAgua.getText()) % 2 == 1) {

                    if (!textFieldEdad.getText().trim().equals("") && !textFieldEdadMetabolica.getText().trim().equals("")
                            && !textFieldAltura.getText().trim().equals("") && !textFieldPeso.getText().trim().equals("")
                            && !textFieldPorcentajeMasaMuscular.getText().trim().equals("") && !textFieldGrasa.getText().trim().equals("")
                            && !textFieldGrasaVisceral.getText().trim().equals("") && !textFieldHueso.getText().trim().equals("")
                            && !textFieldPorcentajeAgua.getText().trim().equals("") && !textFieldActividadFisica.getText().trim().equals("")
                            && !textFieldHorasDescanso.getText().trim().equals("") && !textAreaNotas.getText().trim().equals("")) {

                        ReporteMedico reporteMedico = new ReporteMedico(textFieldID.getText(), textFieldNombre.getText(),
                                textFieldFecha.getText(), textFieldHora.getText(), textFieldEdad.getText(), textFieldEdadMetabolica.getText(),
                                textFieldAltura.getText(), textFieldPeso.getText(), textFieldPorcentajeMasaMuscular.getText(), textFieldGrasa.getText(),
                                textFieldGrasaVisceral.getText(), textFieldHueso.getText(), textFieldPorcentajeAgua.getText(), textFieldActividadFisica.getText(),
                                textFieldHorasDescanso.getText(), textAreaNotas.getText());
                        logicaCola.escribeCitas(reporteMedico);

                        Acciones acciones = new Acciones(iniciarSesion.ID, "Ingresó nuevo formulario para un paciente", fechaHora.histoFechaHora());
                        logicaAVL.escribeHistorial(acciones);

                        textFieldID.clear();
                        textFieldNombre.clear();
                        textFieldFecha.clear();
                        textFieldHora.clear();
                        textFieldEdad.clear();
                        textFieldEdadMetabolica.clear();
                        textFieldAltura.clear();
                        textFieldPeso.clear();
                        textFieldPorcentajeMasaMuscular.clear();
                        textFieldGrasa.clear();
                        textFieldGrasaVisceral.clear();
                        textFieldHueso.clear();
                        textFieldPorcentajeAgua.clear();
                        textFieldActividadFisica.clear();
                        textFieldHorasDescanso.clear();
                        textAreaNotas.clear();
                        alerta.alertInformation("Formulario completado");
                        buttonAceptar.setDisable(true);
                        buttonCerrar.setDisable(false);
                        buttonEnviarCorreo.setDisable(true);
                    }
                    else {
                        alerta.alertWarning("Hay campos vacios\nIntentelo de nuevo");
                    }

                }
                else {
                    alerta.alertWarning("Campos obligatorios con numeros\n(Agua,Grasa,Mas Muscular,Grasa viceral)\nIntente de nuevo");
                }
            } catch (java.lang.NumberFormatException nfe) {
                alerta.alertWarning("Campos obligatorios con numeros\n(Agua,Grasa,Mas Muscular,Grasa viceral)\nIntente de nuevo");
            }
        });

        buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneFormulario.add(buttonCerrar, 0, 8);
        
        MainMenuBarAdministrador o = new MainMenuBarAdministrador();
        
        buttonCerrar.setOnAction((event) -> {
            gridPaneFormulario.getChildren().clear();
            gridPaneFormulario.setBackground(Background.EMPTY);
            gridPaneFormulario.getChildren().add(o.menuAdministrador());
        });

        return gridPaneFormulario;
    }//end gridPaneFormulario()
}
