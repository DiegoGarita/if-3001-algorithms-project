package edu.ucr.rp.clinicadenutricion.Objetos;

public class Usuario {

    private String tipo;
    private String id;
    private String name;
    private String contraseña;
    private String correo;
    private String telefono;
    private String direccion;

    public Usuario(String tipo, String id, String name, String contraseña, String correo, String telefono, String direccion) {
        this.tipo = tipo;
        this.id = id;
        this.name = name;
        this.contraseña = contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
