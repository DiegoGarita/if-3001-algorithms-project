package edu.ucr.rp.clinicadenutricion.Objetos;

public class Cita {

    /**
     * IDCita: ID de la cita, debe ser único
     * Nombre: nombre/ID del paciente
     * fecha: fecha de la cita 
     * hora: hora de la cita 
     * doctora: nombre del doctor(a) realizador de la cita
     */
    private String IDCita;
    private String Nombre;
    private String fecha;
    private String hora;
    private String doctora;

    public Cita(String idCita, String Nombre, String fecha, String hora, String doctora) {
        this.IDCita = idCita;
        this.Nombre = Nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.doctora = doctora;
    }

    public String getIDCita() {
        return IDCita;
    }

    public void setIDCita(String IDCita) {
        this.IDCita = IDCita;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDoctora() {
        return doctora;
    }

    public void setDoctora(String doctora) {
        this.doctora = doctora;
    }

}//end cita
