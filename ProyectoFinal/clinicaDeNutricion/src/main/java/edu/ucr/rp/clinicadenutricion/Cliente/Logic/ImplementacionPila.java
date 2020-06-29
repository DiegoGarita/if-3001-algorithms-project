package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;

class Node {

    Cita element;
    Node next;

    public Node(Cita cita) {
        this.element = cita;
        next = null;
    }

    Cita seeElement() {

        return this.element;
    }

    Node seeNext() {

        return this.next;
    }

}

public class ImplementacionPila implements InterfacePila {

    Node start, end;

    /**
     *
     * @param cita recibe objeto a insertar a la pila
     */
    @Override
    public void push(Cita cita) {
        Node aux = start;
        if (aux == null) {
            aux = new Node(cita);
            start = aux;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = new Node(cita);
        }
    }

    /**
     *
     * @return retorna objeto, el último en la pila
     */
    @Override
    public Object peek() {
        Node aux = start;
        Object peekNode = null;
        if (aux == null) {
            return -1;
        } else {
            do {
                if (aux.next == null) {
                    peekNode = aux.element;
                }
                aux = aux.next;
            } while (aux != null);
        }
        return peekNode;
    }

    /**
     *
     * @param cita recibe cita a quitar
     * @return devuelve el objeto sin la cita recibida
     */
    @Override
    public Object pop(Cita cita) {
        Node aux = start;
        cita = null;
        if (aux == null) {
            return -1;
        } else {
            do {
                if (aux.next == null) {
                    cita = aux.element;
                }
                aux = aux.next;
            } while (aux != null);
        }
        return cita;
    }

    /**
     *
     * @return devuelve tamaño de la pila
     */
    @Override
    public int size() {
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

    /**
     *
     * @param index recibe indice
     * @return devuelve cita del indice indicado en el @param
     */
    @Override
    public Cita indexOf(int index) {

        Node aux = start;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        }

        return aux.seeElement();

    }
    
            public void display() {
        Node current = start;

        if (start == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("linked list: ");
        while (current != null) {
            System.out.print(current.element.getIDCita() + "* ");
            current = current.next;
        }
        System.out.println();
    }

}
