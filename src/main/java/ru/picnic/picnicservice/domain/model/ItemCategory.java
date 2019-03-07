package ru.picnic.picnicservice.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item_category")
@Data
public class ItemCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String name;
}
