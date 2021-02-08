package co.mask.cart.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class NonMemberCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		HttpSession session = request.getSession();
		
		if (request.getParameter("productNum") != null) {
			vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
			dao.select(vo);
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList<ProductVo> arr = (ArrayList) session.getAttribute("arr");
			if (arr == null) arr = new ArrayList<ProductVo>();
			
			arr.add(vo);
			
			session.setMaxInactiveInterval(1*60*20);
			session.setAttribute("NonMemberList", arr);
		}

		return "view/cart/nonMemberCart";
	}

}
