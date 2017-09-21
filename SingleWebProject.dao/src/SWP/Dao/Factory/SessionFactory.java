package SWP.Dao.Factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	//
	private static SessionFactory instance;
	private SqlSessionFactory sqlSessionFactory;
	
	private SessionFactory(){
		//
		try{
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("SessionFactory 실행 중 오류 발생");
		}
	}
	
	public static SessionFactory createInstance(){
		//	
		if(instance == null){
			instance = new SessionFactory();
		}
		return instance;
	}
	
	public SqlSession getSession(){
		//
		return sqlSessionFactory.openSession(true);
	}
}
