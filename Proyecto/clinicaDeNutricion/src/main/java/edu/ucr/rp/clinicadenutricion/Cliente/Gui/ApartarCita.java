package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

// clase para que el cliente aparte una cita
import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.ClienteLogic;
import edu.ucr.rp.clinicadenutricion.Cliente.Logic.PilaImplementacion;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.HorarioTiempoClinica;
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

public class ApartarCita {

    TextField textFieldidDeReservacion;
    TextField textFieldDoctora;
    TextField textFieldHora;
    Button botonGuardar;
    String agendo = "Agendo cita";
    ComboBox comboHora = new ComboBox();
    ClienteLogic clienteLogic = new ClienteLogic();
    AVLArchivo histo = new AVLArchivo();
    HoraFecha horaFecha = new HoraFecha();
    HorarioTiempoClinica ajustahorarios = new HorarioTiempoClinica();

    Logic l = new Logic();
    Entrar en;
    LogoApp logo = new LogoApp();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane reservar() {

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);

        Usuario supAdmConfi = l.stringTokenizer(l.readLine("ë"));
        comboHora.setValue("Hora de cita");

        gridPaneCitaNue.setStyle(("-fx-background-image:url('file:src/image/" + supAdmConfi.getContraseña() + "');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        textFieldidDeReservacion = new TextField();
        textFieldidDeReservacion.setPromptText("ID reservacion");
        textFieldidDeReservacion.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldidDeReservacion, 0, 1); /// columna fila
        textFieldidDeReservacion.setFocusTraversable(false);

        // Label labelFechHora = new Label("Hacer algo con Hora y fecha");
        //  gridPaneNewCatalogue.add(labelFechHora, 0, 2);
        gridPaneCitaNue.add(new Label("Fecha de cita"), 0, 2);
        DatePicker dT_DateFligth = new DatePicker(LocalDate.now());
        dT_DateFligth.setEditable(false);
        gridPaneCitaNue.add(dT_DateFligth, 1, 2);

        //-->  abre      cierra      intervalo
        for (int i = Integer.parseInt(supAdmConfi.getCorreo()); i < Integer.parseInt(supAdmConfi.getTelefono()); i = i + Integer.parseInt(supAdmConfi.getDireccion())) {  //--> horario de 9am a 5pm -->>Estos valores (9y17) van a ser variables
            // que vengan desde superAdmin -->> Consultas cada hora
            comboHora.getItems().addAll(i + ":00");
        }
        gridPaneCitaNue.add(comboHora, 0, 03);

//        textFieldHora = new TextField();
//        textFieldHora.setPromptText("Hore");
//        textFieldHora.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneCitaNue.add(textFieldHora, 0, 3); /// columna fila
//        textFieldHora.setFocusTraversable(false);
        textFieldDoctora = new TextField();
        textFieldDoctora.setPromptText("Doctora");
        textFieldDoctora.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldDoctora, 0, 4); /// columna fila
        textFieldDoctora.setFocusTraversable(false);

        Usuario uwu = l.stringTokenizer(l.readLine(en.ID));
        String tipo = "";
        if (uwu.getTipo().equals("ä")) {
            tipo = "Cliente";
        } else if (uwu.getTipo().equals("ö")) {
            tipo = "Administración";
        }

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonGuardar, 0, 7);

        botonGuardar.setOnAction((event) -> {

            Cita cita = new Cita(textFieldidDeReservacion.getText(), uwu.getName(), dT_DateFligth.getValue().toString(),
                    comboHora.getValue().toString(), textFieldDoctora.getText());
            clienteLogic.writeFileApartaCita(cita);
            Acciones acc = new Acciones(uwu.getName(), agendo, horaFecha.histoFechaHora());
            histo.writeFileCitas(acc);

        });//END BUTTON

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneCitaNue.getChildren().clear();
            gridPaneCitaNue.setBackground(Background.EMPTY);
            gridPaneCitaNue.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPaneCitaNue;
    }//end GridPane createCatalogue()
}
