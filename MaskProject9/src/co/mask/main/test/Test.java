package co.mask.main.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class Test implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "view/login/test";
	}

}
