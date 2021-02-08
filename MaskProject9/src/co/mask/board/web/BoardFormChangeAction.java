package co.mask.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFormChangeAction implements Action {
	private String form = "main.jsp?contentPage=board/";
	private String path;
	
	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx) + ".jsp";
	}
	
	@Override
	public ActionForWord execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ActionForWord forward = new ActionForWord();
			
			forward.setRedirect(false);
			
			if(path.equals("main.jsp"))
				forward.setNextPath(path);
			else
				forward.setNextPath(form+path);
		return forward;
	}

}
