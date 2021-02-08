package co.mask.sell.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.sell.dao.SellDao;
import co.mask.sell.vo.SellVo;

public class BuyerView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 구매 내역 페이지
		ArrayList<SellVo> list = new ArrayList<SellVo>(); 
		SellDao dao = new SellDao();
		SellVo vo = new SellVo();
		HttpSession session = request.getSession();
		vo.setSellUser((String) session.getAttribute("memberId"));

		list = dao.selectList(vo);
		request.setAttribute("buyList", list);
		
		return "view/sell/buyerView";
	}

}
