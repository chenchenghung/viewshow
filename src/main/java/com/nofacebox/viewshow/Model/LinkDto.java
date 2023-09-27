package com.nofacebox.viewshow.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LinkDto {
    private Long linkid;

    private Long tid;
    private String name;

    private Long mid;
    private String mname;

    private Long aid;
    private Date xdate;

    @Override
    public String toString() {
        return "LinkDto{" +
                "linkid=" + linkid +
                ", tid=" + tid +
                ", tname='" + name + '\'' +
                ", mid=" + mid +
                ", mname='" + mname + '\'' +
                ", aid=" + aid +
                ", xdate='" + xdate + '\'' +
                '}';
    }
}
