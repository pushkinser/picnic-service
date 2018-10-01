package ru.picnic.picnicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.picnic.picnicservice.dto.ItemDTO;
import ru.picnic.picnicservice.service.IItemService;

import java.util.List;

@Controller
public class ItemViewController {
    

    private final IItemService itemService;
    
    @Autowired
    public ItemViewController(IItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping("/items")
    public ModelAndView getItemList() {
        ModelAndView itemsPage = new ModelAndView();
        List<ItemDTO> items = itemService.getAllItems();
        itemsPage.addObject("items", items);
        return itemsPage;
    }
}
