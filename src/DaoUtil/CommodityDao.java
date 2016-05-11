package DaoUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Commodity;

public class CommodityDao {
	/*
	 * ��ȡ��Ʒ��Ϣ�б�
	 */
	public List<Commodity> queryAllCommodity()
	{
		Transaction trans = null;
		List<Commodity> list = null;
		String hql = "";
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from Commodity";
			Query query = session.createQuery(hql);
			list = query.list();
			trans.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return list;
		}finally {
			if ( trans != null)
			{
				trans = null;
			}
		}
	}
	/*
	 * �����Ʒ��Ϣ
	 */
	public boolean addCommodity(Commodity commodity)
	{
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			session.save(commodity);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return false;
		}finally {
			if( trans != null)
			{
				trans = null;
			}
		}
	}
}
