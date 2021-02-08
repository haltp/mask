package co.mask.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;
import co.mask.member.vo.MemberVo;

public class MyPageUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//회원의 회원정보 수정
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberPhone(request.getParameter("memberPhone"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberEmail(request.getParameter("memberEmail"));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberZipcode(request.getParameter("memberZipcode"));		

		int n = dao.update(vo);

		String viewPage = null;
		if (n != 0) {
			viewPage = "myPageForm.do";
		} else {
			viewPage = "view/member/updateFail";
		}

		return viewPage;
	}

}
