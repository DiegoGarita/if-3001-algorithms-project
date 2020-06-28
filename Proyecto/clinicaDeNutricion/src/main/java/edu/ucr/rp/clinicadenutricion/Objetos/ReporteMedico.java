package edu.ucr.rp.clinicadenutricion.Objetos;

public class ReporteMedico {
    
    /**
     *  ID: ID del cliente (debe ser único)
     *  nombre: nombre del cliente 
     *  fecha: fecha en que se realiza el reporte
     *  hora: hora en que se realiza el reporte
     *  edad: edad del cliente
     *  edadMetabolica: edad metabólica del cliente
     *  altura: altura del cliente
     *  peso: peso del cliente
     *  porcentajeMasaMuscular: porcentaje de masa muscular del cliente
     *  grasa: grasa del cliente
     *  grasaVisceral: grasa visceral del cliente
     *  hueso: hueso del cliente
     *  porcentajeAgua: porcentaje de agua que bebe el cliente por día
     *  actividadFisica: horas de actividad física realizada por día por el cliente
     *  horasDeSueño: horas de sueño por día del cliente
     *  textAreaNotas: notas tomadas por el doctor que realiza el reporte
     */

    private String ID;
    private String nombre;
    private String fecha;
    private String hora;
    private String edad;
    private String edadMetabolica;
    private String altura;
    private String peso;
    private String porcentajeMasaMuscular;
    private String grasa;
    private String grasaVisceral;
    private String hueso;
    private String porcentajeAgua;
    private String actividadFisica;
    private String horasDeSueño;
    private String textAreaNotas;

    public ReporteMedico(String ID, String nombre, String fecha, String hora, String edad, String edadMetabolica, String altura, String peso, String porcentajeMasaMuscular, String grasa, String grasaVisceral, String hueso, String porcentajeAgua, String actividadFisica, String horasDeSueño, String textAreaNotas) {
        this.ID = ID;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.edad = edad;
        this.edadMetabolica = edadMetabolica;
        this.altura = altura;
        this.peso = peso;
        this.porcentajeMasaMuscular = porcentajeMasaMuscular;
        this.grasa = grasa;
        this.grasaVisceral = grasaVisceral;
        this.hueso = hueso;
        this.porcentajeAgua = porcentajeAgua;
        this.actividadFisica = actividadFisica;
        this.horasDeSueño = horasDeSueño;
        this.textAreaNotas = textAreaNotas;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdadMetabolica() {
        return edadMetabolica;
    }

    public void setEdadMetabolica(String edadMetabolica) {
        this.edadMetabolica = edadMetabolica;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPorcentajeMasaMuscular() {
        return porcentajeMasaMuscular;
    }

    public void setPorcentajeMasaMuscular(String porcentajeMasaMuscular) {
        this.porcentajeMasaMuscular = porcentajeMasaMuscular;
    }

    public String getGrasa() {
        return grasa;
    }

    public void setGrasa(String grasa) {
        this.grasa = grasa;
    }

    public String getGrasaVisceral() {
        return grasaVisceral;
    }

    public void setGrasaVisceral(String grasaVisceral) {
        this.grasaVisceral = grasaVisceral;
    }

    public String getHueso() {
        return hueso;
    }

    public void setHueso(String hueso) {
        this.hueso = hueso;
    }

    public String getPorcentajeAgua() {
        return porcentajeAgua;
    }

    public void setPorcentajeAgua(String porcentajeAgua) {
        this.porcentajeAgua = porcentajeAgua;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public String getHorasDeSueño() {
        return horasDeSueño;
    }

    public void setHorasDeSueño(String horasDeSueño) {
        this.horasDeSueño = horasDeSueño;
    }

    public String getTextAreaNotas() {
        return textAreaNotas;
    }

    public void setTextAreaNotas(String textAreaNotas) {
        this.textAreaNotas = textAreaNotas;
    }

}//end citas
