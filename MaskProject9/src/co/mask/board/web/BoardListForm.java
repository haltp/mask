package co.mask.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.dao.BoardDao;
import co.mask.board.vo.BoardVo;
import co.mask.common.Command;

public class BoardListForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		return "view/board/boardListForm";
	}

}
