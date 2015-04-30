package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

import service.CommandProcess;

public class MemberIdCheckAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id =(String)request.getParameter("id");
		Member member =new Member();
		member.setId(id);
		
		MemberDao md =MemberDao.getInstance();
		member =md.select(id);
		
		request.setAttribute("member", member);
		request.setAttribute("id", id);
		return "idCheck.jsp";
	}

}
