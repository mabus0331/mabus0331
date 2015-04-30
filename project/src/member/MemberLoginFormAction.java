package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class MemberLoginFormAction implements CommandProcess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response){

		return "loginForm.jsp";
	}
}
