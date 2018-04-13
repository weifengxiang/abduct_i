package org.sky.ywbl.model;

import java.util.Date;

public class TbStYwbh {
    private String id;

    private String szm;

    private String jgdm;

    private String ny;

    private Integer sxh;

    private Date createTime;

    private String creater;

    private Date updateTime;

    private String updater;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSzm() {
        return szm;
    }

    public void setSzm(String szm) {
        this.szm = szm;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getNy() {
        return ny;
    }

    public void setNy(String ny) {
        this.ny = ny;
    }

    public Integer getSxh() {
        return sxh;
    }

    public void setSxh(Integer sxh) {
        this.sxh = sxh;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}