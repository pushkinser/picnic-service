package ru.picnic.picnicservice.controller.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static ru.picnic.picnicservice.util.constants.UrlConstant.ENDPOINT_ITEM;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.picnic.picnicservice.domain.dto.ItemDTO;

public interface ItemRestController {

    @GetMapping(
            value = ENDPOINT_ITEM + "/{id}",
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    ResponseEntity<ItemDTO> getItemById(Long id);

    @PostMapping(
            value = "/edit",
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    ResponseEntity<Void> updateItemDTO(ItemDTO itemDTO);

}
