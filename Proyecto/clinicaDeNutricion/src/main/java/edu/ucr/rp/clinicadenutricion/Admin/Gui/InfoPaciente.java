package edu.ucr.rp.clinicadenutricion.Admin.Gui;

// en esta clase los admin tendran acceso a info de  los pacientes

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class InfoPaciente {
    
    
     
    
   // Busqueda busqueda;

  //  File fileURL = new File("jaja.txt");

  //  mantienePaises ma = new mantienePaises("Países.txt");
  //  cuentaBusquedas cB = new cuentaBusquedas("registroBusqueda.txt");


    public BorderPane infoCliente() {

        BorderPane bP_acomodarInterfaz = new BorderPane();
        bP_acomodarInterfaz.setPrefSize(600, 550);

        GridPane gP_buscar = new GridPane();
        gP_buscar.setMinSize(300, 350);
        // determina el espacio entre columnas (vertical y horizontal)
        gP_buscar.setVgap(15);   //espacio
        gP_buscar.setHgap(15);    // espacio
        // alinear el grip
        gP_buscar.setAlignment(Pos.CENTER);
        gP_buscar.setStyle("-fx-background-color: dodgerblue");

        TextField tF_buscar = new TextField();
        tF_buscar.setPromptText("Nombre de cliente");

        tF_buscar.setFocusTraversable(false);
        gP_buscar.add(tF_buscar, 0, 0); /// columna fila

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
        gP_buscar.add(bTN_buscar, 0, 5);
        bTN_buscar.setDisable(false);

        tF_buscar.setOnKeyPressed((event) -> {
            bTN_buscar.setDisable(false);
            // tV_pais.setVisible(false);
        });


        Button bTN_Cerrar = new Button("Cerrar");
        bTN_Cerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        bTN_Cerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        bTN_Cerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gP_buscar.add(bTN_Cerrar, 0, 6);


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
       
        bTN_Cerrar.setOnAction(
                (event) -> {
                    gP_buscar.getChildren().clear();
                    gP_buscar.setBackground(Background.EMPTY);  //limpia color para que quede el color

                 //   tV_pais.setVisible(false);
                  

                });

   
        bP_acomodarInterfaz.setTop(gP_buscar);

    ///    bP_acomodarInterfaz.setBottom(tV_pais);

        return bP_acomodarInterfaz;
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
