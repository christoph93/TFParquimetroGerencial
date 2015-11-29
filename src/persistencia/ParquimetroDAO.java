/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Parquimetro;

/**
 *
 * @author Christoph
 */
public interface ParquimetroDAO {
    
    
    public Parquimetro getParquimetro(String codigoParquimetro);
    
    public List<Parquimetro> getParquimetro();
    
    public void addParquimetro(Parquimetro parquimetro);
    
    
}
