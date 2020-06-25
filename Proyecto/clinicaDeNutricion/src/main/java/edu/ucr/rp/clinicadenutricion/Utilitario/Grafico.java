package edu.ucr.rp.clinicadenutricion.Utilitario;

import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Grafico {

    LogicaCola logicaCola = new LogicaCola();
    IniciarSesion iniciarSesion;

    public void MuestraGraficoActual() {
        ReporteMedico reporteMedico = logicaCola.stringTokenizer(logicaCola.obtieneLineaEspecifica(iniciarSesion.ID, true));

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("% Agua", Integer.parseInt(reporteMedico.getPorcenAgua()));
        pieDataset.setValue("% Masa muscular", Integer.parseInt(reporteMedico.getPorcenMasaMuscular()));
        pieDataset.setValue("%Grasa", Integer.parseInt(reporteMedico.getGrasa()));
        pieDataset.setValue("%Grasa visceral", Integer.parseInt(reporteMedico.getGrasaVisceral()));

        JFreeChart chart = ChartFactory.createPieChart(
                "Reporte reciente (" + reporteMedico.getFecha() + "",
                pieDataset,
                true,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Reporte de estado", chart);

        frame.pack();
        frame.setVisible(true);

    }// end public void MuestraGraficoInicial()

    public void MuestraGraficoInicial() {
        ReporteMedico reporteMedico = logicaCola.stringTokenizer(logicaCola.obtieneLineaEspecifica(iniciarSesion.ID, false));

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("% Agua", Integer.parseInt(reporteMedico.getPorcenAgua()));
        pieDataset.setValue("% Masa muscular", Integer.parseInt(reporteMedico.getPorcenMasaMuscular()));
        pieDataset.setValue("Grasa", Integer.parseInt(reporteMedico.getGrasa()));
        pieDataset.setValue("Grasa visceral", Integer.parseInt(reporteMedico.getGrasaVisceral()));

        JFreeChart chart = ChartFactory.createPieChart(
                "Reporte inicial (" + reporteMedico.getFecha() + ")",
                pieDataset,
                true,
                true,
                false
        );

        ChartFrame frame = new ChartFrame("Reporte de estado", chart);
        frame.pack();
        frame.setVisible(true);

    }// end public void MuestraGraficoInicial()

}// end grafico
