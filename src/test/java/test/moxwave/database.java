package test.moxwave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class database {
   
    public void table_validate(){

	try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //	String dbURL = "jdbc:sqlserver://192.168.14.15:3306;Localization1.3";
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.14.15;user=sa;password=dbadmin987!;database=Localization1.3");
       

        String query="select * from CustomerMaster";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				String name=rs.getString("CustomerName");
				System.out.println(name);
			}


		}catch(Exception e) {
			System.out.println(e);
        }	
    }
}