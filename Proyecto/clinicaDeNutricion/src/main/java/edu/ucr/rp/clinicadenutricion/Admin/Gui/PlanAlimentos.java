package edu.ucr.rp.clinicadenutricion.Admin.Gui;

//en etsa clase el admin tendra acceso a los planes de alimentacion
import edu.ucr.rp.clinicadenutricion.Admin.logic.PlanAlimentosLogic;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.LogoApp;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class PlanAlimentos {
    
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
    public GridPane planesAlimentos() {

        /// File file = new File(fileName);
        GridPane gridPanePlanRece = new GridPane();
        gridPanePlanRece.setMinSize(600, 700);
        // determina el espacio entre columnas (vertical y horizontal)
        gridPanePlanRece.setVgap(15);   //espacio
        gridPanePlanRece.setHgap(15);    // espacio
        // alinear el grip
        gridPanePlanRece.setAlignment(Pos.CENTER);
        gridPanePlanRece.setStyle(("-fx-background-image:url('file:src/image/" + logo.NombreLogo + ".jpeg');"
                + "-fx-background-repeat : no-repeat;"
                + "-fx-background-size: 900 700, 20 20, 20 20, 20 20, auto;"));
        
        comboBoxOp.setValue("Elige una opcion");
        comboBoxOp.setStyle("-fx-background-color: lightblue");
        comboBoxOp.getItems().addAll("Planes alimenticios", "Recetas");
        gridPanePlanRece.add(comboBoxOp, 0, 0);
        
        comboBoxSele.setValue("Elige una opcion");
        comboBoxSele.setVisible(false);
        comboBoxSele.setStyle("-fx-background-color: lightblue");
        gridPanePlanRece.add(comboBoxSele, 0, 1);
        
        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonAceptar.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonAceptar.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanRece.add(buttonAceptar, 1, 0);
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
        gridPanePlanRece.add(buttonDesplegarInfo, 1, 1);
        buttonDesplegarInfo.setOnAction((event) -> {
            if (comboBoxOp.getValue().toString().equals("Recetas")) {
                textAreaMostrar.setText(planAl.readFile(comboBoxSele.getValue().toString(), "Recetas"));
            } else if (comboBoxOp.getValue().toString().equals("Planes alimenticios")) {
                textAreaMostrar.setText(planAl.readFile(comboBoxSele.getValue().toString(), "Planes"));
            }
            
        });//end setOnAction

        textAreaMostrar.setEditable(false);
        gridPanePlanRece.add(textAreaMostrar, 0, 3);

        //***
        MainMenuBarAdmi o = new MainMenuBarAdmi();
        //***
        Button buttonClose = new Button("Cerrar");
        buttonClose.setTextFill(Color.WHITE);//Color de la letra del boton
        buttonClose.setStyle("-fx-background-color: BLACK");//Color del fondo
        buttonClose.setFont(Font.font("Castellar", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 10));//Tipo de letra
        gridPanePlanRece.add(buttonClose, 2, 8);
        buttonClose.setOnAction((event) -> {
            
            gridPanePlanRece.getChildren().clear();
            gridPanePlanRece.setBackground(Background.EMPTY);  //limpia color para que quede el color
            gridPanePlanRece.getChildren().add(o.menuAdmi());
            
        });//end btn cerrar

        return gridPanePlanRece;
    }//end GridPane createCatalogue()

}//end PlanAlimentos
