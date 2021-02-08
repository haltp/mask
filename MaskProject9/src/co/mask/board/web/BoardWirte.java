package co.mask.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.dao.BoardDao;
import co.mask.board.vo.BoardVo;
import co.mask.common.Command;

public class BoardWirte implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		System.out.println("boardnumber");
//		vo.setBoardNumber(Integer.parseInt(request.getParameter("boardnumber")));
		vo.setBoardTitle(request.getParameter("boardtitle"));
		vo.setBoardWriter(request.getParameter("boardwriter"));
		vo.setBoardContent(request.getParameter("boardcontent"));
		vo.setBoardFile(request.getParameter("boardfile"));
		
		dao.boardInsert(vo);
		
		return "view/board/boardWriteForm";
	}

}
