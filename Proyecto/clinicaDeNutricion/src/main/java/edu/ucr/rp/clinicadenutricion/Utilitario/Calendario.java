package edu.ucr.rp.clinicadenutricion.Utilitario;

import java.time.DayOfWeek;
import java.time.LocalDate;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

public class Calendario {

    // public DatePicker calenCita() {
    public Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell() {
        @Override
        public void updateItem(LocalDate item, boolean empty) {

            super.updateItem(item, empty);

            this.setDisable(false);
            this.setBackground(null);
            this.setTextFill(Color.BLACK);

//                // deshabilitar las fechas futuras
//                if (item.isAfter(LocalDate.now())) {
//                    this.setDisable(true);
//                }
            // marcar los dias de quincena
            int day = item.getDayOfMonth();
            if (day == 15 || day == 30) {

                Paint color = Color.LIGHTBLUE;
                BackgroundFill fill = new BackgroundFill(color, null, null);

                this.setBackground(new Background(fill));
                this.setTextFill(Color.WHITESMOKE);
            }

            // fines de semana en color verde
            DayOfWeek dayweek = item.getDayOfWeek();
            if (dayweek == DayOfWeek.SATURDAY || dayweek == DayOfWeek.SUNDAY) {
                this.setTextFill(Color.ORANGE);
            }

            super.updateItem(item, empty);
            LocalDate today = LocalDate.now();
            setDisable(empty || item.compareTo(today) < 0);

        }
    };

}//end Calendario
