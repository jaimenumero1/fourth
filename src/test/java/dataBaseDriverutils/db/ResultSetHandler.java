package dataBaseDriverutils.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetHandler {


    public static List<Map<String, Object>> rsToList(ResultSet rs) {
        try {
            List<Map<String, Object>> table = new ArrayList<>();
            List<String> headers = getHeaders(rs); // Store headers
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>(); // declare a map that would represent a row
                for (String headerName : headers) { // Iterating through headers
                    row.put(headerName, rs.getObject(headerName)); // populating the row with (key = header name; value = is a value from result set under that column)
                }
                table.add(row);
            }
            return table;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }



    private static List<String> getHeaders(ResultSet rs) throws SQLException {
        try {
            List<String> headers = new ArrayList<>();
            // get MetaData (Data about data)
            ResultSetMetaData metaData = rs.getMetaData(); // Metadata contains names of the columns
            int num_of_colums = metaData.getColumnCount(); // Returns the number of columns in our result set
            for (int i = 1; i <= num_of_colums; i++) {
                headers.add(metaData.getColumnName(i)); //getColumnName(i)  Returns the name of the column, expects the index
            }
            return headers;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
