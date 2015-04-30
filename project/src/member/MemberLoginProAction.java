package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class MemberLoginProAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response){
		
			int result=0;
			
			String id =request.getParameter("id");
			String pass =request.getParameter("pass");
			
			Member member =new Member();
			member.setId(id);
			member.setPass(pass);
			MemberDao md =MemberDao.getInstance();
			result =md.check(member);
			request.setAttribute("result", result);
		
			if(result==1){// result ���� 1�̿����� ����� ���̵� ������ 
				HttpSession session=request.getSession();
				session.setAttribute("id", id);
				//������ �ҷ��ͼ� ���̵� ������.
			}
			return "loginPro.jsp";
		}
}
