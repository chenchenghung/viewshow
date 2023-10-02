package com.nofacebox.viewshow.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    @Column(name="mname")
    private String mname;
    @Column(name="pubdate")
    private Date pubdate;
    @Column(name="offdate")
    private Date offdate;

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Link> theaterMovieAdateLink;
    public Movie(){};
    public Movie(Long mid, String mname, Date pubdate, Date offdate) {
        this.mid = mid;
        this.mname = mname;
        this.pubdate = pubdate;
        this.offdate = offdate;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Date getOffdate() {
        return offdate;
    }

    public void setOffdate(Date offdate) {
        this.offdate = offdate;
    }
}
