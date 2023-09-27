package com.nofacebox.viewshow.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="link")
@Entity
public class LinkPk implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkid;
    @Column(name="tid")
    private Long tid;
    @Column(name="mid")
    private Long mid;
    @Column(name="aid")
    private Long aid;

    @Override
    public int hashCode() {
        return Objects.hash(tid,mid,aid);
    }

    @Override
    public boolean equals(Object obj) {
        if(this ==obj) return true;
        if(obj==null) return false;
        if(getClass() !=obj.getClass())
            return  false;
        LinkPk other=(LinkPk) obj;
        return Objects.equals(tid,other.tid)&&Objects.equals(mid,other.mid)&&Objects.equals(aid,other.aid);


    }
}
