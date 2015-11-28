/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Parquimetro;

/**
 *
 * @author Christoph
 */
public class ParquimetroDAODerby implements ParquimetroDAO{

    @Override
    public Parquimetro getParquimetro(String codigoParquimetro) {
        //buscar no banco de dados pelo codigo
        return null;
    }

    @Override
    public Parquimetro getParquimetro() {
        return null;
    }

    @Override
    public void addParquimetro(Parquimetro parquimetro) {
        //mapeia parquimetro para o banco
    }
    
}
