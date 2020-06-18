package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;

public class ImplementacionArbol {

    public static class NodoBinario {

        ReporteMedico dato;
        NodoBinario izq, der;

        NodoBinario(ReporteMedico n) {
            dato = n;
            izq = null;
            der = null;
        }//fin de nodo binario
    }//fin de clase NodoBinario

    //puntero al nodo raiz del arbol sera nulo en un arbol vacio
    private NodoBinario raiz;

    public ImplementacionArbol() {
        this.raiz = null;
    }

    // metodos publicos
    public void insertar(ReporteMedico dato) {
        raiz = insertar(raiz, dato);
    }

////    public boolean BusquedaBinaria(int dato) {
////        return BusquedaBinaria(raiz, dato);
////    }
////
////    public void suprimir(int dato) {
////        raiz = suprimir(raiz, dato);
////    }
////
////    public int minValor() {
////        return minValor(raiz);
////    }

    public void PreOrden() {
        PreOrden(raiz);
    }

    public void PostOrden() {
        PostOrden(raiz);
    }

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
//
//    private boolean BusquedaBinaria(NodoBinario nodo, int dato) {
//        
//        while (nodo != null) { //mientras el nodo no sea nulo
//            if (nodo.dato == dato) {//si la raíz es el dato a buscar
//
//                return true; //retorna verdadero
//            } else if (nodo.dato > dato) { //si el dato del nodo es mayor al valor a buscar
//
//                nodo = nodo.izq; //nodo pasa a ser el de la izquierda
//            }//end else if
//            else {//else
//
//                nodo = nodo.der; //el nodo pasa a ser el de la derecha
//            }//end else    
//        }//end while
//
//        return false;//retorna falso si del todo no lo encontró
//    }
//
//    private NodoBinario suprimir(NodoBinario nodo, int n) {
//
//        NodoBinario actual = raiz;//guarda el nodo en actual a raíz (será primordial para comparar)
//
//        while (actual != null && actual.dato != n) {//mientras no sea nulo y el dato actual sea diferente al dato a buscar
//            nodo = actual;//actualiza el nodo
//
//            if (n < actual.dato) { //si es menor al nodo
//                actual = actual.izq;//se va a la izquierda
//            } else { //else
//                actual = actual.der;//se va a la derecha
//            }
//        }
//
//        if (actual == null) {//si el nodo actual es nulo
//            return raiz;//retorna la raíz 
//        }
//
//        //caso 1 el nodo a ser eliminado no tiene hijo, es un nodo hoja
//        if (actual.izq == null && actual.der == null) { //si la izquierda es nula y la derecha es nula (demuestra que no tiene hijos)
//            if (actual != raiz) { //si el nodo a ser eliminado es distinto al nodo raiz
//                if (nodo.izq == actual) { //si el nodo de la izquierda es el actual
//                    nodo.izq = null; //hace nulo a su izquierda
//                } else { //else
//                    nodo.der = null; //hace nulo a su derecha
//                }
//            } else {
//                raiz = null;//pone la raíz en nulo
//            }
//
//            //caso 2: el nodo a ser eliminado tiene dos hijos 
//        } else if (actual.izq != null && actual.der != null) { //si la izquierda y derecha del actual es diferente de nulo (demuestra que tiene ambos hijos)
//
//            int val = minValor(actual.der);//guarda el minimo valor de la actual derecha
//
//            suprimir(raiz, minValor(actual.der));//recursivamente elimina al sucesor
//
//            actual.dato = val;//reemplaza el valor de dato por el guardado anteriormente de la derecha
//            
//            //caso 3: el nodo que será eliminado tendrá un hijo
//        } else {
//            //encuentra al hijo en el nodo 
//            NodoBinario hijo = (actual.izq != null) ? actual.izq : actual.der;//operacion ternaria, guarda en un hijo el valor
//
//            if (actual != raiz) {   //si el nodo a ser eliminado no es raíz nodo 
//                if (actual == nodo.izq) {//si el nodo actual es nodo de la izquierda
//                    nodo.izq = hijo; //el nodo izquierda se guarda en el hijo 
//                } else {
//                    nodo.der = hijo; //el nodo derecha guarda el hijo
//                }
//               
//            } else { //si el nodo a ser eliminado es una raíz nodo
//                raiz = hijo;//establece la raíz en hijo
//            }
//        }
//
//        return raiz; //retorna la raiz
//    }
//
//    private int minValor(NodoBinario nodo) {
//
//        while (nodo.izq != null) {
//            nodo = nodo.izq;
//        }
//        return nodo.dato;
//    }

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

//    public static void main(String as[]) {
//        ImplementacionArbol a = new ImplementacionArbol();
//        a.insertar(10);
//        a.insertar(20);
//        a.insertar(6);
//        a.insertar(4);
//        a.insertar(3);
//        a.insertar(15);
//        a.insertar(5);
//        a.insertar(18);
//        a.insertar(12);
//        System.out.println("postOrden");
//        a.PostOrden();
//        System.out.println("");
//
//        System.out.println("preOrden");
//        a.PreOrden();
//        System.out.println("");
//
//        System.out.println("inOrden");
//        a.InOrden();
//        System.out.println("");
//
//        System.out.println("El menor valor: ");
//        System.out.println(a.minValor());
//        System.out.println("");
//
//        System.out.println("buscar 18");
//        System.out.println(a.BusquedaBinaria(18));
//        System.out.println("");
//
//        System.out.println("elminar el 10");
//        a.suprimir(10);
//        a.InOrden();
//
//    }

}// fin de clase arbol Binario


