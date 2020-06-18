package edu.ucr.rp.clinicadenutricion.AVL;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import static java.lang.Integer.max;

public class ImplementacionAVL {

    class Node {

        Acciones acciones;
        int altura;
        Node left, right;

        public Node(Acciones accion) {
            this.acciones = accion;
            this.altura = 1;
            this.left = null;
            this.right = null;
        }// end constructor() 
    }// end class Node()

    Node root;

    /**
     *
     * @param raiz raiz del arbol
     * @return devuelve la altura del arbol
     */
    public int altura(Node raiz) {
        if (raiz == null) {
            return 0;
        }//end if
        return raiz.altura;
    }// end altura()

    public int buscarAltura() {
        return altura(root);
    }// end buscarAltur()

    /**
     * metodo que equilibra arboles desbalanceados a la izquierda
     *
     * @param node
     * @return arbol balanceado
     */
    public Node rotacionDerecha(Node node) {
        Node hijoIzq = node.left;
        node.left = hijoIzq.right;
        hijoIzq.right = node;
        node.altura = Integer.max(altura(node.left), altura(node.right) + 1);
        hijoIzq.altura = Integer.max(altura(hijoIzq.left), altura(hijoIzq.right)) + 1;
        return hijoIzq;
    }// end rotacion derecha

    /**
     * metodo que equilibra arboles desbalanceados a la derecha
     *
     * @param node
     * @return arbol balanceado
     */
    public Node rotacionIzquierda(Node node) {
        Node hijoDer = node.right;
        node.right = hijoDer.left;
        hijoDer.left = node;
        node.altura = Integer.max(altura(node.left), altura(node.right)) + 1;
        hijoDer.altura = Integer.max(altura(hijoDer.left), altura(hijoDer.right)) + 1;
        return hijoDer;
    }// end rotacion derecha()

    /**
     * metodo para insertar elementos
     *
     * @param acciones
     */
    public void insertar(Acciones acciones) {
        root = InsertarNodo(root, acciones);
    }

    /**
     * Metodo que se relaciona con el metod de arriba
     *
     * @param node nodo raiz
     * @param acciones elemento a ingresar
     * @return
     */
    public Node InsertarNodo(Node node, Acciones acciones) {

        if (node == null) {

            node = new Node(acciones);
        } else {
            if (Integer.parseInt(acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", "")) < Integer.parseInt(root.acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", ""))) {

                node.left = InsertarNodo(node.left, acciones);

            } else {

                node.right = InsertarNodo(node.right, acciones);
            }

        }
        node.altura = max(altura(node.left), altura(node.right)) + 1;
        int balance = altura(node.left) - altura(node.right);
        if (balance > 1) {
            if (Integer.parseInt(acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", "")) < Integer.parseInt(node.left.acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", ""))) {
                // caso izq : izq
                node = rotacionDerecha(node);
            } else {
                // caso izq : der
                node.left = rotacionIzquierda(node.left);
                node = rotacionDerecha(node);
            }
            // caso der : der
        } else if (balance < -1) {
            if (Integer.parseInt(acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", "")) > Integer.parseInt(node.right.acciones.getFechaHoraAccion().substring(8, 19).replaceAll(":", "").replaceAll(" ", ""))) {
                node = rotacionIzquierda(node);
            } else {
                // caso der : izq
                node.right = rotacionDerecha(node.right);
                node = rotacionIzquierda(node);
            }

        }
        return node;
    }//end insertarNodo

    public void PreOrden() {
        PreOrden(root);
    }

    public void PreOrden(Node nodo) {
        if (nodo != null) {
            System.out.print(nodo.acciones.getFechaHoraAccion() + " , ");
            PreOrden(nodo.left);
            PreOrden(nodo.right);
        }
    }

    private int obtenerBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return altura(node.left) - altura(node.right);
    }

}// end class AVL

