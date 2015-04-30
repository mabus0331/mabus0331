package member;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.Member;

public class MemberDao {
	private static MemberDao instance;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if (instance == null) {	instance = new MemberDao();		}
		return instance;
	}
	private SqlSession getSession() {
		SqlSession session = null;
		
		try {
			Reader r = Resources.getResourceAsReader("member/memConfiguration.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(r);
			session = sf.openSession(true);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
	public void insert(Member member) {
		
		SqlSession session = null;
		try {
			session = getSession();
			session.insert("insert",member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();		
	}
	public int check(Member member){
		int result =0;
		SqlSession session=null;
		try { 
			session=getSession();
			Member mem = (Member)session.selectOne("select",member.getId());
				if (mem.getPass().equals(member.getPass())) {
					result = 1;//암호 맞았어
				}else result = 0;//암호 틀렸어
		} catch (Exception e) {
			result=-1;	//아이디가 존재 하지 않는다.
		}
		session.close();
		return result;
	}
	public int checkPass(Member member){
		int result =0;
		SqlSession session=null;
		try { 
			session=getSession();
			Member mem = (Member)session.selectOne("select",member.getId());
				if (mem.getPass().equals(member.getPass())) {
					result = 1;//암호 맞았어
				}else result = 0;//암호 틀렸어
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
		return result;
	}
	public List<Member>list(){
		List<Member> list =new ArrayList<Member>();
		SqlSession session=null;
		try {
			session=getSession();
			list=session.selectList("list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
		return list;
	}
	public Member select (String id){
		Member mem =null;
		SqlSession session=null;
		try { 
			session=getSession();
			mem = session.selectOne("select",id);
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
		return mem;
	}
	public void update(Member member) {
		
		SqlSession session = null;
		try {
			session = getSession();
			session.update("update",member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();		
	}
	public void delete(String id){
		SqlSession session =null;
		try {
			session =getSession();
			session.delete("delete",id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
	}
	public String findId (Member member) {
		SqlSession session =null;
		String id=null;
		try {
			session =getSession();
			id =session.selectOne("findid",member);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
		return id;
	}

}
