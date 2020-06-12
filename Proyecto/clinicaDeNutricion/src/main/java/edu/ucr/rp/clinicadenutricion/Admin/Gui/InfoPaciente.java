package edu.ucr.rp.clinicadenutricion.Admin.Gui;

// en esta clase los admin tendran acceso a info de  los pacientes
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class InfoPaciente {

    // Busqueda busqueda;
    //  File fileURL = new File("jaja.txt");
    //  mantienePaises ma = new mantienePaises("Países.txt");
    //  cuentaBusquedas cB = new cuentaBusquedas("registroBusqueda.txt");
        LogoApp logo = new LogoApp();
    public GridPane infoCliente() {

//        BorderPane bP_acomodarInterfaz = new BorderPane();
//        bP_acomodarInterfaz.setPrefSize(600, 550);
        GridPane gridPaneInfo = new GridPane();
        gridPaneInfo.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPaneInfo.setVgap(15);   //espacio
        gridPaneInfo.setHgap(15);    // espacio
        // alinear el grip
        gridPaneInfo.setAlignment(Pos.CENTER);
        gridPaneInfo.setStyle(("-fx-background-image:url('file:src/image/"+logo.NombreLogo+".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        TextField tF_buscar = new TextField();
        tF_buscar.setPromptText("Nombre de cliente");

        tF_buscar.setFocusTraversable(false);
        gridPaneInfo.add(tF_buscar, 0, 0); /// columna fila

        TableView<String> tV_pais = new TableView<>();

        TableColumn tc_continenteColumna = new TableColumn("Continente");
        tc_continenteColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_continenteColumna.setCellValueFactory(new PropertyValueFactory("continent"));

        TableColumn tc_capitalColumna = new TableColumn("Capital");
        tc_capitalColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_capitalColumna.setCellValueFactory(new PropertyValueFactory("capital"));

        TableColumn tc_poblacionColumna = new TableColumn("Población");
        tc_poblacionColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_poblacionColumna.setCellValueFactory(new PropertyValueFactory("population"));

        TableColumn tc_monedaColumna = new TableColumn("Moneda");
        tc_monedaColumna.setStyle("-fx-background-color: lightsteelblue;");
        tc_monedaColumna.setCellValueFactory(new PropertyValueFactory("currency"));

        tV_pais.getColumns().addAll(tc_continenteColumna,
                tc_capitalColumna, tc_poblacionColumna, tc_monedaColumna);
        tV_pais.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //tV_pais.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        Button bTN_buscar = new Button("Buscar");
        bTN_buscar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_buscar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_buscar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneInfo.add(bTN_buscar, 0, 5);
        bTN_buscar.setDisable(false);

        Button bTN_Cerrar = new Button("Cerrar");
        bTN_Cerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_Cerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_Cerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneInfo.add(bTN_Cerrar, 0, 6);

        bTN_buscar.setOnAction((event) -> {

//            bTN_buscar.setDisable(true);
//            bTN_apagar.setDisable(false);
//
//            String nombreInsertado = tF_buscar.getText();
//
//            aclaracion.setText("No hay registro guardado del país: " + nombreInsertado + " \n "
//                    + "Pero nuestra base de datos cuenta con el himno y la bandera del mismo.");
//
//            if (ma.encontrado(nombreInsertado) == false) {
//
//                aclaracion.setVisible(true);
//
//                try {
//                    iV.setFitHeight(45);
//                    iV.setFitWidth(90);
//                    iV.setImage(new Image("/flags/" + nombreInsertado + ".gif"));//pone la imagen de la bandera
//                    iV.setVisible(true);
//                } catch (IllegalArgumentException iae) {
//                    aclaracion.setText("Ingrese un pais que sea real");
//                }
//
//
//                ObservableList<Country> datos = getListaContactos(nombreInsertado);
//                tV_pais.setItems(datos);//Trae los datos
//
//            } else {
//
//                // tV_pais.setVisible(true);
//                aclaracion.setVisible(false);
//
//                iV.setFitHeight(45);
//                iV.setFitWidth(90);
//                iV.setImage(new Image("/flags/" + nombreInsertado + ".gif"));//pone la imagen de la bandera
//                iV.setVisible(true);
//
//                bTN_apagar.setDisable(false);
//                bTN_buscar.setDisable(true);
//
//                tF_buscar.clear();//limpia
//
//                ObservableList<Country> datos = getListaContactos(nombreInsertado);
//                tV_pais.setItems(datos);//Trae los datos
//
//                //  Busqueda busqueda;
////                Busqueda busquedas[] = new Busqueda[cB.cuentaRegistroPaises()];
////                for (int i = 0; i < busquedas.length; i++) {
////
//                Busqueda nomExis[] = cB.getPaisesArchivo();
//
//                busqueda = new Busqueda(nombreInsertado, contador1 + "");
//                cB.insertarPais(busqueda);
//
//                for (int i = 0; i < nomExis.length; i++) {
//
//                    //if (nomExis[i].getNombreBuscado().equalsIgnoreCase(nomExis[0].getNombreBuscado())) {
//                    if (nomExis[i].getNombreBuscado().equalsIgnoreCase(nombreInsertado)) {
//                        // if (cB.encontradoBusq(nombreInsertado) == true) {
//                        contador2 = contador1++;
//                        busqueda = new Busqueda(nomExis[i].getNombreBuscado(), contador2 + "");// i debe ser otra cosa
//                       
//                        nomExis[i] = busqueda;// i debe ser manejado por otra variable
//                        cB.insertarPaisModificado(nomExis);
//
//                    }//end if                    
//                }//end for
//
//                //el problema radica en reiniciar los contadores asi que hay que biscar una forma
//                //ademas de eso, hay que ver como traer de nuevio al mism nombre 
//                //para que no lo guarde como uno nuevo
//                String path = urlMusic + nombreInsertado + ".mp3";
//                Media media = new Media(new File(path).toURI().toString());
//                mediaPlayer = new MediaPlayer(media);
//                MediaView mediaView = new MediaView(mediaPlayer);
//                mediaPlayer.setMute(false);
//                mediaPlayer.setAutoPlay(true);
//
//            }//end else
//
        });// end boton

        //***
        MainMenuBarAdmi o = new MainMenuBarAdmi();
        //***

        bTN_Cerrar.setOnAction(
                (event) -> {
                    gridPaneInfo.getChildren().clear();
                    gridPaneInfo.setBackground(Background.EMPTY);  //limpia color para que quede el color
                    gridPaneInfo.getChildren().add(o.menuAdmi());

                });

        /// bP_acomodarInterfaz.setTop(gridPaneInfo);
        ///    bP_acomodarInterfaz.setBottom(tV_pais);
        return gridPaneInfo;
    }

//*************************************************************************\\
//    public ObservableList<Country> getListaContactos(String nombreInsertado) {
//
//        ArrayList array = new ArrayList();
//
//        Country arrayContactos[] = ma.getPaisesArchivo();
//
//        for (int j = 0; j < arrayContactos.length; j++) {
//            if (nombreInsertado.equalsIgnoreCase(arrayContactos[j].getNameCountry())) {
//                array.add(arrayContactos[j]);
//            }
//        }
//
//        ObservableList<Country> oL_ListadoContactos = FXCollections.observableArrayList(array);
//
//        return oL_ListadoContactos;
//    }
}
