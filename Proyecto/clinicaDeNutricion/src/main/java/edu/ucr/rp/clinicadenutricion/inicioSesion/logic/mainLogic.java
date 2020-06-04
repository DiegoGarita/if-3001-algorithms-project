
package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

public class mainLogic {

    public static void main(String[] args) {

        Logic l = new Logic();
//        l.writeFileCatalogue("Nombre3", "Contrasena", "Cliente");
//        l.writeFileCatalogue("Nombre4", "Contrasena", "Admin");
        l.writeFileCatalogue("Nombre6", "Contrasena", "SuperAdmin");
        
        System.out.println(l.readProperties("Nombre4"));
        
    }
    
}
