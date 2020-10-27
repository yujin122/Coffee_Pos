import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class CoffeePosDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web";
	String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	String sql = "";
	
	public CoffeePosDAO() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public boolean isExist(String phoneExist) {
		boolean result = false;
		
		sql = "select * from member where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneExist);
			
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

	public int memAdd(String phoneData, String nameData, String birthData, String genderData, String emailData) {
		int res = 0;
		
		try {
			sql = "insert into member values(?, ?, ?, ?, ?, 0)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nameData);
			pstmt.setInt(2, Integer.parseInt(birthData));
			pstmt.setString(3, genderData);
			pstmt.setString(4, phoneData);
			pstmt.setString(5, emailData);

			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public void tableAll(DefaultTableModel dTable) {
		
		try {
			sql = "select * from member";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("mname");
				int birth = rs.getInt("mbirth");
				String gender = rs.getString("mgender");
				String phone = rs.getString("mphone");
				String mail = rs.getString("memail");
				
				Object data[] = {name, birth, gender, phone, mail};
				dTable.addRow(data);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	public String[] memUpdateForm(String phoneData) {
		String[] data = new String[5];
		
		sql = "select * from member where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneData);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				data[0] = rs.getString("mname");
				data[1] = String.valueOf(rs.getInt("mbirth"));
				data[2] = rs.getString("mgender");
				data[3] = rs.getString("mphone");
				data[4] = rs.getString("memail");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

	public int memUpdate(String nameData, String phoneData_, String emailData, String phoneData) {
		int res = 0;
		
		sql = "update member set mname = ?, mphone = ?, memail = ? where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, nameData);
			pstmt.setString(2, phoneData_);
			pstmt.setString(3, emailData);
			pstmt.setString(4, phoneData);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int memDelete(String phoneData) {
		int res = 0;
		
		sql = "delete from member where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneData);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public void memSearch(String item, DefaultTableModel dTable) {
		
		sql = "select * from member where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);

			
			rs = pstmt.executeQuery();
			dTable.setRowCount(0);
			
			while(rs.next()) {
				
				String name = rs.getString("mname");
				int birth = rs.getInt("mbirth");
				String gender = rs.getString("mgender");
				String phone = rs.getString("mphone");
				String mail = rs.getString("memail");
				
				Object data[] = {name, birth, gender, phone, mail};
				dTable.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
