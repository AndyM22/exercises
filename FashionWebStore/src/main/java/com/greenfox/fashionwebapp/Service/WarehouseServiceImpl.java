package com.greenfox.fashionwebapp.Service;

import com.greenfox.fashionwebapp.DTO.Items;
import com.greenfox.fashionwebapp.Model.Warehouse;
import com.greenfox.fashionwebapp.Repository.WarehouseRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> listAllItems() {
        return this.warehouseRepository.findAll();
    }

    @Override
    public List<String> listAllSizes() {
        return listAllItems().stream()
                .map(Warehouse::getSize)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listAllItemsName() {
        return listAllItems().stream()
                .map(Warehouse::getItemName)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public float getPrice(float quantity, Warehouse warehouse) {
        return warehouse.getUnitPrice() * quantity;
    }

    @Override
    public Warehouse getByName(String name, String size) {
        return this.warehouseRepository.getByItemNameAndSize(name, size);
    }

    @Override
    public Items clothByPrice(float price, String type) {
        Items item = new Items();
        switch (type) {
            case "lower":
                item.setClothes(this.warehouseRepository.findAllByUnitPriceBefore(price));
                break;
            case "equals":
                item.setClothes(this.warehouseRepository.findAllByUnitPriceEquals(price));
                break;
            case "higher":
                item.setClothes(this.warehouseRepository.findAllByUnitPriceAfter(price));
                break;
        }
        return item;
    }

}
