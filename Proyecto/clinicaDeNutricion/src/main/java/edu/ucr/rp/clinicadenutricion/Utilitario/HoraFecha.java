package edu.ucr.rp.clinicadenutricion.Utilitario;

import java.util.Date;

public class HoraFecha {

    public String histoFechaHora() {
        
        String salida;
        java.util.Date fecha = new Date();
        salida = fecha+"";
        return salida;
    }//end histoFechaHora

}//end horaFecha