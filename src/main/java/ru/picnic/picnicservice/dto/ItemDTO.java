package ru.picnic.picnicservice.dto;

import lombok.Data;
import ru.picnic.picnicservice.model.ItemCategory;

@Data
public class ItemDTO {
    
    private Long id;
    private String title;
    private String description;
    private ItemCategory category;
}
