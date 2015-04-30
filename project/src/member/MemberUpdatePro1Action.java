package member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;

public class MemberUpdatePro1Action implements CommandProcess{
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			String zip1 = request.getParameter("zip1");
			String zip2 = request.getParameter("zip2");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String birthday=request.getParameter("birthday");
			String phone =request.getParameter("phone");
			String email =request.getParameter("email");
			
			HttpSession session =request.getSession();
			
			Member member =new Member();
			member.setId((String)session.getAttribute("id"));
			member.setZip1(zip1);
			member.setZip2(zip2);
			member.setAddr1(addr1);
			member.setAddr2(addr2);
			member.setPhone(phone);
			member.setEmail(email);
			member.setBirthday(birthday);
			
			MemberDao md =MemberDao.getInstance();
			md.update(member);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		
		return "updatePro1.jsp";
	}
}
