package edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui;

// en esta clase se colocara para poder realizar un cambio de logo del app
import edu.ucr.rp.clinicadenutricion.Cliente.Gui.MainMenuBarCliente;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;

public class LogoApp {

    TextField textFieldContra;
    Button botonGuardar;
    Button botonLogo;
    Button buttonModiUsu;
    public String NombreLogo = "3";
    Logic logic = new Logic();

    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane logoClinica() {

        GridPane gridPaneCitaNue = new GridPane();
        gridPaneCitaNue.setMinSize(600, 700);
        gridPaneCitaNue.setVgap(15);
        gridPaneCitaNue.setHgap(15);
        gridPaneCitaNue.setAlignment(Pos.CENTER);

        gridPaneCitaNue.setStyle(("-fx-background-image:url('file:src/image/SuperAdmin.gif');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

        Usuario uwu = logic.stringTokenizer(logic.readLine("ë"));

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

        buttonModiUsu = new Button("Modificar logo");
        buttonModiUsu.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonModiUsu.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonModiUsu.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(buttonModiUsu, 1, 1);
        buttonModiUsu.setOnAction((event) -> {

            if (textFieldContra.getText().equals(uwu.getName())) {
                botonLogo.setVisible(true);
                botonGuardar.setVisible(true);
                buttonModiUsu.setDisable(true);
            }

        });//end setOnAction

        Label label = new Label("no files selected");
        botonLogo = new Button("Elegir logo");
        botonLogo.setTextFill(Color.WHITE);//Color de la letra del boton
        botonLogo.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonLogo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonLogo, 0, 6);
        botonLogo.setVisible(false);
        botonLogo.setOnAction((event) -> {
            File file1 = setFileChooser().showOpenDialog(null);
            if (file1 != null) {

                label.setText(file1.getName());
            }
        });//END BUTTON

        ////// file1.getName()  *************************************************////////////////*******************//////////////////
        botonGuardar = new Button("Guardar");
        botonGuardar.setTextFill(Color.WHITE);//Color de la letra del boton
        botonGuardar.setStyle("-fx-background-color: BLACK");//Color del fondo
        botonGuardar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPaneCitaNue.add(botonGuardar, 0, 7);
         botonGuardar.setVisible(false);
        botonGuardar.setOnAction((event) -> {

            Usuario usuario = logic.stringTokenizer(logic.readLine("ë"));
            Usuario usuario1 = new Usuario(uwu.getTipo(), uwu.getId(), uwu.getName(), label.getText(), uwu.getCorreo(),
                    uwu.getTelefono(), uwu.getDireccion());

            logic.readInFile();
            ///logic.modified(usuario, textFieldAbre.getText());
           // logic.modifiedSuperFondo(usuario, label.getText());
            logic.removeLineFromFile(usuario.getTipo());
            logic.writeInFile(usuario1);
        });//END BUTTON

        //***
        MainMenuBarSuperAdmi barSuper = new MainMenuBarSuperAdmi();
        //***
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

    public FileChooser setFileChooser() {
        //Este metodo crea el fileChooser que va a escoger las imagenes
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.setInitialDirectory(new File("C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion\\src\\image"));

        //Filtros de lo que muestra la ventana
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
        );//fin filtro

        return fileChooser;
    }//end method setFileChooser

}
