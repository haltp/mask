package co.mask.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class MainPage implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// main.jsp로 이동
		return "view/main/main";
	}

}
