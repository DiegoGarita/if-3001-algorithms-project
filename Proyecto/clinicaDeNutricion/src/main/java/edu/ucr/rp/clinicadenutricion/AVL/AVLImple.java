package edu.ucr.rp.clinicadenutricion.AVL;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;

public class AVLImple {

    class Node {

        Acciones acc;
        int altura;
        Node left, right;

        public Node(Acciones x) {
            this.acc = x;
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
     * @param n
     * @return arbol balanceado
     */
    public Node rotacionDerecha(Node n) {
        Node hijoIzq = n.left;
        n.left = hijoIzq.right;
        hijoIzq.right = n;
        n.altura = Integer.max(altura(n.left), altura(n.right) + 1);
        hijoIzq.altura = Integer.max(altura(hijoIzq.left), altura(hijoIzq.right)) + 1;
        return hijoIzq;
    }// end rotacion derecha

    /**
     * metodo que equilibra arboles desbalanceados a la derecha
     *
     * @param n
     * @return arbol balanceado
     */
    public Node rotacionIzquierda(Node n) {
        Node hijoDer = n.right;
        n.right = hijoDer.left;
        hijoDer.left = n;
        n.altura = Integer.max(altura(n.left), altura(n.right)) + 1;
        hijoDer.altura = Integer.max(altura(hijoDer.left), altura(hijoDer.right)) + 1;
        return hijoDer;
    }// end rotacion derecha()

    /**
     * metodo para insertar elementos
     *
     * @param x
     */
    public void insertar(Acciones x) {
        root = InsertarNodo(root, x);
    }

    /**
     * Metodo que se relaciona con el metod de arriba
     *
     * @param n nodo raiz
     * @param x elemento a ingresar
     * @return
     */
    public Node InsertarNodo(Node n, Acciones x) {

        if (n == null) {

            n = new Node(x);
        } else {

            if (x < n.acc) {

                n.left = InsertarNodo(n.left, x);

            } else {

                n.right = InsertarNodo(n.right, x);
            }

        }
        n.altura = Integer.max(altura(n.left), altura(n.right)) + 1;
        int balance = altura(n.left) - altura(n.right);
        if (balance > 1) {
            if (x < n.left.acc) {
                // caso izq : izq
                n = rotacionDerecha(n);
            } else {
                // caso izq : der
                n.left = rotacionIzquierda(n.left);
                n = rotacionDerecha(n);
            }
            // caso der : der
        } else if (balance < -1) {
            if (x > n.right.acc) {
                n = rotacionIzquierda(n);
            } else {
                // caso der : izq
                n.right = rotacionDerecha(n.right);
                n = rotacionIzquierda(n);
            }

        }
        return n;
    }//end insertarNodo

    /**
     * metodo para buscar
     *
     * @param valor elemento por buscar
     * @return
     */
    public boolean buscar(int valor) {
        Node node = buscar(root, valor);
        if (node == null) {

            return false;
        }// enf if

        return true;

    }//end buscar

    /**
     * metodo que se relaciona con el metodo de arriba
     *
     * @param raiz
     * @param valor
     * @return
     */
    public Node buscar(Node raiz, int valor) {
        if (raiz == null) {
            return null;
        } else {
            if (valor == raiz.value) {
                return raiz;
            } else if (valor < raiz.value) {
                return buscar(raiz.left, valor);
            } else {
                return buscar(raiz.right, valor);
            }// end else raiz.right    
        }// end else
    }// end method()

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
            System.out.print(nodo.value + " , ");
            // estamos haciendo una impresion del
            //arbol de forma recursiva
            PreOrden(nodo.left);
            PreOrden(nodo.right);
        }
    }// end ProeOrden()

    public void InOrden() {
        InOrden(root);
    }

    /**
     * metodo de ordenamiento de arbol
     *
     * @param nodo
     */
    private void InOrden(Node nodo) {
        if (nodo != null) {

            InOrden(nodo.left);
            System.out.print(nodo.value + " , ");
            InOrden(nodo.right);
        }
    }//end inOrden

    /**
     * metodo que nos indica el balance del arbol
     *
     * @param N
     * @return
     */
    private int obtenerBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return altura(N.left) - altura(N.right);
    }

}// end class AVL

