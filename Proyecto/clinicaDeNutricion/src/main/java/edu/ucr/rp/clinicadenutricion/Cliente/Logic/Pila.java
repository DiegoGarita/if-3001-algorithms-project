package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;

public interface Pila {

    public void push(Cita infoCita);

    public Object peek();

    public Object pop();
//
//    public int size();
//
//    public boolean isEmpty();
//
//    public boolean isFull();
}
