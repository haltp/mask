package co.mask.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;

public class CartDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 장바구니 삭제
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		vo.setCartNumber(Integer.parseInt(request.getParameter("cartNumber")));
		
		dao.delete(vo);
		
		return "cartView.do";
	}

}
