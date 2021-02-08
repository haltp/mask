package co.mask.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.AdminDao;
import co.mask.member.vo.MemberVo;

public class UserUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 관리자의 회원 수정
		AdminDao dao = new AdminDao();
		MemberVo vo = new MemberVo();
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPhone(request.getParameter("memberPhone"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		vo.setMemberEmail(request.getParameter("memberEmail"));
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberZipcode(request.getParameter("memberZipcode"));
		
		int n = dao.update(vo);
		
		String viewPage = null;
		if(n != 0) {
			viewPage = "adminUserForm.do";
		}else {
			viewPage = "view/admin/userUpdateFail";
		}
		
		return viewPage;
	}

}
