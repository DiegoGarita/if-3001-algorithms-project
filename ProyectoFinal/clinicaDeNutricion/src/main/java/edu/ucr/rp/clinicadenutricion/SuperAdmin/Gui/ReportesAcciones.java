package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReportesAcciones {

    LogicaSuperAdmin archSupAdmin = new LogicaSuperAdmin();
    TableView<Acciones> tableViewAcciones;

    public GridPane reportesAcciones() {

        GridPane gridPaneReportesAcciones = new GridPane();
        gridPaneReportesAcciones.setMinSize(600, 700);
        gridPaneReportesAcciones.setVgap(15);
        gridPaneReportesAcciones.setHgap(15);
        gridPaneReportesAcciones.setAlignment(Pos.CENTER);

        gridPaneReportesAcciones.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

        tableViewAcciones = new TableView<>();

        TableColumn<Acciones, String> accionadorColunm = new TableColumn<>("Accionador");
        accionadorColunm.setMaxWidth(200);
        accionadorColunm.setCellValueFactory(new PropertyValueFactory<>("Accionador"));
        accionadorColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<Acciones, String> accionColunm = new TableColumn<>("Acción");
        accionColunm.setMaxWidth(200);
        accionColunm.setCellValueFactory(new PropertyValueFactory<>("accion"));
        accionColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<Acciones, String> fechaHoraAccionColunm = new TableColumn<>("Fecha/Hora de acción");
        fechaHoraAccionColunm.setMaxWidth(200);
        fechaHoraAccionColunm.setCellValueFactory(new PropertyValueFactory<>("fechaHoraAccion"));
        fechaHoraAccionColunm.setStyle("-fx-alignment: CENTER;");

        GridPane.setColumnSpan(tableViewAcciones, Integer.BYTES);
        tableViewAcciones.setItems(obtieneAcciones());
        tableViewAcciones.getColumns().addAll(accionadorColunm, accionColunm, fechaHoraAccionColunm);
        tableViewAcciones.setMinSize(500, 400);
        gridPaneReportesAcciones.add(tableViewAcciones, 0, 2);

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneReportesAcciones.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneReportesAcciones.getChildren().clear();
            gridPaneReportesAcciones.setBackground(Background.EMPTY);
            gridPaneReportesAcciones.getChildren().add(barSuper.menuSuperAdmi());

        });

        return gridPaneReportesAcciones;
    }//end gridPaneReportesAcciones()

    /**
     * método observableList necesario para el funcionamiento del tableView
     * @return retorna el objeto Acciones dentro del observableList
     */
    public ObservableList<Acciones> obtieneAcciones() {
        ObservableList<Acciones> reporteMedico = FXCollections.observableArrayList();
        for (int i = 0; i < archSupAdmin.cantidadDeLineas(); i++) {
            reporteMedico.add(archSupAdmin.stringTokenizerHistorial(archSupAdmin.leeArchivo(i)));
        }
        return reporteMedico;
    }

}
