package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;

class Node {

    Usuario element;
    Node next;

    public Node(Usuario usuario) {
        element = usuario;
        next = null;

    }

    Usuario seeElement() {

        return this.element;
    }

    Node seeNext() {

        return this.next;
    }

}

public class ImplementacionListas implements InterfaceListas {

    public ImplementacionListas() {
    }
    Node inicio, fin;

    /**
     *
     * @param usuario objeto usuario que será agregado a la lista
     */
    @Override
    public void add(Usuario usuario) {

        Node aux = inicio;

        if (aux == null) {

            aux = new Node(usuario);
            inicio = aux;

        } else {
            while (aux.next != null) {

                aux = aux.next;
            }
            aux.next = new Node(usuario);
            fin = aux.next;

        }
    }

    /**
     *
     * @param usuario objeto usuario que será removido de la lista
     */
    @Override
    public void remove(Usuario usuario) {

        if (isEmpty() == false) {
            if (inicio.equals(fin) && usuario.equals(inicio.element)) {
                inicio = fin = null;
            } else if (usuario.equals(inicio.element)) {
                inicio = inicio.next;

            } else {
                Node aux1, aux;
                aux1 = inicio;
                aux = inicio.next;

                while (!(aux.equals(null)) && !(aux.element.getName().equals(usuario.getName()))) {

                    aux1 = aux1.next;
                    aux = aux.next;
                    System.out.println(usuario.getName() + "== " + aux1.element.getName());
                }//end while
                if (aux != null) {
                    aux1.next = aux.next;
                    if (aux.equals(fin)) {
                        fin = aux1;
                    }
                }
            }
        }
    }

    /**
     *
     * @return booleano, true si está vacío, false si no está vacío
     */
    @Override
    public boolean isEmpty() {

        boolean empty = false;
        Node aux = inicio;

        if (aux == null) {
            return empty = true;
        } else {
            return empty;

        }
    }

    @Override
    public void display() {
        Node current = inicio;

        if (inicio == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("linked list: ");
        while (current != null) {
            System.out.print(current.element.getId() + "* ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     *
     * @param aBuscar busca un string en los nodos dentro de la lista
     * @return retorna booleano, true si lo encuentra y false si no lo encuentra
     */
    @Override
    public boolean search(String aBuscar) {
        Node current = inicio;
        while (current != null) {

            if (current.element.getName().equals(aBuscar) || current.element.getId().equals(aBuscar)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     *
     * @param index indice del Usuario a buscar
     * @return Usuario encontrado en el indice indicado
     */
    @Override
    public Usuario indexOf(int index) {

        Node aux = inicio;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext();
        }

        return aux.seeElement();

    }

    /**
     *
     * @return tamaño de la lista
     */
    @Override
    public int size() {

        int output = 0;
        Node aux = inicio;
        while (aux.next != null) {
            aux = aux.next;
            output++;
        }
        return output + 1;
    }
}
