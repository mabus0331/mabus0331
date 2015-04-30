package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class MemberLogoutAction implements CommandProcess {
	public String requestPro(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		session.invalidate();
		
		return "logout.jsp";
	}
}
