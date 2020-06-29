package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;

class Node {

    SuperAdmin element;
    Node next;

    public Node(SuperAdmin n) {
        element = n;
        next = null;

    }

    SuperAdmin seeElement() {

        return this.element;
    }

    Node seeNext() {

        return this.next;
    }

}

public class ImplementacionCola implements InterfaceCola {

    public ImplementacionCola() {
    }
    Node inicio, fin;

    /**
     *
     * @param superAdmin elemento tipo SuperAdmin que será agregado a la lista
     */
    @Override
    public void add(SuperAdmin superAdmin) {

        Node aux = inicio;

        if (aux == null) {

            aux = new Node(superAdmin);
            inicio = aux;

        } else {
            while (aux.next != null) {

                aux = aux.next;

            }
            aux.next = new Node(superAdmin);
            fin = aux.next;

        }
    }

    /**
     *
     * @param superAdmin recibe objeto superAdministrador para eliminar (luego
     * agrega nuevo en forma de modificar)
     */
    @Override
    public void remove(SuperAdmin superAdmin) {

        if (isEmpty() == false) {
            if (inicio.equals(fin) && superAdmin.equals(inicio.element)) {
                inicio = fin = null;
            } else if (superAdmin.equals(inicio.element)) {
                inicio = inicio.next;

            } else {
                Node aux1, aux;
                aux1 = inicio;
                aux = inicio.next;

                while (!(aux.equals(null)) && !(aux.element.getIdentificadorSA().equals(superAdmin.getIdentificadorSA()))) {

                    aux1 = aux1.next;
                    aux = aux.next;
                }
                if (aux != null) {
                    aux1.next = aux.next;
                    if (aux.equals(fin)) {
                        fin = aux1;
                    }
                }
            }
        }
    }

    /**
     *
     * @return booleano, true si está vacio, false si no está vacío
     */
    @Override
    public boolean isEmpty() {

        boolean empty = false;
        Node aux = inicio;

        if (aux == null) {
            return empty = true;
        } else {
            return empty;

        }
    }

    /**
     *
     * @param index indice del elemento a buscar
     * @return elemento SuperAdmin encontrado
     */
    @Override
    public SuperAdmin indexOf(int index) {

        Node aux = inicio;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        }

        return aux.seeElement();

    }

    /**
     *
     * @return tamaño de la cola
     */
    @Override
    public int size() {

        int output = 0;
        Node aux = inicio;
        while (aux.next != null) {
            aux = aux.next;
            output++;
        }
        return output + 1;

    }//end size
    
        public void display() {
        Node current = inicio;

        if (inicio == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("linked list: ");
        while (current != null) {
            System.out.print(current.element.getPathDeGuardado() + "* ");
            current = current.next;
        }
        System.out.println();
    }

}
