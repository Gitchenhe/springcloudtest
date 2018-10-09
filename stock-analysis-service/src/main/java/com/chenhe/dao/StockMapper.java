package com.chenhe.dao;

import com.chenhe.dao.entity.StockEntity;
import com.chenhe.dao.entity.StockListEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author chenhe
 * @Date 2018-09-27 15:54
 * @desc
 **/
@Mapper
public interface StockMapper {

    String insertSql = "INSERT INTO stock_analysis.t_stock_info (reportCode, marketNo, stockName, lastClosePrice, openPrice, currentPrice, highestPrice, floorPrice, bidPrice, auctionPrice, volume, turnover, buy1EntrustCount,  buy1EntrustPrice, buy2EntrustCount, buy2EntrustPrice, buy3EntrustCount, buy3EntrustPrice, buy4EntrustCount, buy4EntrustPrice, buy5EntrustCount,  buy5EntrustPrice, sale1EntrustCount, sale1EntrustPrice, sale2EntrustCount, sale2EntrustPrice, sale3EntrustCount, sale3EntrustPrice, sale4EntrustCount,  sale4EntrustPrice, sale5EntrustCount, sale5EntrustPrice, date, time, createTime)  VALUES (#{reportCode}, #{marketNo}, #{stockName}, #{lastClosePrice}, #{openPrice}, #{currentPrice}, #{highestPrice}, #{floorPrice}, #{bidPrice}, #{auctionPrice}, #{volume}, #{turnover},  #{buy1EntrustCount},  #{buy1EntrustPrice}, #{buy2EntrustCount}, #{buy2EntrustPrice}, #{buy3EntrustCount}, #{buy3EntrustPrice}, #{buy4EntrustCount}, #{buy4EntrustPrice}, #{buy5EntrustCount}, #{buy5EntrustPrice}, #{sale1EntrustCount}, #{sale1EntrustPrice},\n" +
            "#{sale2EntrustCount},#{sale2EntrustPrice}, #{sale3EntrustCount}, #{sale3EntrustPrice},#{sale4EntrustCount},#{sale4EntrustPrice}, #{sale5EntrustCount}, #{sale5EntrustPrice},#{date}, #{time}, now())";

    @Select("select * from t_stock_list where marketNo = #{marketNo,jdbcType=INTEGER}")
    List<StockListEntity> queryStockList(int marketNo);

    @Insert(insertSql)
    void insert(StockEntity stockEntity);
}
