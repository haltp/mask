package co.mask.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class UpdateExec implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// UpdateExec.do 처리 메소드
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();

		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		vo.setProductName(request.getParameter("productName"));
		vo.setProductQunt(Integer.parseInt(request.getParameter("productQunt")));
		vo.setProductPrice(Integer.parseInt(request.getParameter("productPrice")));
		vo.setProductSeller(request.getParameter("ProductSeller"));

		int n = dao.update(vo);
		request.setAttribute("vo", vo);

		return "showProduct.do";
	}

}
