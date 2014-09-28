//test
import java.sql.*;
public class PrepState {

	public static void main(String[] args) throws SQLException {
		
		String queryString = "SELECT DISTINCT ipAddress FROM testschema.testtable WHERE acctNumber = ?";
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			prep = conn.prepareStatement(queryString);
			prep.setString(1, "123456");
			rs = prep.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println("you effed up! " + e.getMessage());
		}
		finally{
			if(prep != null)
			{
				prep.close();
			}
			if(conn != null)
			{
				conn.close();
			}
			if(rs != null)
			{
				rs.close();
			}
		}
	}

}
