package com.chenhe.dao.entity;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author chenhe
 * @Date 2018-09-27 17:31
 * @desc
 **/
public class StockEntity {
    FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
    FastDateFormat timeFormat = FastDateFormat.getInstance("HH:mm:ss");

    private Integer id;
    private String reportCode;
    private Integer marketNo;
    private String stockName;
    private String lastClosePrice;
    private String openPrice;
    private BigDecimal currentPrice;
    private BigDecimal highestPrice;
    private BigDecimal floorPrice;
    private BigDecimal bidPrice;
    private BigDecimal auctionPrice;
    private String volume;
    private String turnover;
    private Integer buy1EntrustCount;
    private BigDecimal buy1EntrustPrice;
    private Integer buy2EntrustCount;
    private BigDecimal buy2EntrustPrice;
    private Integer buy3EntrustCount;
    private BigDecimal buy3EntrustPrice;
    private Integer buy4EntrustCount;
    private BigDecimal buy4EntrustPrice;
    private Integer buy5EntrustCount;
    private BigDecimal buy5EntrustPrice;
    private Integer sale1EntrustCount;
    private BigDecimal sale1EntrustPrice;
    private Integer sale2EntrustCount;
    private BigDecimal sale2EntrustPrice;
    private Integer sale3EntrustCount;
    private BigDecimal sale3EntrustPrice;
    private Integer sale4EntrustCount;
    private BigDecimal sale4EntrustPrice;
    private Integer sale5EntrustCount;
    private BigDecimal sale5EntrustPrice;
    private Date date;
    private Date time;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public Integer getMarketNo() {
        return marketNo;
    }

