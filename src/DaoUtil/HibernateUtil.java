package DaoUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	@SuppressWarnings("rawtypes")
	private static ThreadLocal session = new ThreadLocal();
	private HibernateUtil()	{}
	public static SessionFactory getSessionFactory()
	{
		  //第一步:读取Hibernate的配置文件  hibernamte.cfg.xml文件
		Configuration config = new Configuration().configure();
		  //第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
		  ServiceRegistryBuilder regbulider = new ServiceRegistryBuilder().applySettings(config.getProperties());
		 //创建注册服务
		  ServiceRegistry reg = regbulider.buildServiceRegistry();
		 sessionFactory = config.buildSessionFactory(reg);
		 return sessionFactory;
	}
	
/*	  书上例子，未能实现
 * public static Session getThreadLocalSession()
	{
		Session s = (Session)session.get();
		if( s == null ){
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}  */
	 public static Session getSession()
	 {
	      return getSessionFactory().openSession();
	 }
	
	public static void closeSession() {
		Session s = (Session) session.get();
		if( s != null)
		{
			s.close();
		}
	}
		
}
