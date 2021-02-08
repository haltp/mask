package co.mask.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;
import co.mask.member.vo.MemberVo;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		System.out.println(vo.toString());
		vo = dao.login(vo);
		
		
		String viewPage = null;

		if (vo.getMemberAuth() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("memberAuth", vo.getMemberAuth());
			request.setAttribute("vo", vo);
			viewPage = "view/login/loginSuccess";
		} else {
			viewPage = "view/login/loginFail";
		}

		return viewPage;
	}

}
