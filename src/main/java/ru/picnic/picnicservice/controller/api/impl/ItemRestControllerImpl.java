package ru.picnic.picnicservice.controller.api.impl;

import static org.springframework.http.ResponseEntity.ok;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.picnic.picnicservice.controller.api.ItemRestController;
import ru.picnic.picnicservice.domain.dto.ItemDTO;
import ru.picnic.picnicservice.service.IItemService;

@RestController
@RequiredArgsConstructor
public class ItemRestControllerImpl implements ItemRestController {

    private final IItemService itemService;

    @Override
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return ok(itemService.getItemById(id));
    }

    @Override
    public ResponseEntity<Void> updateItemDTO(@ModelAttribute("item") ItemDTO itemDTO) {
        Long id = itemDTO.getId();
        // TODO: сделать выбор категории на странице редактирования карточки
        itemDTO.setCategory(itemService.getItemById(id).getCategory());
        itemService.editItemById(itemDTO);

        return ok().build();
    }

}
