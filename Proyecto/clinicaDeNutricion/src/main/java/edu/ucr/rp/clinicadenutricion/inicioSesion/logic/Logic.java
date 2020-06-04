package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Logic{

    CRUD c = new CRUD();

    public void writeFileCatalogue(String nombre, String contraseña, String tipo) {

        File newFile = new File("usuarios.txt");
        String tipoDeToken = "";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            if (tipo.equals("Cliente")) {
                tipoDeToken = "-";
            } else if (tipo.equals("Admin")) {
                tipoDeToken = "+";
            } else if (tipo.equals("SuperAdmin")) {
                tipoDeToken = "*";
            }

            printStream.println(c.add(nombre) + "|" + contraseña + tipoDeToken);

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public String readProperties(String nombre) {

        File newFile = new File("usuarios.txt");
        String lineKeeper = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                if (currentRegistry.contains(nombre)) {
                    lineKeeper = currentRegistry + " : Cliente : ";

                }

                currentRegistry = bufferedReader.readLine();
            }
            

            StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "|");
            lineKeeper += stringTokenizer.nextToken();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
        return lineKeeper+"_"+c.getList().get(0);
    }// end readProperties()

}
