package org.sky.spsb.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbStSpTx {
    private String id;

    private String spbh;

    private BigDecimal xsd;

    private String creater;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpbh() {
        return spbh;
    }

    public void setSpbh(String spbh) {
        this.spbh = spbh;
    }

    public BigDecimal getXsd() {
        return xsd;
    }

    public void setXsd(BigDecimal xsd) {
        this.xsd = xsd;
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
}