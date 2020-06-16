package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public class ImplementacionCola {

    class Node {

        ReporteMedico reporteMedico;
        Node next;

        public Node(ReporteMedico reporteMedico) {
            reporteMedico = reporteMedico;
            next = null;
        }
    }

    Node first;
    Node end;
    int size;

    public ImplementacionCola() {
        end = null;
        size = 0;
    }

    public String enqueue(ReporteMedico reporteMedico) {
        Node newNode = new Node(reporteMedico);
        String salida;
        if (first == null) {
            first = newNode;
            end = newNode;
            salida = end + "";
            size++;
            return salida;
        } else {
            end.next = newNode;
            end = newNode;
            salida = end + "";
            size++;
            return salida;
        }

    }

    public ReporteMedico dequeue() {
        if (first == null) {
            return null;
        }
        ReporteMedico o = first.reporteMedico;
        first = first.next;
        size--;
        return o;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public ReporteMedico first() {
        if (first == null) {
            return null;
        } else {
            return first.reporteMedico;
        }
    }

}
