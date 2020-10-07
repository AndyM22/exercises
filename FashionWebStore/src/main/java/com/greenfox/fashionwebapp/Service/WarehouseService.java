package com.greenfox.fashionwebapp.Service;

import com.greenfox.fashionwebapp.DTO.Items;
import com.greenfox.fashionwebapp.Model.Warehouse;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> listAllItems();

    List<String> listAllSizes();

    List<String> listAllItemsName();

    float getPrice(float quantity, Warehouse warehouse);

    Warehouse getByName(String name, String size);

    Items clothByPrice(float price, String type);

}
