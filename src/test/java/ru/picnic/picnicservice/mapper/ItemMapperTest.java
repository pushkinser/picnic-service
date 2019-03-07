package ru.picnic.picnicservice.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import ru.picnic.picnicservice.domain.dto.ItemDTO;
import ru.picnic.picnicservice.domain.model.Item;
import ru.picnic.picnicservice.domain.model.ItemCategory;

public class ItemMapperTest {

    private static final String ITEM_TITLE = "itemTitle";
    private static final String ITEM_CATEGORY = "itemCategory";

    @Test
    public void itemDTOToItemTest() {
        ItemDTO itemDTO = ItemDTO.builder()
                .title(ITEM_TITLE)
                .category(buildItemCategory())
                .build();

        Item item = ItemMapper.MAPPER.itemDTOToItem(itemDTO);

        assertEquals(itemDTO.getCategory().getName(), item.getItemCategory().getName());
    }

    private ItemCategory buildItemCategory() {
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setName(ITEM_CATEGORY);
        return itemCategory;
    }

}
