package edu.ucr.rp.clinicadenutricion.Objetos;

public class SuperAdmin {
    
    /**
     * identificadorSA: identificador de la clínica y del super administrador
     * abreClinica: hora en que abre la clínica
     * cierreClinica: hora en que cierra la clínica
     * TiempoConsulta: tiempo de duración de la consulta (*por hora*)
     * NombreLogo: nombre del logo de la aplicación
     * pathDeGuardado: path de guardado 
     * paginacion: número de elementos mostrados por página
     */
    

    private String identificadorSA;
    private String abreClinica;
    private String cierreClinica;
    private String TiempoConsulta;
    private String NombreLogo;
    private String pathDeGuardado;
    private String paginacion;

    public SuperAdmin(String identificadorSA, String abreClinica, String cierreClinica, String TiempoConsulta, String NombreLogo, String pathDeGuardado, String paginacion) {
        this.identificadorSA = identificadorSA;
        this.abreClinica = abreClinica;
        this.cierreClinica = cierreClinica;
        this.TiempoConsulta = TiempoConsulta;
        this.NombreLogo = NombreLogo;
        this.pathDeGuardado = pathDeGuardado;
        this.paginacion = paginacion;
    }

    public String getIdentificadorSA() {
        return identificadorSA;
    }

    public void setIdentificadorSA(String identificadorSA) {
        this.identificadorSA = identificadorSA;
    }

    public String getAbreClinica() {
        return abreClinica;
    }

    public void setAbreClinica(String abreClinica) {
        this.abreClinica = abreClinica;
    }

    public String getCierreClinica() {
        return cierreClinica;
    }

    public void setCierreClinica(String cierreClinica) {
        this.cierreClinica = cierreClinica;
    }

    public String getTiempoConsulta() {
        return TiempoConsulta;
    }

    public void setTiempoConsulta(String TiempoConsulta) {
        this.TiempoConsulta = TiempoConsulta;
    }

    public String getNombreLogo() {
        return NombreLogo;
    }

    public void setNombreLogo(String NombreLogo) {
        this.NombreLogo = NombreLogo;
    }

    public String getPathDeGuardado() {
        return pathDeGuardado;
    }

    public void setPathDeGuardado(String pathDeGuardado) {
        this.pathDeGuardado = pathDeGuardado;
    }

    public String getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(String paginacion) {
        this.paginacion = paginacion;
    }

    
    
}//end SuperAdmin
