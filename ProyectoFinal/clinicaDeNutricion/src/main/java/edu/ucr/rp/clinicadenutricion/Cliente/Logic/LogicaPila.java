package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class LogicaPila {

    ImplementacionPila implementacionPila = new ImplementacionPila();
    public int contadorHoras = 0;

    /**
     * método que escribe el archivo ApartaCita
     *
     * @param cita cita que será escrita en el archivo
     */
    public void EscribeArchivoSolicitudCita(Cita cita) {

        File newFile = new File("ApartaCita.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(cita.getIDCita() + " & " + cita.getNombre() + " & " + cita.getFecha() + " & " + cita.getHora() + " & " + cita.getDoctora());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }

    /**
     * método que lee el archivo ApartaCita para hacer push de las citas
     */
    public void leeArchivoSolicitudCita() {
        File newFile = new File("ApartaCita.txt");
        String currentRegistry = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                StringTokenizer stringTokenizer = new StringTokenizer(currentRegistry, "&");
                int counterTokens = 0;
                String IDCita = "";
                String nombre = "";
                String fecha = "";
                String hora = "";
                String doctor = "";

                while (stringTokenizer.hasMoreTokens()) {
                    if (counterTokens == 0) {
                        IDCita = stringTokenizer.nextToken();
                        nombre = stringTokenizer.nextToken();
                        fecha = stringTokenizer.nextToken();
                        hora = stringTokenizer.nextToken();
                        doctor = stringTokenizer.nextToken();
                        counterTokens++;
                    }
                }

                Cita cita = new Cita(IDCita, nombre, fecha, hora, doctor);
                implementacionPila.push(cita);

                currentRegistry = bufferedReader.readLine();

            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }

    }

    /**
     * método que elimina/remueve línea del archivo ApartaCita
     *
     * @param IDBuscar identificador para eliminar línea específico
     */
    public void remueveLineaDelArchivo(String IDBuscar) {

        ImplementacionPila implementacionPila = new ImplementacionPila();
        File previousFile = new File("ApartaCita.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(previousFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (!currentRegistry.contains(IDBuscar)) {
                    implementacionPila.push(stringTokenizer(currentRegistry));
                }
                currentRegistry = bufferedReader.readLine();
            }
            previousFile.deleteOnExit();
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + "\nProblemas con el archivo");
        }
        File fileNew = new File("ApartaCita.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            for (int i = 0; i < implementacionPila.size(); i++) {
                printStream.println(implementacionPila.indexOf(i).getIDCita() + "&" + implementacionPila.indexOf(i).getNombre()
                        + "&" + implementacionPila.indexOf(i).getFecha() + "&"
                        + implementacionPila.indexOf(i).getHora() + "&" + implementacionPila.indexOf(i).getDoctora());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end remueveLineaDelArchivo(

    /**
     * método que convierte String en el Objeto Cita
     *
     * @param linea String recibido a convertir
     * @return Objeto tipo Cita
     */
    public Cita stringTokenizer(String linea) {

        StringTokenizer stringTokenizer = new StringTokenizer(linea, "&");
        int counterTokens = 0;
        String IDCita = "";
        String nombre = "";
        String fecha = "";
        String hora = "";
        String doctor = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    IDCita = stringTokenizer.nextToken();
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
                    doctor = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }

        }

        Cita cita = new Cita(IDCita, nombre, fecha, hora, doctor);
        return cita;

    }

    /**
     * método que lee línea especifico del archivo ApartaCita
     *
     * @param identificador recibe identificador de la linea que se busca leer
     * @return retorna línea que contiene el identificador
     */
    public String leeLinea(String identificador) {
        File newFile = new File("ApartaCita.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                if (currentRegistry.contains(identificador)) {
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
     * método que lee especificamente fecha y hora del archivo ApartaCita
     *
     * @param date recibe identificador de la fecha
     * @return retorna ArrayList de las fechas obtenidas en similitud con el
     * identificador
     */
    public ArrayList<String> leeArchivoHoraFecha(String date) {

        File newFile = new File("ApartaCita.txt");
        ArrayList<String> returned = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();
            contadorHoras = 0;
            while (currentRegistry != null) {
                if (currentRegistry.contains(date)) {
                    contadorHoras++;
                    Cita c = stringTokenizer(currentRegistry);
                    returned.add(c.getHora().substring(1, 3));
                }

                currentRegistry = bufferedReader.readLine();

            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
        return returned;
    }

    /**
     * método que devuelve el tamaño del contador de horas utilizado en
     * leeArchivoHoraFecha()
     *
     * @return cantidad de horas encontradas en el método anterior
     */
    public int tamanio() {
        return contadorHoras;
    }

    /**
     * método que elimina la cita de la pila
     *
     * @param cita cita a eliminar
     */
    public void elimina(Cita cita) {
        implementacionPila.pop(cita);
    }

    /**
     * método booleano que verifica si existe una cita específica en el archivo
     * ApartaCita
     *
     * @param identificador para hacer la búsqueda específica
     * @param usuarioIngresado para buscar directamente del usuario
     * @return booleano, true si encuentra y false si no encuentra
     */
    public boolean existeCita(String identificador, String usuarioIngresado) {

        File newFile = new File("ApartaCita.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                StringTokenizer stringTokenizerprev = new StringTokenizer(currentRegistry, "&");
                stringTokenizerprev.nextToken();
                String usuario = stringTokenizerprev.nextToken();
                if (usuario.trim().equals(usuarioIngresado.trim())) {
                    StringTokenizer stringTokenizer = new StringTokenizer(currentRegistry, "&");
                    String id = stringTokenizer.nextToken();
                    if (id.trim().equals(identificador.trim())) {
                        return true;

                    }

                }
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
        return false;
    }
    
        public void muestra() {
        implementacionPila.display();
    }

}
