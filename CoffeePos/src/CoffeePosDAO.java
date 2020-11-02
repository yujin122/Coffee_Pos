import java.sql.*;

import javax.swing.table.DefaultTableModel;

// DB
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
	
	// Login
	
	// 로그인
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
			e.printStackTrace();
		
		}
		return result;

	}

	// 아이디 중복확인
	public boolean dcheck(String idDcheck) {
		boolean result = false;

		sql = "select * from mgr where mgid = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idDcheck);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	// 관리자 회원가입
	public int mJoin(String nameData, String rNumberData, String genderData, String idData, String pwData,
			String phoneData, String emailData) {
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
	
	// 아이디 찾기
	public String fId(String namef, String rNumberf) {
		String result = null;
		
		sql = "select mgid from mgr where mgname = ? and mgrnumber = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, namef);
			pstmt.setString(2, rNumberf);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("mgid");
			}
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 비밀번호 찾기
	public String fpw(String namefind, String rNumberfind, String idfind) {
		String result = null;
		
		sql = "select mgpw from mgr where mgname = ? and mgrnumber = ? "
				+ "and  mgid = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, namefind);
			pstmt.setString(2, rNumberfind);
			pstmt.setString(3, idfind);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("mgpw");
			}
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	// MemberManage

	// 회원 table 정보 뿌리기
	public void memTableAll(DefaultTableModel dTable) {

		try {
			sql = "select * from member";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("mname");
				int birth = rs.getInt("mbirth");
				String gender = rs.getString("mgender");
				String phone = rs.getString("mphone");
				String mail = rs.getString("memail");
				String point = rs.getString("point");

				Object data[] = { name, birth, gender, phone, mail, point };
				dTable.addRow(data);
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 멤버 조회
	public void memSearch(String item, DefaultTableModel dTable) {
		sql = "select * from member where mphone = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);

			rs = pstmt.executeQuery();
			dTable.setRowCount(0);

			while (rs.next()) {

				String name = rs.getString("mname");
				int birth = rs.getInt("mbirth");
				String gender = rs.getString("mgender");
				String phone = rs.getString("mphone");
				String mail = rs.getString("memail");
				int point = rs.getInt("point");

				Object data[] = { name, birth, gender, phone, mail, point };
				dTable.addRow(data);
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 멤버 추가
	public int memAdd(String phoneData, String nameData, String birthData, String genderData, String emailData) {
		int res = 0;

		try {
			sql = "insert into member values(mem_seq.nextval, ?, ?, ?, ?, ?, 0)";

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

	// 회원 핸드폰 중복확인
	public boolean isExist(String phoneExist) {
		boolean result = false;

		sql = "select * from member where mphone = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneExist);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 선택한 컬럼을 멤버정보수정 페이지에 넘기기
	public String[] memUpdateForm(String phoneData) {
		String[] data = new String[5];

		sql = "select * from member where mphone = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneData);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				data[0] = rs.getString("mname");
				data[1] = String.valueOf(rs.getInt("mbirth"));
				data[2] = rs.getString("mgender");
				data[3] = rs.getString("mphone");
				data[4] = rs.getString("memail");
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
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

			pstmt.close();
			con.close();
		} catch (SQLException e) {
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

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	// StockManage
	
	// 재고 저장하는메서드
	public int stockAdd(String stoname, String stocount) {
		int res = 0;

		try {

			String sql = "insert into stock values(?, ?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, stoname);
			pstmt.setInt(2, Integer.parseInt(stocount));

			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	// 재고 table
	public void stoTableAll(DefaultTableModel dTable) {

		try {
			sql = "select * from stock";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String stoname = rs.getString("stoname");
				int stocount = rs.getInt("stocount");

				Object data[] = { stoname, stocount };
				dTable.addRow(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 재고 선택정보 수정페이지에 뿌려주기
	public String[] stoUpdateForm(String stoname) {

		String[] data = new String[2];

		try {
			sql = "select * from stock where stoname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stoname);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				data[0] = rs.getString("stoname");
				data[1] = String.valueOf(rs.getInt("stocount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;

	}

	// 재고 정보 수정
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
			e.printStackTrace();
		}

		return res;

	}

	// 재고 삭제
	public int stoDelete(String stoname) {

		int res = 0;

		try {

			sql = "delete from stock where stoname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stoname);
			res = pstmt.executeUpdate();

			// open 객체 닫기
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 재고 찾기
	public void stoSearch(String item, DefaultTableModel dTable) {

		try {
			sql = "select * from stock where stoname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);

			rs = pstmt.executeQuery();
			dTable.setRowCount(0);

			while (rs.next()) {

				String stoname = rs.getString("stoname");
				int stockcount = rs.getInt("stocount");

				Object data[] = { stoname, stockcount };
				dTable.addRow(data);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SalesManage

	// 일매출
	public int sumDay(int year_, int month_, String data) {
		int sales = 0;
		String date = year_ + "-" + month_ + "-" + data;

		sql = "select sum(money) from cafesum where to_char(todaydate,'YYYY-mm-dd')= ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sales = rs.getInt(1);
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sales;

	}

	// 월매출
	public int sumMonth(int year_, int month_) {
		int sales = 0;

		String date = year_ + "-" + month_;
		sql = "select sum(money) from cafesum where to_char(todaydate,'YYYY-mm')= ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, date);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sales = rs.getInt(1);
			}

			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sales;

	}
	
	// POS 
	
	// 메뉴 정보 가져오기
	public String[] menuInfo(int index) {
		String item[] = new String[3];

		sql = "select name, price from menu where menuno = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, index);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				item[0] = rs.getString("name");
				item[1] = String.valueOf(rs.getInt("price"));
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return item;
	}

	// cafeorder 데이터 수
	public int listCount() {
		int count = 0;

		sql = "select count(*) from cafeorder";

		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// 주문목록 추가
	public int addList(int[][] list) {
		int res = 0;

		sql = "insert into cafeorder values(?, ?, ?, sysdate)";

		for (int i = 0; i < list.length; i++) {
			int no = list[i][0];
			int count = list[i][1];
			int price = list[i][2];

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.setInt(2, count);
				pstmt.setInt(3, price);

				res = pstmt.executeUpdate();

				if (res < 0) {
					return res;
				}

				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	// pos 회원조회
	public String[] memSearch(String item) {
		String[] mem = new String[3];
		
		int point = -1;
		mem[1] = String.valueOf(point);
		
		sql = "select mnum, mname, point from member where mphone = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mem[0] = rs.getString("mname");
				mem[1] = String.valueOf(rs.getInt("point"));
				mem[2] = String.valueOf(rs.getInt("mnum"));
			}
			
			rs.close(); pstmt.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mem;
	}

	// 회원 포인트 적립 사용
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
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 포인트 저장
	public int pointInsert(String mnum) {
		int res = 0;
		sql = "insert into pointlist values(?,?,0,sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(mnum));
			pstmt.setInt(2, POS.savep);
			
			res = pstmt.executeUpdate();
		
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 사용포인트 추가
	public int pointUpdate(String mnum) {
		int res = 0;
		
		sql = "update pointlist set usepoint = ? where pnum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, POS.usep);
			pstmt.setInt(2, Integer.parseInt(mnum));
			
			res = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	// 포인트 조회
	public int[] pointSearch() {
		int point[] = null;
		
		sql = "select * from (select pnum, savepoint, usepoint from pointlist order by pdate desc) where rownum <=1";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				point = new int[4];
				point[0] = rs.getInt(1);
				point[1] = rs.getInt(2);
				point[2] = rs.getInt(3);
			}
			
			rs.close(); pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return point;
		
	}
	
	// 멤버 포인트 업데이트
	public int memPointUpdate(int[] point) {
		int res = 0;
		
		sql = "update member set point = point - ? where mnum = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (point[2]-point[1]));
			pstmt.setInt(2, point[0]);
			
			res = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	
	}
	
	// 초기화, 포인트 리스트 삭제
	public int pointDelete() {
		int res = 0;
		
		sql = "delete from pointlist "
				+ "where pdate = "
				+ "(select * "
				+ "from (select pdate from pointlist order by pdate desc) "
				+ "where rownum <=1)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
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
			e.printStackTrace();
		}		
	}

	// 주문한 메뉴 총 합가격
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
			e.printStackTrace();
		}	
		
		return sum;
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
			e.printStackTrace();
		}
		
		return res;
	}

}
