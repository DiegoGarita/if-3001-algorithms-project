package edu.ucr.rp.clinicadenutricion.inicioSesion.Gui;

//import edu.ucr.rp.clinicadenutricion.Cliente.Gui.ClienteGui;
import edu.ucr.rp.clinicadenutricion.Admin.Gui.MainMenuBarAdmi;
import edu.ucr.rp.clinicadenutricion.Cliente.Gui.MainMenuBarCliente;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Gui.MainMenuBarSuperAdmi;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.EncripMD5;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;

public class MainMenuBarSesion {

    AcercaDe acercaDe = new AcercaDe();
    Ayuda ayuda = new Ayuda();
    Creditos creditos = new Creditos();

    CrearUsuarioNuevo crearUsuarionuevo = new CrearUsuarioNuevo();
    Entrar entrar = new Entrar();

    VBox vBoxWindows, vBoxMain;
    

    Logic l = new Logic();


    /**
     *
     * @return Nos da la GUI que contiene todos los elementos por mostrar en la
     * barra de menú
     */
    public Scene getMainScene() {

        vBoxMain = new VBox();
//        vBoxMain.setStyle(("-fx-background-image:url('file:src/image/inicio1.jpg');"
//                + "-fx-background-repeat : no-repeat;"
//                + "-fx-background-size: 920 920, 20 20, 20 20, 20 20, auto;"));

        Scene scene = new Scene(vBoxMain, 900, 700);
        vBoxWindows = new VBox();

        MenuBar menuBarMenu = new MenuBar();
        menuBarMenu.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");

        SeparatorMenuItem separator = new SeparatorMenuItem();
        //Menu Sistema
        Menu menuSystem = new Menu("Sistema", new ImageView(new Image("file:src/image/sistema.png")));
        menuSystem.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        //SubMenu de Sistema
        MenuItem menuItemAbout = new MenuItem("Acerca de", new ImageView(new Image("file:src/image/aD.png")));
        menuItemAbout.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        MenuItem menuItemCredits = new MenuItem("Créditos", new ImageView(new Image("file:src/image/credi.png")));
        menuItemCredits.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        MenuItem menuItemPerformance = new MenuItem("Funcionamiento", new ImageView(new Image("file:src/image/preg.png")));
        MenuItem menuItemExit = new MenuItem("Salir", new ImageView(new Image("file:src/image/salir.png")));
        menuItemExit.setAccelerator(KeyCombination.keyCombination("Alt+S"));

        menuItemCredits.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(creditos.getGraphicalUserInterfaceCredits());
        });

        menuItemAbout.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(acercaDe.getGraphicalUserInterfaceAbout());
        });

        menuItemPerformance.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(ayuda.getGraphicalUserInterfaceHelper());
        });

        menuItemExit.setOnAction((event) -> Platform.exit());

        menuSystem.getItems().addAll(menuItemAbout, menuItemCredits, menuItemPerformance, menuItemExit);

        Menu menuCrearUsuario = new Menu("Cuenta", new ImageView(new Image("file:src/image/regis.png")));
        menuCrearUsuario.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
                + "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);"
                + "-fx-background-insets: 50;");
        MenuItem menuItemCreaCuenta = new MenuItem("Crear cuenta", new ImageView(new Image("file:src/image/nuevo.png")));
        menuItemCreaCuenta.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        MenuItem menuItemIngresar = new MenuItem("Ingresar", new ImageView(new Image("file:src/image/ingr.png")));
        menuItemIngresar.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

        menuItemCreaCuenta.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(crearUsuarionuevo.creaUsuario());
        });

        menuItemIngresar.setOnAction((event) -> {
            vBoxWindows.getChildren().clear();
            vBoxWindows.getChildren().addAll(entrar.ingresaCuenta());
        });

        menuCrearUsuario.getItems().addAll(menuItemCreaCuenta, menuItemIngresar);

        menuBarMenu.setOpacity(0.0);
        menuBarMenu.setOnMouseMoved((event) -> {
            menuBarMenu.setOpacity(0.9);
        });

