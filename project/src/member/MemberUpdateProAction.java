package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class MemberUpdateProAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response){
		int result =0;
		String pass = request.getParameter("pass");
		HttpSession session =request.getSession();
		String id =(String)session.getAttribute("id");
		
		/*System.out.println(pass);
		System.out.println(id);*/
		
		Member member =new Member();
		member.setId(id);
		member.setPass(pass);
		MemberDao md =MemberDao.getInstance();
		result=md.checkPass(member);
		request.setAttribute("result", result);//result=1이면 암호 맞아 
												//result=0이면 암호 틀려
		return "updatePro.jsp";
	}
}
