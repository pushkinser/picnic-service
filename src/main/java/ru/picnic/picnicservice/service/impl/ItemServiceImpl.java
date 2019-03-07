package ru.picnic.picnicservice.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.picnic.picnicservice.domain.dto.ItemDTO;
import ru.picnic.picnicservice.mapper.ItemMapper;
import ru.picnic.picnicservice.domain.model.Item;
import ru.picnic.picnicservice.repositories.ItemRepository;
import ru.picnic.picnicservice.service.IItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        return itemMapper.itemToItemDTO(item);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.itemToItemDTO(items);
    }

    @Override
    public void editItemById(ItemDTO itemDTO) {
        Item item = itemMapper.itemDTOToItem(itemDTO);
        itemRepository.save(item);
    }

}
