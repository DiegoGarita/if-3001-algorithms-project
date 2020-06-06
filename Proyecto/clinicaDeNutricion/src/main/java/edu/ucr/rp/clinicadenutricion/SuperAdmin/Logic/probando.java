package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Citas;

public class probando {

    public static void main(String[] args) {

        Citas cita;
    //    cita.setFecha("20/8/20");
     ///   cita.setAltura(1.70);
        
        cita = new Citas("20/2/2020", "3:25", 0.5, 0.3, 0.1, 0.8, 0.9, 0.4, 0.7, 0, 0, 0, "Nula");
        //ColaImplementacion cola = new ColaImplementacion();
        // cola.insertarNodo(cita);
        // cola.desplegarCola(cita);
        SuperAdminLogic sL = new SuperAdminLogic();
        sL.writeFileCitas(cita);
     // sL.writeFileCatalogue(cita);


    }

}//end probando
