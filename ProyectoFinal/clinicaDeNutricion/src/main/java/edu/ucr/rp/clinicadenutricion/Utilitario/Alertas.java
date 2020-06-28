package edu.ucr.rp.clinicadenutricion.Utilitario;

import javafx.scene.control.Alert;

public class Alertas {

    /**
     * Metodo que contiene las ventanas que saltan en ciertas acciones
     *
     * @param message message que se quiere expresar
     */
    public void alertInformation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acción concretada");
        alert.setHeaderText("Aviso");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Metodo que contiene las ventanas que saltan en ciertas acciones
     *
     * @param message message que se quiere expresar
     */
    public void alertWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alerta");
        alert.setHeaderText("Alerta, sucedió un error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Metodo que contiene las ventanas que saltan en ciertas acciones
     *
     * @param message message que se quiere expresar
     * @return
     */
    public Alert alertConfirmation(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Acepta nuestros términos y condiciones");
        return alert;
    }

}//end alertas
