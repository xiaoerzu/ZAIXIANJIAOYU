package com.jk.model;

public class SectionBean {

    private  Integer id;
    private  Integer sectionid;
    private  String  sectionname;
    private  String  video;
    private  String  duration;


    public SectionBean(Integer id, Integer sectionid, String sectionname, String video, String duration) {
        this.id = id;
        this.sectionid = sectionid;
        this.sectionname = sectionname;
        this.video = video;
        this.duration = duration;
    }

    public SectionBean() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public Integer getSectionid() {
        return sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public String getVideo() {
        return video;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSectionid(Integer sectionid) {
        this.sectionid = sectionid;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "SectionBean{" +
                "id=" + id +
                ", sectionid=" + sectionid +
                ", sectionname='" + sectionname + '\'' +
                ", video='" + video + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
