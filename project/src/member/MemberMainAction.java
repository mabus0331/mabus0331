package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommandProcess;
import memship.MemShip;
import memship.MemShipDao;
public class MemberMainAction implements CommandProcess{
	public String requestPro(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session =request.getSession();
		String id =(String)session.getAttribute("id");
		MemberDao md =MemberDao.getInstance();
		
		Member member =md.select(id);
		int MsNum=member.getMsNum();
		
		MemShipDao msd =MemShipDao.getInstance();
		MemShip memship=msd.msSelect(MsNum);
		request.setAttribute("grade", memship.getGrade());
		
		
		return "main.jsp";
	}
}