//
//        Button botonAceptar = new Button("Aceptar");
//        TextField textFieldNombre = new TextField();
//        textFieldNombre.setPromptText("Ingrese su nombre de usuario");
//        
//
//        PasswordField fieldContraseña = new PasswordField();
//        fieldContraseña.setPromptText("Ingrese su contraseña");
        

        menuBarMenu.getMenus().addAll(menuSystem, menuCrearUsuario);
        ((VBox) scene.getRoot()).getChildren().addAll(menuBarMenu, vBoxWindows);

//
//        MainMenuBarCliente zz = new MainMenuBarCliente();
//        MainMenuBarSuperAdmi mm = new MainMenuBarSuperAdmi();
//        MainMenuBarAdmi nn = new MainMenuBarAdmi();
//
//        botonAceptar.setOnAction((event) -> {
//            
//            l.readInFile();
//          
//            if(l.search(textFieldNombre.getText())&&l.search(fieldContraseña.getText())){
//                
//            vBoxWindows.getChildren().clear();
//             menuBarMenu.setVisible(false);
//             
//             if(l.readType(textFieldNombre.getText()+"|"+fieldContraseña.getText()).equals("-")){
//              vBoxWindows.getChildren().add(zz.menuCliente());
//             }
//             else if(l.readType(textFieldNombre.getText()+"|"+fieldContraseña.getText()).equals("+")){
//                 vBoxWindows.getChildren().add(nn.menuAdmi());
//             }
//             else if(l.readType(textFieldNombre.getText()+"|"+fieldContraseña.getText()).equals("*")){
//                     vBoxWindows.getChildren().add(mm.menuSuperAdmi());
//             }
//                
//            }
//            else{
//                System.out.println("Usuario no existe");
//            }
            
              //encriptar.encriptar("clinicaSusanaDistancia", fieldContraseña.getText());
                        //vBoxWindows.getChildren().removeAll(vBoxWindows);
            
            //            String cadenaEncriptada = encriptar.encriptar("clinicaSusanaDistancia", fieldContraseña.getText());
//            JOptionPane.showMessageDialog(null, "Cadena encriptada: " + cadenaEncriptada);
//            String cadenaDesencriptada = encriptar.desencriptar("clinicaSusanaDistancia", cadenaEncriptada);
//            JOptionPane.showMessageDialog(null, "Cadena desencriptada: " + cadenaDesencriptada);
            
            
            
//            if (l.readProperties(textFieldNombre.getText()).size() != 0){
//
//                System.out.println("existo\n");
//                System.out.println(l.readProperties(textFieldNombre.getText()).get(0));
//                String password="";
//
//                if (l.readProperties(textFieldNombre.getText()).get(0).contains("-")) {
//                   password = l.readProperties(textFieldNombre.getText()).get(1);
//                    System.out.println(password);
//                    System.out.println(encriptar.encriptar("clinicaSusanaDistancia", textFieldContraseña.getText()));
//                    if (password.equals(encriptar.encriptar("clinicaSusanaDistancia", textFieldContraseña.getText()))) {
//                        System.out.println("Contraseña correcta, entró");
//                    } else {
//                        System.out.println("Contraseña incorrecta");
//                    }
//
//                } else if (l.readProperties(textFieldNombre.getText()).get(0).contains("+")) {
//                    password = l.readProperties(textFieldNombre.getText()).get(1);
//                    System.out.println(password);
//                    if (password.equals(encriptar.encriptar("SusanaDistancia", textFieldContraseña.getText()))) {
//                        System.out.println("Contraseña correcta, entró");
//                    } else {
//                        System.out.println("Contraseña incorrecta");
//                    }
//
//                } else if (l.readProperties(textFieldNombre.getText()).get(0).contains("*")) {
//                    password = l.readProperties(textFieldNombre.getText()).get(1);
//                    System.out.println(password);
//                    if (password.equals(encriptar.encriptar("SusanaDistancia", textFieldContraseña.getText()))) {
//                        System.out.println("Contraseña correcta, entró");
//                    } else {
//                        System.out.println("Contraseña incorrecta");
//                    }
//
//                }
//
//            } else {
//                System.out.println("no existo");
//            }

      //  });

        return scene;

    }//end Scene getMainScene()

}//end MainMenuBarSesion
