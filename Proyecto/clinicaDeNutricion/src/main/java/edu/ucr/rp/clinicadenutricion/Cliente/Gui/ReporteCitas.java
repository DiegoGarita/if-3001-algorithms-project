package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

// clase para poder visualizar las citas del cliente
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReporteCitas {

    //ClienteLogic ma = new ClienteLogic("Países.txt");
    public BorderPane busquedaPais() {

        BorderPane bP_acomodarInterfaz = new BorderPane();
        bP_acomodarInterfaz.setPrefSize(600, 550);

        GridPane gridPanehisto = new GridPane();
        gridPanehisto.setMinSize(300, 350);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanehisto.setVgap(15);   //espacio
        gridPanehisto.setHgap(15);    // espacio
        // alinear el grip
        gridPanehisto.setAlignment(Pos.CENTER);
        gridPanehisto.setStyle("-fx-background-color: dodgerblue");

        TableView<Cita> tV_pais = new TableView<>();

        TableColumn tc_continenteColumna = new TableColumn("Cliente");
        tc_continenteColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_continenteColumna.setCellValueFactory(new PropertyValueFactory("Nombre"));

        TableColumn tc_capitalColumna = new TableColumn("Fecha");
        tc_capitalColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_capitalColumna.setCellValueFactory(new PropertyValueFactory("fecha"));

        TableColumn tc_poblacionColumna = new TableColumn("Hora");
        tc_poblacionColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_poblacionColumna.setCellValueFactory(new PropertyValueFactory("hora"));

        TableColumn tc_monedaColumna = new TableColumn("Doctora");
        tc_monedaColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_monedaColumna.setCellValueFactory(new PropertyValueFactory("doctora"));

        tV_pais.getColumns().addAll(tc_continenteColumna,
                tc_capitalColumna, tc_poblacionColumna, tc_monedaColumna);
        tV_pais.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //tV_pais.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***
        Button bTN_Cerrar = new Button("Cerrar");
        bTN_Cerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_Cerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_Cerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanehisto.add(bTN_Cerrar, 0, 6);
        bTN_Cerrar.setOnAction((event) -> {
            bP_acomodarInterfaz.getChildren().clear();
            bP_acomodarInterfaz.setBackground(Background.EMPTY);
            bP_acomodarInterfaz.getChildren().add(barCliente.menuCliente());
        });

        bP_acomodarInterfaz.setTop(gridPanehisto);
        bP_acomodarInterfaz.setBottom(tV_pais);
        return bP_acomodarInterfaz;
    }

}//end class reporte citas
