package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDao;
import member.Member;
import service.CommandProcess;

public class MemberJoinProAction implements CommandProcess{

	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
	        request.setCharacterEncoding("utf-8");   
	        
	        Member member = new Member();
	   	        
	        member.setId(request.getParameter("id"));
	        member.setPass(request.getParameter("pass"));
	        member.setName(request.getParameter("name"));
	        member.setZip1(request.getParameter("zip1"));
	        member.setZip2(request.getParameter("zip2"));
	        member.setAddr1(request.getParameter("addr1"));
	        member.setAddr2(request.getParameter("addr2"));
	        member.setBirthday(request.getParameter("birthday"));
	        member.setPhone(request.getParameter("phone"));
	        member.setEmail(request.getParameter("email"));
	        member.setGen(request.getParameter("gen"));
	       	
	        //System.out.print(request.getParameter("birthday"));
	        MemberDao mPro = MemberDao.getInstance();
	        mPro.insert(member);
	        
		} catch(Exception e) { System.out.println(e.getMessage()); }
        return "joinPro.jsp";		
	}

}
