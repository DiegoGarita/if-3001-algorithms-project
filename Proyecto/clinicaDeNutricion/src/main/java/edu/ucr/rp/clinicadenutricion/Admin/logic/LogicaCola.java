package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class LogicaCola {

    ImplementacionCola implementacionCola = new ImplementacionCola();

    public ArrayList<Usuario> arrayListClientes = new ArrayList<>();
    LogicaListas logic = new LogicaListas();

    public void escribeCitas(ReporteMedico reporteMedico) {

        File newFile = new File("Solicitud de cita para " + reporteMedico.getID() + ".txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(reporteMedico.getID() + "|" + reporteMedico.getNombre() + "|" + reporteMedico.getFecha() + "|" + reporteMedico.getHora() + "|" + reporteMedico.getEdad() + "|" + reporteMedico.getEdadMetabolica() + "|" + reporteMedico.getAltura() + "|" + reporteMedico.getPeso() + "|" + reporteMedico.getPorcenMasaMuscular() + "|" + reporteMedico.getGrasa() + "|" + reporteMedico.getGrasaVisceral() + "|" + reporteMedico.getHueso() + "|" + reporteMedico.getPorcenAgua() + "|" + reporteMedico.getActividadFisica() + "|" + reporteMedico.getHorasDeSueño() + "|" + reporteMedico.getTextAreaNotas());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public String leeArchivo(String file) {

        File newFile = new File("Solicitud de cita para " + file + ".txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                implementacionCola.enqueue(stringTokenizer(currentRegistry));
                returned += currentRegistry + "\n";

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return returned;
    }// end readProperties()

    public String obtieneUltimo(String file) {

        File newFile = new File("Solicitud de cita para " + file + ".txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                implementacionCola.enqueue(stringTokenizer(currentRegistry));
                returned = currentRegistry;

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return returned;
    }// end readProperties()

    public int cantidadDeClientes(String identificador) {
        int cantidad = 0;
        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (currentRegistry.contains(identificador)) {
                    arrayListClientes.add(logic.stringTokenizer(currentRegistry));
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

    public Usuario obtieneUsuario(String s) {
        return logic.stringTokenizer(logic.leeLinea(s));
    }

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

        ReporteMedico reporteMedico = new ReporteMedico(iD, nombre, fecha, hora, edad, edadMetabolica, altura, peso, porcenMasaMuscular, grasa, grasaVisceral, hueso, porcenAgua, actividadFisica, horasDeSueño, textAreaNotas);
        return reporteMedico;

    }

}
