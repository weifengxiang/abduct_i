package org.sky.ywbl.model;

import java.util.Date;

public class TbStTxxx {
    private String id;

    private String ywlx;

    private String ywbh;

    private String txmc;

    private String txlx;

    private Integer txdx;

    private Integer seq;

    private String creater;

    private Date createTime;

    private String txnr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public String getYwbh() {
        return ywbh;
    }

    public void setYwbh(String ywbh) {
        this.ywbh = ywbh;
    }

    public String getTxmc() {
        return txmc;
    }

    public void setTxmc(String txmc) {
        this.txmc = txmc;
    }

    public String getTxlx() {
        return txlx;
    }

    public void setTxlx(String txlx) {
        this.txlx = txlx;
    }

    public Integer getTxdx() {
        return txdx;
    }

    public void setTxdx(Integer txdx) {
        this.txdx = txdx;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    public String getTxnr() {
        return txnr;
    }

    public void setTxnr(String txnr) {
        this.txnr = txnr;
    }
}