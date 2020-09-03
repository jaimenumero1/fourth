package beans;

import dataBaseDriverutils.db.DataBaseUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employees {

    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private int reportsTo;
    private String jobTitle;

    public static ResultSet rs;

    public static final String[] properties_ColumnsNames = {"employeeNumber", "lastName", "firstName", "extension", "email", "officeCode",
            "reportsTo", "jobTitle"};



    public Employees(String employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, String reportsTo, String jobTitle) {
        this.employeeNumber = Integer.parseInt(employeeNumber);
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = Integer.parseInt(reportsTo);
        this.jobTitle = jobTitle;
    }


    public List<Employees> processRSTobeanList(ResultSet rs) {
        BeanProcessor beanProcessor = new BeanProcessor();
        List<Employees> processedBean = new ArrayList<>();
        try {
            processedBean = beanProcessor.toBeanList(rs, Employees.class);
            return processedBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getAllFromDataBaseEmployeesTable() {
        try {
            String query = "SELECT * FROM employees;";
            ResultSet rs = DataBaseUtils.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
