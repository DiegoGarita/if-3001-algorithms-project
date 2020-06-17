package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class InformacionPaciente {

    LogicaCola logicaCola = new LogicaCola();
    ComboBox comboBoxClientes = new ComboBox();
    IniciarSesion iniciarSesion;
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    TableView<ReporteMedico> tableViewReporteMedico;

    public GridPane informacionPaciente() {

        GridPane gridPaneInformacionPaciente = new GridPane();
        gridPaneInformacionPaciente.setMinSize(600, 700);
        gridPaneInformacionPaciente.setVgap(15);
        gridPaneInformacionPaciente.setHgap(15);
        gridPaneInformacionPaciente.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        gridPaneInformacionPaciente.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        comboBoxClientes.setValue("Clientes");
        comboBoxClientes.setStyle("-fx-background-color: lightblue");
        gridPaneInformacionPaciente.add(comboBoxClientes, 0, 0);

        for (int i = 0; i < logicaCola.cantidadDeClientes("ä"); i++) {
            comboBoxClientes.getItems().addAll(logicaCola.arrayListClientes.get(i).getId());
        }

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

        Button buttonBuscar = new Button("Buscar");
        buttonBuscar.setTextFill(Color.WHITE);
        buttonBuscar.setStyle("-fx-background-color: BLACK");
        buttonBuscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneInformacionPaciente.add(buttonBuscar, 1, 0);
        buttonBuscar.setDisable(false);

        buttonBuscar.setOnAction((event) -> {

            Acciones acciones = new Acciones(iniciarSesion.ID, "Solicitó información de pacientes", fechaHora.histoFechaHora());
            logicaAVL.escribeHistorial(acciones);

            gridPaneInformacionPaciente.add(tableViewReporteMedico, 0, 4);
             GridPane.setColumnSpan(tableViewReporteMedico, Integer.BYTES);
            tableViewReporteMedico.setItems(obtieneReporteMedico(comboBoxClientes.getValue().toString()));
            tableViewReporteMedico.getColumns().addAll(idColunm, nombreColunm, fechaColunm, horaColunm, edadColunm, edadMetabolicaColunm, alturaColunm, pesoColunm, porcenMasaMuscularColunm, grasaColunm, grasaVisceralColunm, huesoColunm, porcenAguaColunm, actividadFisicaColunm, horasDeSueñoColunm, textAreaNotasColunm);

        });// end boton

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneInformacionPaciente.add(buttonCerrar, 2, 0);

        MainMenuBarAdministrador o = new MainMenuBarAdministrador();

        buttonCerrar.setOnAction((event) -> {
            gridPaneInformacionPaciente.getChildren().clear();
            gridPaneInformacionPaciente.setBackground(Background.EMPTY);
            gridPaneInformacionPaciente.getChildren().add(o.menuAdministrador());

        });

        return gridPaneInformacionPaciente;
    }

    public ObservableList<ReporteMedico> obtieneReporteMedico(String file) {
        ObservableList<ReporteMedico> reporteMedico = FXCollections.observableArrayList();
        for (int i = 0; i < logicaCola.cantidadDeLineas(file); i++) {
            reporteMedico.add(logicaCola.stringTokenizer(logicaCola.leeArchivo(comboBoxClientes.getValue().toString(), i)));
        }
        return reporteMedico;
    }

}
