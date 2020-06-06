package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Citas;
import java.util.Scanner;

class Nodo {

    Citas cita;
    Nodo siguiente;

    public Nodo(Citas n) {
        cita = n;
    }//end constructorNodo

}//end nodo

public class ColaImplementacion implements Cola{

    Nodo primero;
    Nodo ultimo;
    Scanner teclado = new Scanner(System.in);

    public ColaImplementacion() {
        primero = null;
        ultimo = null;
    }//end constructor

    //@Override
    public String insertarCita(Citas n) {
        
        Nodo nuevo = new Nodo(n);
        String guardado = null;
      
      //  nuevo.cita = nuevo;
        //nuevo.cita = teclado.nextInt();

        if (primero.equals(null)) {// es el primero de la cola????? --> SI
            primero = nuevo;
            primero.siguiente = null;
            ultimo = nuevo;
            guardado = ultimo + "";
        }//end if
        else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = null;
            ultimo = nuevo;
            guardado = ultimo + "";
        }//end else
        return guardado;
    }//end insertarNodo

    @Override
    public void buscarNodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void emiminarNodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desplegarCola() {
//        Nodo actual = new Nodo(cita);
//        actual = primero;
//        if (primero != null) {
//            while (actual != null) {
//                System.out.println(" " + actual.cita);
//                actual = actual.siguiente;
//            }//end while
//        }//end if
    }

}//end ColaImplementacion implements Cola
