package ru.picnic.picnicservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "item_title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @OneToOne
    @JoinColumn(name = "item_category_id")
    private ItemCategory itemCategory;
    
}
