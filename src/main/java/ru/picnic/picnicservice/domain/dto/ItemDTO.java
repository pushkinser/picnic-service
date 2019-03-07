package ru.picnic.picnicservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.picnic.picnicservice.domain.model.ItemCategory;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private Long id;
    private String title;
    private String description;
    private ItemCategory category;
}
