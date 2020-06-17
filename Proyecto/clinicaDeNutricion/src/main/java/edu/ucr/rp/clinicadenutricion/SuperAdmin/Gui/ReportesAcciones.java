package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

// en esta clase se podra tener acceso a los reportes de acciones
public class ReportesAcciones {

    LogicaListas logic = new LogicaListas();
    Usuario uwu = logic.stringTokenizer(logic.leeLinea("ë"));
    ArchSupAdmin archSupAdmin = new ArchSupAdmin();
    TableView<Acciones> tableViewAcciones;

    public GridPane historial() {

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);

        gridPaneCitaNue.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

        tableViewAcciones = new TableView<>();

        TableColumn<Acciones, String> accionadorColunm = new TableColumn<>("Accionador");
        accionadorColunm.setMaxWidth(200);
        accionadorColunm.setCellValueFactory(new PropertyValueFactory<>("Accionador"));

        TableColumn<Acciones, String> accionColunm = new TableColumn<>("accion");
        accionColunm.setMaxWidth(200);
        accionColunm.setCellValueFactory(new PropertyValueFactory<>("accion"));

        TableColumn<Acciones, String> fechaHoraAccionColunm = new TableColumn<>("fechaHoraAccion");
        fechaHoraAccionColunm.setMaxWidth(200);
        fechaHoraAccionColunm.setCellValueFactory(new PropertyValueFactory<>("fechaHoraAccion"));

        gridPaneCitaNue.add(tableViewAcciones, 0, 2);
        GridPane.setColumnSpan(tableViewAcciones, Integer.BYTES);
        tableViewAcciones.setItems(obtieneAcciones());
        tableViewAcciones.getColumns().addAll(accionadorColunm, accionColunm, fechaHoraAccionColunm);

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneCitaNue.getChildren().clear();
            gridPaneCitaNue.setBackground(Background.EMPTY);
            gridPaneCitaNue.getChildren().add(barSuper.menuSuperAdmi());

        });//end btn cerrar

        return gridPaneCitaNue;
    }//end GridPane createCatalogue()

    public ObservableList<Acciones> obtieneAcciones() {
        ObservableList<Acciones> reporteMedico = FXCollections.observableArrayList();
        for (int i = 0; i < archSupAdmin.cantidadDeLineas(); i++) {
            reporteMedico.add(archSupAdmin.stringTokenizerHistorial(archSupAdmin.leeArchivo(i)));
        }
        return reporteMedico;
    }

}
