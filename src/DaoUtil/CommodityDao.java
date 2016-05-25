package DaoUtil;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Commodity;
import entity.Employees;

public class CommodityDao {
	/*
	 * 获取商品信息列表
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
	/*
	 * 添加商品信息
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
	/*
	 * 徹底刪除商品信息
	 */
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
	
/*
 * 搜索商品
 */
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
	/*
	 * 保存修改的商品信息
	 */
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
