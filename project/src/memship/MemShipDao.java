package memship;

import java.io.Reader;

import memship.MemShipDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemShipDao {
	private static MemShipDao instance;
	private MemShipDao() {}
	public static MemShipDao getInstance() {
		if (instance == null) {	instance = new MemShipDao();		}
		return instance;
	}
	private SqlSession getSession() {
		SqlSession session = null;
		
		try {
			Reader r = Resources.getResourceAsReader("memship/msConfiguration.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(r);
			session = sf.openSession(true);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
	public MemShip msSelect(int MsNum){
		SqlSession session =null;
		MemShip memship =null;
		
		try {
			session=getSession();
			memship=session.selectOne("select",MsNum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return memship;
	}
}
