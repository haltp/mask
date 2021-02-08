package co.mask.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.web.BoardListForm;
import co.mask.board.web.BoardView;
import co.mask.board.web.BoardWirte;
import co.mask.board.web.Hedaer;
import co.mask.board.web.Notice;
import co.mask.main.MainPage;
import co.mask.main.Menu;



@WebServlet("/FrontController3")
public class FrontController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController3() {
        super();
        
    }
 
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainPage());
		map.put("/menu.do", new Menu()); //메뉴 확인하려고 index에서 바로 menu로 변경해보았습니다.
		map.put("/boardListForm.do", new BoardListForm());
		map.put("/boardWirte.do", new BoardWirte());
		map.put("/header.do", new Hedaer());
		map.put("/boardView.do", new BoardView());
		map.put("/notice.do", new Notice());
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contexPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contexPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
