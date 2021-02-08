package co.mask.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.common.DAO;
import co.mask.member.vo.MemberVo;

public class AdminDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	// 관리자의 회원조회
	public ArrayList<MemberVo> selectUserList() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM MEMBER WHERE MEMBERAUTH='USER'";
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("MEMBERID"));
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
	//관리자의 회원 한 건 가져오기
	public MemberVo select(MemberVo vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("MEMBERID"));
				vo.setMemberName(rs.getString("MEMBERNAME"));
				vo.setMemberPhone(rs.getString("MEMBERPHONE"));
				vo.setMemberAddress(rs.getString("MEMBERADDRESS"));
				vo.setMemberEmail(rs.getString("MEMBEREMAIL"));
				vo.setMemberAuth(rs.getString("MEMBERAUTH"));
				vo.setMemberZipcode(rs.getString("MEMBERZIPCODE"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	} 
	
	//관리자의 회원, 거래처 수정
	public int update(MemberVo vo) {
		int n = 0;
		String sql = "UPDATE MEMBER SET MEMBERNAME=?, MEMBERPHONE=?, MEMBERADDRESS=?, MEMBEREMAIL=?, MEMBERZIPCODE=? WHERE MEMBERID=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberName());
			psmt.setString(2, vo.getMemberPhone());
			psmt.setString(3, vo.getMemberAddress());
			psmt.setString(4, vo.getMemberEmail());
			psmt.setString(5, vo.getMemberZipcode());
			psmt.setString(6, vo.getMemberId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	//관리자의 회원, 거래처 삭제
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
	
	//관리자의 거래처 조회
	public ArrayList<MemberVo> selectSellerList() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM MEMBER WHERE MEMBERAUTH='SELLER'";
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("MEMBERID"));
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
