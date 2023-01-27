package employeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class databaseConnection {

    Connection c;
    Statement s;
    public databaseConnection(){


        try{
            //register the driver class
            //path to class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creating connection string
            c= DriverManager.getConnection("jdbc:mysql:///EmployeeManagementSystem","root","vabh3101@");
            //creating statement class
            s=c.createStatement();
            //creating mysql queries

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
