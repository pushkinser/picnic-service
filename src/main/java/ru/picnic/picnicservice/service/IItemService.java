package ru.picnic.picnicservice.service;

import ru.picnic.picnicservice.domain.dto.ItemDTO;

import java.util.List;

public interface IItemService {

    ItemDTO getItemById(Long id);

    List<ItemDTO> getAllItems();

    void editItemById(ItemDTO itemDTO);
}
