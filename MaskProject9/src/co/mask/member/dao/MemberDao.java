package co.mask.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.common.DAO;
import co.mask.member.vo.MemberVo;

public class MemberDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	// 회원가입
	public int insert(MemberVo vo) {
		String sql = "INSERT INTO MEMBER(MEMBERID, MEMBERPASSWORD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS, MEMBEREMAIL, MEMBERAUTH, MEMBERZIPCODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberPhone());
			psmt.setString(5, vo.getMemberAddress());
			psmt.setString(6, vo.getMemberEmail());
			psmt.setString(7, vo.getMemberAuth());
			psmt.setString(8, vo.getMemberZipcode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 아이디 중복체크
	public boolean idCheck(String id) {
		boolean bool = true;
		String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bool;
	}

	// 로그인
	public MemberVo login(MemberVo vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("MEMBERNAME"));
				vo.setMemberAuth(rs.getString("MEMBERAUTH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 회원의 자기정보 조회
	public ArrayList<MemberVo> select(MemberVo vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setMemberPassword(rs.getString("MEMBERPASSWORD"));
				vo.setMemberName(rs.getString("MEMBERNAME"));
				vo.setMemberPhone(rs.getString("MEMBERPHONE"));
				vo.setMemberAddress(rs.getString("MEMBERADDRESS"));
				vo.setMemberEmail(rs.getString("MEMBEREMAIL"));
				vo.setMemberAuth(rs.getString("MEMBERAUTH"));
				vo.setMemberZipcode(rs.getString("MEMBERZIPCODE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 회원의 회원수정
	public int update(MemberVo vo) {
		int n = 0;
		String sql = "UPDATE MEMBER SET MEMBERNAME=?, MEMBERPHONE=?, MEMBERADDRESS=?, MEMBEREMAIL=?, MEMBERPASSWORD=?, MEMBERZIPCODE=? WHERE MEMBERID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberName());
			psmt.setString(2, vo.getMemberPhone());
			psmt.setString(3, vo.getMemberAddress());
			psmt.setString(4, vo.getMemberEmail());
			psmt.setString(5, vo.getMemberPassword());
			psmt.setString(6, vo.getMemberZipcode());
			psmt.setString(7, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 회원의 회원탈퇴
	public int delete(MemberVo vo) {
		String sql = "DELETE FROM MEMBER WHERE MEMBERID =?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	//회원의 결제내역 확인
	

	public void close() { // close 메소드
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
