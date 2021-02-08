package co.mask.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class AdminFrom implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//관리자의 관리창 호출
		return "view/admin/adminForm";
	}

}
