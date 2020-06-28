package edu.ucr.rp.clinicadenutricion.Utilitario;

import java.util.Date;

public class FechaHora {

    /**
     * método que muestra la hora actual obtenida desde la computadora
     * @return retorna String con hora y fecha obtenida del método java.util.Date
     */
    public String histoFechaHora() {
        
        String salida;
        java.util.Date fecha = new Date();
        salida = fecha+"";
        return salida;
    }//end histoFechaHora

}//end horaFecha
