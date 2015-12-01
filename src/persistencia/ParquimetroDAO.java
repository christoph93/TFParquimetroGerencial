package persistencia;

import java.util.List;
import negocio.Parquimetro;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public interface ParquimetroDAO {
    
    
    public Parquimetro getParquimetro(String codigoParquimetro) throws ParquimetroDAOException;
    
    public Parquimetro getParquimetro() throws ParquimetroDAOException;
    
    public List<Parquimetro> getParquimetros() throws ParquimetroDAOException;
    
    public void addParquimetro(Parquimetro parquimetro);
    
    
}
