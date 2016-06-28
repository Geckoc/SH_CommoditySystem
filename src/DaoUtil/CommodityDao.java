package DaoUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Interface.ICommodityDao;

import entity.Commodity;

public class CommodityDao implements ICommodityDao {
	/*
	 * 获取商品信息列表
	 */
	@SuppressWarnings("unchecked")
	@Override
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> queryCommodity(Commodity commodity)
	{
		Transaction trans = null;
		String hql = "";
		List<Commodity> list = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from Commodity where commodity_num=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, commodity.getCommodity_num());
			list = query.list();
			trans.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return list;
		}finally {
			if( trans != null ){
				trans = null;
			}
		}
	}
	
	@Override
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
	
	@Override
	public boolean deleteCommodity(String commodity_num)
	{
			Transaction trans = null;
			try {
				Session session = HibernateUtil.getSession();
				trans = session.beginTransaction();
				Commodity commodity = (Commodity)session.get(Commodity.class, commodity_num);
				session.delete(commodity);
				trans.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				trans.commit();
				return false;
			}finally {
				if(trans != null)
				{
					trans = null;
				}
			}
	}
	
	@Override
	public Commodity commoditySearch(String commodity_num)
	{
		Transaction trans = null;
		Commodity commodity = null;
		try{
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			commodity = (Commodity) session.get(Commodity.class,commodity_num);
			trans.commit();
			return commodity;
		}catch(Exception e){ 
			e.printStackTrace();
			trans.commit();
			return commodity;
		}finally{
			if( trans != null){
				trans = null;  
			} 
		}
	}
	
	@Override
	public boolean updateCommodity( Commodity commodity)
	{
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			session.update(commodity);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return false;
		}finally{
			if( trans != null )
			{
				trans = null;
			}
		}
	}
}
