package co.mask.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class Insertexec implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// Insertexec.do 처리 메소드
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();

		vo.setProductName(request.getParameter("productName"));
		vo.setProductQunt(Integer.parseInt(request.getParameter("productQunt")));
		vo.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
		vo.setProductSeller(request.getParameter("ProductSeller"));

		int n = dao.insert(vo);
		request.setAttribute("vo", vo);

		return "showProduct.do";
	}

}
