package co.mask.cart.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;

public class CartView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 장바구니 리스트 출력 & 이동
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		ArrayList<CartVo> list = new ArrayList<CartVo>();
		HttpSession session = request.getSession();

		vo.setCartUser((String) session.getAttribute("memberId"));

		list = dao.selectList(vo);

		request.setAttribute("cartList", list);

		return "view/cart/cartView";
	}

}
