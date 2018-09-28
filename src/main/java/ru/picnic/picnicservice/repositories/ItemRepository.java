package ru.picnic.picnicservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.picnic.picnicservice.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
