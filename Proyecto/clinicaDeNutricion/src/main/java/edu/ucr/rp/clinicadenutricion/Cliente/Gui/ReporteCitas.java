package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

// clase para poder visualizar las citas del cliente
import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.ClienteLogic;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.HoraFecha;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ReporteCitas {

    String repoCita = "Vio su reporte de citas";
    AVLArchivo histo = new AVLArchivo();
    HoraFecha horaFecha = new HoraFecha();
    ClienteLogic clienteLogic = new ClienteLogic();

    Logic l = new Logic();
    Entrar en;
    LogoApp logo = new LogoApp();

    //ClienteLogic ma = new ClienteLogic("Países.txt");
    public GridPane reporteCita() {

        //   BorderPane bP_acomodarInterfaz = new BorderPane();
        //   bP_acomodarInterfaz.setPrefSize(600, 550);
        GridPane gridPanehisto = new GridPane();
        gridPanehisto.setMinSize(300, 350);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanehisto.setVgap(15);   //espacio
        gridPanehisto.setHgap(15);    // espacio
        // alinear el grip
        gridPanehisto.setAlignment(Pos.CENTER);
        gridPanehisto.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario uwu = l.stringTokenizer(l.readLine(en.ID));
        String tipo = "";
        if (uwu.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (uwu.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        // TextArea t = new TextArea();
        //// String sal = clienteLogic.readApartaCita();
        /// System.out.println("sal--->" + sal);
        // t.setText(sal);
        // gridPanehisto.add(t, 0, 4);
        TableView<Cita> tV_pais = new TableView<>();

        TableColumn tc_continenteColumna = new TableColumn("Cliente");
        tc_continenteColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_continenteColumna.setCellValueFactory(new PropertyValueFactory<>("Nombre"));

        TableColumn tc_capitalColumna = new TableColumn("Fecha");
        tc_capitalColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_capitalColumna.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        TableColumn tc_poblacionColumna = new TableColumn("Hora");
        tc_poblacionColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_poblacionColumna.setCellValueFactory(new PropertyValueFactory<>("hora"));

        TableColumn tc_monedaColumna = new TableColumn("Doc");
        tc_monedaColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_monedaColumna.setCellValueFactory(new PropertyValueFactory<>("doctora"));

        tV_pais.getColumns().addAll(tc_continenteColumna,
                tc_capitalColumna, tc_poblacionColumna, tc_monedaColumna);
        tV_pais.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //tV_pais.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        //    tV_pais.getItems().addAll(clienteLogic.readApartaCita());

        Acciones acc = new Acciones(uwu.getName(), repoCita, horaFecha.histoFechaHora());
        histo.writeFileCitas(acc);

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***
        Button bTN_Cerrar = new Button("Cerrar");
        bTN_Cerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_Cerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_Cerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanehisto.add(bTN_Cerrar, 0, 6);
        bTN_Cerrar.setOnAction((event) -> {
            gridPanehisto.getChildren().clear();
            gridPanehisto.setBackground(Background.EMPTY);
            gridPanehisto.getChildren().add(barCliente.menuCliente());
        });

        clienteLogic.readApartaCita();
        //bP_acomodarInterfaz.setTop(gridPanehisto);
        gridPanehisto.add(tV_pais, 0, 4);
        return gridPanehisto;

    }//end class reporte citas

//    public ObservableList<Cita> getListaPaises() {
//        ArrayList array = new ArrayList();
//        Cita arrayPaises[] = clienteLogic.readApartaCita();
//        for (int j = 0; j < arrayPaises.length; j++) {
//            array.add(arrayPaises[j]);
//        }
//
//        ObservableList<Cita> oL_ListadoContactos = FXCollections.observableArrayList(array);
//
//        return oL_ListadoContactos;
//    }
}
