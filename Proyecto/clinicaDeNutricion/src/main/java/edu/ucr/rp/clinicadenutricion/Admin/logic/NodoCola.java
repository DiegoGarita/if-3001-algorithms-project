package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public class NodoCola {

    class Node {

        ReporteMedico elem;
        Node Next;

        public Node(ReporteMedico o) {
            elem = o;
            Next = null;
        }
    }

    Node first;
    Node end;
    int size;

    public NodoCola() {
        end = null;
        size = 0;
    }

    public String enqueue(ReporteMedico o) {
        Node new_node = new Node(o);
        String salida;
        if (first == null) {
            first = new_node;
            end = new_node;
            salida = end + "";
            size++;
            return  salida;
        } else {
            end.Next = new_node;
            end = new_node;
            salida = end + "";
            size++;
            return salida;
        }
        
    }


  public ReporteMedico dequeue() {
        if (first == null) {
            return null;
        }
        ReporteMedico o = first.elem;
        first = first.Next;
        size--;
        return o;
    } 

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public  ReporteMedico first() {
        if (first == null) {
            return null;
        } else {
            return first.elem;
        }
    }

}
