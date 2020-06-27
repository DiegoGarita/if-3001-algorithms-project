package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;

class Node {

    SuperAdmin element;
    Node next;

    public Node(SuperAdmin n) {
        element = n;
        next = null;

    } //end public

    SuperAdmin seeElement() { //instancia para ver el elemento (utilizado solo en IndexOf)

        return this.element; //retorna al elemento recibido por public Node
    }// end seeElement

    Node seeNext() { //instancia para ver al siguiente

        return this.next; //retorna next
    } //ver siguiente

}

public class LogicSuperAdmin implements InterfaceCola {

    public LogicSuperAdmin() {
    }
    Node inicio, fin;

    @Override
    public void add(SuperAdmin n) { //inserta un elemento en la lista

        Node aux = inicio; //auxiliar tipo nodo 

        if (aux == null) { //se pregunta si la lista está vacia

            aux = new Node(n); //se crea un primer objeto
            inicio = aux; //inicio es igual al auxiliar tipo Nodo con el elemento n que pasa como parámetro en el método

        } //end if
        else { //else
            while (aux.next != null) { //mientras el siguiente del auxiliar sea diferente de nulo

                aux = aux.next; //se le asigna la variable aux a los siguientes

            } // end while
            aux.next = new Node(n); //el auxiliar siguiente es siguiente nodo
            fin = aux.next; //la variable fin guarda al auxiliar siguiente

        }// end else  
    } //end add(Object n)

    @Override
    public void remove(SuperAdmin usuario) {

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

                while (!(aux.equals(null)) && !(aux.element.getIdentificadorSA().equals(usuario.getIdentificadorSA()))) {

                    aux1 = aux1.next;
                    aux = aux.next;
                    //System.out.println(usuario.getName() + "== " + aux1.element.getName());
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
    public SuperAdmin indexOf(int index) {

        Node aux = inicio;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        } // end for

        return aux.seeElement();    // ---- >> Aqui tambien ???

    } //end indexOf

    @Override
    public int size() {

        int output = 0;
        Node aux = inicio;
        while (aux.next != null) {    //--> Aveces aqui tambien
            aux = aux.next;
            output++;
        }// end while
        return output + 1; //retorna el output +1 por los indices

    }//end size

}
