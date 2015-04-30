package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class BoardDeleteFormAction implements CommandProcess{

	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String board_num= request.getParameter("board_num");
		
		BoardDao bd=BoardDao.getInstance();
		Board board =new Board();
		
		board.setBoard_num(Integer.parseInt(board_num));
		bd.delete(board_num); 
		
		return "/gongzi/deletePro.jsp";
	}

}
