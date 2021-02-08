package co.mask.sell.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;
import co.mask.sell.dao.SellDao;
import co.mask.sell.vo.SellVo;

public class SellInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 판매 완료시 Sell 테이블 입력
		SellDao dao = new SellDao();
		SellVo vo = new SellVo();
		HttpSession session = request.getSession();
		
		vo.setSellProductNumber(Integer.parseInt(request.getParameter("productNum")));
		vo.setSellUser((String) session.getAttribute("memberId"));
		vo.setSellQunt(Integer.parseInt(request.getParameter("sellQunt")));
		
		dao.insert(vo);
		
		ProductDao pDao = new ProductDao();
		ProductVo pVo = new ProductVo();
		pVo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		pDao.select(pVo);
		
		pDao = new ProductDao();
		pVo.setProductQunt(pVo.getProductQunt() - Integer.parseInt(request.getParameter("sellQunt")));
//		pDao.productUpDown(pVo);
		
		return "sellView.do";
	}

}
