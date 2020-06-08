package edu.ucr.rp.clinicadenutricion.inicioSesion.logic;

public class Usuario {

    private String name;
    private String contraseña;
    private String telefono;
    private String direccion;
    private String correo;
    private String tipo;

    public Usuario(String name, String contraseña, String telefono, String direccion, String correo, String tipo) {
        this.name = name;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.tipo = tipo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
