package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class BoardListFromAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardDao bd =BoardDao.getInstance();
		Board board =new Board();
		board.getBoard_content();
		List<Board> list =bd.list();
		
		request.setAttribute("list", list);
		return "/gongzi/listForm.jsp";
	}

}
