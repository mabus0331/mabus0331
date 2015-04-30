package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class MemberIdProAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String name =request.getParameter("name");
		String email=request.getParameter("email");
		String phone =request.getParameter("phone");
		String gen =request.getParameter("gen");
		
		Member member =new Member();
		member.setName(name);
		member.setEmail(email);
		member.setPhone(phone);
		member.setGen(gen);
		
		String id=null;
		String id2 =null;
		String id3=null;
		MemberDao md =MemberDao.getInstance();
		id =md.findId(member);
		//System.out.println(id.substring(id.length()-3,id.length()));
		

		if(id !=null){		
			id2=id.substring(0,id.length()-3);
			id3=id2+"***";
			request.setAttribute("id", id3);
			return "idPro.jsp";	
			
		}else{				
			return "idAlert.jsp";
		}
	}

}
