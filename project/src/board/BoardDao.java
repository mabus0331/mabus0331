package board;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import member.Member;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao {
	private static BoardDao instance;
	private BoardDao(){}
	public static BoardDao getInstance(){
		if(instance==null){ instance =new BoardDao();}
		return instance;
	}
	private SqlSession getSession() {
		SqlSession session = null;
		
		try {
			Reader r = Resources.getResourceAsReader("board/boardConfiguration.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(r);
			session = sf.openSession(true);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
	public void insert(Board board) {
		
		SqlSession session = null;
		try {
			session = getSession();
			session.insert("insert",board);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();		
	}
	public List<Board>list(){
		List<Board> list =new ArrayList<Board>();
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
	public Board select(String board_num) {
		Board board =null;
		SqlSession session=null;
		try { 
			session=getSession();
			board = session.selectOne("select",board_num);
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
		return board;
	}
	public void delete(String board_num) {
		SqlSession session =null;
		try {
			session=getSession();
			session.delete("delete",board_num);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
		
	}
	public void update(Board board) {
		SqlSession session =null;
		try {
			session=getSession();
			session.update("update",board);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.close();
	}
}
