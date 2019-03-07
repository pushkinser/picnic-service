package ru.picnic.picnicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.picnic.picnicservice.controller.api.impl.ItemRestControllerImpl;
import ru.picnic.picnicservice.domain.dto.ItemDTO;
import ru.picnic.picnicservice.service.IItemService;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemViewController {

    private final ItemRestControllerImpl itemRestController;
    private final IItemService itemService;

    @Autowired
    public ItemViewController(IItemService itemService, ItemRestControllerImpl itemRestController) {
        this.itemService = itemService;
        this.itemRestController = itemRestController;
    }

    @GetMapping("/all")
    public ModelAndView getItemList() {
        ModelAndView itemsPage = new ModelAndView();
        List<ItemDTO> items = itemService.getAllItems();
        itemsPage.addObject("items", items);
        itemsPage.setViewName("items");
        return itemsPage;
    }

    @GetMapping("/{id}")
    public ModelAndView getItemInfo(@PathVariable("id") Long id) {
        ModelAndView itemPage = new ModelAndView();
        ItemDTO item = itemService.getItemById(id);
        itemPage.addObject("item", item);
        itemPage.setViewName("item");
        return itemPage;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editItemInfo(@PathVariable("id") Long id) {
        ModelAndView editItemPage = new ModelAndView();
        ItemDTO item = itemService.getItemById(id);
        editItemPage.addObject("item", item);
        editItemPage.setViewName("edit/item");
        return editItemPage;
    }

    @PostMapping("/edit")
    public ModelAndView editItemInfo(@ModelAttribute("item") ItemDTO itemDTO) {
        itemRestController.updateItemDTO(itemDTO);
        return new ModelAndView("redirect:/item/all");
    }
}
