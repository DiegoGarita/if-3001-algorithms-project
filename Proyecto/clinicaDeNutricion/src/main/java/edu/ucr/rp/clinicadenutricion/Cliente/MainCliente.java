package edu.ucr.rp.clinicadenutricion.Cliente;

import edu.ucr.rp.clinicadenutricion.Cliente.Gui.ClienteGui;
import java.io.IOException;

public class MainCliente {

    public static void main(String... args) throws IOException {
        ClienteGui mainInterface = new ClienteGui();
        mainInterface.display();
    }//end main 
}//end mainCliente
