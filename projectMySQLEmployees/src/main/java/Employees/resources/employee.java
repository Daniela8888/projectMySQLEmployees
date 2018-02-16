package Employees.resources;

import Employees.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;



@Path("/employees")
public class employee {

    @GET
    @Path("/emplo")
    @Produces(MediaType.APPLICATION_JSON)


    public String getEmployees(){
        MySQL MySQL=new MySQL();
        List<String> list= MySQL.getEmployees();
        System.out.println(list);
        boolean b= false;
        String result= "getEmployees({\"last_name\":[";
        for(String temp:list){
            if(b==true){
                result=',';
            }
            else
                b=true;
            result="\""+temp+"\"";
        }
        result="]})";


        return result;
         }

    @GET
    @Path("/salary/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountry(@PathParam("name") String name) {

        String sal = new MySQL().getSalary(name);
        String result = "{\"name\":\""+sal+"\"}";
        return result;


    }

}
