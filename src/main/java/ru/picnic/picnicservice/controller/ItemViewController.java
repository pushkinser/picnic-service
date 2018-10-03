package ru.picnic.picnicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/item/{id}")
    public ModelAndView getItemInfo(@PathVariable("id") Long id) {
        ModelAndView itemPage = new ModelAndView();
        ItemDTO item = itemService.getItemById(id);
        itemPage.addObject("item", item);
        itemPage.setViewName("item");
        return itemPage;
    }
    
    @GetMapping("/item/edit/{id}")
    public ModelAndView editItemInfo(@PathVariable("id") Long id) {
        ModelAndView editItemPage = new ModelAndView();
        ItemDTO item = itemService.getItemById(id);
        editItemPage.addObject("item", item);
        editItemPage.setViewName("edit/item");
        return editItemPage;
    }
}
