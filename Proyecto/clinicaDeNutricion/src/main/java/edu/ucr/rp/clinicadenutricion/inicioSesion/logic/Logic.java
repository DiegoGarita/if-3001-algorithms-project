package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

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

public class Logic {

    CRUD c = new CRUD();

    public void writeInFile(Usuario usuario) {

        File newFile = new File("usuarios.txt");
        String tipoDeToken = "";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            if (usuario.getTipo().equals("Cliente") || usuario.getTipo().equals("-")) {
                tipoDeToken = "-";
            } else if (usuario.getTipo().equals("Administrador") || usuario.getTipo().equals("+")) {
                tipoDeToken = "+";
            }

            printStream.println(tipoDeToken + usuario.getName() + "|" + usuario.getContraseña());

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end writeFileCatalogue()

    public void readInFile() {

        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                StringTokenizer stringTokenizer = new StringTokenizer(currentRegistry, "|");
                int counterTokens = 0;
                String name = "";
                String password = "";
                while (stringTokenizer.hasMoreTokens()) {
                    if (counterTokens == 0) {
                        name = stringTokenizer.nextToken();
                        name = name.substring(1, name.length());
                        counterTokens++;
                    } else if (counterTokens == 1) {
                        password = stringTokenizer.nextToken();
                        counterTokens++;
                    }

                }

                Usuario u = new Usuario(name, password, "", "", "", "");
                c.add(u);

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + ": Problemas con el archivo");
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }// end readProperties()

    public void removeLineFromFile(String lineToRemove) {
        CRUD cr = new CRUD();
        File previousFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(previousFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (!currentRegistry.contains(lineToRemove)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(currentRegistry, "|"); //string 
                    int counterTokens = 0;
                    String name = "";
                    String password = "";
                    String tipoToken = "";
                    while (stringTokenizer.hasMoreTokens()) {
                        if (counterTokens == 0) {
                            name = stringTokenizer.nextToken(); //mantiene el string para comparar
                            tipoToken = name.subSequence(0, 1) + "";
                            name = name.substring(1, name.length());
                            counterTokens++;
                        } else if (counterTokens == 1) {
                            password = stringTokenizer.nextToken();
                            counterTokens++;
                        }

                    }

                    Usuario usuario = new Usuario(name, password, "", "", "", tipoToken);
                    cr.add(usuario);

                }
                currentRegistry = bufferedReader.readLine();
            }
            previousFile.deleteOnExit();
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + "\nProblemas con el archivo");
        }
        File fileNew = new File("usuarios.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            for (int i = 0; i < cr.size(); i++) {
                printStream.println(cr.indexOf(i).getTipo() + cr.indexOf(i).getName() + "|" + cr.indexOf(i).getContraseña());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end removeLineFromFile(

    public String readType(String cont) {

        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                if (currentRegistry.contains(cont)) {
                    return currentRegistry.substring(0, 1);

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

    public void modified(Usuario usuario, String s) {
        c.remove(usuario);
        c.add(c.newPassword(usuario, s));
    }

    public void modidelete(Usuario usuario) {
        c.remove(usuario);

    }

    public boolean search(String user) {
        return c.search(user);
    }

    
    public void disp() { //mostrar nodos
        c.display();
        
     }
    
    
    
//    
//        public void delete(String line) {
//        removeLineFromFile(line);
//    }

//        public int size() {
//        return c.size();
//    }
    //    public void writeFileCatalogue(String nombre, String contraseña, String tipo) {
//
//        File newFile = new File("usuarios.txt");
//        String tipoDeToken = "";
//
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
//            PrintStream printStream = new PrintStream(fileOutputStream);
//
//            if (tipo.equals("Cliente")) {
//                tipoDeToken = "-";
//            } else if (tipo.equals("Administrador")) {
//                tipoDeToken = "+";
//            } else if (tipo.equals("Super Administrador")) {
//                tipoDeToken = "*";
//            }
//
//            printStream.println(tipoDeToken + c.add(nombre) + "|" + c.add(contraseña));
//
//        } catch (FileNotFoundException fileNotFoundException) {
//            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
//        }
//    }//end writeFileCatalogue()
//
//    public ArrayList<String> readProperties(String nombre) {
//
//        File newFile = new File("usuarios.txt");
//        String lineKeeper = "";
//        ArrayList<String> a = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = new FileInputStream(newFile);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String currentRegistry = bufferedReader.readLine();
//
//            while (currentRegistry != null) { //mientras haya mas lineas
//                if (currentRegistry.contains(nombre)) { //si contiene el nombre
//
//                    lineKeeper += currentRegistry + "|"; //guarda todos los que lo contienen
//
//                    StringTokenizer stringTokenizer = new StringTokenizer(lineKeeper, "|"); //string tokenizer
//
//                    while (stringTokenizer.hasMoreTokens()) {
//                        String name = stringTokenizer.nextToken(); //mantiene el string para comparar
//                        name = name.substring(1, name.length());
//
//                        if (name.equals(nombre)) { //si es igual al nombre
//                            a.add(0, name); //agrega
//                            a.add(1, stringTokenizer.nextToken()); //agrega
//                            return a; //retorna
//                        } else {
//                            stringTokenizer.nextToken();
//                        }
//                    }
//                }
//
//                currentRegistry = bufferedReader.readLine(); //mueve while
//            }
//
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.out.println(fileNotFoundException + ": Problemas con el archivo");
//        } catch (IOException IOException) {
//            System.out.println(IOException + ": Problemas con el archivo");
//        }
//        return a;
//    }// end readProperties()
}
