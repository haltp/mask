package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.dao.BoardDao;
import co.mask.board.vo.BoardVo;


@WebServlet("/GetBoardListTest")
public class GetBoardListTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetBoardListTest() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html charset=utf-8");
		
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		String json = "[";
		int cnt =1;
		for(BoardVo prd : list) {
			json += "{";
			
			json += "\"boardNumber\":\""+ prd.getBoardNumber()+"\"";
			json += ",\"boardTitle\":\""+ prd.getBoardTitle()+"\"";
			json += ",\"boardWriter\":\""+ prd.getBoardWriter()+"\"";
			json += ",\"boardDate\":\""+ prd.getBoardDate()+"\"";
			json += ",\"boardHit\":\""+ prd.getBoardHit()+"\"";
			
			json += "}";
			
			
			if(list.size() != cnt++) {
				json +=",";
			}
		}
		
		json += "]";
		
		
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