    public void setMarketNo(Integer marketNo) {
        this.marketNo = marketNo;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getLastClosePrice() {
        return lastClosePrice;
    }

    public void setLastClosePrice(String lastClosePrice) {
        this.lastClosePrice = lastClosePrice;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(BigDecimal auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public Integer getBuy1EntrustCount() {
        return buy1EntrustCount;
    }

    public void setBuy1EntrustCount(Integer buy1EntrustCount) {
        this.buy1EntrustCount = buy1EntrustCount;
    }

    public BigDecimal getBuy1EntrustPrice() {
        return buy1EntrustPrice;
    }

    public void setBuy1EntrustPrice(BigDecimal buy1EntrustPrice) {
        this.buy1EntrustPrice = buy1EntrustPrice;
    }

    public Integer getBuy2EntrustCount() {
        return buy2EntrustCount;
    }

    public void setBuy2EntrustCount(Integer buy2EntrustCount) {
        this.buy2EntrustCount = buy2EntrustCount;
    }

    public BigDecimal getBuy2EntrustPrice() {
        return buy2EntrustPrice;
    }

    public void setBuy2EntrustPrice(BigDecimal buy2EntrustPrice) {
        this.buy2EntrustPrice = buy2EntrustPrice;
    }

    public Integer getBuy3EntrustCount() {
        return buy3EntrustCount;
    }

    public void setBuy3EntrustCount(Integer buy3EntrustCount) {
        this.buy3EntrustCount = buy3EntrustCount;
    }

    public BigDecimal getBuy3EntrustPrice() {
        return buy3EntrustPrice;
    }

    public void setBuy3EntrustPrice(BigDecimal buy3EntrustPrice) {
        this.buy3EntrustPrice = buy3EntrustPrice;
    }

    public Integer getBuy4EntrustCount() {
        return buy4EntrustCount;
    }

    public void setBuy4EntrustCount(Integer buy4EntrustCount) {
        this.buy4EntrustCount = buy4EntrustCount;
    }

    public BigDecimal getBuy4EntrustPrice() {
        return buy4EntrustPrice;
    }

    public void setBuy4EntrustPrice(BigDecimal buy4EntrustPrice) {
        this.buy4EntrustPrice = buy4EntrustPrice;
    }

    public Integer getBuy5EntrustCount() {
        return buy5EntrustCount;
    }

    public void setBuy5EntrustCount(Integer buy5EntrustCount) {
        this.buy5EntrustCount = buy5EntrustCount;
    }

    public BigDecimal getBuy5EntrustPrice() {
        return buy5EntrustPrice;
    }

    public void setBuy5EntrustPrice(BigDecimal buy5EntrustPrice) {
        this.buy5EntrustPrice = buy5EntrustPrice;
    }

    public Integer getSale1EntrustCount() {
        return sale1EntrustCount;
    }

    public void setSale1EntrustCount(Integer sale1EntrustCount) {
        this.sale1EntrustCount = sale1EntrustCount;
    }

    public BigDecimal getSale1EntrustPrice() {
        return sale1EntrustPrice;
    }

    public void setSale1EntrustPrice(BigDecimal sale1EntrustPrice) {
        this.sale1EntrustPrice = sale1EntrustPrice;
    }

    public Integer getSale2EntrustCount() {
        return sale2EntrustCount;
    }

    public void setSale2EntrustCount(Integer sale2EntrustCount) {
        this.sale2EntrustCount = sale2EntrustCount;
    }

    public BigDecimal getSale2EntrustPrice() {
        return sale2EntrustPrice;
    }

    public void setSale2EntrustPrice(BigDecimal sale2EntrustPrice) {
        this.sale2EntrustPrice = sale2EntrustPrice;
    }

    public Integer getSale3EntrustCount() {
        return sale3EntrustCount;
    }

    public void setSale3EntrustCount(Integer sale3EntrustCount) {
        this.sale3EntrustCount = sale3EntrustCount;
    }

    public BigDecimal getSale3EntrustPrice() {
        return sale3EntrustPrice;
    }

    public void setSale3EntrustPrice(BigDecimal sale3EntrustPrice) {
        this.sale3EntrustPrice = sale3EntrustPrice;
    }

    public Integer getSale4EntrustCount() {
        return sale4EntrustCount;
    }

    public void setSale4EntrustCount(Integer sale4EntrustCount) {
        this.sale4EntrustCount = sale4EntrustCount;
    }

    public BigDecimal getSale4EntrustPrice() {
        return sale4EntrustPrice;
    }

    public void setSale4EntrustPrice(BigDecimal sale4EntrustPrice) {
        this.sale4EntrustPrice = sale4EntrustPrice;
    }

    public Integer getSale5EntrustCount() {
        return sale5EntrustCount;
    }

    public void setSale5EntrustCount(Integer sale5EntrustCount) {
        this.sale5EntrustCount = sale5EntrustCount;
    }

    public BigDecimal getSale5EntrustPrice() {
        return sale5EntrustPrice;
    }

    public void setSale5EntrustPrice(BigDecimal sale5EntrustPrice) {
        this.sale5EntrustPrice = sale5EntrustPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    Logger logger = LoggerFactory.getLogger(StockEntity.class);
    public void parseFromString(String data) {

        String[] stockInfos = data.split("=");
        if (stockInfos[0].contains("sh")) {
            this.setMarketNo(1);
        } else if (stockInfos[0].contains("sz")) {
            this.setMarketNo(2);
        }
        String reportCode = stockInfos[0].replace("sz", "").replace("sh", "");
        this.setReportCode(reportCode);
        stockInfos = stockInfos[1].replace("\"", "").split(",");
        if (stockInfos.length == 0){
            return;
        }
        logger.info("====> {}", Arrays.asList(stockInfos));
        this.stockName = stockInfos[0];
        this.lastClosePrice = stockInfos[1];
        this.openPrice = stockInfos[2];
        this.currentPrice = new BigDecimal(stockInfos[3]);
        this.highestPrice = new BigDecimal(stockInfos[4]);
        this.floorPrice = new BigDecimal(stockInfos[5]);
        this.bidPrice = new BigDecimal(stockInfos[6]);
        this.auctionPrice = new BigDecimal(stockInfos[7]);
        this.volume = stockInfos[8];
        this.turnover = stockInfos[9];
        this.buy1EntrustCount = new Integer(stockInfos[10]);
        this.buy1EntrustPrice = new BigDecimal(stockInfos[11]);
        this.buy2EntrustCount = new Integer(stockInfos[12]);
        this.buy2EntrustPrice = new BigDecimal(stockInfos[13]);
        this.buy3EntrustCount = new Integer(stockInfos[14]);
        this.buy3EntrustPrice = new BigDecimal(stockInfos[15]);
        this.buy4EntrustCount = new Integer(stockInfos[16]);
        this.buy4EntrustPrice = new BigDecimal(stockInfos[17]);
        this.buy5EntrustCount = new Integer(stockInfos[18]);
        this.buy5EntrustPrice = new BigDecimal(stockInfos[19]);
        this.sale1EntrustCount = new Integer(stockInfos[20]);
        this.sale1EntrustPrice = new BigDecimal(stockInfos[21]);
        this.sale2EntrustCount = new Integer(stockInfos[22]);
        this.sale2EntrustPrice = new BigDecimal(stockInfos[23]);
        this.sale3EntrustCount = new Integer(stockInfos[24]);
        this.sale3EntrustPrice = new BigDecimal(stockInfos[25]);
        this.sale4EntrustCount = new Integer(stockInfos[26]);
        this.sale4EntrustPrice = new BigDecimal(stockInfos[27]);
        this.sale5EntrustCount = new Integer(stockInfos[28]);
        this.sale5EntrustPrice = new BigDecimal(stockInfos[29]);
        try {
            this.date = dateFormat.parse(stockInfos[30]);
            this.time = timeFormat.parse(stockInfos[31]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.createTime = new Date();
    }
}
