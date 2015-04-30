package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class BoardWriteProAction implements CommandProcess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String board_sub =request.getParameter("board_sub");
		String board_content=request.getParameter("board_content");
		
		BoardDao bd =BoardDao.getInstance();
		Board board =new Board();
		board.setBoard_sub(board_sub);
		board.setBoard_content(board_content);
		bd.insert(board);
		return "/gongzi/writePro.jsp";
	}

}
