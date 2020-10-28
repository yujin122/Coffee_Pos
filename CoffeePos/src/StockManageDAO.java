
import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class StockManageDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web";
	String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	String sql = "";
	
	public StockManageDAO() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// 저장하는메서드
	public int stockAdd(String stoname, String stocount) {
		int res = 0;
		
		
		try {
			
			String sql = "insert into stock values(?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, stoname);
			pstmt.setInt(2, Integer.parseInt(stocount));
			
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	public void tableAll(DefaultTableModel dTable) {
		
		try {
			sql = "select * from stock";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String stoname = rs.getString("stoname");
				int stocount = rs.getInt("stocount");
				
				Object data[] = {stoname, stocount};
				dTable.addRow(data);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	// 선택정보 수정페이지에 뿌려주기
	public String[] stoUpdateForm(String stoname) {
		
		String[] data = new String[2];
		
		try {
			sql = "select * from stock where stoname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stoname);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				data[0] = rs.getString("stoname");
				data[1] = String.valueOf(rs.getInt("stocount"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
		
	}
	
	
	
	// 정보 수정
	public int stoUpdate(String stoname_, String stocount, String stoname) {
		int res = 0;
		
		try {
			
			sql = "update stock set stoname = ?, stocount = ? where stoname = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, stoname);
			pstmt.setInt(2, Integer.parseInt(stocount));
			pstmt.setString(3, stoname);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
		
	}
	
	
	
	// 삭제하는 메서드
	public int stoDelete(String stoname) {
		
		int res = 0;
		
		
		
		try {
			
			sql = "delete from stock where stoname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stoname);
			res = pstmt.executeUpdate();
			
			// open 객체 닫기
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	//찾기
	public void stoSearch(String item, DefaultTableModel dTable) {
		
		
		try {
			sql = "select * from stock where stoname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			
			rs = pstmt.executeQuery();
			dTable.setRowCount(0);
			
			while(rs.next()) {
				
				String stoname = rs.getString("stoname");
				int stockcount = rs.getInt("stocount");
				
				Object data[] = {stoname, stockcount};
				dTable.addRow(data);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	

}
