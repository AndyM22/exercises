package com.greenfox.fashionwebapp.Controller;

import com.greenfox.fashionwebapp.DTO.Items;
import com.greenfox.fashionwebapp.Model.Warehouse;
import com.greenfox.fashionwebapp.Service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WarehouseController {

    private WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/shoppingplanner")
    public String mainPage(Model model) {
        model.addAttribute("items", this.warehouseService.listAllItems());
        model.addAttribute("sizes", this.warehouseService.listAllSizes());
        model.addAttribute("itemNames", this.warehouseService.listAllItemsName());
        model.addAttribute("newWarehouse", new Warehouse());
        return "index";
    }

    @PostMapping("/shoppingplanner/summary")
    public String submitItems(int quantity, String itemName, String itemSize,  Model model) {
        model.addAttribute("quantity", quantity);
        Warehouse warehouse = this.warehouseService.getByName(itemName, itemSize);
        model.addAttribute("warehouse", warehouse);
        model.addAttribute("price", this.warehouseService.getPrice(quantity, warehouse));
        return "summary";
    }

    @GetMapping("/shoppingplanner/query")
    @ResponseBody
    public Object clothesByPrice(@RequestParam int price, @RequestParam String type) {
        Items items = this.warehouseService.clothByPrice(price, type);
        if (items.getClothes().isEmpty()) {
            items.setResult("no clothes available");
        } else {
            items.setResult("ok");
        }
        return items;
    }

}
