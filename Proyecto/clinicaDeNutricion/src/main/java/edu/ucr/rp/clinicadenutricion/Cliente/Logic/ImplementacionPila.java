package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;

class Node {

    Cita element;
    Node next;

    public Node(Cita cita) {
        this.element = cita;
        next = null;
    }

    Cita seeElement() { //instancia para ver el elemento (utilizado solo en IndexOf)

        return this.element; //retorna al elemento recibido por public Node
    }// end seeElement

    Node seeNext() { //instancia para ver al siguiente

        return this.next; //retorna next
    } //ver siguiente

}

public class ImplementacionPila implements InterfacePila {

    Node start, end;

    @Override
    public void push(Cita cita) { //agrega nuevo
        Node aux = start;
        if (aux == null) {
            aux = new Node(cita); //agrega si no hay
            start = aux; //start guarda el aux
        }// end if
        else {
            while (aux.next != null) {//si el siguiente es siguiente de nulo 
                aux = aux.next;//recorre
            }// end while
            aux.next = new Node(cita); //nuevo si ya hay uno
        }// end else
        //  return salida;
    }

    @Override
    public Object peek() { //muestra el ultimo 
        Node aux = start;
        Object peekNode = null;
        if (aux == null) { //si es nulo retorna -1
            return -1;
        } else {
            do {
                if (aux.next == null) {//si el siguiente es nulo
                    peekNode = aux.element; //toma el ultimo
                }
                aux = aux.next; //recorre
            } while (aux != null); //mientras no sea nulo
        }
        return peekNode;
    }

    @Override
    public Object pop(Cita cita) { //quita el ultimo    -->>> Seria este ?????
        Node aux = start;
        cita = null; //para devolver el que borra
        if (aux == null) { //si es nulo retorna -1
            return -1;
        }//end if
        else {
            do {
                if (aux.next == null) { //si el siguiente es nulo
                    cita = aux.element;
                }
                aux = aux.next;
            } while (aux != null);
        }//end else
        return cita;
    }//end pop

    @Override
    public int size() { //tamaño (hecho en clase)
        int s = 1;
        Node aux = start;

        if (aux == null) {
            return 0;
        } else {
            do {
                s++;
                aux = aux.next;
            } while (aux.next != null);
        }
        return s;
    }

    @Override
    public Cita indexOf(int index) {

        Node aux = start;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        } // end for

        return aux.seeElement();

    } //end indexOf

}
