import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "web";
	String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "";
	
	public JoinDAO() {
		try {
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pwd);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 중복확인
		public boolean dcheck(String idDcheck) {
			boolean result = false;
			
			sql = "select * from mgr where mgid = ?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, idDcheck);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					result = true;
				}
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		
		}
		
		// 회원가입
		public int mJoin(String nameData, String rNumberData , String genderData,
						  String idData, String pwData, String phoneData, String emailData) {
			int res = 0;
			
			try {
				sql = "insert into mgr values(?, ?, ?, ?, ?, ?, ?, sysdate)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, nameData);
				pstmt.setString(2, rNumberData);
				pstmt.setString(3, genderData);
				pstmt.setString(4, idData);
				pstmt.setString(5, pwData);
				pstmt.setString(6, phoneData);
				pstmt.setString(7, emailData);
				
				res = pstmt.executeUpdate();
				
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return res;
		}
		
		
		
		
}
