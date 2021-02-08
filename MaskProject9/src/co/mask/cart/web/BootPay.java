package co.mask.cart.web;

import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;

public class BootPay implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 부트페이 결제 시스템
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		vo.setCartProduct(Integer.parseInt(request.getParameter("cartProduct")));
		vo.setCartUser(request.getParameter("cartUser"));
		
		dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/cart/bootPay";
	}

}
