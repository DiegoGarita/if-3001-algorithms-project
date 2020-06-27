package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;

public interface InterfaceCola {

    public void add(SuperAdmin n);

    public void remove(SuperAdmin usuario);

    public boolean isEmpty();

    public SuperAdmin indexOf(int index);

    public int size();

}//end cola
