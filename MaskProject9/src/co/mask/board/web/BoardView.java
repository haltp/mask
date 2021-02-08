package co.mask.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.dao.BoardDao;
import co.mask.board.vo.BoardVo;
import co.mask.common.Command;
import co.mask.member.dao.MemberDao;

public class BoardView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setBoardNumber(Integer.parseInt(request.getParameter("row")));
		
		
		dao.select(vo);
		
		
		request.setAttribute("vo", vo);
		
		return "view/board/boardView";
	}

}
