package com.cpn.aiithire.lnkinservice.domain.valueobject;

import java.math.BigInteger;

public class LnkProfileVO {

    private BigInteger id;
    private String name;
    private String url;

    public LnkProfileVO() {
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
