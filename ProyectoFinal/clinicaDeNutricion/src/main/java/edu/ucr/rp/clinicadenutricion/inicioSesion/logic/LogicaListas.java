package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

import edu.ucr.rp.clinicadenutricion.Objetos.Usuario;
import edu.ucr.rp.clinicadenutricion.SuperAdmin.Logic.LogicaSuperAdmin;
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

public class LogicaListas {

    ImplementacionListas implementacionListas = new ImplementacionListas();
    LogicaSuperAdmin logicaSuperAdmin = new LogicaSuperAdmin();

    /**
     * método que escribe en el archivo usuarios.txt
     *
     * @param usuario usuario que será agregado al archivo .txt
     */
    public void escribirArchivo(Usuario usuario) {

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
    }

    /**
     * método que lee del archivo usuarios.txt
     */
    public void leerArchivo() {

        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                implementacionListas.add(stringTokenizer(currentRegistry));

                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
    }

    /**
     * método que remueve una línea del archivo usuarios.txt
     *
     * @param IDBuscar identificador de la línea a eliminar
     */
    public void remueveLineaDeArchivo(String IDBuscar) {
        ImplementacionListas implementacionListas = new ImplementacionListas();
        File archivoAntiguo = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(archivoAntiguo);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {
                if (!currentRegistry.contains(IDBuscar)) {

                    implementacionListas.add(stringTokenizer(currentRegistry));
                }
                currentRegistry = bufferedReader.readLine();
            }
            //archivoAntiguo.deleteOnExit();
            archivoAntiguo.delete();
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + "\nProblemas con el archivo");
        }
        File fileNew = new File("usuarios.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNew);
            PrintStream printStream = new PrintStream(fileOutputStream);
            for (int i = 0; i < implementacionListas.size(); i++) {
                printStream.println(implementacionListas.indexOf(i).getTipo() + "|" + implementacionListas.indexOf(i).getId() + "|" + implementacionListas.indexOf(i).getName() + "|" + implementacionListas.indexOf(i).getContraseña() + "|" + implementacionListas.indexOf(i).getCorreo() + "|" + implementacionListas.indexOf(i).getTelefono() + "|" + implementacionListas.indexOf(i).getDireccion());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            JOptionPane.showMessageDialog(null, fileNotFoundException + "\nProblemas con el archivo");
        }
    }

    /**
     * método que recibe un String y lo convierte en el objeto Usuario
     *
     * @param lineas línea que será convertida
     * @return objeto usuario que viene de la línea del parámetro
     */
    public Usuario stringTokenizer(String lineas) {

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

    /**
     * método que lee una línea en específico del archivo usuarios.txt
     *
     * @param IDIdentificador identificador de la línea a leer
     * @return devuelve la línea que encontró el identificador dentro del
     * archivo usuarios.txt
     */
    public String leeLinea(String IDIdentificador) {

        File newFile = new File("usuarios.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String currentRegistry = bufferedReader.readLine();

            while (currentRegistry != null) {

                if (currentRegistry.contains(IDIdentificador)) {
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
     * método que cuenta la cantidad de clientes que hay en el archivo
     * usuarios.txt
     *
     * @param identificador identificador de qué tipo de usuario se busca contar
     * @return retorna la cantidad de clientes encontrados
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
                    cantidad++;
                }
                currentRegistry = bufferedReader.readLine();
            }

        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException IOException) {
            JOptionPane.showMessageDialog(null, IOException + ": Problemas con el archivo");
        }
        return cantidad;
    }

    /**
     * método que modifica listas
     *
     * @param usuario recibe el usuario que va a modificar
     * @param cadena string del nuevo usuario que modificó
     */
    public void modificado(Usuario usuario, String cadena) {
        implementacionListas.remove(usuario);
        implementacionListas.add(nuevosDatos(usuario, cadena));
    }

    /**
     * método que remueve de las listas
     *
     * @param usuario usuario que será removido de la lista
     */
    public void remueve(Usuario usuario) {
        implementacionListas.remove(usuario);

    }

    /**
     * método que busca un usuario dentro de la lista
     *
     * @param usuario usuario a buscar
     * @return true si lo encuentra, false si no lo encuentra
     */
    public boolean busca(String usuario) {
        return implementacionListas.search(usuario);
    }

    /**
     * método que muestra la lista
     */
    public void muestra() {
        implementacionListas.display();

    }

    /**
     * método que cambia los atributos de usuario
     *
     * @param usuario usuario que será cambiado
     * @param contraseña contraseña cambiada y para validar
     * @return usuario nuevo y cambiado
     */
    public Usuario nuevosDatos(Usuario usuario, String contraseña) {
        Usuario usuarioTemp = usuario;
        Usuario usuarioNuevo = new Usuario(usuarioTemp.getTipo(), usuarioTemp.getId(), usuarioTemp.getName(), contraseña, usuarioTemp.getCorreo(), usuarioTemp.getTelefono(), usuarioTemp.getDireccion());
        return usuarioNuevo;
    }

}
