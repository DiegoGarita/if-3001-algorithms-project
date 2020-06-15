package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

//clase para que el cliente modifique o cancel su cita
import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.ClienteLogic;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.HoraFecha;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class ModificaCancelaCita {

    
    TextField textFieldNombreUsu;
    Button buttonDesplegar;
    Button buttonModiCita;
    Button buttonCanceCita;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboHora = new ComboBox();
    String modiCita = "Modifico cita";
    String cancelCita = "Cancelo cita";
    AVLArchivo histo = new AVLArchivo();
    HoraFecha horaFecha = new HoraFecha();

    Logic l = new Logic();
    Entrar en;
    LogoApp logo = new LogoApp();
    ClienteLogic archivoPila = new ClienteLogic();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane modiCancel() {
        /// File file = new File(fileName);
        GridPane gridPaneModiCan = new GridPane();
        gridPaneModiCan.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPaneModiCan.setVgap(15);   //espacio
        gridPaneModiCan.setHgap(15);    // espacio
        // alinear el grip
        gridPaneModiCan.setAlignment(Pos.CENTER);
        Usuario supAdmConfi = l.stringTokenizer(l.readLine("ë"));

        gridPaneModiCan.setStyle(("-fx-background-image:url('file:src/image/" + supAdmConfi.getContraseña() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario uwu = l.stringTokenizer(l.readLine(en.ID));
        String tipo = "";
        if (uwu.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (uwu.getTipo().equals("ö")) {
            tipo = "Administración";
        }
////////        
        Cita citaTrae = archivoPila.stringTokenizer(archivoPila.readLine(""));

        gridPaneModiCan.add(new Label("Fecha de cita"), 0, 2);
        DatePicker dT_DateFligth = new DatePicker(LocalDate.now());
        dT_DateFligth.setEditable(false);
        gridPaneModiCan.add(dT_DateFligth, 1, 2);

        //-->  abre      cierra      intervalo
        for (int i = Integer.parseInt(supAdmConfi.getCorreo()); i < Integer.parseInt(supAdmConfi.getTelefono()); i = i + Integer.parseInt(supAdmConfi.getDireccion())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
            // que vengan desde superAdmin -->> Consultas cada hora
            comboHora.getItems().addAll(i + ":00");
        }
        gridPaneModiCan.add(comboHora, 0, 3);
        
        TextField g = new TextField();
        gridPaneModiCan.add(g, 3, 3);

        buttonModiCita = new Button("Modificar");
        buttonModiCita.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiCita.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonModiCita, 1, 5);
        buttonModiCita.setOnAction((event) -> {

            Cita cita = archivoPila.stringTokenizer(archivoPila.readLine(g.getText()));
            Cita citaAux = new Cita(g.getText(), citaTrae.getNombre(),
                    dT_DateFligth.getValue().toString(), comboHora.getValue().toString(), cita.getDoctora());

            archivoPila.readApartaCita();
            ///logic.modified(usuario, textFieldAbre.getText());
            //logic.modifiedSuperHoras(usuario, textFieldAbre.getText(), textFieldCierra.getText(), textFieldIntervalo.getText());
            archivoPila.removeLineFromFile(cita.getIdCita());
            archivoPila.writeFileApartaCita(citaAux);

            Acciones acc = new Acciones(uwu.getName(), modiCita, horaFecha.histoFechaHora());
            histo.writeFileCitas(acc);

        });//end setOnAction

        buttonCanceCita = new Button("Cancelar cita");
        buttonCanceCita.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonCanceCita.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonCanceCita.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonCanceCita, 2, 5);
        buttonCanceCita.setOnAction((event) -> {

            // Usuario usuario = archivoPila.stringTokenizer(archivoPila.readLine(textFieldID.getText()));
            Cita cita = archivoPila.stringTokenizer(archivoPila.readLine(g.getText()));
            archivoPila.readApartaCita();   // ------------>>> Linea cerda del problema -805306369
            archivoPila.delete(cita);
            archivoPila.removeLineFromFile(cita.getIdCita()); //----->> Linea que me duplica

            Acciones acc = new Acciones(uwu.getName(), cancelCita, horaFecha.histoFechaHora());
            histo.writeFileCitas(acc);

            System.out.println("Hola me precionaste");

        });//end setOnAction

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneModiCan.add(buttonClose, 0, 8);
        buttonClose.setOnAction((event) -> {

            gridPaneModiCan.getChildren().clear();
            gridPaneModiCan.setBackground(Background.EMPTY);
            gridPaneModiCan.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPaneModiCan;
    }//end GridPane createCatalogue()
}
