package co.mask.cart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.cart.vo.CartVo;
import co.mask.common.DAO;

public class CartDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<CartVo> selectList(CartVo vo) { // 유저 장바구니 리스트 조회
		ArrayList<CartVo> list = new ArrayList<CartVo>();
		String sql = "SELECT * FROM CART C, PRODUCT P WHERE CARTUSER = ? AND C.CARTPRODUCT = P.PRODUCTNUM";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCartUser());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new CartVo();
				vo.setCartNumber(rs.getInt("cartnumber"));
				vo.setCartUser(rs.getString("cartuser"));
				vo.setCartProduct(rs.getInt("cartproduct"));
				vo.setCartSelect(rs.getInt("cartselect"));
				vo.setProductName(rs.getString("productname"));
				vo.setProductPrice(rs.getInt("productprice"));
				vo.setProductSeller(rs.getString("productseller"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public CartVo select(CartVo vo) { // 장바구니 결제시 한개의 리스트 조회
		String sql = "SELECT * FROM CART C, PRODUCT P WHERE C.CARTUSER = ? AND P.PRODUCTNUM = C.CARTPRODUCT AND CARTPRODUCT = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCartUser());
			psmt.setInt(2, vo.getCartProduct());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setCartNumber(rs.getInt("cartnumber"));
				vo.setCartUser(rs.getString("cartuser"));
				vo.setCartProduct(rs.getInt("cartproduct"));
				vo.setCartSelect(rs.getInt("cartselect"));
				vo.setProductNum(rs.getInt("productNum"));
				vo.setProductName(rs.getString("productName"));
				vo.setProductQunt(rs.getInt("productQunt"));
				vo.setProductPrice(rs.getInt("productPrice"));
				vo.setProductSeller(rs.getString("productSeller"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	public int delete(CartVo vo) { //장바구니 삭제
		int n = 0;
		String sql = "DELETE FROM CART WHERE CARTNUMBER = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getCartNumber());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public int insert(CartVo vo) { //장바구니 추가
		int n = 0;
		String sql = "INSERT INTO CART VALUES(SEQCART.NEXTVAL, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCartUser());
			psmt.setInt(2, vo.getCartProduct());
			psmt.setInt(3, vo.getCartSelect());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//관리자 상품 삭제**
		public int deleteAdmin(CartVo vo) {
			int n=0;
			String sql="DELETE FROM PRODUCT WHERE PRODUCTNUM IN(SELECT C.CARTPRODUCT FROM CART C WHERE C.CARTPRODUCT=?)";
			
			try {
				psmt=conn.prepareStatement(sql);
				psmt.setInt(1, vo.getCartProduct());
				
				n=psmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
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
