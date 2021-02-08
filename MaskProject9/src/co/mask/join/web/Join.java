package co.mask.join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;
import co.mask.member.vo.MemberVo;

public class Join implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 완료
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPhone(request.getParameter("memberPhone"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberEmail(request.getParameter("memberEmail"));
		vo.setMemberAuth(request.getParameter("memberAuth"));
		vo.setMemberZipcode(request.getParameter("memberZipcode"));
		
		String viewPage = null;
		int n = dao.insert(vo);
		request.setAttribute("vo", vo);
		
		if (n != 0) {
			viewPage = "view/join/joinSuccess";
		}else {
			viewPage = "view/join/joinFail";
		}
					
		return viewPage;
	}

}
