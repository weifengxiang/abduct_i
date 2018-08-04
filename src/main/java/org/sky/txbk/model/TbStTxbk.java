package org.sky.txbk.model;

import java.util.Date;

public class TbStTxbk {
    private String id;

    private String txbh;

    private String txmc;

    private String ysmc;

    private String bkk;

    private String bz;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private String txnr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxbh() {
        return txbh;
    }

    public void setTxbh(String txbh) {
        this.txbh = txbh;
    }

    public String getTxmc() {
        return txmc;
    }

    public void setTxmc(String txmc) {
        this.txmc = txmc;
    }

    public String getYsmc() {
        return ysmc;
    }

    public void setYsmc(String ysmc) {
        this.ysmc = ysmc;
    }

    public String getBkk() {
        return bkk;
    }

    public void setBkk(String bkk) {
        this.bkk = bkk;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTxnr() {
        return txnr;
    }

    public void setTxnr(String txnr) {
        this.txnr = txnr;
    }
}