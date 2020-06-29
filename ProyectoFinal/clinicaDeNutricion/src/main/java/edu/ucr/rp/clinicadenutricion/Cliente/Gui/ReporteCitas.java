package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

import edu.ucr.rp.clinicadenutricion.AVL.LogicaAVL;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaArbol;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.LogicaPila;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
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

    Label labelTraeId = new Label();
    TableView<ReporteMedico> tableViewReporteMedico;

    LogicaAVL logicaAVL = new LogicaAVL();
    FechaHora fechaHora = new FechaHora();
    LogicaPila logicaPila = new LogicaPila();
    LogicaArbol logicaArbol = new LogicaArbol();
    LogicaListas logicaListas = new LogicaListas();
    IniciarSesion iniciarSesion;
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();

    public GridPane reporteCita() {

        GridPane gridPaneReporteCitas = new GridPane();
        gridPaneReporteCitas.setMinSize(300, 350);
        gridPaneReporteCitas.setVgap(15);
        gridPaneReporteCitas.setHgap(15);
        gridPaneReporteCitas.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
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

        tableViewReporteMedico = new TableView<>();

        TableColumn<ReporteMedico, String> idColunm = new TableColumn<>("ID");
        idColunm.setMaxWidth(200);
        idColunm.setCellValueFactory(new PropertyValueFactory<>("ID"));
        idColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> nombreColunm = new TableColumn<>("Nombre");
        nombreColunm.setMaxWidth(200);
        nombreColunm.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> fechaColunm = new TableColumn<>("Fecha");
        fechaColunm.setMaxWidth(200);
        fechaColunm.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        fechaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> horaColunm = new TableColumn<>("Hora");
        horaColunm.setMaxWidth(200);
        horaColunm.setCellValueFactory(new PropertyValueFactory<>("hora"));
        horaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> edadColunm = new TableColumn<>("Edad");
        edadColunm.setMaxWidth(200);
        edadColunm.setCellValueFactory(new PropertyValueFactory<>("edad"));
        edadColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> edadMetabolicaColunm = new TableColumn<>("Edad metabolica");
        edadMetabolicaColunm.setMaxWidth(200);
        edadMetabolicaColunm.setCellValueFactory(new PropertyValueFactory<>("edadMetabolica"));
        edadMetabolicaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> alturaColunm = new TableColumn<>("Altura");
        alturaColunm.setMaxWidth(200);
        alturaColunm.setCellValueFactory(new PropertyValueFactory<>("altura"));
        alturaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> pesoColunm = new TableColumn<>("Peso");
        pesoColunm.setMaxWidth(200);
        pesoColunm.setCellValueFactory(new PropertyValueFactory<>("peso"));
        pesoColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> porcenMasaMuscularColunm = new TableColumn<>("% Masa muscular");
        porcenMasaMuscularColunm.setMaxWidth(200);
        porcenMasaMuscularColunm.setCellValueFactory(new PropertyValueFactory<>("porcentajeMasaMuscular"));
        porcenMasaMuscularColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> grasaColunm = new TableColumn<>("Grasa");
        grasaColunm.setMaxWidth(200);
        grasaColunm.setCellValueFactory(new PropertyValueFactory<>("grasa"));
        grasaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> grasaVisceralColunm = new TableColumn<>("Grasa visceral");
        grasaVisceralColunm.setMaxWidth(200);
        grasaVisceralColunm.setCellValueFactory(new PropertyValueFactory<>("grasaVisceral"));
        grasaVisceralColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> huesoColunm = new TableColumn<>("Hueso");
        huesoColunm.setMaxWidth(200);
        huesoColunm.setCellValueFactory(new PropertyValueFactory<>("hueso"));
        huesoColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> porcenAguaColunm = new TableColumn<>("% Agua");
        porcenAguaColunm.setMaxWidth(200);
        porcenAguaColunm.setCellValueFactory(new PropertyValueFactory<>("porcentajeAgua"));
        porcenAguaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> actividadFisicaColunm = new TableColumn<>("Actividad fisica");
        actividadFisicaColunm.setMaxWidth(200);
        actividadFisicaColunm.setCellValueFactory(new PropertyValueFactory<>("actividadFisica"));
        actividadFisicaColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> horasDeSueñoColunm = new TableColumn<>("Horas de sueño");
        horasDeSueñoColunm.setMaxWidth(200);
        horasDeSueñoColunm.setCellValueFactory(new PropertyValueFactory<>("horasDeSueño"));
        horasDeSueñoColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<ReporteMedico, String> textAreaNotasColunm = new TableColumn<>("Notas");
        textAreaNotasColunm.setMaxWidth(200);
        textAreaNotasColunm.setCellValueFactory(new PropertyValueFactory<>("textAreaNotas"));
        textAreaNotasColunm.setStyle("-fx-alignment: CENTER;");

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
            tableViewReporteMedico.setItems(obtieneReporteMedicos(labelTraeId.getText()));
            tableViewReporteMedico.getColumns().addAll(idColunm, nombreColunm, fechaColunm,
                    horaColunm, edadColunm, edadMetabolicaColunm, alturaColunm, pesoColunm,
                    porcenMasaMuscularColunm, grasaColunm, grasaVisceralColunm, huesoColunm,
                    porcenAguaColunm, actividadFisicaColunm, horasDeSueñoColunm, textAreaNotasColunm);
            buttonBuscar.setDisable(true);
        });

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

        logicaPila.leeArchivoSolicitudCita();

        return gridPaneReporteCitas;

    } //end reporteCita

    public ObservableList<ReporteMedico> obtieneReporteMedicos(String file) {
        ObservableList<ReporteMedico> reporteMedico = FXCollections.observableArrayList();
        for (int i = 0; i < logicaArbol.cantidadDeLineas(file); i++) {
            reporteMedico.add(logicaArbol.stringTokenizer(logicaArbol.leeArchivo(labelTraeId.getText(), i)));
        }
        return reporteMedico;
    }

}//end class reporteCitas
