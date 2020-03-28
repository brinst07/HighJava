package kr.or.ddit.basic;

import util.DBUtil;
import util.DBUtil2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements IMemberDao{
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    /**
     * 자원 반납용 메소드
     */
    private void disConnect() {
        if(rs!=null)try {rs.close();}catch(SQLException ee) {}
        if(stmt!= null)try {stmt.close();}catch(SQLException ee) {}
        if(pstmt!=null)try {pstmt.close();}catch(SQLException ee) {}
        if(conn!=null)try {conn.close();}catch(SQLException ee) {}

    }


    @Override
    public int insertMember(MemberVO mv) {
        int cnt = 0;
        try {
            conn = DBUtil.getConnection();

            String sql = "insert into mymember (mem_id, mem_name, mem_tel, mem_addr) values(?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mv.getMem_id());
            pstmt.setString(2, mv.getMem_name());
            pstmt.setString(3, mv.getMem_tel());
            pstmt.setString(4, mv.getMem_addr());

            cnt = pstmt.executeUpdate();


        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disConnect();
        }
        return 0;
    }

    @Override
    public boolean getMember(String memId) {
        boolean chk = false;

        try {
            conn = DBUtil.getConnection();
            String sql = "select count(*) as cnt from mymember"
                    + " where mem_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);

            rs = pstmt.executeQuery();

            int cnt = 0;
            if(rs.next()) {
                cnt = rs.getInt("cnt");
            }

            if(cnt > 0) {
                chk = true;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            disConnect();
        }
        return chk;
    }


    @Override
    public List<MemberVO> getAllMemberList() {

        List<MemberVO> memlist = new ArrayList<>();

        try {
            conn = DBUtil.getConnection();

            String sql = "select * from mymember";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MemberVO mv = new MemberVO();
                mv.setMem_id(rs.getString("mem_id"));
                mv.setMem_name(rs.getString("mem_name"));
                mv.setMem_tel(rs.getString("mem_tel"));
                mv.setMem_addr(rs.getString("mem_addr"));
                memlist.add(mv);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disConnect();
        }
        return memlist;
    }

    @Override
    public int updateMember(MemberVO mv) {
        int cnt = 0;
        try {
            conn = DBUtil.getConnection();

            String sql = "UPDATE mymember SET mem_id=?, mem_name=?, mem_tel=?, mem_addr=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mv.getMem_id());
            pstmt.setString(2, mv.getMem_name());
            pstmt.setString(3, mv.getMem_tel());
            pstmt.setString(4, mv.getMem_addr());

            cnt = pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disConnect();
        }
        return cnt;
    }

    @Override
    public int deleteMember(String memId) {
        int cnt = 0;
        try {
            conn = DBUtil2.getConnection();

            String sql = "DELETE FROM mymember WHERE mem_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memId);

            cnt = pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disConnect();
        }
        return cnt;
    }
}
