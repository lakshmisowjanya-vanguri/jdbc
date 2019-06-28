/**
 * 
 */
package org.h2.util;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
// TODO: Auto-generated Javadoc

/**
 * The Class JDBCExample1.
 *
 * @author sowjanya
 * 
 */
public class JDBCExample1 {

	/**
	 * this is a main method.
	 *
	 * @param args the arguments
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static void main(final String[] args)throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		   Connection con=null;;
		  ResultSet rsltst;
		try {
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","sowjanya");
			/**
			 * this statement is used to insert the values into database
			 */
			PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?)");
			PreparedStatement pstmt1=con.prepareStatement("select * from employee");
			pstmt.setInt(1,15);
			pstmt.setString(2,"aarati");
			pstmt.executeUpdate();
			/**
			 * this is used for to execute the data in database
			 */
			 rsltst=pstmt1.executeQuery();
			/**
			 * it is used for to get the driver name and version 
			 */
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("driver  name"+dbmd.getDriverName());
			System.out.println("driver version  "+dbmd.getDriverVersion());

			ResultSetMetaData rsmd = rsltst.getMetaData();
			int colCount = rsmd.getColumnCount();
			System.out.println("Number Of Columns : "+colCount);
			System.out.println("column Details :");
			for(int i=1;i<=colCount;i++) {
				String colName = rsmd.getColumnName(i);
				String colType = rsmd.getColumnTypeName(i);
				System.out.println(colName+"  type of  "+colType);
			}     

			while(rsltst.next()) {
				System.out.println(rsltst.getInt(1)+" "+rsltst.getString(2));
			}
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			con.close();
		}
	}
}
