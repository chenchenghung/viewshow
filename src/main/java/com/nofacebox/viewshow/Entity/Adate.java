package com.nofacebox.viewshow.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Table(name="adate")
public class Adate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    @Column(name="xdate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date xdate;

//    @OneToMany(mappedBy = "adate", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Link> theaterMovieAdateLink= new ArrayList<>();

//    @JsonManagedReference
//    public List<Link> getTheaterMovieAdateLink() {
//        return theaterMovieAdateLink;
//    }

//    public void setTheaterMovieAdateLink(List<Link> theaterMovieAdateLink) {
//        this.theaterMovieAdateLink = theaterMovieAdateLink;
//    }

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


}
