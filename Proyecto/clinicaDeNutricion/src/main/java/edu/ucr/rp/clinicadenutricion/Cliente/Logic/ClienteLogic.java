package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Cita;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ClienteLogic {

    PilaImplementacion crudPila = new PilaImplementacion();

    public void writeFileApartaCita(Cita cita) {

        File newFile = new File("ApartaCita.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            // printStream.println(c.add(nombre) + "|" + contraseña + tipoDeToken);
            //  printStream.println(c.insertarCita(fecha + hora + porcenAgua + porcenMasaMuscular + grasa + grasaVisceral
            //         + hueso + edadMetabolica + peso + altura + horasDeSueño + edad + actividadFisica));
////          + hueso +  edadMetabolica+ peso + altura + horasDeSueño+ edad + actividadFisica));
//Citas c = new Citas(fecha, hora, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, actividadFisica);
            //  printStream.println(c.push(Nombre+ " & " +fecha+ " & " +hora+ " & " +doctora));
            // printStream.println(c.push(cita.getNombre()+"&"+ cita.getFecha()+"&"+cita.getHora()+"&"+cita.getDoctora()));
            printStream.println(cita.getIdCita() + " & " + cita.getNombre() + " & " + cita.getFecha() + " & " + cita.getHora() + " & " + cita.getDoctora());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public void readApartaCita() {

        File newFile = new File("ApartaCita.txt");
        String lineKeeper = "";
        String currentRegistry = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                StringTokenizer stringTokenizer = new StringTokenizer(currentRegistry, "&");
                int counterTokens = 0;
                String idDeCita = "";
                String name = "";
                String fecha = "";
                String hora = "";
                String doc = "";

                while (stringTokenizer.hasMoreTokens()) {
                    if (counterTokens == 0) {
                        idDeCita = stringTokenizer.nextToken();
                        name = stringTokenizer.nextToken();
                        fecha = stringTokenizer.nextToken();
                        hora = stringTokenizer.nextToken();
                     //   counterTokens++;
                   // } //end if
                  //  else if (counterTokens == 1) {
                        doc = stringTokenizer.nextToken();
                        counterTokens++;
                    }//end elseif
                }//end while interno

                Cita cita = new Cita(idDeCita, name, fecha, hora, doc);
                crudPila.push(cita);

                currentRegistry = bufferedReader.readLine();
                //System.out.println(currentRegistry);
                // return currentRegistry;
            }//end while

//            StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "&");
//            lineKeeper = stringTokenizer.nextToken();
            // return lineKeeper;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            System.out.println(IOException + ": Problemas con el archivo");
        }
        //   return "*";
    }// end readProperties()

    public void removeLineFromFile(String idSearched) {
        // CRUD cr = new CRUD();
        //  pilaImple
          PilaImplementacion rett = new PilaImplementacion();
        File previousFile = new File("ApartaCita.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(previousFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (!currentRegistry.contains(idSearched)) {
                    // cr.add(stringTokenizer(currentRegistry));
                    rett.push(stringTokenizer(currentRegistry));
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
            //  for (int i = 0; i < cr.size(); i++) {
            for (int i = 0; i < rett.size(); i++) {
                printStream.println(rett.indexOf(i).getIdCita() + "&" + rett.indexOf(i).getNombre()
                        + "&" + rett.indexOf(i).getFecha() + "&"
                        + rett.indexOf(i).getHora() + "&" + rett.indexOf(i).getDoctora());
                // printStream.println(pilaImple.indexOf(i).getTipo() + "|" + cr.indexOf(i).getId() + "|" + cr.indexOf(i).getName() + "|" + cr.indexOf(i).getContraseña() + "|" + cr.indexOf(i).getCorreo() + "|" + cr.indexOf(i).getTelefono() + "|" + cr.indexOf(i).getDireccion());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end removeLineFromFile(

    public Cita stringTokenizer(String lines) {

        StringTokenizer stringTokenizer = new StringTokenizer(lines, "&");
        int counterTokens = 0;
        String idDeCita = "";
        String nombre = "";
        String fecha = "";
        String hora = "";
        String doc = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    idDeCita = stringTokenizer.nextToken();
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
                    doc = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }//end switch

        }//end while

        //  Usuario u = new Usuario(type, id, name, password, email, phone, direction);
        Cita cita = new Cita(idDeCita, nombre, fecha, hora, doc);  //--> nombre fecha hota doc
        return cita;

    }//end token

    public String readLine(String idIdentifier) {

        File newFile = new File("ApartaCita.txt");
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

    public Cita cambioCita(Cita element, String fechaNueva, String horaNueva) {
        Cita cita = element;
        Cita nuevaCita = new Cita(cita.getIdCita(), cita.getNombre(), fechaNueva, horaNueva, cita.getDoctora());

        return nuevaCita;
    }

    public void modified(Cita usuario, String fech, String hor) {
        //crudPila.remove(usuario);
        crudPila.pop();
        crudPila.push(cambioCita(usuario, fech, hor));
    }

    public void delete(Cita citas) {
        // crudPila.remove(citas);
        crudPila.popi(citas);
    }

}// end writeFileCitas
