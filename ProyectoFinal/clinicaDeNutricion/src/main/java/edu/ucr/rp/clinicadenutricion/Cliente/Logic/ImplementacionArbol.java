package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public class ImplementacionArbol implements InterfaceArbol {

    public static class NodoBinario {

        ReporteMedico dato;
        NodoBinario izquierda, derecha;

        NodoBinario(ReporteMedico reporteMedico) {
            dato = reporteMedico;
            izquierda = null;
            derecha = null;
        }
    }//fin de clase NodoBinario

    private NodoBinario raiz;

    public ImplementacionArbol() {
        this.raiz = null;
    }

    @Override
    public void insertar(ReporteMedico reporteMedico) {
        raiz = insertar(raiz, reporteMedico);
    }

    @Override
    public void PreOrden() {
        PreOrden(raiz);
    }

    @Override
    public void PostOrden() {
        PostOrden(raiz);
    }

    @Override
    public void InOrden() {
        InOrden(raiz);
    }

    /**
     *
     * @param nodo nodo a ser validado y realizar rotaciones
     * @param reporteMedico objeto a ser agregado
     * @return nodo binario con reporteMedico agregado
     */
    private NodoBinario insertar(NodoBinario nodo, ReporteMedico reporteMedico) {

        NodoBinario nodoElemento = new NodoBinario(reporteMedico);
        if (nodo == null) {
            nodo = nodoElemento;
            raiz = nodo;
        } else {
            if (!reporteMedico.equals(nodo.dato)) {
                nodo.izquierda = insertar(nodo.izquierda, reporteMedico);
            } else {
                nodo.derecha = insertar(nodo.derecha, reporteMedico);
            }

        }

        return nodo;
    }

    /**
     *
     * @param nodo nodo que será mostrado en preOrden
     */
    private void PreOrden(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + ", ");
            PreOrden(nodo.izquierda);
            PreOrden(nodo.derecha);
        }

    }

    /**
     *
     * @param nodo nodo que será mostrado en inOrden
     */
    private void InOrden(NodoBinario nodo) {
        if (nodo != null) {
            InOrden(nodo.izquierda);
            System.out.print(nodo.dato.getNombre() + ", ");
            InOrden(nodo.derecha);
        }

    }

    /**
     *
     * @param nodo nodo que será mostrado en postOrden
     */
    private void PostOrden(NodoBinario nodo) {
        if (nodo != null) {
            InOrden(nodo.izquierda);
            InOrden(nodo.derecha);
            System.out.print(nodo.dato + ", ");
        }

    }

}// end ImplementacionArbol

