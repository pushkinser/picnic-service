package ru.picnic.picnicservice.service;

import ru.picnic.picnicservice.dto.ItemDTO;

import java.util.List;

public interface IItemService {
    
    public ItemDTO getItemById(Long id);
    
    public List<ItemDTO> getAllItems();
}
