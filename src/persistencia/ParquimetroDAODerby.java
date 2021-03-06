package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Parquimetro;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class ParquimetroDAODerby implements ParquimetroDAO{

    @Override
    public Parquimetro getParquimetro(String codigoParquimetro) {
        //buscar no banco de dados pelo codigo
        return null;
    }

    @Override
    public List<Parquimetro> getParquimetros() throws ParquimetroDAOException {
        List<Parquimetro> parq = new ArrayList<>();
        String sql = "select * from parquimetro";
        try (Connection conexao = InicializadorBancoDeDados.conectarBd()) {
            try (Statement comando = conexao.createStatement()) {
                try (ResultSet resultado = comando.executeQuery(sql)) {
                    while (resultado.next()) {
//                        Parquimetro p = new Parquimetro(
//                                resultado.getString("endereco"),
//                                resultado.getString("primeironome"),
//                                resultado.getString("ultimonome"));
//                        parq.add(p);
                    }
                    return parq;
                }
            }
        } catch (Exception e) {
            throw new ParquimetroDAOException("Falha na busca", e);
        }
        

    }

    @Override
    public void addParquimetro(Parquimetro parquimetro) {
        //mapeia parquimetro para o banco
    }

    @Override
    public Parquimetro getParquimetro() throws ParquimetroDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}




//
//
//    @Override
//    public Autor buscarPorCodigo(int codigo) throws DAOAutorException {
//        String sql = "select * from autores where codigo = ?";
//        Autor autor = null;
//        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
//            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
//                comando.setInt(1, codigo);
//                try (ResultSet resultado = comando.executeQuery()) {
//                    if (resultado.next()) {
//                        autor = new Autor(
//                                resultado.getInt("codigo"),
//                                resultado.getString("primeironome"),
//                                resultado.getString("ultimonome")
//                        );
//                    }
//                    return autor;
//                }
//            }
//        } catch (Exception e) {
//            throw new DAOAutorException("Falha na busca", e);
//        }
//    }
//
//    @Override
//    public List<Autor> buscarPorUltimoNome(String nome) throws DAOAutorException {
//        String sql = "select * from autores where ultimonome = ?";
//        List<Autor> autores = new ArrayList<>();
//        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
//            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
//                comando.setString(1, nome);
//                try (ResultSet resultado = comando.executeQuery()) {
//                    while (resultado.next()) {
//                        Autor autor = new Autor(
//                                resultado.getInt("codigo"),
//                                resultado.getString("primeironome"),
//                                resultado.getString("ultimonome"));
//                        autores.add(autor);
//                    }
//                    return autores;
//                }
//            }
//        } catch (Exception e) {
//            throw new DAOAutorException("Falha na busca", e);
//        }
//    }
//
//    @Override
//    public void inserir(Autor autor) throws DAOAutorException {
//        String sql = "insert into autores(codigo,primeironome,ultimonome) values(?,?,?)";
//        int resultado = 0;
//        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
//            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
//                comando.setInt(1, autor.getCodigo());
//                comando.setString(2, autor.getPrimeiroNome());
//                comando.setString(3, autor.getUltimoNome());
//                resultado = comando.executeUpdate();
//            }
//        } catch (Exception e) {
//            throw new DAOAutorException("Falha na inserção", e);
//        }
//        if (resultado == 0) {
//            throw new DAOAutorException("Falha na inserção");
//        }
//    }
//
//    @Override
//    public void alterar(Autor autor) throws DAOAutorException {
//        String sql = "update autores set primeironome=?, ultimonome=? where codigo = ?";
//        int resultado = 0;
//        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
//            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
//                comando.setString(1, autor.getPrimeiroNome());
//                comando.setString(2, autor.getUltimoNome());
//                comando.setInt(3, autor.getCodigo());
//                resultado = comando.executeUpdate();
//            }
//        } catch (Exception e) {
//            throw new DAOAutorException("Falha na alteração", e);
//        }
//        if (resultado == 0) {
//            throw new DAOAutorException("Falha na alteração");
//        }
//    }
