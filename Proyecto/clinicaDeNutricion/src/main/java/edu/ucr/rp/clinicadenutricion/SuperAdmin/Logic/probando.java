package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import javafx.scene.control.TextArea;

public class probando {

    public static void main(String[] args) {

        ReporteMedico cita;
//        //    cita.setFecha("20/8/20");
//        ///   cita.setAltura(1.70);
        TextArea t = new TextArea();
        t.setText("hjbd");
        //cita = new ReporteMedico("fsd", "edf", "nula", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, t);
//        //ColaImplementacion cola = new ColaImplementacion();
//        // cola.insertarNodo(cita);
//        // cola.desplegarCola(cita);
        SuperAdminLogic sL = new SuperAdminLogic();
//        cita.getTextAreaNotas();
        sL.writeFileCitas("fsd", "edf", "nula", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, t);
//        // sL.writeFileCatalogue(cita);

    }

}//end probando
