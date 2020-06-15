package edu.ucr.rp.clinicadenutricion.Objetos;

public class ReporteMedico {

    private String ID;
    private String nombre;
    private String fecha;
    private String hora;
    private String edad;
    private String edadMetabolica;
    private String altura;
    private String peso;
    private String porcenMasaMuscular;
    private String grasa;
    private String grasaVisceral;
    private String hueso;
    private String porcenAgua;
    private String actividadFisica;
    private String horasDeSueño;
    private String textAreaNotas;

    public ReporteMedico(String ID, String nombre, String fecha, String hora, String edad, String edadMetabolica, String altura, String peso, String porcenMasaMuscular, String grasa, String grasaVisceral, String hueso, String porcenAgua, String actividadFisica, String horasDeSueño, String textAreaNotas) {
        this.ID = ID;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.edad = edad;
        this.edadMetabolica = edadMetabolica;
        this.altura = altura;
        this.peso = peso;
        this.porcenMasaMuscular = porcenMasaMuscular;
        this.grasa = grasa;
        this.grasaVisceral = grasaVisceral;
        this.hueso = hueso;
        this.porcenAgua = porcenAgua;
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

    public String getPorcenMasaMuscular() {
        return porcenMasaMuscular;
    }

    public void setPorcenMasaMuscular(String porcenMasaMuscular) {
        this.porcenMasaMuscular = porcenMasaMuscular;
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

    public String getPorcenAgua() {
        return porcenAgua;
    }

    public void setPorcenAgua(String porcenAgua) {
        this.porcenAgua = porcenAgua;
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
