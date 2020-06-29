package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class LogicaArbol {

    ImplementacionArbol implementacionArbol = new ImplementacionArbol();

    /**
     * método que lee el archivo solicitud de cita para X cliente
     *
     * @param file nombre del cliente para leer del archivo
     * @param identificador verificador de líneas para validar si lo contiene
     * @return String con lo obtenido del archivo
     */
    public String leeArchivo(String file, int identificador) {

        File newFile = new File("Solicitud de cita para " + file + ".txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();
            int contador = 0;
            while (currentRegistry != null) {
                if (contador == identificador) {
                    implementacionArbol.insertar(stringTokenizer(currentRegistry));
                    returned += currentRegistry;
                    contador++;
                }
                contador++;
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return returned;
    }// end readProperties()

    /**
     * método que lee la cantidad de líneas encontradas en el archivo solicitud
     * de cita para X cliente
     *
     * @param file nombre del cliente para leer del archivo
     * @return cantidad de líneas encontradas
     */
    public int cantidadDeLineas(String file) {
        int cantidad = 0;
        File newFile = new File("Solicitud de cita para " + file + ".txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                cantidad++;
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return cantidad;
    }

    /**
     * método que convierte de String al objeto Reporte Médico
     *
     * @param lines recibe la línea a convertir
     * @return objeto Reporte Médico obtenido del String recibido
     */
    public ReporteMedico stringTokenizer(String lines) {

        StringTokenizer stringTokenizer = new StringTokenizer(lines, "|");
        int counterTokens = 0;
        String iD = "";
        String nombre = "";
        String fecha = "";
        String hora = "";
        String edad = "";
        String edadMetabolica = "";
        String altura = "";
        String peso = "";
        String porcenMasaMuscular = "";
        String grasa = "";
        String grasaVisceral = "";
        String hueso = "";
        String porcenAgua = "";
        String actividadFisica = "";
        String horasDeSueño = "";
        String textAreaNotas = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    iD = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 1:
                    nombre = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 2:
                    fecha = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 3:
                    hora = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 4:
                    edad = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 5:
                    edadMetabolica = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 6:
                    altura = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 7:
                    peso = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 8:
                    porcenMasaMuscular = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 9:
                    grasa = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 10:
                    grasaVisceral = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 11:
                    hueso = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 12:
                    porcenAgua = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 13:
                    actividadFisica = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 14:
                    horasDeSueño = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 15:
                    textAreaNotas = stringTokenizer.nextToken();
                    counterTokens++;
                    break;

                default:
                    break;
            }

        }

        ReporteMedico reporteMedico = new ReporteMedico(iD, nombre, fecha, hora, edad, edadMetabolica,
                altura, peso, porcenMasaMuscular, grasa, grasaVisceral, hueso, porcenAgua, actividadFisica,
                horasDeSueño, textAreaNotas);
        return reporteMedico;

    }
    
        public void muestra() {
        implementacionArbol.InOrden();
    }

}
