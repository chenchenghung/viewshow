package com.nofacebox.viewshow.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;


    @Column
    private Date avadate;

    @Column
    private String avasession;
    @Column
    private String hall;
    @Column
    private String s01;
    @Column
    private String s02;
    @Column
    private String s03;
    @Column
    private String s04;
    @Column
    private String s05;
    @Column
    private String s06;
    @Column
    private String s07;
    @Column
    private String s08;
    @Column
    private String s09;
    @Column
    private String s10;



    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "linkid" , insertable = true, updatable = true)
    private LinkPk linkPk;



    @Override
    public String toString() {
        return "Session{" +
                "sid=" + sid +
                ", avadate=" + avadate +
                ", avasession='" + avasession + '\'' +
                ", hall='" + hall + '\'' +
                ", s01='" + s01 + '\'' +
                ", s02='" + s02 + '\'' +
                ", s03='" + s03 + '\'' +
                ", s04='" + s04 + '\'' +
                ", s05='" + s05 + '\'' +
                ", s06='" + s06 + '\'' +
                ", s07='" + s07 + '\'' +
                ", s08='" + s08 + '\'' +
                ", s09='" + s09 + '\'' +
                ", s10='" + s10 + '\'' +
                '}';
    }
}
