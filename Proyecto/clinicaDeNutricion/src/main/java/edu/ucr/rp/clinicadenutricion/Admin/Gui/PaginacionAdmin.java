package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.MainMenuBarSuperAdmi;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PaginacionAdmin {

    ArchSupAdmin archSupAdmin = new ArchSupAdmin();
    TableView<Usuario> tableViewUsuarios;
    public int divisionInt = 0;
    public ObservableList<Usuario> reporteMedico = FXCollections.observableArrayList();

    public GridPane historial() {
        
        SuperAdmin configuracion = archSupAdmin.stringTokenizer(archSupAdmin.readLine("KEYDistancia"));

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);

        gridPaneCitaNue.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));


        Button botonBuscar = new Button("Mostrar");
        botonBuscar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonBuscar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonBuscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonBuscar, 1, 1);

        botonBuscar.setOnAction((event) -> {

            archSupAdmin.guardaEnAL("ä");
            divisionInt = archSupAdmin.cantidadDC / Integer.parseInt(configuracion.getPaginacion());
            Double divisionDouble = archSupAdmin.cantidadDC / Double.parseDouble(configuracion.getPaginacion());
            if (divisionDouble > divisionInt) {
                divisionInt = divisionInt + 1;
            }

            ArrayList<Button> ButtonAL;

            ButtonAL = new ArrayList<>();
            for (int i = 0; i < divisionInt; i++) {
                Button button = new Button();
                button.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: rgb(41, 75, 152);");
                button.setText((i + 1) + "");

                ButtonAL.add(i, button);
                final int x = Integer.parseInt(ButtonAL.get(i).getText()) - 1;

                if (i <= 6) {
                    gridPaneCitaNue.add(ButtonAL.get(i), i + 1, 4);
                } else if (i <= 12) {
                    gridPaneCitaNue.add(ButtonAL.get(i), i - 6, 5);
                } else if (i <= 18) {
                    gridPaneCitaNue.add(ButtonAL.get(i), i - 12, 6);
                } else if (i <= 24) {
                    gridPaneCitaNue.add(ButtonAL.get(i), i - 18, 7);
                }

                ButtonAL.get(i).setOnMouseClicked((event1) -> {
                    tableViewUsuarios.getItems().clear();

                    ArchSupAdmin a = new ArchSupAdmin();

                    for (int j = x * Integer.parseInt(configuracion.getPaginacion()); j < Integer.parseInt(configuracion.getPaginacion()) * (x + 1); j++) {
                        try {
                            reporteMedico.add(a.guardaEnAL("ä").get(j));
                        } catch (IndexOutOfBoundsException ide) {

                        }
                    }

                });

            }//for

        });

        tableViewUsuarios = new TableView<>();

        TableColumn<Usuario, String> idColunm = new TableColumn<>("id");
        idColunm.setMaxWidth(200);
        idColunm.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<Usuario, String> nameColunm = new TableColumn<>("name");
        nameColunm.setMaxWidth(200);
        nameColunm.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColunm.setStyle("-fx-alignment: CENTER;");

        TableColumn<Usuario, String> correoColunm = new TableColumn<>("correo");
        correoColunm.setMaxWidth(200);
        correoColunm.setCellValueFactory(new PropertyValueFactory<>("correo"));
        correoColunm.setStyle("-fx-alignment: CENTER;");

        GridPane.setColumnSpan(tableViewUsuarios, Integer.BYTES);
        tableViewUsuarios.setItems(reporteMedico);
        tableViewUsuarios.getColumns().addAll(idColunm, nameColunm, correoColunm);
        tableViewUsuarios.setMinSize(500, 400);
        gridPaneCitaNue.add(tableViewUsuarios, 1, 2);
        
         MainMenuBarAdministrador o = new MainMenuBarAdministrador();

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

        gridPaneCitaNue.getChildren().clear();
            gridPaneCitaNue.setBackground(Background.EMPTY);
            gridPaneCitaNue.getChildren().add(o.menuAdministrador());

        });//end btn cerrar

        return gridPaneCitaNue;
    }//end GridPane createCatalogue()

}
