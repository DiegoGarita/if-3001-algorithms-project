
package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;

public interface InterfaceListas {
    
    public void add(Usuario usuario);
    
    public void remove(Usuario usuario);
    
    public boolean isEmpty();
    
    public void display();
    
    public boolean search(String aBuscar);
    
    public Usuario indexOf(int index);
    
     public int size();
}
