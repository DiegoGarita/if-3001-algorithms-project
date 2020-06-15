package edu.ucr.rp.clinicadenutricion.Cliente.Gui;

//en esta clase el usuario pued ver sus planes de alimentacion
import edu.ucr.rp.clinicadenutricion.AVL.AVLArchivo;
import edu.ucr.rp.clinicadenutricion.Admin.logic.PlanAlimentosLogic;
import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import edu.ucr.rp.clinicadenutricion.Utilitario.HoraFecha;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PlanesAlimentacion {

    ComboBox comboBoxSele = new ComboBox();
    Button buttonDesplegarInfo;
    Button buttonAceptar;
    TextArea textAreaMostrar = new TextArea();
    ComboBox comboBoxOp = new ComboBox();
    LogoApp logo = new LogoApp();
    
    PlanAlimentosLogic planAl = new PlanAlimentosLogic();


    /**
     *
     * @return Nos da la GUI que nos permite crear un nuevo catálogo
     */
    public GridPane misPlanesAlimentos() {

        GridPane gridPanePlanAli = new GridPane();
        gridPanePlanAli.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanePlanAli.setVgap(15);   //espacio
        gridPanePlanAli.setHgap(15);    // espacio
        // alinear el grip
        gridPanePlanAli.setAlignment(Pos.CENTER);
        gridPanePlanAli.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));

      comboBoxOp.setValue("Elige una opcion");
        comboBoxOp.setStyle("-fx-background-color: lightblue");
        comboBoxOp.getItems().addAll("Planes alimenticios", "Recetas");
        gridPanePlanAli.add(comboBoxOp, 0, 0);
        
        comboBoxSele.setValue("Elige una opcion");
        comboBoxSele.setVisible(false);
        comboBoxSele.setStyle("-fx-background-color: lightblue");
        gridPanePlanAli.add(comboBoxSele, 0, 1);
        
        
       buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanAli.add(buttonAceptar, 1, 0);
        buttonAceptar.setOnAction((event) -> {
            if (comboBoxOp.getValue().toString().equals("Recetas")) {
                comboBoxSele.setVisible(true);
                buttonDesplegarInfo.setVisible(true);
                for (int i = 0; i < planAl.Cantidad("*", "Recetas", planAl.recetas); i++) {
                    comboBoxSele.getItems().addAll(planAl.recetas.get(i));
                }
            } else if (comboBoxOp.getValue().toString().equals("Planes alimenticios")) {
                comboBoxSele.setVisible(true);
                buttonDesplegarInfo.setVisible(true);
                for (int i = 0; i < planAl.Cantidad("*","Planes", planAl.planes); i++) {
                    comboBoxSele.getItems().addAll(planAl.planes.get(i));
                }
            }
            
        });//end setOnAction

         buttonDesplegarInfo = new Button("Desplegar");
        buttonDesplegarInfo.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonDesplegarInfo.setVisible(false);
        buttonDesplegarInfo.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonDesplegarInfo.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
       gridPanePlanAli.add(buttonDesplegarInfo, 1, 1);
        buttonDesplegarInfo.setOnAction((event) -> {
            if (comboBoxOp.getValue().toString().equals("Recetas")) {
                textAreaMostrar.setText(planAl.readFile(comboBoxSele.getValue().toString(), "Recetas"));
            } else if (comboBoxOp.getValue().toString().equals("Planes alimenticios")) {
                textAreaMostrar.setText(planAl.readFile(comboBoxSele.getValue().toString(), "Planes"));
            }
            
        });//end setOnAction
        
         textAreaMostrar.setEditable(false);
        gridPanePlanAli.add(textAreaMostrar, 0, 3);

        //***
        MainMenuBarCliente barCliente = new MainMenuBarCliente();
        //***

        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanAli.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {

            gridPanePlanAli.getChildren().clear();
            gridPanePlanAli.setBackground(Background.EMPTY);
            gridPanePlanAli.getChildren().add(barCliente.menuCliente());

        });//end btn cerrar

        return gridPanePlanAli;
    }//end GridPane createCatalogue()
}
// Acciones acc = new Acciones(uwu.getName(), consu, horaFecha.histoFechaHora());
//            histo.writeFileCitas(acc);