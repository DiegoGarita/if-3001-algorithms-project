package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.Logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PlanAlimentosLogic {

    public ArrayList<String> recetas = new ArrayList<>();
    public ArrayList<String> planes = new ArrayList<>();
    Logic logic = new Logic();

    public int Cantidad(String capta, String file, ArrayList<String> a) {
        int cant = 0;
        File newFile = new File(file + ".txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (currentRegistry.contains(capta)) {
                    currentRegistry = currentRegistry.substring(0, currentRegistry.length() - 1);
                    a.add(currentRegistry);
                    cant++;
                }
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return cant;
    }// end readProperties()

    public String readFile(String search, String file) {

        File newFile = new File(file + ".txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            int counter = 0;
            while (currentRegistry != null) {
                if (currentRegistry.contains(search)) {
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
