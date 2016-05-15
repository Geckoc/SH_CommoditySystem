package actions;

import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import DaoUtil.CommodityDao;
import entity.Commodity;

public class CommodityAction extends SuperAction implements ModelDriven<Commodity>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Commodity commodity = new Commodity();
	
	/*
	 * 获得全部商品信息
	 */
	public String queryCommodity()
	{
		CommodityDao commodityDao = new CommodityDao();
		List<Commodity> list = commodityDao.queryAllCommodity();
		if( list != null && list.size() > 0 ){
			session.setAttribute("commodity_list", list);
		}else{
			session.setAttribute("commodity_list", null);
		}
		return "commodity_information";
	}
	/*
	*	添加商品
	*/	
	public String addCommodity() throws Exception
	{		
		commodity.setCommodity_num(request.getParameter("commodity_num"));
		commodity.setCommodity_name(request.getParameter("commodity_name"));
		commodity.setCommodity_price(Float.valueOf(request.getParameter("commodity_price")));
		commodity.setCommodity_type(request.getParameter("commodity_type"));
		commodity.setCommodity_information(request.getParameter("commodity_information"));
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		commodity.setCommodity_time(simpleDate.parse(request.getParameter("commodity_time")));
			CommodityDao commodityDao = new CommodityDao();
			commodityDao.addCommodity(commodity);

		       return "addCommodity_success";
	}
	/*
	 * 刪除商品
	 */
	public String deleteCommodity()
	{
		CommodityDao commodityDao = new CommodityDao();
		String commodity_num= request.getParameter("commodity_num");
		commodityDao.deleteCommodity(commodity_num);
		
		return "delete";
	}
	/*
 	 *查找商品
 	 */
	public String commoditySearch()
	{
		CommodityDao commodity_dao = new CommodityDao();
		Commodity com = commodity_dao.commoditySearch(commodity.getCommodity_num());
		session.setAttribute("search_list", com);
			return "search_success";
	}
	
	@Override
	public Commodity getModel() {
		return this.commodity;
	}

}
