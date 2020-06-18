package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReporteCitas {

    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaPila logicaCliente = new LogicaPila();


    TableView<ReporteMedico> tableViewReporteMedico;
    LogicaCola logicaCola = new LogicaCola();
    Label labelTraeId = new Label();

    LogicaListas logicaListas = new LogicaListas();
    IniciarSesion iniciarSesion;
    ArchSupAdmin logiSuper = new ArchSupAdmin();

    public GridPane reporteCita() {

        GridPane gridPaneReporteCitas = new GridPane();
        gridPaneReporteCitas.setMinSize(300, 350);
        gridPaneReporteCitas.setVgap(15);
        gridPaneReporteCitas.setHgap(15);
        gridPaneReporteCitas.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        gridPaneReporteCitas.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario usuario = logicaListas.stringTokenizer(logicaListas.leeLinea(iniciarSesion.ID));
        String tipo = "";
        if (usuario.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (usuario.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        labelTraeId.setText(usuario.getId());

        //---------------------------------------------------------------------------------------------------------------------------      
        tableViewReporteMedico = new TableView<>();

        TableColumn<ReporteMedico, String> idColunm = new TableColumn<>("ID");
        idColunm.setMaxWidth(200);
        idColunm.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<ReporteMedico, String> nombreColunm = new TableColumn<>("nombre");
        nombreColunm.setMaxWidth(200);
        nombreColunm.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<ReporteMedico, String> fechaColunm = new TableColumn<>("fecha");
        fechaColunm.setMaxWidth(200);
        fechaColunm.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        TableColumn<ReporteMedico, String> horaColunm = new TableColumn<>("hora");
        horaColunm.setMaxWidth(200);
        horaColunm.setCellValueFactory(new PropertyValueFactory<>("hora"));

        TableColumn<ReporteMedico, String> edadColunm = new TableColumn<>("edad");
        edadColunm.setMaxWidth(200);
        edadColunm.setCellValueFactory(new PropertyValueFactory<>("edad"));

        TableColumn<ReporteMedico, String> edadMetabolicaColunm = new TableColumn<>("edadMetabolica");
        edadMetabolicaColunm.setMaxWidth(200);
        edadMetabolicaColunm.setCellValueFactory(new PropertyValueFactory<>("edadMetabolica"));

        TableColumn<ReporteMedico, String> alturaColunm = new TableColumn<>("altura");
        alturaColunm.setMaxWidth(200);
        alturaColunm.setCellValueFactory(new PropertyValueFactory<>("altura"));

        TableColumn<ReporteMedico, String> pesoColunm = new TableColumn<>("peso");
        pesoColunm.setMaxWidth(200);
        pesoColunm.setCellValueFactory(new PropertyValueFactory<>("peso"));

        TableColumn<ReporteMedico, String> porcenMasaMuscularColunm = new TableColumn<>("porcenMasaMuscular");
        porcenMasaMuscularColunm.setMaxWidth(200);
        porcenMasaMuscularColunm.setCellValueFactory(new PropertyValueFactory<>("porcenMasaMuscular"));

        TableColumn<ReporteMedico, String> grasaColunm = new TableColumn<>("grasa");
        grasaColunm.setMaxWidth(200);
        grasaColunm.setCellValueFactory(new PropertyValueFactory<>("grasa"));

        TableColumn<ReporteMedico, String> grasaVisceralColunm = new TableColumn<>("grasaVisceral");
        grasaVisceralColunm.setMaxWidth(200);
        grasaVisceralColunm.setCellValueFactory(new PropertyValueFactory<>("grasaVisceral"));


        TableColumn<ReporteMedico, String> huesoColunm = new TableColumn<>("hueso");
        huesoColunm.setMaxWidth(200);
        huesoColunm.setCellValueFactory(new PropertyValueFactory<>("hueso"));

        TableColumn<ReporteMedico, String> porcenAguaColunm = new TableColumn<>("porcenAgua");
        porcenAguaColunm.setMaxWidth(200);
        porcenAguaColunm.setCellValueFactory(new PropertyValueFactory<>("porcenAgua"));

        TableColumn<ReporteMedico, String> actividadFisicaColunm = new TableColumn<>("actividadFisica");
        actividadFisicaColunm.setMaxWidth(200);
        actividadFisicaColunm.setCellValueFactory(new PropertyValueFactory<>("actividadFisica"));

        TableColumn<ReporteMedico, String> horasDeSueñoColunm = new TableColumn<>("horasDeSueño");
        horasDeSueñoColunm.setMaxWidth(200);
        horasDeSueñoColunm.setCellValueFactory(new PropertyValueFactory<>("horasDeSueño"));

        TableColumn<ReporteMedico, String> textAreaNotasColunm = new TableColumn<>("textAreaNotas");
        textAreaNotasColunm.setMaxWidth(200);
        textAreaNotasColunm.setCellValueFactory(new PropertyValueFactory<>("textAreaNotas"));

        Button buttonBuscar = new Button("Desplegar informe");
        buttonBuscar.setTextFill(Color.WHITE);
        buttonBuscar.setStyle("-fx-background-color: BLACK");
        buttonBuscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReporteCitas.add(buttonBuscar, 0, 0);
        buttonBuscar.setDisable(false);
        buttonBuscar.setOnAction((event) -> {

            Acciones acciones = new Acciones(iniciarSesion.ID, "consultó su reporte de citas", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);

            gridPaneReporteCitas.add(tableViewReporteMedico, 0, 4);
            GridPane.setColumnSpan(tableViewReporteMedico, Integer.BYTES);
            tableViewReporteMedico.setItems(obtieneReporteMedico(labelTraeId.getText()));
            //  System.out.println(labelTraeId.getText());
            tableViewReporteMedico.getColumns().addAll(idColunm, nombreColunm, fechaColunm, horaColunm, edadColunm, edadMetabolicaColunm, alturaColunm, pesoColunm, porcenMasaMuscularColunm, grasaColunm, grasaVisceralColunm, huesoColunm, porcenAguaColunm, actividadFisicaColunm, horasDeSueñoColunm, textAreaNotasColunm);

        });// end boton

//---------------------------------------------------------------------------------------------------------------------------
        MainMenuBarCliente barCliente = new MainMenuBarCliente();

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReporteCitas.add(buttonCerrar, 0, 6);
        buttonCerrar.setOnAction((event) -> {
            gridPaneReporteCitas.getChildren().clear();
            gridPaneReporteCitas.setBackground(Background.EMPTY);
            gridPaneReporteCitas.getChildren().add(barCliente.menuCliente());
        });

        logicaCliente.leeArchivoSolicitudCita();

        return gridPaneReporteCitas;

    }

    public ObservableList<ReporteMedico> obtieneReporteMedico(String file) {
        ObservableList<ReporteMedico> reporteMedico = FXCollections.observableArrayList();
        for (int i = 0; i < logicaCola.cantidadDeLineas(file); i++) {
            reporteMedico.add(logicaCola.stringTokenizer(logicaCola.leeArchivo(labelTraeId.getText(), i)));
        }
        return reporteMedico;
    }

}//end class reporte citas
