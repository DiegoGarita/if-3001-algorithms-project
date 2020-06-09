package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Grafico {

    //Se recibe 4 parametros para poder crear la grafica
    public void showGraficMethods(double porAgua, double porMassaMus,
            double grasa, double grasaVisc) {

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("% Agua", porAgua);
        pieDataset.setValue("% Masa muscular", porMassaMus);
        pieDataset.setValue("Grasa", grasa);
        pieDataset.setValue("Grasa visceral", grasaVisc);


        JFreeChart chart = ChartFactory.createPieChart(
                "Informacion actual",
                pieDataset,
                true,
                true,
                false
        );

        //Mostramos la grafica en pantalla
        ChartFrame frame = new ChartFrame("Reporte de estado", chart);
        frame.pack();
        frame.setVisible(true);

    }// end public void showGraficMethods()

}// end grafico
