package co.mask.sell.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.common.DAO;
import co.mask.sell.vo.SellVo;

public class SellDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<SellVo> selectList(SellVo vo) { // 판매완료 상품 목록 리스트 ( 구매자 )
		ArrayList<SellVo> list = new ArrayList<SellVo>();
		String sql = "SELECT * FROM SELL S, PRODUCT P, MEMBER M WHERE S.SELLUSER = M.MEMBERID AND S.SELLUSER = ?"
				+ " AND P.PRODUCTNUM = S.SELLPRODUCTNUMBER";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getSellUser());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SellVo();
				vo.setSellNumber(rs.getInt("sellnumber"));
				vo.setSellProductNumber(rs.getInt("sellproductnumber"));
				vo.setProductName(rs.getString("productname"));
				vo.setProductPrice(rs.getInt("productprice"));
				vo.setProductSeller(rs.getString("productseller"));
				vo.setSellUser(rs.getString("selluser"));
				vo.setSellDate(rs.getDate("selldate"));
				vo.setSellQunt(rs.getInt("sellqunt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public ArrayList<SellVo> selectListSeller(SellVo vo) { // 판매완료 상품 목록 리스트 ( 판매자 )
		ArrayList<SellVo> list = new ArrayList<SellVo>();
		String sql = "SELECT * FROM SELL S, PRODUCT P, MEMBER M WHERE S.SELLUSER = M.MEMBERID "
				+ "AND P.PRODUCTSELLER = ? AND P.PRODUCTNUM = S.SELLPRODUCTNUMBER";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductSeller());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SellVo();
				vo.setSellNumber(rs.getInt("sellnumber"));
				vo.setSellProductNumber(rs.getInt("sellproductnumber"));
				vo.setProductName(rs.getString("productname"));
				vo.setProductPrice(rs.getInt("productprice"));
				vo.setProductSeller(rs.getString("productseller"));
				vo.setSellUser(rs.getString("selluser"));
				vo.setSellDate(rs.getDate("selldate"));
				vo.setSellQunt(rs.getInt("sellqunt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public int insert(SellVo vo) { // 구매한 상품 정보 입력
		int n = 0;
		String sql = "INSERT INTO SELL VALUES(SEQSELL.NEXTVAL, ?, SYSDATE, ?, ?);";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getSellProductNumber());
			psmt.setString(2, vo.getSellUser());
			psmt.setInt(3, vo.getSellQunt());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
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
