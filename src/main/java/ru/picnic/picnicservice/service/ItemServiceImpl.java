package ru.picnic.picnicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.picnic.picnicservice.dto.ItemDTO;
import ru.picnic.picnicservice.mapper.ItemMapper;
import ru.picnic.picnicservice.model.Item;
import ru.picnic.picnicservice.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    
    private final ItemRepository itemRepository;
    
    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    @Override
    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        return ItemMapper.MAPPER.itemToItemDTO(item);
    }
    
    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return ItemMapper.MAPPER.itemToItemDTO(items);
    }
}
