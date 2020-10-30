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
			pstmt.close();
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
			
			pstmt.close();
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
				String point = rs.getString("point");
				
				Object data[] = {name, birth, gender, phone, mail, point};
				dTable.addRow(data);
			}
			
			rs.close(); pstmt.close(); 
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
			
			rs.close(); pstmt.close(); 
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
			
			pstmt.close(); con.close();
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
			
			pstmt.close(); con.close();
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
				int point = rs.getInt("point");
				
				Object data[] = {name, birth, gender, phone, mail, point};
				dTable.addRow(data);
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// pos 회원조회
	public String[] memSearch(String item) {
		String[] mem = new String[2];
		
		int point = -1;
		mem[1] = String.valueOf(point);
		
		sql = "select mname, point from member where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mem[0] = rs.getString("mname");
				mem[1] = String.valueOf(rs.getInt("point"));
			}
			
			rs.close(); pstmt.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}

	// 주문목록 추가
	public int addList(int[][] list) {
		int res = 0;
		
		sql = "insert into cafeorder values(?, ?, ?, sysdate)";
		
		for(int i = 0; i < list.length; i++) {
			int no = list[i][0];
			int count =list[i][1];
			int price = list[i][2];
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setInt(2, count);
				pstmt.setInt(3, price);
				
				res = pstmt.executeUpdate();
				
				if(res < 0) {
					return res;	
				}
				
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return res;
	}

	// 메뉴 정보 가져오기
	public String[] menuInfo(int index) {
		String item[] = new String[3];
		
		sql = "select name, price from menu where menuno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				item[0] = rs.getString("name");
				item[1] = String.valueOf(rs.getInt("price"));
 			}
			
			rs.close(); pstmt.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return item;
	}

	// 영수증 출력
	public void listAll(DefaultTableModel dTable, int num) {
		
		int i = 0;
		
		sql = "select name, price, count, sumprice from menu m join cafeorder c on m.menuno = c.menunumber order by orderdate";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if(i < num) {
					i++;
					continue;
				}else {
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int count = rs.getInt("count");
					int sumprice = rs.getInt("sumprice");
					

					Object[] data = { name, price, count, sumprice };

					try {
						dTable.addRow(data);
						i++;
					} catch (NullPointerException e) {
						break;
					}

				}
			}
			
			rs.close(); pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	// cafeorder 데이터 수
	public int listCount() {
		int count = 0;
		
		sql = "select count(*) from cafeorder";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			rs.close(); pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}

	public int pointUpdate(int usingPoint, String phone) {
		int res = 0;
		
		sql = "update member set point = ? where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, usingPoint);
			pstmt.setString(2, phone);
			
			res = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public int sumPrice(int count) {
		int i = 0, sum = 0;
		
		sql = "select sumprice from menu m join cafeorder c on m.menuno = c.menunumber order by orderdate";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				if(i < count) {
					i++;
					continue;
				}else {
					int sumprice = rs.getInt("sumprice");
					sum += sumprice;
				}
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return sum;
	}

	// 일매출 
	public int sumDay(int year_, int month_, String data) {
		int sales = 0;
		String date = year_+"-"+month_+"-"+data;
		
		sql = "select sum(money) from cafesum where to_char(todaydate,'YYYY-mm-dd')= ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sales = rs.getInt(1);
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sales;
		
	}

	// 월매출
	public int sumMonth(int year_, int month_) {
		int sales = 0;
		
		String date = year_+"-"+month_;
		sql = "select sum(money) from cafesum where to_char(todaydate,'YYYY-mm')= ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sales = rs.getInt(1);
			}
			
			rs.close(); pstmt.close(); con.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sales;
		
	}

	// 매출 DB 저장
	public int addSales(int sum) {
		int res = 0;
		sql = "insert into cafesum values(sysdate, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sum);
			
			res = pstmt.executeUpdate();
			
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	
}
