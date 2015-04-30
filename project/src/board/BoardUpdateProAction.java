package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class BoardUpdateProAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String board_sub = request.getParameter("board_sub");
		String board_content = request.getParameter("board_content");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDao bd = BoardDao.getInstance();
		Board board =new Board();
		
		board.setBoard_num(board_num);
		board.setBoard_content(board_content);
		board.setBoard_sub(board_sub);
		
		bd.update(board);
		return "updatePro.jsp";
	}

}
