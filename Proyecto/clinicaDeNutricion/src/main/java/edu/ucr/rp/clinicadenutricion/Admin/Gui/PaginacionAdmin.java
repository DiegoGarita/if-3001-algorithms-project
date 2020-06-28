package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
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

    public int divisionInt = 0;
    ArrayList<Button> ButtonArrayList;
    Button button;
    TableView<Usuario> tableViewUsuarios;
    public ObservableList<Usuario> reporteMedico = FXCollections.observableArrayList();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();

    public GridPane PaginacionAdmin() {

        GridPane gridPanePaginacionAdmin = new GridPane();
        gridPanePaginacionAdmin.setMinSize(600, 700);
        gridPanePaginacionAdmin.setVgap(15);
        gridPanePaginacionAdmin.setHgap(15);
        gridPanePaginacionAdmin.setAlignment(Pos.CENTER);
        SuperAdmin configuracion = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
        gridPanePaginacionAdmin.setStyle(("-fx-background-image:url('file:src/image/" + configuracion.getNombreLogo() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Button buttonMostrar = new Button("Mostrar");
        buttonMostrar.setTextFill(Color.WHITE);
        buttonMostrar.setStyle("-fx-background-color: BLACK");
        buttonMostrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePaginacionAdmin.add(buttonMostrar, 2, 0);
        buttonMostrar.setOnAction((event) -> {
            tableViewUsuarios.setVisible(true);
            SuperAdmin configuracionActual = logicaSuperAdmin.stringTokenizer(logicaSuperAdmin.readLine("KEYDistancia"));
            logicaSuperAdmin.guardaEnAL("ä");
            divisionInt = logicaSuperAdmin.cantidadDC / Integer.parseInt(configuracionActual.getPaginacion());
            Double divisionDouble = logicaSuperAdmin.cantidadDC / Double.parseDouble(configuracionActual.getPaginacion());
            if (divisionDouble > divisionInt) {
                divisionInt = divisionInt + 1;
            }

            ButtonArrayList = new ArrayList<>();

            for (int i = 0; i < divisionInt; i++) {
                button = new Button();
                button.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20));
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color: rgb(41, 75, 152);");
                button.setText((i + 1) + "");
                ButtonArrayList.add(i, button);
                final int x = Integer.parseInt(ButtonArrayList.get(i).getText()) - 1;

                if (i <= 5) {
                    gridPanePaginacionAdmin.add(ButtonArrayList.get(i), i + 2, 4);
                } else if (i <= 11) {
                    gridPanePaginacionAdmin.add(ButtonArrayList.get(i), i - 4, 5);
                } else if (i <= 17) {
                    gridPanePaginacionAdmin.add(ButtonArrayList.get(i), i - 10, 6);
                }

                ButtonArrayList.get(i).setOnMouseClicked((event1) -> {
                    tableViewUsuarios.getItems().clear();
                    LogicaSuperAdmin newLogicaSuperAdmin = new LogicaSuperAdmin();

                    for (int j = x * Integer.parseInt(configuracionActual.getPaginacion()); j < Integer.parseInt(configuracionActual.getPaginacion()) * (x + 1); j++) {
                        try {
                            reporteMedico.add(newLogicaSuperAdmin.guardaEnAL("ä").get(j));
                        } catch (IndexOutOfBoundsException ide) {

                        }
                    }

                });

            }
            buttonMostrar.setDisable(true);
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
        gridPanePaginacionAdmin.add(tableViewUsuarios, 0, 2);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setTextFill(Color.WHITE);
        buttonCerrar.setStyle("-fx-background-color: BLACK");
        buttonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPanePaginacionAdmin.add(buttonCerrar, 1, 2);
        MainMenuBarAdministrador o = new MainMenuBarAdministrador();
        buttonCerrar.setOnAction((event) -> {

            gridPanePaginacionAdmin.getChildren().clear();
            gridPanePaginacionAdmin.setBackground(Background.EMPTY);
            gridPanePaginacionAdmin.getChildren().add(o.menuAdministrador());

        });

        return gridPanePaginacionAdmin;
    }//end gridPanePaginacionAdmin

}
