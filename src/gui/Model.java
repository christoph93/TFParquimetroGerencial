package gui;

import negocio.Facade;
import org.jfree.chart.JFreeChart;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class Model {

    private Controller c;
    private Facade f;

    public Model() {
        f = new Facade();
    }

    public Facade getFacade() {
        return f;
    }

    void associaController(Controller c) {
        this.c = c;
    }

    public void importarLog() {
        f.importarLog();
    }

    public void gerarRelatorio(String s) {
        System.out.println(s);
        f.gerarRelatorio(s);

    }

    public void gerarEstatPorParq(String s) {
        System.out.println(s);
        f.gerarEstatPorParq(s);
    }

    public void gerarGraficoBarras(String init, String fim) {
        System.out.println(init + " - - " + fim);
        JFreeChart j = f.gerarGraficoBarras(init, fim);
        c.desenhaGraph(j);
    }

    public void gerarGraficoPizza(String init, String fim) {
        System.out.println(init + " - - " + fim);
        JFreeChart j = f.gerarGraficoPizza(init, fim);
        c.desenhaGraph(j);
    }
}
