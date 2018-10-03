package ru.picnic.picnicservice.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.picnic.picnicservice.dto.ItemDTO;
import ru.picnic.picnicservice.service.IItemService;

@Controller
@RequestMapping("/api/item")
public class ItemRestController {
    
    private final IItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(ItemRestController.class);
    
    @Autowired
    public ItemRestController(IItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public ItemDTO getItemById(@PathVariable("id") Long id) {
        logger.info("Get item by id " + id);
        return itemService.getItemById(id);
    }
    
    @RequestMapping(value = "/edit/", method = RequestMethod.POST)
    public String updateItemDTO(@ModelAttribute("item") ItemDTO itemDTO) {
        Long id = itemDTO.getId();
        logger.info("Update item by id " + id);
        // TODO: сделать выбор категории на странице редактирования карточки
        // Bad hardcode
        itemDTO.setCategory(itemService.getItemById(id).getCategory());
        itemService.editItemById(itemDTO);
        return "redirect:/items";
    }
    
}
