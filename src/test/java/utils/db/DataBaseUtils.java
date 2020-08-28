package utils.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;
import utils.config.Config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {

    private static Connection connection;
    private static Statement statement;
    private static QueryRunner queryRunner;


    private DataBaseUtils(){}

    public static void open(String dataBase) throws SQLException {
        MysqlDataSource dataSource = getBaseDataSource(dataBase);
        if (connection == null) {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            queryRunner = new QueryRunner(dataSource);
        } else {
            throw new SQLException("Connection is already open");
        }
    }



    public static void connectToDatabase(){}
   // public static ResultSet executeQuery(String query){}
    public static void executeUpdate (){}
    public static void executeInsert(){}
  //  public static <T> T executeQueryToBean(){}











    public static void close() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






private static MysqlDataSource getBaseDataSource(String database){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(Config.getPropertiesValue("server"));
        dataSource.setPortNumber(Integer.parseInt(Config.getPropertiesValue("port")));
        dataSource.setUser(Config.getPropertiesValue("user"));
        dataSource.setPassword(Config.getPropertiesValue(System.getProperty("DdbPassword")));
        dataSource.setDatabaseName(database);
        return dataSource;
}

}
