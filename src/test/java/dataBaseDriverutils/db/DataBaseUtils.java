package dataBaseDriverutils.db;

import beans.Employees;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.config.Config;

import java.sql.*;

public class DataBaseUtils<T> {

    public static Connection connection;
    private static Statement statement;
    private static QueryRunner queryRunner;


    private DataBaseUtils() {
    }


    public static void main(String[] args) {
        System.out.println(System.getProperty("dbPassword"));
      //  System.out.println(System.getenv("dbPassword"));
        openTestDataBase();
        ResultSet rs = executeQuery("SELECT * FROM employees WHERE lastName = ?" +
                " AND firstName = ? AND officeCode = ?;","Lopez","John"
        ,223);
        System.out.println(new Employees().processRSTobeanList(rs));
        close();
    }

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

    public static void openTestDataBase(){
       try {
           DataBaseUtils.open("test");
       }catch (SQLException ex){
           ex.printStackTrace();
       }
    }


    public static void open() throws SQLException {
        open("food_delivery_db1");
    }


    // public static void connectToDatabase(){}
    public static void executeUpdate() {

    }

    public static <T> T executeQueryToBean(String query, Class<T> c) throws SQLException {
        return queryRunner.query(query, new BeanHandler<>(c));
    }

    public static void executeUpdate(String query) throws SQLException {
        boolean isUpdatedOrNot = statement.execute(query);
        System.out.println(isUpdatedOrNot);
    }


    public static boolean executeInsert(String query, Object bean, String[] properties) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        try {  // instantiate new prep statement
            queryRunner.fillStatementWithBean(preparedStatement, bean, properties);
            System.out.println(bean);
            // fill the statement(replace ? with values from our Bean(Object) from variable names provide as properties )
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement.execute();
    }

    // This method underneath replaces question marks with Object which can be a String,Double,int,ect...
    // This method uses prepared method class and can only replace filtering data
    // Specifically data after the keyword WHERE it can not replace question marks before WHERE keyword hence "filtering Data(parameterized filter)
    // For example SELECT * FROM employees WHERE lastName = ?;    Database.query(query, Lopez);
    // In the above statement we would need to specify if the value was a String/int/double by providing single quotes or
    //not prepared statement knows the data type saving us from having to implement different methods for diff. data types
    //P
    public static ResultSet executeQuery(String query, Object... params)  {
        try {
            if (params.length == 0) return statement.executeQuery(query);

            // Prepared statement is used to execute a number of same queries with different params
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            return preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public static void truncate(String table) throws SQLException {
        statement.execute("TRUNCATE TABLE " + table + ";");
    }


    public static void close() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static MysqlDataSource getBaseDataSource(String database) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(Config.getPropertiesValue("server"));
        dataSource.setPortNumber(Integer.parseInt(Config.getPropertiesValue("port")));
        dataSource.setUser(Config.getPropertiesValue("user"));
        String passwordVmOptions = System.getProperty("dbPassword");
        //dataSource.setPassword(System.getProperty("dbPassword"));

        dataSource.setPassword(passwordVmOptions);
        dataSource.setDatabaseName(database);
        return dataSource;
    }

}
