package com.greenfox.fashionwebapp.DTO;

import com.greenfox.fashionwebapp.Model.Warehouse;

import java.util.List;

public class Items {

    private String result;
    private List<Warehouse> clothes;

    public Items() {
    }

    public Items(String result, List<Warehouse> clothes) {
        this.result = result;
        this.clothes = clothes;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Warehouse> getClothes() {
        return clothes;
    }

    public void setClothes(List<Warehouse> clothes) {
        this.clothes = clothes;
    }
}
