package edu.ucr.rp.clinicadenutricion.AVL;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;

public interface InterfaceAVL {

    public int altura(ImplementacionAVL.Node raiz);

    public int buscarAltura();

    public ImplementacionAVL.Node rotacionDerecha(ImplementacionAVL.Node node);

    public ImplementacionAVL.Node rotacionIzquierda(ImplementacionAVL.Node node);

    public void insertar(Acciones acciones);

    public ImplementacionAVL.Node insertarNodo(ImplementacionAVL.Node node, Acciones acciones);

    public void preOrden();

    public void preOrden(ImplementacionAVL.Node nodo);

}
