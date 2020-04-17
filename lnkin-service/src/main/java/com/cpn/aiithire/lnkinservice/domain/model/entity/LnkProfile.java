package com.cpn.aiithire.lnkinservice.domain.model.entity;

public class LnkProfile extends BaseEntity<String> {

    public String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LnkProfile(String name, String url) {
        super(name);
        this.url = url;
    }

    @Override
    public String toString() {
        return "LnkProfile{" +
                "url='" + url + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
