/*
 * 
 */
package org.h2.util;
import java.sql.*;
public class Jdbcexample {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.h2.Driver");
			Connection con=DriverManager.getConnection("jdbc:h2:~/test","sa","sowjanya");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM TEST");
			while(rs.next()) { 
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}	
			st.close();
			con.close();
		} catch(SQLException e) {
			System.out.println(e);
		}
	}
	
}


