package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;

class Node {

    Cita element;
    Node next;

    public Node(Cita x) { //x = element
        this.element = x;
        next = null;
    }

    Cita seeElement() { //instancia para ver el elemento (utilizado solo en IndexOf)

        return this.element; //retorna al elemento recibido por public Node
    }// end seeElement

    Node seeNext() { //instancia para ver al siguiente

        return this.next; //retorna next
    } //ver siguiente

}

public class PilaImplementacion implements Pila {

    Node start, end; //agrega un end para poder localizar al ultimo

//    public boolean isEmpty() {
//        return start == null ? true : false; //ve si era vacío
//    }
    @Override
    public void push(Cita infocita) { //agrega nuevo
        Node aux = start;
        String salida;
        if (aux == null) {
            aux = new Node(infocita); //agrega si no hay
            start = aux; //start guarda el aux
            salida = infocita + "";
        }// end if
        else {
            while (aux.next != null) {//si el siguiente es siguiente de nulo 
                aux = aux.next;//recorre
            }// end while
            aux.next = new Node(infocita); //nuevo si ya hay uno
            salida = infocita + "";
        }// end else
        //  return salida;
    }

    @Override
    public Object peek() { //muestra el ultimo 
        Node aux = start; //aux
        Object peekNode = null; //
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
//

    @Override
    public Object pop() { //quita el ultimo    -->>> Seria este ?????
        Node aux = start;
        Node element = null;
        Object peekNode = null; //para devolver el que borra
        if (aux == null) { //si es nulo retorna -1
            return -1;
        } else {
            do {
                if (aux.next == null) { //si el siguiente es nulo
                    element = aux;
                    peekNode = aux.element;
                }
                aux = aux.next;
            } while (aux != null);
        }
        return peekNode;
    }
//
//        if (isEmpty() == false) { //usa el metodo "isEmpty" para saber si está vacío
//            if (start.equals(end) && element.equals(start.element)) { //si el inicio es igual al final y el elemento es igual al inicio.elemento
//                start = end = null; //inicio es igual a fin y ambos son iguales a nulo
//            }//end if
//            else if (element.equals(start.element)) { //else if
//                start = start.next; //recorre toda la lista
//
//            }// end else if
//            else { //else
//                Node aux1, aux3; //nodos auxiliares
//                aux1 = start; //auxiliar1 es inicio
//                aux3 = start.next; //auxiliar es el siguiente de inicio
//                while (!(aux3.equals(null)) && !(aux3 == (element))) { //mientras auxiliar sea diferente de nulo y el elemento de exiñiar sea diferente de elemento
//                    aux1 = aux1.next; //siguiente
//                    aux3 = aux3.next; //siguiente del siguiente
//                }//end while
//                if (aux3 != null) { //si el auxiliar (siguiente) es diferente de nulo
//                    aux1.next = aux3.next; //el auxiliar1 siguiente es igual al auxiliar siguiente del siguiente
//                    if (aux3.equals(end)) { ////si auxiliar es igual a fin
//                        end = aux1; //fin es igual a auxiliar1
//                    }//end if
//                }//end if
//            }//end else
//
//        }//end IF
//
//        return peekNode;
//    }
//

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

    public Cita indexOf(int index) {

        Node aux = start;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        } // end for

        return aux.seeElement();

    } //end indexOf

//
//    @Override
//    public boolean isFull() {
//        return start != null ? true : false; //contrario al isEmpty()
//    }
}
