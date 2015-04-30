package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class MemberJoinFormAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "joinForm.jsp";
	}

}
