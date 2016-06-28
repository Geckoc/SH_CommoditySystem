package DaoUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Interface.IUserDao;

import entity.User;


public class UserDao implements IUserDao{

	@Override
	public boolean userLogin(User user) {
		Transaction trans = null;
		String hql = "";
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from User where name=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getName());
			query.setParameter(1, user.getPassword());
			@SuppressWarnings("rawtypes")
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

	@Override
	public boolean saveUser(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			return true;
		} catch(Exception e){
			if(tx != null) tx.rollback();
			throw e;
		}finally {
			HibernateUtil.closeSession();
			}
	}

	@SuppressWarnings("null")
	@Override
	public boolean ValidateName(String name) 
	{
		Transaction trans = null;
		String hql = "";
		User user = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from User where name=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getName());
			@SuppressWarnings("rawtypes")
			List list = query.list();
			trans.commit();
			if( list.size() > 0 ){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return false;
		}finally {
			if( trans != null ){
				trans = null;
			}
		}
	}
	
}
