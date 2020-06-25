package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArchSupAdmin {

    LogicSuperAdmin crudListas = new LogicSuperAdmin();

    public void writeInFile(SuperAdmin supAd) {
        File newFile = new File("SuperAdminConfig.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            if (newFile.length() == 0) {
                printStream.println("KEYDistancia|8|18|1|3.jpeg|C:\\source-code\\if-3001-algorithms-project\\Proyecto\\clinicaDeNutricion|3");
            }

            printStream.println(supAd.getIdentificadorSA() + "|" + supAd.getAbreClinica() + "|" + supAd.getCierreClinica() + "|"
                    + supAd.getTiempoConsulta() + "|" + supAd.getNombreLogo() + "|" + supAd.getPathDeGuardado()
                    + "|" + supAd.getPaginacion());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public void readInFile() {

        File newFile = new File("SuperAdminConfig.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                crudListas.add(stringTokenizer(currentRegistry));
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }// end readProperties()

    public void removeLineFromFile(String idSearched) {
        LogicSuperAdmin cr = new LogicSuperAdmin();
        File previousFile = new File("SuperAdminConfig.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(previousFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (!currentRegistry.contains(idSearched)) {

                    cr.add(stringTokenizer(currentRegistry));
                }
                currentRegistry = bufferedReader.readLine();
            }
            previousFile.deleteOnExit();
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + "\nProblemas con el archivo");
        }
        File fileNew = new File("SuperAdminConfig.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            for (int i = 0; i < cr.size(); i++) {  //---> Here
                printStream.println(cr.indexOf(i).getIdentificadorSA() + " | " + cr.indexOf(i).getAbreClinica() + " | "
                        + cr.indexOf(i).getCierreClinica() + " | " + cr.indexOf(i).getTiempoConsulta() + " | "
                        + cr.indexOf(i).getNombreLogo() + " | " + cr.indexOf(i).getPathDeGuardado() + " | "
                        + cr.indexOf(i).getPaginacion());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end removeLineFromFile(

    public SuperAdmin stringTokenizer(String lines) {

        StringTokenizer stringTokenizer = new StringTokenizer(lines, "|");
        int counterTokens = 0;
        String identificadorSA = "";
        String abreClinica = "";
        String cierreClinica = "";
        String TiempoConsulta = "";
        String NombreLogo = "";
        String pathDeGuardado = "";
        String paginacion = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    identificadorSA = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 1:
                    abreClinica = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 2:
                    cierreClinica = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 3:
                    TiempoConsulta = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 4:
                    NombreLogo = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 5:
                    pathDeGuardado = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 6:
                    paginacion = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }

        }

        SuperAdmin u = new SuperAdmin(identificadorSA, abreClinica, cierreClinica,
                TiempoConsulta, NombreLogo, pathDeGuardado, paginacion);
        return u;

    }

    public String readLine(String idIdentifier) {

        File newFile = new File("SuperAdminConfig.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                if (currentRegistry.contains(idIdentifier)) {
                    return currentRegistry;

                }

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return null;
    }// end readProperties()

    public int cantidadDeLineas() {
        int cantidad = 0;
        File newFile = new File("Historial.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                //arrayListClientes.add(logic.stringTokenizer(currentRegistry));
                cantidad++;

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return cantidad;
    }// end readProperties()

    public String leeArchivo(int identificador) {

        File newFile = new File("Historial.txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();
            int contador = 0;
            while (currentRegistry != null) {
                if (contador == identificador) {
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

    public Acciones stringTokenizerHistorial(String lines) {

        StringTokenizer stringTokenizer = new StringTokenizer(lines, "&");
        int counterTokens = 0;
        String Accionador = "";
        String accion = "";
        String fechaHoraAccion = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    Accionador = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 1:
                    accion = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 2:
                    fechaHoraAccion = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }

        }

        Acciones acciones = new Acciones(Accionador, accion, fechaHoraAccion);
        return acciones;

    }

}//end archSupAdmin
