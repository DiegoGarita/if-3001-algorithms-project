package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public interface InterfaceCola {

    public String enqueue(ReporteMedico reporteMedico);

    public ReporteMedico dequeue();

    public boolean isEmpty();

    public int size();

}
