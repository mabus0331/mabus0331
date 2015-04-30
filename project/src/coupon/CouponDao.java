package coupon;

import java.io.Reader;

import coupon.CouponDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CouponDao {
	private static CouponDao instance;
	private CouponDao() {}
	public static CouponDao getInstance() {
		if (instance == null) {	instance = new CouponDao();		}
		return instance;
	}
	private SqlSession getSession() {
		SqlSession session = null;
		
		try {
			Reader r = Resources.getResourceAsReader("couponConfiguration.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(r);
			session = sf.openSession(true);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return session;
	}
}
