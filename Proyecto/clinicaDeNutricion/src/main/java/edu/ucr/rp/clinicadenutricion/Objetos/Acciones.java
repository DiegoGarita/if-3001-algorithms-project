package edu.ucr.rp.clinicadenutricion.Objetos;

public class Acciones {
    
    /**
     * Accionador: Es quien realiza la acción
     * Accion: Qué acción realiza
     * fechaHoraAccion: Fecha y hora de la realización de la acción
     */

    private String Accionador;
    private String accion;
    private String fechaHoraAccion;

    public Acciones(String Accionador, String accion, String fechaHoraAccion) {
        this.Accionador = Accionador;
        this.accion = accion;
        this.fechaHoraAccion = fechaHoraAccion;
    }

    public String getAccionador() {
        return Accionador;
    }

    public void setAccionador(String Accionador) {
        this.Accionador = Accionador;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFechaHoraAccion() {
        return fechaHoraAccion;
    }

    public void setFechaHoraAccion(String fechaHoraAccion) {
        this.fechaHoraAccion = fechaHoraAccion;
    }

}// Acciones
