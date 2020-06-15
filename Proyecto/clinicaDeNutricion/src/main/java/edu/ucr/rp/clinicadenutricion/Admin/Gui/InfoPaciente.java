package edu.ucr.rp.clinicadenutricion.Admin.Gui;

import edu.ucr.rp.clinicadenutricion.Admin.logic.AdminLogic;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class InfoPaciente {

    TextArea textAreaNotas = new TextArea();
    AdminLogic adminLogic = new AdminLogic();
    ComboBox comboBoxTool = new ComboBox();

    public GridPane infoCliente() {

        GridPane gridPaneInfo = new GridPane();
        gridPaneInfo.setMinSize(600, 700);
        gridPaneInfo.setVgap(15);   //espacio
        gridPaneInfo.setHgap(15);    // espacio
        gridPaneInfo.setAlignment(Pos.CENTER);
        gridPaneInfo.setStyle("-fx-background-color: dodgerblue");

        comboBoxTool.setValue("Clientes");
        comboBoxTool.setStyle("-fx-background-color: lightblue");
        gridPaneInfo.add(comboBoxTool, 0, 0);

        for (int i = 0; i < adminLogic.CantidadDeClientes("ä"); i++) {
            comboBoxTool.getItems().addAll(adminLogic.clientesAL.get(i).getId());
        }

        GridPane.setColumnSpan(textAreaNotas, Integer.BYTES);
        textAreaNotas.setVisible(false);
        textAreaNotas.setMinSize(650, 75);
        gridPaneInfo.add(textAreaNotas, 0, 5);

        Button bTN_buscar = new Button("Buscar");
        bTN_buscar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_buscar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_buscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneInfo.add(bTN_buscar, 1, 0);
        bTN_buscar.setDisable(false);

        bTN_buscar.setOnAction((event) -> {
            textAreaNotas.setText(adminLogic.readInFile(comboBoxTool.getValue().toString()));
            textAreaNotas.setVisible(true);

        });// end boton

        Button bTN_Cerrar = new Button("Cerrar");
        bTN_Cerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_Cerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_Cerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneInfo.add(bTN_Cerrar, 2, 0);

        MainMenuBarAdmi o = new MainMenuBarAdmi();

        bTN_Cerrar.setOnAction((event) -> {
            gridPaneInfo.getChildren().clear();
            gridPaneInfo.setBackground(Background.EMPTY);
            gridPaneInfo.getChildren().add(o.menuAdmi());

        });

        return gridPaneInfo;
    }

}
