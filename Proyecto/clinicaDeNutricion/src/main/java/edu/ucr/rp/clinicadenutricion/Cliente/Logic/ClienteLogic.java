package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Usuario;
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

    public void writeFileApartaCita(Cita cita) {

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
            printStream.println(cita.getNombre() + " & " + cita.getFecha() + " & " + cita.getHora() + " & " + cita.getDoctora());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public void readApartaCita() {

        File newFile = new File("ApartaCita.txt");
        String lineKeeper = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                StringTokenizer stringTokenizer = new StringTokenizer(currentRegistry, "&");
                int counterTokens = 0;
                String name = "";
                String fecha = "";
                String hora = "";
                String doc = "";

                while (stringTokenizer.hasMoreTokens()) {
                    if (counterTokens == 0) {
                        name = stringTokenizer.nextToken();
                        //  name = name.substring(1, name.length());
                        fecha = stringTokenizer.nextToken();
                        hora = stringTokenizer.nextToken();
                        counterTokens++;
                    } //end if
                    else if (counterTokens == 1) {
                        doc = stringTokenizer.nextToken();
                        counterTokens++;
                    }//end elseif
                }//end while interno

                Cita cita = new Cita(name, fecha, hora, doc);
                pilaImple.push(cita);

                currentRegistry = bufferedReader.readLine();
                System.out.println(currentRegistry);
            }//end while

            //StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "&");
            // lineKeeper += stringTokenizer.nextToken();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
    }// end readProperties()

    

}// end writeFileCitas
