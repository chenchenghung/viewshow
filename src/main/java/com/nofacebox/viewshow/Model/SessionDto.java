package com.nofacebox.viewshow.Model;

import java.util.Date;

public class SessionDto {
    private Long sid;

    private Long linkid;

    private Date avadate;

    private String avasession;

    private String hall;

    private Long xvalue;

    private String xtext;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getLinkid() {
        return linkid;
    }

    public void setLinkid(Long linkid) {
        this.linkid = linkid;
    }

    public Date getAvadate() {
        return avadate;
    }

    public void setAvadate(Date avadate) {
        this.avadate = avadate;
    }

    public String getAvasession() {
        return avasession;
    }

    public void setAvasession(String avasession) {
        this.avasession = avasession;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public Long getXvalue() {
        return xvalue;
    }

    public void setXvalue(Long xvalue) {
        this.xvalue = xvalue;
    }

    public String getXtext() {
        return xtext;
    }

    public void setXtext(String xtext) {
        this.xtext = xtext;
    }

    @Override
    public String toString() {
        return "SessionDto{" +
                "sid=" + sid +
                ", linkid=" + linkid +
                ", avadate=" + avadate +
                ", avasession='" + avasession + '\'' +
                ", hall='" + hall + '\'' +
                '}';
    }
}
