package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Citas;
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

public class SuperAdminLogic {

    ColaImplementacion c = new ColaImplementacion();

    public void writeFileCitas(Citas cita) {

        File newFile = new File("CITAadmi.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            // printStream.println(c.add(nombre) + "|" + contraseña + tipoDeToken);
          //  printStream.println(c.insertarCita(fecha + hora + porcenAgua + porcenMasaMuscular + grasa + grasaVisceral
          //         + hueso + edadMetabolica + peso + altura + horasDeSueño + edad + actividadFisica));

////          + hueso +  edadMetabolica+ peso + altura + horasDeSueño+ edad + actividadFisica));
//Citas c = new Citas(fecha, hora, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, actividadFisica);
            printStream.println(c.insertarCita(cita));
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    
//    public String readProperties(String nombre) {

//        File newFile = new File("CITAadmi.txt");
//        String lineKeeper = "";
//        try {
//            FileInputStream fileInputStream = new FileInputStream(newFile);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String currentRegistry = bufferedReader.readLine();
//
//            while (currentRegistry != null) {
//
//                if (currentRegistry.contains(nombre)) {
//                    lineKeeper = currentRegistry + " : Cliente : ";
//
//                }
//
//                currentRegistry = bufferedReader.readLine();
//            }
//            
//
//            StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "|");
//            lineKeeper += stringTokenizer.nextToken();
//
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.out.println(fileNotFoundException + ": Problemas con el archivo");
//        } catch (IOException IOException) {
//            System.out.println(IOException + ": Problemas con el archivo");
//        }
//        return lineKeeper+"_"+c.desplegarCola();
//    }// end readProperties()
    
    
}// end writeFileCitas
