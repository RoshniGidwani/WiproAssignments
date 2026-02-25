package wipro_JDBC;

import java.sql.*;
public class jdbc_ex3 {
		public static void main(String[] args) {
			// TODO Auto-generated method 
			try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			   
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Wiprodb", "root", "Sql@1234");
			String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)";
	        CallableStatement cs = con.prepareCall("{call getAllEmployees()}");
	        ResultSet rs = cs.executeQuery();

	   
	        System.out.printf("%-8s %-15s %-10s %-10s%n",
	                "ID", "Name", "Salary");
	        System.out.println("-----------------------------------------------");

	    
	        while (rs.next()) {
	            System.out.printf("%-8d %-15s %-10d %-10d%n",
	                    rs.getInt("id"),
	                    rs.getString("name"),
//	                    rs.getInt("dept_id"),
	                    rs.getInt("salary"));
	        }

			con.close();
			}
				catch (Exception e)
			   {
					System.out.println(e);
			   }
			}

	}

