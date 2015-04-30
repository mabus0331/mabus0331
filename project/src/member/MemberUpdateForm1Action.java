package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class MemberUpdateForm1Action implements CommandProcess {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
			
		MemberDao md = MemberDao.getInstance();
		Member member = md.select(id);
		
		request.setAttribute("member", member);
		return "updateForm1.jsp";
	}
}
