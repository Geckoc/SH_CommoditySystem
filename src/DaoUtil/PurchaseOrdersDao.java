package DaoUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Commodity;
import entity.PurchaseOrders;

public class PurchaseOrdersDao {
	/*
	 * �г����ж�����Ϣ�б�
	 * Get PurchaseOrders Information 
	 */
	public List<PurchaseOrders> queryPurchaseOrdersAll()
	{
		Transaction trans = null;
		List<PurchaseOrders> list = null;
		String hql = "";
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "from PurchaseOrders";
			Query query = session.createQuery(hql);
			list = query.list();
			trans.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			if( trans != null ){
				trans = null;
			}
			return list;
		}finally {
			HibernateUtil.closeSession();
		}
	}
	/*
	 * ���ɶ����ı��
	 */
	private String GetPurchaseOrders_num()
	{
		Transaction trans = null;
		String hql = "";
		String purchaseOrders_num = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			hql = "select max(purchaseOrders_num) from PurchaseOrders";
			Query query = session.createQuery(hql);
			purchaseOrders_num = (String) query.uniqueResult();
			if( purchaseOrders_num == null || "".equals(purchaseOrders_num) ){
				// ��һ�����Ĭ�ϱ��
				purchaseOrders_num = "C0000001";
			}else {
				String temp = purchaseOrders_num.substring(1); //ȥ������ĸ��ȡ����λ
				int i = Integer.valueOf(temp);   
				i++;
				temp = String.valueOf(i);     
				int len = temp.length();
				//�� Forѭ��ȥƴ�ն������
				for( int j = 0; j < 7 - len; j++ ){
						temp = "0" + temp;
				}
				purchaseOrders_num = "C" + temp;
			}
				trans.commit();
			   return  purchaseOrders_num;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			return null;
		}finally {
			if( trans != null )
			{
				trans = null;
			}
			HibernateUtil.closeSession();
		}
	}
	/*
	 * ��Ӷ���
	 * Add PurchaseOrders method
	 */
	public boolean addPurchaseOrders(PurchaseOrders purchaseOrders)
	{	
		purchaseOrders.setPurchaseOrders_num(GetPurchaseOrders_num());  //���ö������
		Transaction trans = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			session.save(purchaseOrders);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			if( trans != null){
				trans = null;
			}
			return false;
		}finally {
			HibernateUtil.closeSession();
		}
	}
	/*
	 * ��ȡ������Ϣ
	 * Get PurchaseOrders Information
	 */
	public Commodity GetOrderInformation(String commodity_num)
	{
		Transaction trans = null;
		Commodity orders = null;
		try {
			Session session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			orders = (Commodity) session.get(Commodity.class, commodity_num);
			trans.commit();
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
			trans.commit();
			if( trans != null){
				trans = null;
			}
			return orders;
		}finally {
			HibernateUtil.closeSession();
		}
	}
	
}
