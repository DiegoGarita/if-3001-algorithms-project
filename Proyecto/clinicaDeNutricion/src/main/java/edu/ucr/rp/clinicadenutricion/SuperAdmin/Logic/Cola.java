package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Citas;
import java.util.ArrayList;

public interface Cola {

    public String insertarCita(Citas cita);

    public void buscarNodo();

    public void modificar();

    public void emiminarNodo();

    public void desplegarCola();

}//end cola
