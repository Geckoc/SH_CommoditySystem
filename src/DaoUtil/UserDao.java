package DaoUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import entity.User;


public class UserDao {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public boolean userLogin(User user)
	{
		Transaction trans = null;
		String hql = "";
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from User where name=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getName());
			query.setParameter(1, user.getPassword());
			List list = query.list();
			trans.commit();   //提交事务
			if(list.size() > 0)
			{
				return true;
			}else 
				{
				 return false;
				}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if (trans != null)
			{
				trans = null;
			}
		}
	}
	
	/**
	 * 用户注册方法
	 * @param user
	 */
	public void savaUser(User user)
	{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch(Exception e){
			if(tx != null) tx.rollback();
			throw e;
		}finally {
			HibernateUtil.closeSession();
			}
	}
	
}
