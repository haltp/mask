package co.mask.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.AdminDao;
import co.mask.member.vo.MemberVo;

public class SellerDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원 삭제
		AdminDao dao = new AdminDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("row"));

		int n = dao.delete(vo);

		return "adminSellerForm.do";
	}

}
