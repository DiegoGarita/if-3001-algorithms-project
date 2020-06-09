package edu.ucr.rp.clinicadenutricion.Objetos;

import javafx.scene.control.TextArea;

public class ReporteMedico {

    private String fecha ;
    private String hora ;  
    private String actividadFisica;
    private double porcenAgua;
    private double porcenMasaMuscular;
    private double grasa;
    private double grasaVisceral;
    private double hueso;
    private double edadMetabolica;
    private double peso;  
    private double altura;     
    private int horasDeSueño;
    private int edad;    
    private TextArea textAreaNotas;

    public ReporteMedico(String fecha, String hora, String actividadFisica,
            double porcenAgua, double porcenMasaMuscular, double grasa,
            double grasaVisceral, double hueso, double edadMetabolica,
            double peso, double altura, int horasDeSueño, int edad, TextArea textAreaNotas) {
        this.fecha = fecha;
        this.hora = hora;
        this.actividadFisica = actividadFisica;
        this.porcenAgua = porcenAgua;
        this.porcenMasaMuscular = porcenMasaMuscular;
        this.grasa = grasa;
        this.grasaVisceral = grasaVisceral;
        this.hueso = hueso;
        this.edadMetabolica = edadMetabolica;
        this.peso = peso;
        this.altura = altura;
        this.horasDeSueño = horasDeSueño;
        this.edad = edad;
        this.textAreaNotas = textAreaNotas;
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

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public double getPorcenAgua() {
        return porcenAgua;
    }

    public void setPorcenAgua(double porcenAgua) {
        this.porcenAgua = porcenAgua;
    }

    public double getPorcenMasaMuscular() {
        return porcenMasaMuscular;
    }

    public void setPorcenMasaMuscular(double porcenMasaMuscular) {
        this.porcenMasaMuscular = porcenMasaMuscular;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    public double getGrasaVisceral() {
        return grasaVisceral;
    }

    public void setGrasaVisceral(double grasaVisceral) {
        this.grasaVisceral = grasaVisceral;
    }

    public double getHueso() {
        return hueso;
    }

    public void setHueso(double hueso) {
        this.hueso = hueso;
    }

    public double getEdadMetabolica() {
        return edadMetabolica;
    }

    public void setEdadMetabolica(double edadMetabolica) {
        this.edadMetabolica = edadMetabolica;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getHorasDeSueño() {
        return horasDeSueño;
    }

    public void setHorasDeSueño(int horasDeSueño) {
        this.horasDeSueño = horasDeSueño;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TextArea getTextAreaNotas() {
        return textAreaNotas;
    }

    public void setTextAreaNotas(TextArea textAreaNotas) {
        this.textAreaNotas = textAreaNotas;
    }
  

}//end citas
