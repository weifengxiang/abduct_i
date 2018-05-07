package org.sky.txsb.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbStTxsb {
    private String id;

    private String ywlx;

    private String ywbh;

    private Integer txxh;

    private BigDecimal xsd;

    private String wz;

    private Date sbsj;

    private String ajbh;

    private Integer ajtxxh;

    private Date createTime;

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

    public Integer getTxxh() {
        return txxh;
    }

    public void setTxxh(Integer txxh) {
        this.txxh = txxh;
    }

    public BigDecimal getXsd() {
        return xsd;
    }

    public void setXsd(BigDecimal xsd) {
        this.xsd = xsd;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }

    public Date getSbsj() {
        return sbsj;
    }

    public void setSbsj(Date sbsj) {
        this.sbsj = sbsj;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public Integer getAjtxxh() {
        return ajtxxh;
    }

    public void setAjtxxh(Integer ajtxxh) {
        this.ajtxxh = ajtxxh;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}