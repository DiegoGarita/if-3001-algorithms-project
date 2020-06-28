package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public interface InterfaceArbol {

    public void insertar(ReporteMedico dato);

    public void PreOrden();

    public void PostOrden();

    public void InOrden();

}
