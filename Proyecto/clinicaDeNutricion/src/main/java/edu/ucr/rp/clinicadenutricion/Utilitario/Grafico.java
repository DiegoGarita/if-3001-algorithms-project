package edu.ucr.rp.clinicadenutricion.Utilitario;

import edu.ucr.rp.clinicadenutricion.Admin.logic.LogicaCola;
import edu.ucr.rp.clinicadenutricion.Objetos.ReporteMedico;
import edu.ucr.rp.clinicadenutricion.inicioSesion.Gui.IniciarSesion;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
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

        PiePlot plot = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);

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

        PiePlot plot = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        ChartFrame frame = new ChartFrame("Reporte de estado", chart);
        frame.pack();
        frame.setVisible(true);

    }// end public void MuestraGraficoInicial()

}// end grafico
