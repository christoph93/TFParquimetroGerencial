/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
//import org.apache.derby.jdbc.EmbeddedDataSource;

public class InicializadorBancoDeDados {

    public static String DB_NAME = "cadastro";
    public static String USER_NAME = "usuario";
    public static String PASSWORD = "senha";
    private static DataSource dataSource;

    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {
//            EmbeddedDataSource ds = new EmbeddedDataSource();
//            ds.setDatabaseName(DB_NAME);
//            ds.setCreateDatabase("create");
//            ds.setUser(USER_NAME);
//            ds.setPassword(PASSWORD);
//            dataSource = ds;
        }
        return dataSource;
    }

    public static Connection conectarBd() throws Exception {
        return criarDataSource().getConnection();
    }
}

