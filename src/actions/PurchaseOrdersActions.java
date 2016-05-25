package actions;



import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import DaoUtil.CommodityDao;
import DaoUtil.PurchaseOrdersDao;
import entity.Commodity;
import entity.PurchaseOrders;

public class PurchaseOrdersActions extends SuperAction implements ModelDriven<PurchaseOrders>{
	/**
	 * Use ModelDriven Method
	 * You must New Object
	 * ʹ��ģ������������ȡ�ύ��
	 * ��װ��ʵ�������Ҫʵ����
	 */
	private static final long serialVersionUID = 1L;
	PurchaseOrders purchaseOrders = new PurchaseOrders();
	Commodity commodity = new Commodity();
	/*
	 * Get PurchaseOrders List Action
	 * ���ȫ�����������б�
	 */
	public String QueryAllOrdersInfo()
	{
		PurchaseOrdersDao ordersDao = new PurchaseOrdersDao();
		List<PurchaseOrders> list = ordersDao.queryPurchaseOrdersAll();
		if( list != null && list.size() > 0){
			session.setAttribute("orders_info", list);
		}else {
			session.setAttribute("orders_info", null);
		}
			return "ordersInfo_success";
	}
	
	/*
	 * ��ȡ������Ϣ
	 * Get purchaseOrders Information
	 */
	public String GetPurchaseOrder_info()
	{
		CommodityDao commodity_dao = new CommodityDao();
		String num = request.getParameter("commodity_num");
		Commodity com = commodity_dao.commoditySearch(num);
		session.setAttribute("search_list", com);
			return "getInfo_success";
	}
	/*
	 * Add PurchaseOrders
	 * ��ӽ�������
	 */
	public String addPurchaseOrder() throws Exception
	{	
		purchaseOrders.getPurchaseOrders_num();
		purchaseOrders.getPurchaseOrders_name();
		purchaseOrders.getPurchaseOrders_price();
		purchaseOrders.getPurchaseOrders_amount();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd"+"&"+"HH:MM:ss"); 
		purchaseOrders.setPurchaseOrders_date(simple.parse(request.getParameter("purchaseOrders_date")));
		PurchaseOrdersDao OrdersDao = new PurchaseOrdersDao();
		OrdersDao.addPurchaseOrders(purchaseOrders);
		return "addOrder_success";
	}

	@Override
	public PurchaseOrders getModel() {
		return this.purchaseOrders;
	}

}
