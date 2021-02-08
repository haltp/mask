package co.mask.cart.web;

import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class NonMemberBootPay implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 부트페이 결제 시스템
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		
		dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/cart/nonMemberBootPay";
	}

}
