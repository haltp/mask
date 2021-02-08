package co.mask.join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.MemberDao;

public class IdCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복 체크
		MemberDao dao = new MemberDao();
		String id = request.getParameter("memberId");
		boolean bool = dao.idCheck(id);
		String message = null;
		if (bool) {
			message = id + "사용할 수 있는 아이디입니다.";

		} else {
			message = id + "사용할 수 없는 아이디입니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		return "view/join/idCheck";
	}

}
