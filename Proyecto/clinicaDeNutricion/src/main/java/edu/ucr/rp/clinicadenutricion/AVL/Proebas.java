package edu.ucr.rp.clinicadenutricion.AVL;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;

public class Proebas {

    public static void main(String[] args) {

        Acciones a1 = new Acciones("a1", "xxx", "Tue Jun 09 14:31:08 CST 2020");
        Acciones a2 = new Acciones("a2", "xxx", "Tue Jun 09 14:31:28 CST 2020");
        Acciones a3 = new Acciones("a3", "xxx", "Tue Jun 09 14:31:38 CST 2020");
        Acciones a4 = new Acciones("a4", "xxx", "Tue Jun 09 14:31:46 CST 2020");
        Acciones a5 = new Acciones("a5", "xxx", "Tue Jun 09 14:31:57 CST 2020");
        System.out.println(Integer.parseInt(a1.getFechaHoraAccion().substring(8, 19).replaceAll(" ", "").replaceAll(":", "")));
//
//        ImplementacionAVL avl = new ImplementacionAVL();
//        System.out.println("Ingresa a1");
//        avl.insertar(a1);
//        System.out.println("Ingresa a2");
//        avl.insertar(a2);
//        System.out.println("Ingresa a3");
//        avl.insertar(a3);
//        System.out.println("Ingresa a4");
//        avl.insertar(a4);
//        System.out.println("Ingresa a5");
//        avl.insertar(a5);
//        System.out.println("\nMuestra los elementos ingresados con PreOrden:");
//        avl.PreOrden();

    }

}
