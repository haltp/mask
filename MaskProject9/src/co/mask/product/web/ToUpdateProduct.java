
package co.mask.product.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class ToUpdateProduct implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// ToUpdateProduct.do 처리 메소드
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		
		vo.setProductNum(Integer.parseInt(request.getParameter("row")));
		dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/product/updateProductForm";
	}

}

