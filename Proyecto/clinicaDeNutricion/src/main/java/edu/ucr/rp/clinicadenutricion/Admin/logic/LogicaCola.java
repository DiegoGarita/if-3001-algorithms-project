package edu.ucr.rp.clinicadenutricion.Admin.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.inicioSesion.logic.LogicaListas;
import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class LogicaCola {

    public ArrayList<Usuario> arrayListClientes = new ArrayList<>();
    ImplementacionCola implementacionCola = new ImplementacionCola();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();
    LogicaListas logicaListas = new LogicaListas();

    /**
     * método que escribe archivo .txt de solicitud de cita para X cliente
     *
     * @param reporteMedico objeto a agregar al archivo con todos sus atributos
     */
    public void escribeCitas(ReporteMedico reporteMedico) {

        File newFile = new File("Solicitud de cita para " + reporteMedico.getID() + ".txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(reporteMedico.getID() + "|" + reporteMedico.getNombre() + "|"
                    + reporteMedico.getFecha() + "|" + reporteMedico.getHora() + "|"
                    + reporteMedico.getEdad() + "|" + reporteMedico.getEdadMetabolica() + "|"
                    + reporteMedico.getAltura() + "|" + reporteMedico.getPeso() + "|"
                    + reporteMedico.getPorcentajeMasaMuscular() + "|" + reporteMedico.getGrasa() + "|"
                    + reporteMedico.getGrasaVisceral() + "|" + reporteMedico.getHueso() + "|"
                    + reporteMedico.getPorcentajeAgua() + "|" + reporteMedico.getActividadFisica() + "|"
                    + reporteMedico.getHorasDeSueño() + "|" + reporteMedico.getTextAreaNotas());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }

    /**
     * método que lee el archivo .txt de solicitud de cita para X cliente
     *
     * @param file nombre del archivo .txt que va a leer
     * @param identificador utilizado para comparar y validar posteriormente
     * @return String de lo que leyó en el archivo
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
                    implementacionCola.enqueue(stringTokenizer(currentRegistry));
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
     * método que lee el archivo .txt de solicitud de cita para X cliente y
     * devuelve línea en específico
     *
     * @param file nombre del .txt (cliente)
     * @param identificador identificador booleano para saber si se permite leer
     * más
     * @return String de las líneas leídas, utilizado en grafico
     */
    public String obtieneLineaEspecifica(String file, boolean identificador) {

        File newFile = new File("Solicitud de cita para " + file + ".txt");
        String returned = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            if (identificador == true) {

                while (currentRegistry != null) {
                    implementacionCola.enqueue(stringTokenizer(currentRegistry));
                    returned = currentRegistry;

                    currentRegistry = bufferedReader.readLine();
                }
            } else {
                return currentRegistry;
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return returned;
    }// end readProperties()

    /**
     * método que lee la cantidad de clientes de un archivo
     *
     * @param identificador filtro para leer cierto tipo de usuarios
     * @return cantidad de clientes encontrados
     */
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
                    arrayListClientes.add(logicaListas.stringTokenizer(currentRegistry));
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

    /**
     * método que lee la cantidad de líneas encontradas en el archivo de solicitud de cita para X cliente 
     * @param file recibe nombre del archivo (cliente)
     * @return cantidad de líneas encontradas en el archivo
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
    }// end readProperties()

    /**
     * método que une dos métodos para obtener usuarios apartir de un String
     * @param string string que será convertido
     * @return Usuario retornado por medio de los dos métodos utilizados 
     */
    public Usuario obtieneUsuario(String string) {
        return logicaListas.stringTokenizer(logicaListas.leeLinea(string));
    }

    /**
     * método que convierte de String al objeto Reporte Médico
     * @param lineas String a ser convertido
     * @return Reporte médico que viene de procesos con StringTokenizer
     */
    public ReporteMedico stringTokenizer(String lineas) {

        StringTokenizer stringTokenizer = new StringTokenizer(lineas, "|");
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

        ReporteMedico reporteMedico = new ReporteMedico(iD, nombre, fecha,
                hora, edad, edadMetabolica, altura, peso, porcenMasaMuscular,
                grasa, grasaVisceral, hueso, porcenAgua, actividadFisica, horasDeSueño, textAreaNotas);
        return reporteMedico;

    }

}
