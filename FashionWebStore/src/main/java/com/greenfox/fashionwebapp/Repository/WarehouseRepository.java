package com.greenfox.fashionwebapp.Repository;

import com.greenfox.fashionwebapp.Model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    Warehouse getByItemNameAndSize(String name, String size);
    List<Warehouse> findAllByUnitPriceBefore(float price);
    List<Warehouse> findAllByUnitPriceEquals(float price);
    List<Warehouse> findAllByUnitPriceAfter(float price);

}
