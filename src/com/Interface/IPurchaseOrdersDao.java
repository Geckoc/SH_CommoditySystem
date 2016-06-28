package com.Interface;

import java.util.List;

import entity.Commodity;
import entity.PurchaseOrders;

public interface IPurchaseOrdersDao {
	public List<PurchaseOrders> queryPurchaseOrdersAll();
	
	public Commodity GetOrderInformation(String commodity_num);
	
	public boolean addPurchaseOrders(PurchaseOrders orders);
	
	public boolean deletePurchaseOrders(String purchaseOrders_num);
	
	public boolean updatePurchaseOrders(PurchaseOrders orders);
}
