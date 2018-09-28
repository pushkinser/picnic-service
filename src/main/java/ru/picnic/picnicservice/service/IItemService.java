package ru.picnic.picnicservice.service;

import ru.picnic.picnicservice.dto.ItemDTO;

public interface IItemService {
    
    public ItemDTO getItemById(Long id);
}
