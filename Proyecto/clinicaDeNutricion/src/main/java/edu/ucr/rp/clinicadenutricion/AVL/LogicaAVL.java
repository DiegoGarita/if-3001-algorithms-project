package edu.ucr.rp.clinicadenutricion.AVL;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
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

public class LogicaAVL {
    
    ImplementacionAVL implementacionAVL = new ImplementacionAVL();

    public void escribeHistorial(Acciones acciones) {

        File newFile = new File("Historial.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(acciones.getAccionador() + " & " + acciones.getAccion() + " & " + acciones.getFechaHoraAccion());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()
    
        public void leerHistorial() {

        File newFile = new File("Historial.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                implementacionAVL.insertar(stringTokenizer(currentRegistry));

                currentRegistry = bufferedReader.readLine();
            }
            //implementacionAVL.PreOrden();

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }// end readProperties()
        
        public Acciones stringTokenizer(String lineas) {

        StringTokenizer stringTokenizer = new StringTokenizer(lineas, "&");
        int counterTokens = 0;
        String nombre = "";
        String accion = "";
        String fechaHora = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    nombre = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 1:
                    accion = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 2:
                    fechaHora = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }

        }

            Acciones acciones = new Acciones(nombre, accion, fechaHora);
        return acciones;

    }

}
