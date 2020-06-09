package edu.ucr.rp.clinicadenutricion.Admin.logic;

import java.io.*;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;


public class AdminLogic {
    
     ColaImpl c = new ColaImpl();

    public void writeFileCitas(String fecha, String hora, String actividadFisica,
            double porcenAgua, double porcenMasaMuscular, double grasa,
            double grasaVisceral, double hueso, double edadMetabolica,
            double peso, double altura, int horasDeSueño, int edad, TextArea textAreaNotas) {

        File newFile = new File("ApartaCita.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            // printStream.println(c.add(nombre) + "|" + contraseña + tipoDeToken);
            printStream.println(c.enqueue(fecha + hora + porcenAgua + porcenMasaMuscular + grasa + grasaVisceral
                  + hueso + edadMetabolica + peso + altura + horasDeSueño + edad + actividadFisica));

////          + hueso +  edadMetabolica+ peso + altura + horasDeSueño+ edad + actividadFisica));
//Citas c = new Citas(fecha, hora, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, actividadFisica);
          //  printStream.println(c.push(Nombre+ " & " +fecha+ " & " +hora+ " & " +doctora));
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()
    
}
    

