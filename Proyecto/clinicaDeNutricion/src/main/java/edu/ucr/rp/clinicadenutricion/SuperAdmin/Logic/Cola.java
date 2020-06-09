package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import java.util.ArrayList;

public interface Cola {

    public String insertarCita(Object cita);

    public void buscarNodo();

    public void modificar();

    public void emiminarNodo();

    public void desplegarCola();

}//end cola
