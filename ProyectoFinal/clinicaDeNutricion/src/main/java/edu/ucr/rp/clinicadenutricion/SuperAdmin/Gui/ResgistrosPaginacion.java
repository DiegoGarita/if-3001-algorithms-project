package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
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

public class ResgistrosPaginacion {

    public int divisionInt = 0;
    public ObservableList<Usuario> reporteMedico = FXCollections.observableArrayList();
    ArrayList<Button> ButtonArrayList;
    Label labelInter;
    Button button;
    Button botonModificar;
    Button buttonModificar;
    TextField textFieldContraseña;
    TextField textFieldIntervalo;
    TableView<Usuario> tableViewUsuarios;

    LogicaSuperAdmin LogicaSuperAdmin = new LogicaSuperAdmin();
    LogicaListas logic = new LogicaListas();

    public GridPane registrosPaginacion() {

        GridPane gridPaneRegistrosPaginacion = new GridPane();
        gridPaneRegistrosPaginacion.setMinSize(600, 700);
        gridPaneRegistrosPaginacion.setVgap(15);
        gridPaneRegistrosPaginacion.setHgap(15);
        gridPaneRegistrosPaginacion.setAlignment(Pos.CENTER);

        gridPaneRegistrosPaginacion.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();
        SuperAdmin configuracion = LogicaSuperAdmin.stringTokenizer(LogicaSuperAdmin.readLine("KEYDistancia"));

        textFieldContraseña = new TextField();
        textFieldContraseña.setPromptText("Contraseña");
        textFieldContraseña.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneRegistrosPaginacion.add(textFieldContraseña, 0, 0);
        textFieldContraseña.setFocusTraversable(false);
        textFieldContraseña.setOnKeyPressed((event) -> {
            buttonModificar.setDisable(false);
        });

        Usuario usuarioTemp = logic.stringTokenizer(logic.leeLinea("ë"));

        buttonModificar = new Button("Modificar valores");
        buttonModificar.setTextFill(Color.WHITE);
        buttonModificar.setStyle("-fx-background-color: BLACK");
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneRegistrosPaginacion.add(buttonModificar, 1, 0);
        GridPane.setColumnSpan(buttonModificar, Integer.BYTES);
        buttonModificar.setDisable(true);
        buttonModificar.setOnAction((event) -> {

            if (textFieldContraseña.getText().equals(usuarioTemp.getName())) {
                labelInter.setVisible(true);
                textFieldIntervalo.setVisible(true);
                botonModificar.setVisible(true);
                buttonModificar.setDisable(true);
            }
            textFieldContraseña.setDisable(true);

        });

        labelInter = new Label();
        labelInter.setText("Cantidad de usuarios por página");
        gridPaneRegistrosPaginacion.add(labelInter, 0, 1);
        labelInter.setFont(new Font("Arial", 15));
        labelInter.setTextFill(Color.web("#0076a3"));
        labelInter.setVisible(false);
        labelInter.setStyle("-fx-font-weight: bold");
        labelInter.setStyle("-fx-background-color: rgb(111, 210, 170);");

        textFieldIntervalo = new TextField();
        textFieldIntervalo.setPromptText("Cantidad a mostrar");
        textFieldIntervalo.setVisible(false);
        textFieldIntervalo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneRegistrosPaginacion.add(textFieldIntervalo, 1, 1);
        textFieldIntervalo.setFocusTraversable(false);
        textFieldIntervalo.setOnKeyPressed((event) -> {
            botonModificar.setDisable(false);
        });

        botonModificar = new Button("Modificar");
        botonModificar.setTextFill(Color.WHITE);
        botonModificar.setStyle("-fx-background-color: BLACK");
        botonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        botonModificar.setVisible(false);
        botonModificar.setDisable(true);
        gridPaneRegistrosPaginacion.add(botonModificar, 2, 1);
        GridPane.setColumnSpan(botonModificar, Integer.BYTES);
        botonModificar.setOnAction((event) -> {

            SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), configuracion.getAbreClinica(),
                    configuracion.getCierreClinica(), textFieldIntervalo.getText(),
                    configuracion.getNombreLogo(),
                    configuracion.getPathDeGuardado(), textFieldIntervalo.getText());

            LogicaSuperAdmin.replacefromfile(configuracion2);

            labelInter.setVisible(false);
            botonModificar.setDisable(true);
            textFieldIntervalo.setDisable(true);

        });

        Button botonBuscar = new Button("Mostrar");
        botonBuscar.setTextFill(Color.WHITE);
        botonBuscar.setStyle("-fx-background-color: BLACK");
        botonBuscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneRegistrosPaginacion.add(botonBuscar, 2, 0);
        botonBuscar.setOnAction((event) -> {
            tableViewUsuarios.setVisible(true);
            SuperAdmin configuracionActual = LogicaSuperAdmin.stringTokenizer(LogicaSuperAdmin.readLine("KEYDistancia"));
            LogicaSuperAdmin.guardaEnAL("ä");
            divisionInt = LogicaSuperAdmin.cantidadDC / Integer.parseInt(configuracionActual.getPaginacion());
            Double divisionDouble = LogicaSuperAdmin.cantidadDC / Double.parseDouble(configuracionActual.getPaginacion());
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
                    gridPaneRegistrosPaginacion.add(ButtonArrayList.get(i), i + 2, 4);
                } else if (i <= 11) {
                    gridPaneRegistrosPaginacion.add(ButtonArrayList.get(i), i - 4, 5);
                } else if (i <= 17) {
                    gridPaneRegistrosPaginacion.add(ButtonArrayList.get(i), i - 10, 6);
                }

                ButtonArrayList.get(i).setOnMouseClicked((event1) -> {
                    tableViewUsuarios.getItems().clear();
                    LogicaSuperAdmin a = new LogicaSuperAdmin();
                    for (int j = x * Integer.parseInt(configuracionActual.getPaginacion()); j < Integer.parseInt(configuracionActual.getPaginacion()) * (x + 1); j++) {
                        try {
                            reporteMedico.add(a.guardaEnAL("ä").get(j));
                        } catch (IndexOutOfBoundsException ioobe) {

                        }
                    }

                });

            }
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
        gridPaneRegistrosPaginacion.add(tableViewUsuarios, 0, 2);

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);
        botonCerrar.setStyle("-fx-background-color: BLACK");
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));
        gridPaneRegistrosPaginacion.add(botonCerrar, 1, 2);
        GridPane.setColumnSpan(botonCerrar, Integer.BYTES);
        botonCerrar.setOnAction((event) -> {

            gridPaneRegistrosPaginacion.getChildren().clear();
            gridPaneRegistrosPaginacion.setBackground(Background.EMPTY);
            gridPaneRegistrosPaginacion.getChildren().add(barSuper.menuSuperAdmi());

        });

        return gridPaneRegistrosPaginacion;
    }//end gridPaneRegistrosPaginacion()

}
