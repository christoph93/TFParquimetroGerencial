/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import negocio.Facade;

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
}
