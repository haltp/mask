package co.mask.board.web;

import java.util.Enumeration;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.mask.board.dao.BoardDao;
import co.mask.board.vo.BoardVo;

public class BoardWriteAction implements Action {

	@Override
	public ActionForWord execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForWord forward = new ActionForWord();

		int fileSize = 5 * 1024 * 1024; //파일사이즈

		String uploadPath = request.getServletContext().getRealPath("D:\\업로드파일"); //업로드될 파일 경로
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "euc-kr",
					new DefaultFileRenamePolicy());
 
			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			if (names.hasMoreElements()) {
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			BoardDao dao = BoardDao.getInstance();
			BoardVo borderData = new BoardVo();

			borderData.setBoardNumber(dao.getSeq()); // 시퀀스 가져와 셋팅
			borderData.setBoardWriter(multi.getParameter("boardwriter")); // 히든값
			borderData.setBoardTitle(multi.getParameter("boardtitle"));
			borderData.setBoardContent(multi.getParameter("boardcontent"));
			borderData.setBoardFile(multi.getParameter("boardfile"));

			boolean result = dao.boardInsert(borderData);

			if (result) {
				forward.setRedirect(true);
				forward.setNextPath("boardWirteForm.do");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;

	}

}
