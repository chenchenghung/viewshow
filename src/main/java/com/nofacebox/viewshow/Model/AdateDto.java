package com.nofacebox.viewshow.Model;

import jakarta.persistence.Column;

import java.util.Date;

public class AdateDto {
    private Long aid;
    private Date xdate;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Date getXdate() {
        return xdate;
    }

    public void setXdate(Date xdate) {
        this.xdate = xdate;
    }

    @Override
    public String toString() {
        return "AdateDto{" +
                "aid=" + aid +
                ", xdate=" + xdate +
                '}';
    }
}
