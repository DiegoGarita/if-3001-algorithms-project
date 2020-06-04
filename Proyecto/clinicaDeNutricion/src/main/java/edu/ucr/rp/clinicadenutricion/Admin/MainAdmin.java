package edu.ucr.rp.clinicadenutricion.Admin;

import edu.ucr.rp.clinicadenutricion.Admin.Gui.AdminGui;
import java.io.IOException;

public class MainAdmin {

    public static void main(String... args) throws IOException {
        AdminGui mainInterface = new AdminGui();
        mainInterface.display();
    }//end main 

}
