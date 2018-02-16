package Employees.db;


import org.aopalliance.reflect.Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MySQL {



     private Connection connect;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3307/employees";
    private String username="root";
     private String password="";

    public List<String> getEmployees(){
        List<String> list = new ArrayList<>() ;
        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url,username,password);
            String query = "select last_name from employees";

            PreparedStatement prst = connect.prepareStatement(query);
            ResultSet rst=prst.executeQuery();
            while(rst.next()){
                String name=rst.getString("last_name");
                list.add(name);
            }

        }

        catch(Exception exc){
            System.out.println("Err: "+ exc.getMessage());
        }

        return list;
        }

    public String getSalary(String name){
        String result = "";
        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url, username, password);
                String query = "select max.(salaries.salary) as sal from salaries inner join employees " +
                        "on salaries.emp_no = employees.emp_no where employees.last_name ='" +name+ "'";
            PreparedStatement prst = connect.prepareStatement(query);
            ResultSet rst = prst.executeQuery();
            while(rst.next())
                result = rst.getString("sal");


        } catch (Exception exc) {
            System.out.println("Error: " +exc.getMessage()) ;

          }

        return result;
    }
}
