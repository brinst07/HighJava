package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel {

	private Scanner sc;
	private Map<String, String> hotel;

	public Hotel() {
		sc = new Scanner(System.in);
		hotel = new HashMap<>();
	}

	public static void main(String[] args) {

		Hotel h = new Hotel();
		while (true) {
			System.out.println("************************************");
			System.out.println("호텔문을 열었습니다.");
			System.out.println("************************************");
			System.out.println();
			System.out.println("************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 조회 2.입력 3.삭제");
			Scanner sc = new Scanner(System.in);
			int cho = Integer.parseInt(sc.nextLine());

			switch (cho) {
			case 1:
				
				h.jdbcselect();
				break;
			case 2:
				System.out.println("방번호를 입력해주세요");
				int no = Integer.parseInt(sc.nextLine());
				System.out.println("이름을 입력해주세요");
				String name = sc.nextLine();
				h.jdbcInsert(no, name);
				break;
			case 3:
				System.out.println("예약 취소할 방번호 입력해 ");
				int temp = Integer.parseInt(sc.nextLine());
				h.deletejdbc(temp);
				break;
			case 4:
				System.exit(0);
			}
		}
	}

	public void jdbcselect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "hr";
		String pw = "oracle";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			//드라이버 로딩
			Class.forName(driver);
			
			//자바와 데이터베이스의 연동
			con = DriverManager.getConnection(url, id, pw);
			
			//stmt 객체만들기
			stmt = con.createStatement();
			
			//statement에 sql문 담기
			String sql = "SELECT * FROM hotel";
			
			set = stmt.executeQuery(sql);
			System.out.println("===========================================");
			while(set.next()) {
				System.out.println("호텔번호 : " + set.getInt("hotel_no"));
				System.out.println("숙박객 : " + set.getString("name"));
				System.out.println("===========================================");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!= null) stmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				
			}
		}
		
	}
	
	public void jdbcInsert(int no, String name) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "hr";
		String pw = "oracle";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//드라이버 불러오기
			Class.forName(driver);
			
			//자바와 데이터베이스의 연동
			conn = DriverManager.getConnection(url, id, pw);
			
			//preparedstatement
			
			String check = "select * from hotel where hotel_no = ?";
			pstmt = conn.prepareStatement(check);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이미 예약된 방입니다.");
				return;
			}
			
			String sql = "insert into hotel(hotel_no,name) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			int result = pstmt.executeUpdate();
			
			if(result ==1) {
				System.out.println("입력되었습니다.");
			}else {
				System.out.println("입력에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) 
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
	}
	
	public void deletejdbc(int temp) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "hr";
		String pw = "oracle";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			String sql = "delete from hotel where hotel_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, temp);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
	}

}
