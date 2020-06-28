package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;

public interface InterfacePila {

    public void push(Cita cita);

    public Object peek();

    public Object pop(Cita cita);

    public int size();

    public Cita indexOf(int index);

}
