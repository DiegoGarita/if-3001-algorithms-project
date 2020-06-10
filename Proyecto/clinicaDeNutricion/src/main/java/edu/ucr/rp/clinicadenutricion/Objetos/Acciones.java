package edu.ucr.rp.clinicadenutricion.Objetos;

public class Acciones {

    private String Accionador;   // --> Quien realiza la accion
    private String accion;       // --> Que accion realiza
    private String fechaHoraAccion;   // --> Fecha y hora de accion

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

  

}// acciones
