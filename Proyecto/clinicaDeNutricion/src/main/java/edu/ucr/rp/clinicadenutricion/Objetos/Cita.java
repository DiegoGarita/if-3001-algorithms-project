package edu.ucr.rp.clinicadenutricion.Objetos;

public class Cita {
 
    private String idCita;
    private String Nombre;
    private String fecha;
    private String hora;
    private String doctora;

    public Cita(String idCita, String Nombre, String fecha, String hora, String doctora) {
        this.idCita = idCita;
        this.Nombre = Nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.doctora = doctora;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
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
