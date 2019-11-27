package test.moxwave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class database {
   
    public static void main(String[]args){

	try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //	String dbURL = "jdbc:sqlserver://192.168.14.15:3306;Localization1.3";
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.14.15;user=sa;password=dbadmin987!;database=EditToolLocalization");
        String query="select * from englishtoindic";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for(int i=1; i<=rsmd.getColumnCount();i++){
			
			 System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println("");

             int j=1;
			while(rs.next()) {
				
			String InputHash=rs.getString("InputHash")+"\t";
			String inputtext=rs.getString("InputText")+"\t";
		    String outputtext=rs.getString("OutputText")+"\t";
				System.out.print(rs.getString("Out_Language")+"\t");
				System.out.print(rs.getString("Creationdate")+"\t");
				System.out.print(rs.getString("Pred_Score")+"\t");

			}
		}catch(Exception e) {
			System.out.println(e);
        }	
    }
}