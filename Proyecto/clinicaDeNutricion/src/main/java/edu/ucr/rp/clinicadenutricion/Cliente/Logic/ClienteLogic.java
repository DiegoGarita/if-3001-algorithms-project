package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
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


public class ClienteLogic {
   PilaImplementacion pilaImple = new PilaImplementacion();

    public void writeFileCitas(Cita cita) {

        File newFile = new File("ApartaCita.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            // printStream.println(c.add(nombre) + "|" + contraseña + tipoDeToken);
          //  printStream.println(c.insertarCita(fecha + hora + porcenAgua + porcenMasaMuscular + grasa + grasaVisceral
          //         + hueso + edadMetabolica + peso + altura + horasDeSueño + edad + actividadFisica));

////          + hueso +  edadMetabolica+ peso + altura + horasDeSueño+ edad + actividadFisica));
//Citas c = new Citas(fecha, hora, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, actividadFisica);
          //  printStream.println(c.push(Nombre+ " & " +fecha+ " & " +hora+ " & " +doctora));
         // printStream.println(c.push(cita.getNombre()+"&"+ cita.getFecha()+"&"+cita.getHora()+"&"+cita.getDoctora()));
         
         printStream.println(cita.getNombre()+" & "+ cita.getFecha()+" & "+cita.getHora()+" & "+cita.getDoctora() );
       
         
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    
    public void readProperties() {

        File newFile = new File("ApartaCita.txt");
        String lineKeeper = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                
                    lineKeeper = currentRegistry + " : Cliente : ";

                

                currentRegistry = bufferedReader.readLine();
            }
            
//  pilaImple.push(cita);
            StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "&");
            lineKeeper += stringTokenizer.nextToken();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
       // return lineKeeper;
    }// end readProperties()
    
    
}// end writeFileCitas
