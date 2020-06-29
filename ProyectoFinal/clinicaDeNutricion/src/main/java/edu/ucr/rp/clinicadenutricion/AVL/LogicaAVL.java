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

    /**
     * método que escribe en el archivo .txt del historial
     * @param acciones objeto que será insertado en el archivo
     */
    public void escribeHistorial(Acciones acciones) {

        File newFile = new File("Historial.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(acciones.getAccionador() + " & " + acciones.getAccion() + " & " + acciones.getFechaHoraAccion());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end escribeHistorial()

    /**
     * método que lee el archivo .txt del historial
     */
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
            //implementacionAVL.preOrden();

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }// end leerHistorial()

    /**
     * método que convierte una línea (String) en acciones (objeto)
     * @param lineas linea recibida 
     * @return objeto accion
     */
    public Acciones stringTokenizer(String lineas) {

        StringTokenizer stringTokenizer = new StringTokenizer(lineas, "&");
        String nombre = stringTokenizer.nextToken();
        String accion = stringTokenizer.nextToken();
        String fechaHora = stringTokenizer.nextToken();

        Acciones acciones = new Acciones(nombre, accion, fechaHora);
        return acciones;

    }
    
        public void muestra() {
        implementacionAVL.preOrden();
    }

}
