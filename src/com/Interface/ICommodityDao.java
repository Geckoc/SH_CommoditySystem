package com.Interface;

import java.util.List;

import entity.Commodity;

public interface ICommodityDao {
    public List<Commodity> queryAllCommodity();
    
    public List<Commodity> queryCommodity(Commodity commodity);
    
    public Commodity commoditySearch(String commodity_num);
    
    public boolean addCommodity(Commodity commodity);
    
    public boolean deleteCommodity(String commodity_num);
    
    public boolean updateCommodity(Commodity commodity);
    
}
