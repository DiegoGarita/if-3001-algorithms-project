package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;

class Node {

    Usuario element;
    Node next;

    public Node(Usuario usuario) {
        element = usuario;
        next = null;

    } //end public

    Usuario seeElement() { //instancia para ver el elemento (utilizado solo en IndexOf)

        return this.element; //retorna al elemento recibido por public Node
    }// end seeElement

    Node seeNext() { //instancia para ver al siguiente

        return this.next; //retorna next
    } //ver siguiente

}

public class ImplementacionListas implements InterfaceListas{

    public ImplementacionListas() {
    }
    Node inicio, fin;

    @Override
    public void add(Usuario usuario) { //inserta un elemento en la lista

        Node aux = inicio; //auxiliar tipo nodo 

        if (aux == null) { //se pregunta si la lista está vacia

            aux = new Node(usuario); //se crea un primer objeto
            inicio = aux; //inicio es igual al auxiliar tipo Nodo con el elemento usuario que pasa como parámetro en el método

        } //end if
        else { //else
            while (aux.next != null) { //mientras el siguiente del auxiliar sea diferente de nulo

                aux = aux.next; //se le asigna la variable aux a los siguientes

            } // end while
            aux.next = new Node(usuario); //el auxiliar siguiente es siguiente nodo
            fin = aux.next; //la variable fin guarda al auxiliar siguiente

        }// end else  
    } //end add(Object n)

    @Override
    public void remove(Usuario usuario) {

        if (isEmpty() == false) {
            if (inicio.equals(fin) && usuario.equals(inicio.element)) {
                inicio = fin = null;
            }//end if
            else if (usuario.equals(inicio.element)) {
                inicio = inicio.next;

            }// end else if
            else { //else
                Node aux1, aux;
                aux1 = inicio;
                aux = inicio.next;

                while (!(aux.equals(null)) && !(aux.element.getName().equals(usuario.getName()))) {

                    aux1 = aux1.next;
                    aux = aux.next;
                    System.out.println(usuario.getName() + "== " + aux1.element.getName());
                }//end while
                if (aux != null) {
                    aux1.next = aux.next;
                    if (aux.equals(fin)) {
                        fin = aux1;
                    }//end if
                }//end if
            }//end else

        }//end IF

    } //end remove

    @Override
    public boolean isEmpty() {

        boolean empty = false;
        Node aux = inicio;

        if (aux == null) {
            return empty = true;
        }// end if
        else { //else
            return empty;

        } // end else
    }

    @Override
    public void display() {
        Node current = inicio;

        if (inicio == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("linked list: ");
        while (current != null) {
            System.out.print(current.element.getId() + "* ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean search(String aBuscar) {
        Node current = inicio;
        while (current != null) {

            if (current.element.getName().equals(aBuscar) || current.element.getId().equals(aBuscar)) {
                return true;
            }
            current = current.next;
        }
        return false;    //data not found 
    }

    @Override
    public Usuario indexOf(int index) {

        Node aux = inicio;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        } // end for

        return aux.seeElement();

    } //end indexOf

    @Override
    public int size() {

        int output = 0;
        Node aux = inicio;
        while (aux.next != null) {
            aux = aux.next;
            output++;
        }// end while
        return output + 1; //retorna el output +1 por los indices

    }//end size

}
