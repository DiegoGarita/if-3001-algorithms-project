package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.MainMenuBarSuperAdmi;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
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
    ArrayList<Button> ButtonAL;
    Label labelInter;
    Button button;
    Button botonModificar;
    Button buttonModificar;
    TextField textFieldContraseña;
    TextField textFieldIntervalo;
    LogicaListas logic = new LogicaListas();

    public GridPane historial() {

        GridPane gridPanePagi = new GridPane();
        gridPanePagi.setMinSize(600, 700);
        gridPanePagi.setVgap(15);
        gridPanePagi.setHgap(15);
        gridPanePagi.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = archSupAdmin.stringTokenizer(archSupAdmin.readLine("KEYDistancia"));
        gridPanePagi.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();

        Button botonBuscar = new Button("Mostrar");
        botonBuscar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonBuscar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonBuscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePagi.add(botonBuscar, 2, 0);
        botonBuscar.setOnAction((event) -> {
            tableViewUsuarios.setVisible(true);
            SuperAdmin configuracionActual = archSupAdmin.stringTokenizer(archSupAdmin.readLine("KEYDistancia"));
            archSupAdmin.guardaEnAL("ä");
            divisionInt = archSupAdmin.cantidadDC / Integer.parseInt(configuracionActual.getPaginacion());
            Double divisionDouble = archSupAdmin.cantidadDC / Double.parseDouble(configuracionActual.getPaginacion());
            if (divisionDouble > divisionInt) {
                divisionInt = divisionInt + 1;
            }

            ButtonAL = new ArrayList<>();

            for (int i = 0; i < divisionInt; i++) {
                button = new Button();
                button.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: rgb(41, 75, 152);");
                button.setText((i + 1) + "");
                ButtonAL.add(i, button);
                final int x = Integer.parseInt(ButtonAL.get(i).getText()) - 1;

                if (i <= 5) {
                    gridPanePagi.add(ButtonAL.get(i), i + 2, 4);       //1,   4 -->fila

                } else if (i <= 11) {
                    gridPanePagi.add(ButtonAL.get(i), i - 4, 5);        //5 -->fila

                } else if (i <= 17) {
                    gridPanePagi.add(ButtonAL.get(i), i - 10, 6);         //6 -->fila

                }

                ButtonAL.get(i).setOnMouseClicked((event1) -> {
                    tableViewUsuarios.getItems().clear();
                    ArchSupAdmin a = new ArchSupAdmin();

                    for (int j = x * Integer.parseInt(configuracionActual.getPaginacion()); j < Integer.parseInt(configuracionActual.getPaginacion()) * (x + 1); j++) {
                        try {
                            reporteMedico.add(a.guardaEnAL("ä").get(j));
                        } catch (IndexOutOfBoundsException ide) {

                        }
                    }

                });

            }//for
            botonBuscar.setDisable(true);
        });

        tableViewUsuarios = new TableView<>();
        tableViewUsuarios.setVisible(false);

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

        tableViewUsuarios.setItems(reporteMedico);
        tableViewUsuarios.getColumns().addAll(idColunm, nameColunm, correoColunm);
        tableViewUsuarios.setMinSize(300, 200);
        gridPanePagi.add(tableViewUsuarios, 0, 2);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePagi.add(buttonCerrar, 1, 2);
        MainMenuBarAdministrador o = new MainMenuBarAdministrador();
        buttonCerrar.setOnAction((event) -> {

            gridPanePagi.getChildren().clear();
            gridPanePagi.setBackground(Background.EMPTY);
            gridPanePagi.getChildren().add(o.menuAdministrador());

        });//end btn cerrar

        return gridPanePagi;
    }//end GridPane createCatalogue()

}
