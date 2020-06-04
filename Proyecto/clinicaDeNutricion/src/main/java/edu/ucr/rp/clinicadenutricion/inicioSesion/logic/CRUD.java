package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import java.util.ArrayList;

class Node {

    Object element;
    Node next;

    public Node(Object n) {
        element = n;
        next = null;

    } //end public

}

public class CRUD {

    public CRUD() {
    }
    Node inicio, fin;

    public String add(Object n) { //object 

        Node aux = inicio;
        String guardado = null;

        if (aux == null) {

            aux = new Node(n);
            inicio = aux;
            guardado = inicio.element + "";

        } //end if
        else { //else
            while (aux.next != null) {

                aux = aux.next;

            } // end while
            aux.next = new Node(n);
            fin = aux.next;
            guardado = fin.element + "";

        }// end else  
        return guardado;
    } //end add(Object n)

    public int size() {

        int output = 0;
        Node aux = inicio;
        while (aux.next != null) {
            aux = aux.next;
            output++;
        }// end while
        return output + 1; //retorna el output +1 por los indices

    }//end size

    public ArrayList<Object> getList() {

        ArrayList<Object> List = new ArrayList<Object>();
        Node aux = inicio;

        for (int i = 0; i <= (size() - 1); i++) {
            List.add(i, aux.element);
            aux = aux.next;
        }// end for

        return List; //retorna la lista

    }
    
        public void remove(Object element) { //metodo remover el elemento que pasa como parametro. Adv: si el objeto no está dentro de la lista se cae

        if (isEmpty() == false) { //usa el metodo "isEmpty" para saber si está vacío
            if (inicio.equals(fin) && element.equals(inicio.element)) { //si el inicio es igual al final y el elemento es igual al inicio.elemento
                inicio = fin = null; //inicio es igual a fin y ambos son iguales a nulo
            }//end if
            else if (element.equals(inicio.element)) { //else if
                inicio = inicio.next; //recorre toda la lista

            }// end else if
            else { //else
                Node aux1, aux; //nodos auxiliares
                aux1 = inicio; //auxiliar1 es inicio
                aux = inicio.next; //auxiliar es el siguiente de inicio
                while (!(aux.equals(null)) && !(aux.element.equals(element))) { //mientras auxiliar sea diferente de nulo y el elemento de exiñiar sea diferente de elemento
                    aux1 = aux1.next; //siguiente
                    aux = aux.next; //siguiente del siguiente
                }//end while
                if (aux != null) { //si el auxiliar (siguiente) es diferente de nulo
                    aux1.next = aux.next; //el auxiliar1 siguiente es igual al auxiliar siguiente del siguiente
                    if (aux.equals(fin)) { ////si auxiliar es igual a fin
                        fin = aux1; //fin es igual a auxiliar1
                    }//end if
                }//end if
            }//end else

        }//end IF

    } //end remove
        
            public boolean isEmpty() { //metodo isEmpty

        boolean empty = false; //empty tipo booleano
        Node aux = inicio; //aux tipo nodo es inicio

        if (aux == null) { //si auxiliar es nulo
            return empty = true; //retorne true
        }// end if
        else { //else
            return empty; //retorne false

        } // end else
    } //end isEmpty

}
