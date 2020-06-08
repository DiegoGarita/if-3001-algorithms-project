package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

class Node {

    Usuario element;
    Node next;

    public Node(Usuario n) {
        element = n;
        next = null;

    } //end public

    Usuario seeElement() { //instancia para ver el elemento (utilizado solo en IndexOf)

        return this.element; //retorna al elemento recibido por public Node
    }// end seeElement

    Node seeNext() { //instancia para ver al siguiente

        return this.next; //retorna next
    } //ver siguiente

}

public class CRUD {

    public CRUD() {
    }
    Node inicio, fin;

    public void add(Usuario n) { //inserta un elemento en la lista

        Node aux = inicio; //auxiliar tipo nodo 

        if (aux == null) { //se pregunta si la lista está vacia

            aux = new Node(n); //se crea un primer objeto
            inicio = aux; //inicio es igual al auxiliar tipo Nodo con el elemento n que pasa como parámetro en el método

        } //end if
        else { //else
            while (aux.next != null) { //mientras el siguiente del auxiliar sea diferente de nulo

                aux = aux.next; //se le asigna la variable aux a los siguientes

            } // end while
            aux.next = new Node(n); //el auxiliar siguiente es siguiente nodo
            fin = aux.next; //la variable fin guarda al auxiliar siguiente

        }// end else  
    } //end add(Object n)

    public void remove(Usuario usuario) {

        if (isEmpty() == false) {
            if (inicio.equals(fin) && usuario.equals(inicio.element)) {
                inicio = fin = null;
            }//end if
            else if (usuario.equals(inicio.element)) {
                inicio = inicio.next;

            }// end else if
            else { //else
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
                    }//end if
                }//end if
            }//end else

        }//end IF

    } //end remove

    public boolean isEmpty() {

        boolean empty = false;
        Node aux = inicio;

        if (aux == null) {
            return empty = true;
        }// end if
        else { //else
            return empty;

        } // end else
    } 

    public Usuario newPassword(Usuario element, String pass) {
        Usuario u = element;
        Usuario user = new Usuario(u.getName(), pass, u.getTelefono(), u.getDireccion(), u.getCorreo(), u.getTipo());

        return user;
    }

    public void display() {
        Node current = inicio;

        if (inicio == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("linked list: ");
        while (current != null) {
            System.out.print(current.element.getContraseña() + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean search(String x) {
        Node current = inicio;   
        while (current != null) {

            if (current.element.getName().equals(x) || current.element.getContraseña().equals(x) || current.element.getContraseña().equals(x)) {
                return true;
            }
            current = current.next;
        }
        return false;    //data not found 
    }

    public Usuario indexOf(int index) {

        Node aux = inicio;

        for (int i = -1; i < index - 1; i++) {

            aux = aux.seeNext(); 
        } // end for

        return aux.seeElement();

    } //end indexOf

    public int size() {

        int output = 0;
        Node aux = inicio;
        while (aux.next != null) {
            aux = aux.next;
            output++;
        }// end while
        return output + 1; //retorna el output +1 por los indices

    }//end size

//        public boolean searchPassword(Usuario x){
//        Node current = inicio;    //Initialize current 
//        while (current != null){
//                   
//            if (current.element.getContraseña().equals(x.getName()))
//                return true;    //data found 
//            current = current.next; 
//        }
//        return false;    //data not found 
//    } 
//    public ArrayList<Object> getList() { //metodo getList (se le quito lo del parametro que recibia porque no era necesario)
//
//        ArrayList<Object> List = new ArrayList<Object>(); //crea lista
//        Node aux = inicio;//aux tipo nodo es igual a inicio
//
//        for (int i = 0; i <= (size() - 1); i++) { //for para recorrer la lista
//            List.add(i, aux.element); // = agrega al ArrayList
//            aux = aux.next; //recorre, aux igual al siguiente aux
//        }// end for
//
//        return List; //retorna la lista
//
//    }
    //        public void delete(Usuario usuario) {
//        usuario = null;
//
////        Node aux = inicio; //el auxiliar (nodo) se inicializa en inicio
////
//////        while (aux != null) { //si el auxiliar es diferente de nulo
////            System.out.println("while");
////
////            String lineKeeper = aux.element + "";
////            System.out.println(lineKeeper);
////            StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "|"); //string tokenizer
////            while (stringTokenizer.hasMoreTokens()) {
////                System.out.println("whileee");
////                String keeper = stringTokenizer.nextToken(); //mantiene el string para comparar
////                keeper = keeper.substring(1, keeper.length());
////
////                if (keeper.equals(usuario)) { //si es igual al nombre
////                    System.out.println("iffffff");
////                    System.out.println("será borrado :" + aux.element);
////                    aux.element = null;
////                    return;
////                } else {
////                    stringTokenizer.nextToken();
////                }
////            }
////
////            aux = aux.next; //para recorrer toda la lista de objetos
//////        }// end while
//
//    }
    //    public void removeLast() {//remueve el primer elemento 
//
//        var Object = fin.element; //objeto tipo var es el elemento final
//
//        if (inicio == fin.next) { //si el inicio es igual al siguiente del fin
//            inicio = fin = null; //inicio es igual a fin y es igual a nulo
//            System.out.println("esta vacio"); //imprime si está vacío
//        }//end if
//        else {//else
//            Node temporal = inicio;//el nodo temporal es igual a inicio
//            while (temporal.next != fin) { //mientras el siguiente temporal es diferente de fin
//                temporal = temporal.next; //temporal es igual al siguiente (recorre)
//
//            }//end while
//            fin = temporal; //fin es igual al temporal 
//            fin.next = null; //el siguiente del fin es nulo
//
//        }//end else
//    }// end removerLast
}
