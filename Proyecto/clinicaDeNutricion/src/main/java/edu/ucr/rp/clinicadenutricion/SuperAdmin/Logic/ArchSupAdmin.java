package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArchSupAdmin {

    LogicSuperAdmin crudListas = new LogicSuperAdmin();

    public void writeInFile(SuperAdmin nuevo) {
        File newFile = new File("SuperAdminConfig.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(nuevo.getIdentificadorSA() + "|" + nuevo.getAbreClinica() + "|" + nuevo.getCierreClinica() + "|"
                    + nuevo.getTiempoConsulta() + "|" + nuevo.getNombreLogo() + "|" + nuevo.getPathDeGuardado()
                    + "|" + nuevo.getPaginacion());

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

    public void replacefromfile(SuperAdmin nuevo) {
        File previousFile = new File("SuperAdminConfig.txt");

            previousFile.deleteOnExit();
      
        File fileNew = new File("SuperAdminConfig.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(nuevo.getIdentificadorSA() + "|" + nuevo.getAbreClinica() + "|" + nuevo.getCierreClinica() + "|"
                    + nuevo.getTiempoConsulta() + "|" + nuevo.getNombreLogo() + "|" + nuevo.getPathDeGuardado()
                    + "|" + nuevo.getPaginacion());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end replacefromfile(

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
    
public int cantidadDC = 0;
    
       public ArrayList<Usuario> guardaEnAL(String identificador) {
        ArrayList<Usuario> aL= new ArrayList<>();
        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (currentRegistry.contains(identificador)) {
                    aL.add(stringTokenizerUsuario(currentRegistry));
                    cantidadDC++;
                }
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return aL;
    }// end readProperties()
       
    public Usuario stringTokenizerUsuario(String lineas) {

        StringTokenizer stringTokenizer = new StringTokenizer(lineas, "|");
        int counterTokens = 0;
        String tipo = "";
        String ID = "";
        String nombre = "";
        String contraseña = "";
        String correo = "";
        String telefono = "";
        String direccion = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    tipo = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 1:
                    ID = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 2:
                    nombre = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 3:
                    contraseña = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 4:
                    correo = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 5:
                    telefono = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 6:
                    direccion = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }

        }

        Usuario u = new Usuario(tipo, ID, nombre, contraseña, correo, telefono, direccion);
        return u;

    }

}//end archSupAdmin
