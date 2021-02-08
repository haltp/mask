package co.mask.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.AdminDao;
import co.mask.member.vo.MemberVo;

public class SellerUpForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		 //관리자의 거래처 수정 폼 호출
		AdminDao dao = new AdminDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("row"));
		
		vo = dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/admin/sellerUpForm";
	}

}
