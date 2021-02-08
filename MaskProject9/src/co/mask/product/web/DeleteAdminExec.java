package co.mask.product.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class DeleteAdminExec implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// DeleteAdminExec.do 처리 메소드
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		vo.setCartProduct(Integer.parseInt(request.getParameter("row")));
		
		int n=dao.deleteAdmin(vo);
		
		return "showProduct.do";
	}
}

