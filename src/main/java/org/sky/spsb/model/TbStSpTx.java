package org.sky.spsb.model;

import java.math.BigDecimal;
import java.util.Date;

public class TbStSpTx {
    private String id;

    private String spbh;

    private String wjmc;

    private BigDecimal xsd;

    private String creater;

    private Date createTime;

    private String zt;
    
    private String splj;

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

    public String getWjmc() {
        return wjmc;
    }

    public void setWjmc(String wjmc) {
        this.wjmc = wjmc;
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

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

	public String getSplj() {
		return splj;
	}

	public void setSplj(String splj) {
		this.splj = splj;
	}
}