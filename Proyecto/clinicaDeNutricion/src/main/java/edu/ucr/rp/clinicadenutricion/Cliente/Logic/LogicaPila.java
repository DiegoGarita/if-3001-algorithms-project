package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.SuperAdmin;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.ArchSupAdmin;
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
    ArchSupAdmin logiSuper = new ArchSupAdmin();
    public int contadorHoras = 0;

    public void EscribeArchivoSolicitudCita(Cita cita) {

        SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        File newFile = new File(configuracion.getPathDeGuardado() + "\\ApartaCita.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            printStream.println(cita.getIDCita() + " & " + cita.getNombre() + " & " + cita.getFecha() + " & " + cita.getHora() + " & " + cita.getDoctora());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public void leeArchivoSolicitudCita() {
      //  SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
        File newFile = new File( "ApartaCita.txt");
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
                    }//end elseif
                }//end while 

                Cita cita = new Cita(IDCita, nombre, fecha, hora, doctor);
                implementacionPila.push(cita);

                currentRegistry = bufferedReader.readLine();

            }//end while

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }

    }// end readProperties()

    public void remueveLineaDelArchivo(String IDBuscar) {
      //  SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
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
            }//end switch

        }//end while

        Cita cita = new Cita(IDCita, nombre, fecha, hora, doctor);
        return cita;

    }//end token

    public String leeLinea(String identificador) {
    //    SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
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
    }// end readProperties()

    public ArrayList<String> leeArchivoHoraFecha(String date) {
      //  SuperAdmin configuracion = logiSuper.stringTokenizer(logiSuper.readLine("KEYDistancia"));
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

            }//end while

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
        return returned;
    }

    public int tamanio() {
        return contadorHoras;
    }

    public void elimina(Cita cita) {
        implementacionPila.pop(cita);
    }

}// end writeFileCitas
