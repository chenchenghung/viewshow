package com.nofacebox.viewshow.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Table(name="adate")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "id")
public class Adate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    @Column(name="xdate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date xdate;
    @OneToMany(mappedBy = "adate", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Link> links;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Adate(Long aid, Date xdate) {
        this.aid = aid;
        this.xdate = xdate;
    }
    public Adate(){};

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
        return "Adate{" +
                "aid=" + aid +
                ", xdate=" + xdate +
                ", links=" + links +
                '}';
    }
}
