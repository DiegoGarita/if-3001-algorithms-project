package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public class ImplementacionCola implements InterfaceCola {

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

    @Override
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

    @Override
    public ReporteMedico dequeue() {
        if (first == null) {
            return null;
        }
        ReporteMedico o = first.reporteMedico;
        first = first.next;
        size--;
        return o;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

}
