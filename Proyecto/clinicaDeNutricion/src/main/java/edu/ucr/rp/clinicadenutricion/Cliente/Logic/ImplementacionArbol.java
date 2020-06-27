package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public class ImplementacionArbol implements InterfaceArbol {

    public static class NodoBinario {

        ReporteMedico dato;
        NodoBinario izq, der;

        NodoBinario(ReporteMedico n) {
            dato = n;
            izq = null;
            der = null;
        }//fin de nodo binario
    }//fin de clase NodoBinario

    private NodoBinario raiz;

    public ImplementacionArbol() {
        this.raiz = null;
    }

    @Override
    public void insertar(ReporteMedico dato) {
        raiz = insertar(raiz, dato);
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

    // metodos privados a implementar
    private NodoBinario insertar(NodoBinario nodo, ReporteMedico dato) { //recibe el nodo y el valor

        NodoBinario nodoElemento = new NodoBinario(dato);
        if (nodo == null) { //saber si es el primer elemento
            nodo = nodoElemento;
            raiz = nodo; //agrga el nuevo nodo en la raíz
        } else {
            ///if (dato < nodo.dato) { //agregar en el hijo izquierdo
            if (!dato.equals(nodo.dato)) {
                nodo.izq = insertar(nodo.izq, dato);
            } else { //agregar en el hijo derecho
                nodo.der = insertar(nodo.der, dato);
            }

        }

        return nodo;
    }

    private void PreOrden(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + ", ");
            PreOrden(nodo.izq); //impime el arbol de forma recursiva
            PreOrden(nodo.der);
        }

    }

    private void InOrden(NodoBinario nodo) {
        if (nodo != null) {
            InOrden(nodo.izq); //impime el arbol de forma recursiva
            System.out.print(nodo.dato + ", ");
            InOrden(nodo.der);
        }

    }

    private void PostOrden(NodoBinario nodo) {
        if (nodo != null) {
            InOrden(nodo.izq); //impime el arbol de forma recursiva
            InOrden(nodo.der);
            System.out.print(nodo.dato + ", ");
        }

    }

}// fin de clase arbol Binario

