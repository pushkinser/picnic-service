package ru.picnic.picnicservice.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.picnic.picnicservice.dto.ItemDTO;
import ru.picnic.picnicservice.service.IItemService;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
    
    private final IItemService itemService;
    private final Logger logger = LoggerFactory.getLogger(ItemRestController.class);
    
    @Autowired
    public ItemRestController(IItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable("id") Long id) {
        logger.info("Get user by id " + id);
        return itemService.getItemById(id);
    }
    
}
