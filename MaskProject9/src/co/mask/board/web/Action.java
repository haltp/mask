package co.mask.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionForWord execute(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
