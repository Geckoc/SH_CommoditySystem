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
		  //��һ��:��ȡHibernate�������ļ�  hibernamte.cfg.xml�ļ�
		Configuration config = new Configuration().configure();
		  //�ڶ���:��������ע�ṹ��������ͨ�����ö����м������е�������Ϣ
		  ServiceRegistryBuilder regbulider = new ServiceRegistryBuilder().applySettings(config.getProperties());
		 //����ע�����
		  ServiceRegistry reg = regbulider.buildServiceRegistry();
		 sessionFactory = config.buildSessionFactory(reg);
		 return sessionFactory;
	}
	
/*	  �������ӣ�δ��ʵ��
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
