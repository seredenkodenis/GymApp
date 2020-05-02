package com.project.gym.Model;

import javax.persistence.*;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(columnDefinition="TEXT", name = "mon")
    private String mon;

    @Column(columnDefinition="TEXT", name = "tue")
    private String tue;

    @Column(columnDefinition="TEXT", name = "wen")
    private String wen;

    @Column(columnDefinition="TEXT", name = "thu")
    private String thu;

    @Column(columnDefinition="TEXT", name = "fri")
    private String fri;

    @Column(columnDefinition="TEXT", name = "sat")
    private String sat;

    @Column(columnDefinition="TEXT", name = "sun")
    private String sun;

    @OneToOne(mappedBy = "plan")
    private User user;

    public Plan(){}

    public Plan(String mon, String tue, String wen, String thu, String fri, String sat, String sun) {
        this.mon = mon;
        this.tue = tue;
        this.wen = wen;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWen() {
        return wen;
    }

    public void setWen(String wen) {
        this.wen = wen;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
