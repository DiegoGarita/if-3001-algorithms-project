package edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Acciones;
import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.Utilitario.FechaHora;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class LogicaSuperAdmin {

    ImplementacionCola implementacionCola = new ImplementacionCola();
    FechaHora fechaHora = new FechaHora();

    public int cantidadDC = 0;

    /**
     * método que escribe en el archivo .txt
     *
     * @param superAdmin elemento superAdmin agregado en el archivo .txt
     */
    public void writeInFile(SuperAdmin superAdmin) {
        File newFile = new File("SuperAdminConfig.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(superAdmin.getIdentificadorSA() + "|" + superAdmin.getAbreClinica() + "|" + superAdmin.getCierreClinica() + "|"
                    + superAdmin.getTiempoConsulta() + "|" + superAdmin.getNombreLogo() + "|" + superAdmin.getPathDeGuardado()
                    + "|" + superAdmin.getPaginacion());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }

    /**
     * método que lee el archivo SuperAdminConfig.txt y agrega en la lista
     */
    public void readInFile() {

        File newFile = new File("SuperAdminConfig.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                implementacionCola.add(stringTokenizer(currentRegistry));
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }

    /**
     * método que reemplaza por completo el archivo por uno actual
     *
     * @param superAdmin nuevo objeto superAdmin que será agregado al nuevo .txt
     */
    public void replacefromfile(SuperAdmin superAdmin) {
        File previousFile = new File("SuperAdminConfig.txt");

        //previousFile.deleteOnExit();  //--> Here
          previousFile.delete();
        
        File fileNew = new File("SuperAdminConfig.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(superAdmin.getIdentificadorSA() + "|" + superAdmin.getAbreClinica() + "|" + superAdmin.getCierreClinica() + "|"
                    + superAdmin.getTiempoConsulta() + "|" + superAdmin.getNombreLogo() + "|" + superAdmin.getPathDeGuardado()
                    + "|" + superAdmin.getPaginacion());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }

    /**
     * método que convierte un String a un objeto SuperAdmin
     *
     * @param lines linea que será convertida
     * @return objeto SuperAdmin que será obtenido de la línea parámetro
     */
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

        SuperAdmin superAdmin = new SuperAdmin(identificadorSA, abreClinica, cierreClinica,
                TiempoConsulta, NombreLogo, pathDeGuardado, paginacion);
        return superAdmin;

    }

    /**
     * método que lee una línea específica del archivo SuperAdminConfig.txt
     *
     * @param idIdentifier identificador para leer línea exacta
     * @return String obtenido de la línea leída
     */
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
    }

    /**
     * método que lee la cantidad de líneas encontradas en el archivo
     * Historial.txt
     *
     * @return retorna el número de líneas encontradas en el archivo
     * Historial.txt
     */
    public int cantidadDeLineas() {
        int cantidad = 0;
        File newFile = new File("Historial.txt");
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
    }// end readProperties()

    /**
     * método que lee líneas específica deL archivo Historial.txt
     *
     * @param identificador se utiliza para obtener líneas específica
     * @return líneas encontradas que coinciden con el identificador en el
     * archivo Historial.txt
     */
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

    /**
     * método que convierte un String en el objeto Acciones
     *
     * @param lines String a ser convertido
     * @return objeto Acciones obtenido del String ingresado como parámetro
     */
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

    /**
     * método que guarda en arrayList los usuarios
     *
     * @param identificador identificador para validar que tipo de usuario se
     * ingresa
     * @return retorna ArrayList con usuarios (objeto)
     */
    public ArrayList<Usuario> guardaEnAL(String identificador) {
        ArrayList<Usuario> arrayListUsuarios = new ArrayList<>();
        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (currentRegistry.contains(identificador)) {
                    arrayListUsuarios.add(stringTokenizerUsuario(currentRegistry));
                    cantidadDC++;
                }
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return arrayListUsuarios;
    }

    /**
     * método que convierte un String en el objeto Usuario
     *
     * @param lineas String a ser convertido
     * @return objeto Usuario obtenido del String ingresado como parámetro
     */
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

        Usuario usuario = new Usuario(tipo, ID, nombre, contraseña, correo, telefono, direccion);
        return usuario;

    }

    /**
     * método que muestra la lista
     */
    public void muestra() {
        implementacionCola.display();
    }
    
    
    /**
 * método que elimina el historial en el archivo Historial.txt
 */
    public void eliminaHistorial() {
        File previousFile = new File("Historial.txt");
        previousFile.delete();
        File fileNew = new File("Historial.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.print("SuperAdmin" + " & " + "Eliminó el historial" + " & " + fechaHora.histoFechaHora());
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }
    

}
