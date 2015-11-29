/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class Controller {

    private Model model;
    private View view;
    private ActionListener btImport, btRelatorio, btEstat, btGraficoEstatBar, btGraficoEstatPizza;

    public void associaModel(Model m) {
        model = m;
    }

    public void associaView(View v) {
        view = v;
    }

    public void setUpViewEvents() {
        btImport = (ActionEvent actionEvent) -> {
            System.out.println("Teste Import!");
            model.importarLog();
        };
        view.getBtImport().addActionListener(btImport);

        btRelatorio = (ActionEvent actionEvent) -> {
            System.out.println("Teste Relatorio!");
            model.gerarRelatorio(view.getDia().getText() + "/" + view.getMes().getText());
        };
        view.getBtRelat().addActionListener(btRelatorio);

        btEstat = (ActionEvent actionEvent) -> {
            System.out.println("Teste Estatistica!");
            model.gerarEstatPorParq(view.getNumParq().getText());
        };
        view.getBtEstat().addActionListener(btEstat);

        btGraficoEstatBar = (ActionEvent actionEvent) -> {
            System.out.println("Teste Estatistica Barras!");
            model.gerarGraficoBarras(view.getPeriodoInicio().getText(), view.getPeriodoFim().getText());
        };
        view.getBtGrafBar().addActionListener(btGraficoEstatBar);

        btGraficoEstatPizza = (ActionEvent actionEvent) -> {
            System.out.println("Teste Estatistica Pizza!");
            model.gerarGraficoBarras(view.getPeriodoInicio().getText(), view.getPeriodoFim().getText());
        };
        view.getBtGrafPizza().addActionListener(btGraficoEstatPizza);
    }

    public void desenhaGraph(JFreeChart j) {
        ChartPanel myChart = new ChartPanel(j);
        view.getGraph().add(myChart,BorderLayout.CENTER);
        view.getGraph().validate();
    }
}
