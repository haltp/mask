package co.mask.member.web;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;
import co.mask.member.vo.MemberVo;

public class MyPageForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		 //마이페이지 폼 호출
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		vo.setMemberId(request.getParameter("row"));
		
		HttpSession session = request.getSession();
		String value = (String)session.getAttribute("memberId");

		vo.setMemberId(value);
		
		list = dao.select(vo);
		request.setAttribute("list", list);
		
		return "view/member/myPageForm";
	}

}
