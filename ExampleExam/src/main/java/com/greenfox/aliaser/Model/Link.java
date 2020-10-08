package com.greenfox.aliaser.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Link {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private String alias;
    @Column(name = "secret_code")
    @JsonIgnore
    private String secretCode;
    private int hitCount;

    public Link() {
    }

    public Link(String url, String alias) {
        this.url = url;
        this.alias = alias;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
