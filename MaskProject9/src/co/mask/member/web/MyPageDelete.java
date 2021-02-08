package co.mask.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;
import co.mask.member.vo.MemberVo;

public class MyPageDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원 탈퇴
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("row"));


		int n = dao.delete(vo);

		String viewPage = null;
		
		if(n!=0) {
			viewPage ="view/member/deleteSuccess";
		} else {
			viewPage ="view/member/deleteFail";
		}
		return viewPage;
	}

}
