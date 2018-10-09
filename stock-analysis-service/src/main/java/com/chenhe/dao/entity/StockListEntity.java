package com.chenhe.dao.entity;

/**
 * @author chenhe
 * @Date 2018-09-27 15:55
 * @desc
 **/
public class StockListEntity {
    private int id;
    private String reportCode;
    private String stockName;
    private int marketNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getMarketNo() {
        return marketNo;
    }

    public void setMarketNo(int marketNo) {
        this.marketNo = marketNo;
    }
}
