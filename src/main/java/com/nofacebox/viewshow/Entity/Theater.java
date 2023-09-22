package com.nofacebox.viewshow.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;
    @Column (name="region")
    private String region;
    @Column (name="name")
    private  String name;

    @OneToMany(mappedBy = "theater", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Link> theaterMovieAdateLink;
    public  Theater(){};

    public Theater (long tid , String region, String name){
        this.tid=tid;
        this.region=region;
        this.name=name;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie : [ id= " + tid + ", region =" + region + ", name = "+name;
    }
}
