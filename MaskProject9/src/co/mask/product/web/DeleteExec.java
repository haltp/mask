package co.mask.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class DeleteExec implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// DeleteExec.do 메소드 처리
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();

		
		//MemberVo mVo= new MemberVo();
		
		HttpSession session = request.getSession();
		String valeu = (String)session.getAttribute("memberId");
		vo.setMemberId(valeu);
		
		
		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		
		int n=dao.delete(vo);
		
		
		
		return "showProductSeller.do";

	}

}

