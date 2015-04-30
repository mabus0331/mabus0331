package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class BoardContentsFormAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String board_num = request.getParameter("board_num");
		
		BoardDao bd =BoardDao.getInstance();
		Board board=new Board();
		board.setBoard_num(Integer.parseInt(board_num));
		
		board =bd.select(board_num);
		request.setAttribute("board_num", board.getBoard_num()); 
		request.setAttribute("board_sub", board.getBoard_sub());
		request.setAttribute("board_date", board.getBoard_date()); 
		request.setAttribute("board_content", board.getBoard_content()); 
		
		return "/gongzi/contentsForm.jsp";
	}

}
