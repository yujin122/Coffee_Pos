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
	
	// 중복확인
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

	// 멤버 추가
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

	// table 정보 뿌리기
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

	// 선택한 컬럼을 멤버정보수정 페이지에 넘기기
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

	// 멤버 수정
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

	// 멤버 삭제
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

	// 멤버 조회
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

/*	// 메뉴 조회
	public String[] menuSearch(String index_) {
		String[] menuData = new String[3];
		
		sql = "select name, price from menu where menuno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(index_));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				menuData[0] = rs.getString("name");
				menuData[1] = String.valueOf(rs.getInt("price"));
				//menuData[2] = String.valueOf(rs.getInt("checknum"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return menuData;
	}*/

	// 주문목록 추가
	public void addList(String[][] menu, int num) {
		//String 
		
	}

	

}
