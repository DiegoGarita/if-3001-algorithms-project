package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

//en esta clase se colocaran para realizar los ajustes en tiempos de consulta y en horarios de atencion
import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Cliente.Gui.MainMenuBarCliente;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Utilitario.HoraFecha;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.EncripMD5;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import java.util.prefs.Preferences;

public class HorarioTiempoClinica {

    TextField textFieldContra;
    TextField textFieldIntervalo;
    TextField textFieldAbre;
    TextField textFieldCierra;
    Button botonGuardar;
    Button buttonModiUsu;
    public int intervalo = 1;
    public int abre = 9;
    public int cierra = 17;
    public Preferences prefs;
    public String inter = "";

    Logic logic = new Logic();
    EncripMD5 MD5 = new EncripMD5();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane horarioClinica() {

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);

        gridPaneCitaNue.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        prefs = Preferences.userRoot().node(this.getClass().getName());
        prefs.putInt(inter, 1);

        System.out.println(prefs.getInt(inter, 85));

        Usuario uwu = logic.stringTokenizer(logic.readLine("ë"));

        TextField t = new TextField();
        t.setText(uwu.getTipo());
        gridPaneCitaNue.add(t, 2, 1);
        
        textFieldContra = new TextField();
        textFieldContra.setPromptText("Contraseña");
        textFieldContra.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldContra, 0, 1); /// columna fila
        textFieldContra.setFocusTraversable(false);

        textFieldIntervalo = new TextField();
        textFieldIntervalo.setText(uwu.getDireccion());
        textFieldIntervalo.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldIntervalo, 0, 2); /// columna fila
        textFieldIntervalo.setFocusTraversable(false);
        textFieldIntervalo.setVisible(false);

        textFieldAbre = new TextField();
        textFieldAbre.setText(uwu.getCorreo());
        textFieldAbre.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldAbre, 0, 3); /// columna fila
        textFieldAbre.setFocusTraversable(false);
        textFieldAbre.setVisible(false);

        textFieldCierra = new TextField();
        textFieldCierra.setText(uwu.getTelefono());
        textFieldCierra.setStyle(
                "-fx-background-color: lightblue; "
                + "-fx-background-insets: 4; "
                +// tamano
                "-fx-background-radius: 4; "
                +// tamano
                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
        gridPaneCitaNue.add(textFieldCierra, 0, 4); /// columna fila
        textFieldCierra.setFocusTraversable(false);
        textFieldCierra.setVisible(false);

        buttonModiUsu = new Button("Modificar usuario");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setOnAction((event) -> {

            if (textFieldContra.getText().equals(uwu.getName())) {
                textFieldIntervalo.setVisible(true);
                textFieldAbre.setVisible(true);
                textFieldCierra.setVisible(true);
                buttonModiUsu.setDisable(true);
            }

        });//end setOnAction

        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonGuardar, 0, 7);

        botonGuardar.setOnAction((event) -> {

            Usuario usuario = logic.stringTokenizer(logic.readLine("ë"));
            Usuario usuario1 = new Usuario(t.getText(), uwu.getId(), uwu.getName(), uwu.getContraseña(), textFieldAbre.getText(),
                    textFieldCierra.getText(), textFieldIntervalo.getText());

            logic.readInFile();
            ///logic.modified(usuario, textFieldAbre.getText());
            //logic.modifiedSuperHoras(usuario, textFieldAbre.getText(), textFieldCierra.getText(), textFieldIntervalo.getText());
            logic.removeLineFromFile(usuario.getTipo());
            logic.writeInFile(usuario1);

        });//END BUTTON

        //  * *
        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();
        //  * *
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonCerrar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonCerrar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonCerrar, 0, 8);
        botonCerrar.setOnAction((event) -> {

            gridPaneCitaNue.getChildren().clear();
            gridPaneCitaNue.setBackground(Background.EMPTY);
            gridPaneCitaNue.getChildren().add(barSuper.menuSuperAdmi());

        });//end btn cerrar

        return gridPaneCitaNue;
    }//end GridPane createCatalogue()

