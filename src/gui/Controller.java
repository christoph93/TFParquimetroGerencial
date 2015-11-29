/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionListener;

public class Controller {

    private Model model;
    private View view;
    private ActionListener incrementa;

    public void associaModel(Model m) {
        model = m;
    }

    public void associaView(View v) {
        view = v;
    }

    public void setUpViewEvents() {
//        incrementa = (ActionEvent actionEvent) -> {
//            System.out.println("Teste incrementa!");
//            String[] aux = model.incrementaTempo();
//            view.getTempo().setText(aux[0]);
//            view.getValor().setText(aux[1]);
//        };
//        view.getIncrementa().addActionListener(incrementa);
    }
}
