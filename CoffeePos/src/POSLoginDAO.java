import java.sql.*;
import java.util.*;



public class POSLoginDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "web";
	String pwd = "1234";
	
	boolean flag = false;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	String dbpwd = "";
	
public POSLoginDAO() {
	
	try {
		Class.forName(driver);
		
		con = DriverManager.getConnection(url, user, pwd);
				
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
public boolean loginsave(String idData, String pwData) {
	boolean result = false;
	
	sql = "select * from mgr where mgid = ? and mgpw = ?";
	
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, idData);
		pstmt.setString(2,pwData);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			result = true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	return result;
	
	
	
}


		
	
	
}