//       TextField textFieldType;
//    TextField textFieldID;
//    TextField textFieldNombreUsu;
//    TextField textFieldContraUsu;
//    TextField textFieldCorreo;
//    TextField textFieldPhone;
//    TextField textFieldDirection;
//
//    Label labelType;
//    Label labelID;
//    Label labelNombreUsu;
//    Label labelContraUsu;
//    Label labelCorreo;
//    Label labelPhone;
//    Label labelDirection;
//
//    Button buttonModiUsu;
//    Button buttonElimUsu;
//    Button buttonAceptar;
//
//    String fileName;
//    String accionBorra = "Borro su usuario";
//    String accionModi = "Modifico su usuario";
//
//    EncripMD5 e = new EncripMD5();
//    Logic l = new Logic();
//    Entrar en;
//
//    AVLArchivo histo = new AVLArchivo();
//    HoraFecha horaFecha = new HoraFecha();
//
//    LogoApp logo = new LogoApp();
//
//    /**
//     *
//     * @return Nos da la GUI que nos permite crear un nuevo catálogo
//     */
//    public GridPane horarioClinica()  {
//
//        GridPane gridPaneAjustes = new GridPane();
//        gridPaneAjustes.setMinSize(600, 700);
//        gridPaneAjustes.setVgap(15);   //espacio
//        gridPaneAjustes.setHgap(15);    // espacio
//        gridPaneAjustes.setAlignment(Pos.CENTER);
//        Usuario supAdmConfi = l.stringTokenizer(l.readLine("ë"));
//        gridPaneAjustes.setStyle(("-fx-background-image:url('file:src/image/" + supAdmConfi.getContraseña() + "');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));
//
//        Usuario uwu = l.stringTokenizer(l.readLine("ë"));
//        
//        labelType = new Label("Tipo");
//        gridPaneAjustes.add(labelType, 0, 0);
//
//        textFieldType = new TextField("SuperAdmin");
//        textFieldType.setPromptText("Tipo");
//        textFieldType.setDisable(true);
//        textFieldType.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldType, 1, 0);
//        textFieldType.setFocusTraversable(false);
//
//        labelID = new Label("ID: ");
//        gridPaneAjustes.add(labelID, 0, 1);
//        textFieldID = new TextField(uwu.getId());
//        textFieldID.setPromptText("ID");
//        textFieldID.setDisable(true);
//        textFieldID.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldID, 1, 1);
//        textFieldID.setFocusTraversable(false);
//
//        labelNombreUsu = new Label("Nombre: ");
//        gridPaneAjustes.add(labelNombreUsu, 0, 2);
//
//        textFieldNombreUsu = new TextField(uwu.getName());
//        textFieldNombreUsu.setPromptText("Nombre");
//        textFieldNombreUsu.setDisable(true);
//        textFieldNombreUsu.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldNombreUsu, 1, 2);
//        textFieldNombreUsu.setFocusTraversable(false);
//
//        labelContraUsu = new Label("Contraseña: ");
//        gridPaneAjustes.add(labelContraUsu, 0, 3);
//
//        textFieldContraUsu = new TextField();
//        textFieldContraUsu.setPromptText("Contraseña");
//        textFieldContraUsu.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldContraUsu, 1, 3);
//        textFieldContraUsu.setFocusTraversable(false);
//        textFieldContraUsu.setOnMouseClicked((event) -> {
//            buttonModiUsu.setDisable(false);
//            buttonElimUsu.setDisable(false);
//        });
//
//        labelCorreo = new Label("Correo: ");
//        labelCorreo.setVisible(false);
//        gridPaneAjustes.add(labelCorreo, 0, 4);
//
//        textFieldCorreo = new TextField(uwu.getCorreo());
//        textFieldCorreo.setPromptText("correo");
//        textFieldCorreo.setVisible(false);
//        textFieldCorreo.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldCorreo, 1, 4);
//        textFieldCorreo.setFocusTraversable(false);
//
//        labelPhone = new Label("Teléfono: ");
//        labelPhone.setVisible(false);
//        gridPaneAjustes.add(labelPhone, 0, 5);
//
//        textFieldPhone = new TextField(uwu.getTelefono());
//        textFieldPhone.setPromptText("telefono");
//        textFieldPhone.setVisible(false);
//        textFieldPhone.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldPhone, 1, 5);
//        textFieldPhone.setFocusTraversable(false);
//
//        labelDirection = new Label("Dirección: ");
//        labelDirection.setVisible(false);
//        gridPaneAjustes.add(labelDirection, 0, 6);
//
//        textFieldDirection = new TextField(uwu.getDireccion());
//        textFieldDirection.setPromptText("direccion");
//        textFieldDirection.setVisible(false);
//        textFieldDirection.setStyle(
//                "-fx-background-color: lightblue; "
//                + "-fx-background-insets: 4; "
//                +// tamano
//                "-fx-background-radius: 4; "
//                +// tamano
//                "-fx-effect: dropshadow(three-pass-box, blue, 20, 0, 0, 0);");
//        gridPaneAjustes.add(textFieldDirection, 1, 6);
//        textFieldDirection.setFocusTraversable(false);
//
//        buttonModiUsu = new Button("Modificar usuario");
//        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
//        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
//        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
//        gridPaneAjustes.add(buttonModiUsu, 2, 3);
//        buttonModiUsu.setDisable(true);
//        buttonModiUsu.setOnAction((event) -> {
//
//            if (textFieldContraUsu.getText().equals("1234")) {
//                textFieldCorreo.setVisible(true);
//                textFieldDirection.setVisible(true);
//                textFieldPhone.setVisible(true);
//                buttonAceptar.setVisible(true);
//                buttonElimUsu.setDisable(true);
//                buttonModiUsu.setDisable(true);
//            }
//
//        });//end setOnAction
//
//        buttonElimUsu = new Button("Eliminar usuario");
//        buttonElimUsu.setTextFill(Color.WHITE);//Color de la letra del boton
//        buttonElimUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
//        buttonElimUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
//        gridPaneAjustes.add(buttonElimUsu, 3, 3);
//        buttonElimUsu.setDisable(true);
//        buttonElimUsu.setOnAction((event) -> {
//
//            Acciones acc = new Acciones(uwu.getName(), accionBorra, horaFecha.histoFechaHora());
//            histo.writeFileCitas(acc);
//
//            if (uwu.getContraseña().equals(e.encriptar("SusanaDistancia", textFieldContraUsu.getText()))) {
//                Usuario usuario = l.stringTokenizer(l.readLine(textFieldID.getText()));
//                l.readInFile();
//                l.modidelete(usuario);
//                l.removeLineFromFile(usuario.getId());
//                buttonModiUsu.setDisable(true);
//            }
//        });//end setOnAction
//
//        buttonAceptar = new Button("Aceptar");
//        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
//        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
//        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
//        gridPaneAjustes.add(buttonAceptar, 1, 8);
//        buttonAceptar.setVisible(false);
//        buttonAceptar.setOnAction((event) -> {
//
//            Usuario usuario = l.stringTokenizer(l.readLine(textFieldID.getText()));
//            Usuario usuario1 = new Usuario(textFieldType.getText(), textFieldID.getText(), textFieldNombreUsu.getText(), e.encriptar("SusanaDistancia", textFieldContraUsu.getText()), textFieldCorreo.getText(), textFieldPhone.getText(), textFieldDirection.getText());
//
//            l.readInFile();
//            l.modified(usuario, e.encriptar("SusanaDistancia", textFieldCorreo.getText()));
//            l.removeLineFromFile(usuario.getId());
//            l.writeInFile(usuario1);
//
//            Acciones acc = new Acciones(uwu.getName(), accionModi, horaFecha.histoFechaHora());
//            histo.writeFileCitas(acc);
//
//            textFieldDirection.setDisable(true);
//            textFieldCorreo.setDisable(true);
//            textFieldPhone.setDisable(true);
//
//            buttonAceptar.setDisable(true);
//        });//end setOnAction
//
//        //***
//        MainMenuBarCliente barCliente = new MainMenuBarCliente();
//        //***
//
//        Button buttonClose = new Button("Cerrar");
//        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
//        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
//        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
//        gridPaneAjustes.add(buttonClose, 1, 9);
//        buttonClose.setOnAction((event) -> {
//
//            gridPaneAjustes.getChildren().clear();
//            gridPaneAjustes.setBackground(Background.EMPTY);
//            gridPaneAjustes.getChildren().add(barCliente.menuCliente());
//
//        });//end btn cerrar
//
//        return gridPaneAjustes;
//    }//end GridPane createCatalogue()
}// end HorarioTiempoClinica
