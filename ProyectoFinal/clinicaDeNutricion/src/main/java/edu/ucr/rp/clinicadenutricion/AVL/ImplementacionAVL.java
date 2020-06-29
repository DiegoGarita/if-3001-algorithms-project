package edu.ucr.rp.clinicadenutricion.AVL;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import static java.lang.Integer.max;

public class ImplementacionAVL implements InterfaceAVL {

    class Node {

        Acciones acciones;
        int altura;
        Node left, right;

        public Node(Acciones accion) {
            this.acciones = accion;
            this.altura = 1;
            this.left = null;
            this.right = null;
        }
    }//end class Node

    Node root;

    /**
     * @param raiz raíz del árbol
     * @return devuelve la altura del árbol
     */
    @Override
    public int altura(Node raiz) {
        if (raiz == null) {
            return 0;
        }
        return raiz.altura;
    }//end altura()

    /**
     *
     * @return devuelve la altura del árbol
     */
    @Override
    public int buscarAltura() {
        return altura(root);
    }// end buscarAltura()

    /**
     * metodo que equilibra arboles desbalanceados a la izquierda
     *
     * @param node nodo recibido para realizar la rotación
     * @return árbol balanceado
     */
    @Override
    public Node rotacionDerecha(Node node) {
        Node hijoIzq = node.left;
        node.left = hijoIzq.right;
        hijoIzq.right = node;
        node.altura = Integer.max(altura(node.left), altura(node.right) + 1);
        hijoIzq.altura = Integer.max(altura(hijoIzq.left), altura(hijoIzq.right)) + 1;
        return hijoIzq;
    }// end rotacionDerecha()

    /**
     * metodo que equilibra arboles desbalanceados a la derecha
     *
     * @param node recibido para realizar la rotación
     * @return árbol balanceado
     */
    @Override
    public Node rotacionIzquierda(Node node) {
        Node hijoDer = node.right;
        node.right = hijoDer.left;
        hijoDer.left = node;
        node.altura = Integer.max(altura(node.left), altura(node.right)) + 1;
        hijoDer.altura = Integer.max(altura(hijoDer.left), altura(hijoDer.right)) + 1;
        return hijoDer;
    }// end rotacionIzquierda()

    /**
     * @param acciones es el objeto Acciones para insertarlas
     */
    @Override
    public void insertar(Acciones acciones) {
        root = insertarNodo(root, acciones);
    }//insertar()

    /**
     * @param node nodo raiz
     * @param acciones elemento a ingresar, en este caso acciones
     * @return retorna el nodo de acciones
     */
    @Override
    public Node insertarNodo(Node node, Acciones acciones) {

        if (node == null) {
            node = new Node(acciones);
        } else {
            if (Integer.parseInt(acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", "")) < Integer.parseInt(root.acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", ""))) {
                node.left = insertarNodo(node.left, acciones);

            } else {
                node.right = insertarNodo(node.right, acciones);
            }
        }
        node.altura = max(altura(node.left), altura(node.right)) + 1;
        int balance = altura(node.left) - altura(node.right);
        if (balance > 1) {
            if (Integer.parseInt(acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", "")) < Integer.parseInt(node.left.acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", ""))) {
                node = rotacionDerecha(node);
            } else {
                node.left = rotacionIzquierda(node.left);
                node = rotacionDerecha(node);
            }
        } else if (balance < -1) {
            if (Integer.parseInt(acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", "")) > Integer.parseInt(node.right.acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", ""))) {
                node = rotacionIzquierda(node);
            } else {
                node.right = rotacionDerecha(node.right);
                node = rotacionIzquierda(node);
            }

        }
        return node;
    }//end insertarNodo()

    @Override
    public void preOrden() {
        preOrden(root);
    }//end preOrden()

    /**
     * 
     * @param nodo recibe el nodo a mostrar en preorden
     */
    @Override
    public void preOrden(Node nodo) {
        if (nodo != null) {
            System.out.print(nodo.acciones.getAccion() + ", ");
            preOrden(nodo.left);
            preOrden(nodo.right);
        }
    }

}// end class ImplementacionAVL

