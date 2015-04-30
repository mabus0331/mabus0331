package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	public void init(ServletConfig config) throws ServletException { // ���� ���� ����
	   	//web.xml���� propertyConfig�� �ش��ϴ� init-param �� ���� �о��
	   	String props = config.getInitParameter("config");
	    Properties pr = new Properties();//��ɾ�� ó��Ŭ������ ���������� ������ Properties��ü ����
	    // Properties class�� key�� ���� �������µ� key=�� ���� ���� ���� 
	    FileInputStream f = null;
	    try {
	          String configFilePath = 
	         		config.getServletContext().getRealPath(props); 
	          // �ȯ���̵� �����ּҸ� ������(����ȯ���̳� ���� ���� �ٸ��� �ֱ⶧����)
	          f = new FileInputStream(configFilePath);
	          pr.load(f);//Command.properties������ ������  Properties��ü�� ����
	     } catch (IOException e) { throw new ServletException(e);
	     } finally {
	          if (f != null) try { f.close(); } catch(IOException ex) {}
	     }
	     Iterator keyIter = pr.keySet().iterator();//Iterator��ü�� Enumeration��ü�� Ȯ���Ų ������ ��ü
	     while( keyIter.hasNext() ) {//��ü�� �ϳ��� ������ �� ��ü������ Properties��ü�� ����� ��ü�� ����
	          String command = (String)keyIter.next(); // /list.do
	          String className = pr.getProperty(command); // service.ListAction
	          //     ���� ��    <-------------     key    
	          try {
	               Class commandClass = Class.forName(className);//�ش� ���ڿ��� Ŭ������ �����.
	               Object commandInstance = commandClass.newInstance();//�ش�Ŭ������ ��ü�� ����
	               commandMap.put(command, commandInstance);// Map��ü�� commandMap�� ��ü ����
	          } catch (Exception e) {
	               throw new ServletException(e);
	          }
	     }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        requestPro(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	       requestPro(request, response);
	}
	//�ÿ����� ��û�� �м��ؼ� �ش� �۾��� ó��
	private void requestPro(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = null;
	    CommandProcess com=null;
	    try {	String command = request.getRequestURI();//url���� localhost:8181 �� ������
			//	System.out.println(command);  // /ch16/list.do
			//	System.out.println(request.getContextPath()); // /ch16
			//	System.out.println(command.indexOf(request.getContextPath()));  // 0
	        //if (command.indexOf(request.getContextPath()) == 0) {
	              command = command.substring(request.getContextPath().length());
	          //}
	          com = (CommandProcess)commandMap.get(command);  
	          // �θ��� ���Ŀ� ���� ����(�θ�� ����ȯ�� ��� �Ǵ� ������ �ڽĸ� ����)
	          view = com.requestPro(request, response); // �ڽĲ� ����
	    } catch(Throwable e) { throw new ServletException(e); } 
	    RequestDispatcher dispatcher =
	        	request.getRequestDispatcher(view);
	   dispatcher.forward(request, response);
	}
}
