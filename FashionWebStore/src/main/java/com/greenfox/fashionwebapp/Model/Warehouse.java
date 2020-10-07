package com.greenfox.fashionwebapp.Model;

import javax.persistence.*;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "item_name")
    private String itemName;
    private String manufacturer;
    private String category;
    private String size;
    @Column (name = "unit_price")
    private float unitPrice;

    public Warehouse() {
    }

    public Warehouse(String item_name, String manufacturer, String category, String size, float unit_price) {
        this.itemName = item_name;
        this.manufacturer = manufacturer;
        this.category = category;
        this.size = size;
        this.unitPrice = unit_price;
    }

    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String item_name) {
        this.itemName = item_name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unit_price) {
        this.unitPrice = unit_price;
    }
}
