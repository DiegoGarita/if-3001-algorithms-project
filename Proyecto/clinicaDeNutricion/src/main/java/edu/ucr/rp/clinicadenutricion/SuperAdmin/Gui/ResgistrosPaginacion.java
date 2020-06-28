package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
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

public class ResgistrosPaginacion {

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

        gridPanePagi.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();
        SuperAdmin configuracion = archSupAdmin.stringTokenizer(archSupAdmin.readLine("KEYDistancia"));

        textFieldContraseña = new TextField();
        textFieldContraseña.setPromptText("Contraseña");
        textFieldContraseña.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPanePagi.add(textFieldContraseña, 0, 0);
        textFieldContraseña.setFocusTraversable(false);
        textFieldContraseña.setOnKeyPressed((event) -> {
            buttonModificar.setDisable(false);
        });

        Usuario usuarioTemp = logic.stringTokenizer(logic.leeLinea("ë"));

        buttonModificar = new Button("Modificar valores");
        buttonModificar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModificar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePagi.add(buttonModificar, 1, 0);
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

        });//end setOnAction

        labelInter = new Label();
        labelInter.setText("Cantidad de usuarios por página");
        gridPanePagi.add(labelInter, 0, 1);
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
        gridPanePagi.add(textFieldIntervalo, 1, 1);
        textFieldIntervalo.setFocusTraversable(false);
        textFieldIntervalo.setOnKeyPressed((event) -> {
            botonModificar.setDisable(false);
        });

        botonModificar = new Button("Modificar");
        botonModificar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonModificar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonModificar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        botonModificar.setVisible(false);
        botonModificar.setDisable(true);
        gridPanePagi.add(botonModificar, 2, 1);
        GridPane.setColumnSpan(botonModificar, Integer.BYTES);
        botonModificar.setOnAction((event) -> {

            SuperAdmin configuracion2 = new SuperAdmin(configuracion.getIdentificadorSA(), configuracion.getAbreClinica(),
                    configuracion.getCierreClinica(), textFieldIntervalo.getText(),
                    configuracion.getNombreLogo(),
                    configuracion.getPathDeGuardado(), textFieldIntervalo.getText());

            archSupAdmin.replacefromfile(configuracion2);

            labelInter.setVisible(false);
            botonModificar.setDisable(true);
            textFieldIntervalo.setDisable(true);

        });

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

        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePagi.add(botonCerrar, 1, 2);
        GridPane.setColumnSpan(botonCerrar, Integer.BYTES);
        botonCerrar.setOnAction((event) -> {

            gridPanePagi.getChildren().clear();
            gridPanePagi.setBackground(Background.EMPTY);
            gridPanePagi.getChildren().add(barSuper.menuSuperAdmi());

        });//end btn cerrar

        return gridPanePagi;
    }//end GridPane createCatalogue()

}
