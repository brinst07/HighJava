package kr.or.ddit.basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T03_JdbcTest {
	/**
	 * Insert 예제
	 */
	public static void main(String[] args) {
	/**
	 * lprod_id : 101, lprod_gu : N101, lprod_nm : 농산물
	 * lprod_id : 102, lprod_gu : N102, lprod_nm : 수산물
	 * lprod_id : 103, lprod_gu : N103, lprod_nm : 축산물
	 * 
	 * 위 3개의 자료를 추가하기
	 */
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB에 접속(Connection 객체 생성)
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userId = "brinst";
			String password = "java";
			
			con = DriverManager.getConnection(url,userId, password);
			
			/*
			 * //3. Statement객체 생성 => Connection 객체를 이용한다. stmt = con.createStatement();
			 * 
			 * String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm)"+
			 * "values('101','N101','농산물')";
			 * 
			 * //SQL문이 select문이 아닐 경우에는 executeupdate()메서드를 사용한다. //executeUpdate()메서드는 실행한
			 * 성공한 레코드 수를 반환한다.
			 * 
			 * int cnt = stmt.executeUpdate(sql); System.out.println("첫번쨰 반환값 : " + cnt);
			 * 
			 * //----------------------------------------------------------------------- sql
			 * = "insert into lprod(lprod_id, lprod_gu, lprod_nm)"+
			 * "vales (102,'N102','수산물')"; cnt = stmt.executeUpdate(sql);
			 * System.out.println("두번쨰 반환값 : " + cnt);
			 * //-----------------------------------------------------------------------
			 */
			//Preparedtatement 객체를 이용한 자료 추가 방법
			String sql = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values(?,?,?)";
			//PreparedStatement 객체를 생성할때 SQL문을 넣어서 생성한다.
			pstmt = con.prepareStatement(sql);
			
			//쿼리문의 물음표(?) 자리에 들어갈 데이터를 셋팅한다.
			//형식) pstmt.set자료형이름(물음표 순번, 데이터);
			//물음표 순번은 1번부터 시작한다.
			
			pstmt.setInt(1, 101);
			pstmt.setString(2, "N101");
			pstmt.setString(3, "농산물");
			
			//데이터를 셋팅한 후 쿼리문을 실행한다.
			int cnt = pstmt.executeUpdate();
			System.out.println("첫번째 반환값" + cnt);
			//-----------------------------------------------------------------------
			pstmt.setInt(1, 102);
			pstmt.setString(2, "N102");
			pstmt.setString(3, "수산물");
			cnt = pstmt.executeUpdate();
			System.out.println("두번째 반환값" + cnt);
			//-----------------------------------------------------------------------
			pstmt.setInt(1, 103);
			pstmt.setString(2, "N103");
			pstmt.setString(3, "축산물");
			cnt = pstmt.executeUpdate();
			System.out.println("세번째 반환값" + cnt);
			System.out.println("작업 끝....");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
