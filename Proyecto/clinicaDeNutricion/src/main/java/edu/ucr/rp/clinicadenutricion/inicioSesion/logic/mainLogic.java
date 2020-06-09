package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mainLogic {

    public static void main(String[] args) {

        EncripMD5 m = new EncripMD5();

        String d = m.encriptar("gf", "Me");
        System.out.println(d);
        String j = m.desencriptar("gf", d);
        System.out.println(j);


     java.util.Date fecha = new Date();
        System.out.println(fecha);

    }

}
