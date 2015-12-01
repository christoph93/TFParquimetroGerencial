package gui;

import javax.swing.SwingUtilities;
/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */

public class Init {

    private static void criarGui() {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();

        c.associaModel(m);

        c.associaView(v);

        m.associaController(c);
        
        c.setUpViewEvents();

        v.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                criarGui();
            }
        });
    }
}
