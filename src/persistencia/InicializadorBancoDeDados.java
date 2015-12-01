
package persistencia;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;


/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */

public class InicializadorBancoDeDados {

    public static String DB_NAME = "cadastro";
    public static String USER_NAME = "usuario";
    public static String PASSWORD = "senha";
    private static DataSource dataSource;

    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {

        }
        return dataSource;
    }

    public static Connection conectarBd() throws Exception {
        return criarDataSource().getConnection();
    }
}

