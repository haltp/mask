package co.mask.admin.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.member.dao.AdminDao;
import co.mask.member.vo.MemberVo;

public class AdminUserForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 관리자의 회원관리 폼 호출
		AdminDao dao = new AdminDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		list = dao.selectUserList();
		
		request.setAttribute("list", list);
		
		return "view/admin/adminUserForm";
	}

}
