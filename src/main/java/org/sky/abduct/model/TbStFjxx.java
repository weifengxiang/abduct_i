package org.sky.abduct.model;

import java.util.Date;

public class TbStFjxx {
    private String id;

    private String ajbh;

    private String fjmc;

    private String fjlx;

    private Integer fjdx;

    private String creater;

    private Date creatrTime;

    private byte[] fjnr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getFjmc() {
        return fjmc;
    }

    public void setFjmc(String fjmc) {
        this.fjmc = fjmc;
    }

    public String getFjlx() {
        return fjlx;
    }

    public void setFjlx(String fjlx) {
        this.fjlx = fjlx;
    }

    public Integer getFjdx() {
        return fjdx;
    }

    public void setFjdx(Integer fjdx) {
        this.fjdx = fjdx;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreatrTime() {
        return creatrTime;
    }

    public void setCreatrTime(Date creatrTime) {
        this.creatrTime = creatrTime;
    }

    public byte[] getFjnr() {
        return fjnr;
    }

    public void setFjnr(byte[] fjnr) {
        this.fjnr = fjnr;
    }
}