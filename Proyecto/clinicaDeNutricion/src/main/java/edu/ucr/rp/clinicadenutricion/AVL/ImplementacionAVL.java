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

    /**
     * Se relaciona con el metodo de arriba
     *
     * @return altura
     */
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

    /**
     * metodo para buscar
     *
     * @param valor elemento por buscar
     * @return
     */
//    public boolean buscar(int valor) {
//        Node node = buscar(root, valor);
//        if (node == null) {
//
//            return false;
//        }// enf if
//
//        return true;
//
//    }//end buscar
    /**
     * metodo que se relaciona con el metodo de arriba
     *
     * @param raiz
     * @param valor
     * @return
     */
//    public Node buscar(Node raiz, int valor) {
//        if (raiz == null) {
//            return null;
//        } else {
//            if (valor == raiz.value) {
//                return raiz;
//            } else if (valor < raiz.value) {
//                return buscar(raiz.left, valor);
//            } else {
//                return buscar(raiz.right, valor);
//            }// end else raiz.right    
//        }// end else
//    }// end method()
    public void PreOrden() {
        PreOrden(root);
    }

    /**
     * metodo de ordenamiento de arbol
     *
     * @param nodo
     */
    public void PreOrden(Node nodo) {
        // pregunta si el nodo esta vacio
        // METODO RECURSIVO :(
        if (nodo != null) {
            System.out.print(nodo.acciones.getFechaHoraAccion() + " , ");
            // estamos haciendo una impresion del
            //arbol de forma recursiva
            PreOrden(nodo.left);
            PreOrden(nodo.right);
        }
    }// end ProeOrden()
//
//    public void InOrden() {
//        InOrden(root);
//    }

    /**
     * metodo de ordenamiento de arbol
     *
     * @param nodo
     */
//    private void InOrden(Node nodo) {
//        if (nodo != null) {
//
//            InOrden(nodo.left);
//            System.out.print(nodo.value + " , ");
//            InOrden(nodo.right);
//        }
//    }//end inOrden
    /**
     * metodo que nos indica el balance del arbol
     *
     * @param node
     * @return
     */
    private int obtenerBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return altura(node.left) - altura(node.right);
    }

}// end class AVL

