package com.greenfox.aliaser.Dto;

import com.greenfox.aliaser.Model.Link;

public class LinkDto {

    private String secretCode;

    public LinkDto() {
    }

    public LinkDto(Link link) {
        this.secretCode = link.getSecretCode();
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}
