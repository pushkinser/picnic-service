package ru.picnic.picnicservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.picnic.picnicservice.dto.ItemDTO;
import ru.picnic.picnicservice.model.Item;

@Mapper
public interface ItemMapper {
    
    ItemMapper MAPPER = Mappers.getMapper(ItemMapper.class);
    
    @Mapping(source = "category", target = "itemCategory")
    Item itemDTOToItem(ItemDTO itemDTO);
    
    @Mapping(source = "itemCategory", target = "category")
    ItemDTO itemToItemDTO(Item item);
}
