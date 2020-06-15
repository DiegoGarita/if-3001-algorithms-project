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

    CRUD crudListas = new CRUD();

    public void writeInFile(Usuario usuario) {

        File newFile = new File("usuarios.txt");
        String tipoDeToken = "";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            PrintStream printStream = new PrintStream(fileOutputStream);

            if (newFile.length() == 0) {
                printStream.println("ë|Super|1234");
            }

            if (usuario.getTipo().equals("Cliente")) {
                tipoDeToken = "ä";
            } else if (usuario.getTipo().equals("Administrador")) {
                tipoDeToken = "ö";
            }

            printStream.println(tipoDeToken + "|" + usuario.getId() + "|" + usuario.getName() + "|" + usuario.getContraseña() + "|" + usuario.getCorreo() + "|" + usuario.getTelefono() + "|" + usuario.getDireccion());

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

                crudListas.add(stringTokenizer(currentRegistry));

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }// end readProperties()

    public void removeLineFromFile(String idSearched) {
        CRUD cr = new CRUD();
        File previousFile = new File("usuarios.txt");
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
        File fileNew = new File("usuarios.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            for (int i = 0; i < cr.size(); i++) {
                printStream.println(cr.indexOf(i).getTipo() + "|" + cr.indexOf(i).getId() + "|" + cr.indexOf(i).getName() + "|" + cr.indexOf(i).getContraseña() + "|" + cr.indexOf(i).getCorreo() + "|" + cr.indexOf(i).getTelefono() + "|" + cr.indexOf(i).getDireccion());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }//end removeLineFromFile(

    public Usuario stringTokenizer(String lines) {

        StringTokenizer stringTokenizer = new StringTokenizer(lines, "|");
        int counterTokens = 0;
        String type = "";
        String id = "";
        String name = "";
        String password = "";
        String email = "";
        String phone = "";
        String direction = "";

        while (stringTokenizer.hasMoreTokens()) {
            switch (counterTokens) {
                case 0:
                    type = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 1:
                    id = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 2:
                    name = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 3:
                    password = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 4:
                    email = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 5:
                    phone = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                case 6:
                    direction = stringTokenizer.nextToken();
                    counterTokens++;
                    break;
                default:
                    break;
            }

        }

        Usuario u = new Usuario(type, id, name, password, email, phone, direction);
        return u;

    }

    public String readLine(String idIdentifier) {

        File newFile = new File("usuarios.txt");
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

    public void modified(Usuario usuario, String s) {
        crudListas.remove(usuario);
        crudListas.add(newPassword(usuario, s));
    }

    public void modifiedSuperHoras(Usuario usuario, String abre, String cierra, String inter) {
        crudListas.remove(usuario);
        crudListas.add(supereAdminConfiHoras(usuario, abre, cierra, inter));
    }

    public void modifiedSuperFondo(Usuario usuario, String fondo) {
        crudListas.remove(usuario);
        crudListas.add(supereAdminConfiFondo(usuario, fondo));
    }

    public void modidelete(Usuario usuario) {
        crudListas.remove(usuario);

    }

    public boolean search(String user) {
        return crudListas.search(user);
    }

    public void disp() { //mostrar nodos
        crudListas.display();

    }

    public Usuario newPassword(Usuario element, String pass) {
        Usuario u = element;
        Usuario user = new Usuario(u.getTipo(), u.getId(), u.getName(), pass, u.getCorreo(), u.getTelefono(), u.getDireccion());
        return user;
    }

    public Usuario supereAdminConfiHoras(Usuario element, String abre, String cierra, String inter) {
        Usuario u = element;
        Usuario user = new Usuario(u.getTipo(), u.getId(), u.getName(), u.getContraseña(), abre, cierra, inter);
        return user;
    }

    public Usuario supereAdminConfiFondo(Usuario element, String fondo) {
        Usuario u = element;
        Usuario user = new Usuario(u.getTipo(), u.getId(), u.getName(), fondo, u.getCorreo(), u.getTelefono(), u.getDireccion());
        return user;
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
