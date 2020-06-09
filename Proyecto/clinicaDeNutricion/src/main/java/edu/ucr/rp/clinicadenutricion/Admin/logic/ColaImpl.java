package edu.ucr.rp.clinicadenutricion.Admin.logic;

public class ColaImpl {

    class Node {

        Object elem;
        Node Next;

        public Node(Object o) {
            elem = o;
            Next = null;
        }
    }

    Node first;
    Node end;
    int size;

    public ColaImpl() {
        end = null;
        size = 0;
    }

    public String enqueue(Object o) {
        Node new_node = new Node(o);
        String salida;
        if (first == null) {
            first = new_node;
            end = new_node;
            salida = end + "";
            return  salida;
        } else {
            end.Next = new_node;
            end = new_node;
            salida = end + "";
            return salida;
        }
       // size++;
    }

    ; // inserts an object onto the queue

  public Object dequeue() {
        if (first == null) {
            return null;
        }
        ;
        Object o = first.elem;
        first = first.Next;
        size--;
        return o;
    } // gets the object from the queue

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public Object first() {
        if (first == null) {
            return null;
        } else {
            return first.elem;
        }
    }

} // class LinkedQueue
