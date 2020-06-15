package edu.ucr.rp.clinicadenutricion.Cliente.Logic;

import edu.ucr.rp.clinicadenutricion.Admin.logic.AdminLogic;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.Entrar;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Grafico {

    AdminLogic adminLogic = new AdminLogic();
    Entrar en;

    //Se recibe 4 parametros para poder crear la grafica
    public void showGraficMethods() {
        ReporteMedico re = adminLogic.stringTokenizer(adminLogic.getLast(en.ID));

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("% Agua", Integer.parseInt(re.getPorcenAgua()));
        pieDataset.setValue("% Masa muscular", Integer.parseInt(re.getPorcenMasaMuscular()));
        pieDataset.setValue("Grasa", Integer.parseInt(re.getGrasa()));
        pieDataset.setValue("Grasa visceral", Integer.parseInt(re.getGrasaVisceral()));

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
