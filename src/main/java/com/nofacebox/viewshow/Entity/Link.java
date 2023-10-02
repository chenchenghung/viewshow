package com.nofacebox.viewshow.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="link")
@Getter
public class Link implements Serializable {
    //暫時不用，再問問看
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long linkid;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tid")
    private Theater theater;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "mid")
    private Movie movie;
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "aid")
    private Adate adate;

    @Override
    public int hashCode() {
//        return Objects.hash(tid,mid,aid);
        return Objects.hash(theater,movie,adate);
    }

    @Override
    public boolean equals(Object obj) {
        if(this ==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass() !=obj.getClass())
            return  false;
        Link other=(Link) obj;
        return Objects.equals(theater,other.theater)&&Objects.equals(movie,other.movie)&&Objects.equals(adate,other.adate);
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkid=" + linkid +
                ", theater=" + theater.getTid() +
                ", movie=" + movie.getMid() +
                ", adate=" + adate.getAid() +
                '}';
    }
}
