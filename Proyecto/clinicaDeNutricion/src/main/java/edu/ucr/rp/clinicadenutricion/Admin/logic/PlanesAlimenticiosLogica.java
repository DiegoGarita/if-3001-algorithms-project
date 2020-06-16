package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlanesAlimenticiosLogica {

    public ArrayList<String> arrayListRecetas = new ArrayList<>();
    public ArrayList<String> arrayListPlanes = new ArrayList<>();
    LogicaListas logic = new LogicaListas();

    public int cantidadRecetas(String identificador, String nombreArchivo, ArrayList<String> mantieneLista) {
        int cantidad = 0;
        File newFile = new File(nombreArchivo + ".txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (currentRegistry.contains(identificador)) {
                    currentRegistry = currentRegistry.substring(0, currentRegistry.length() - 1);
                    mantieneLista.add(currentRegistry);
                    cantidad++;
                }
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return cantidad;
    }// end readProperties()

    public String leeArchivo(String buscar, String nombreArchivo) {

        File newFile = new File(nombreArchivo + ".txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            int counter = 0;
            while (currentRegistry != null) {
                if (currentRegistry.contains(buscar)) {
                    currentRegistry = currentRegistry.substring(0, currentRegistry.length() - 1);
                    do {
                        if (currentRegistry.contains("|")) {
                            currentRegistry = "";
                            counter++;
                        }
                        returned += currentRegistry + "\n";
                        currentRegistry = bufferedReader.readLine();

                    } while (counter < 5);
                } else {
                    currentRegistry = bufferedReader.readLine();
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return returned;
    }// end readProperties()

}
