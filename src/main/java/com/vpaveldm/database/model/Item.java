package com.vpaveldm.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String photoURL;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "item_ingredients",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> ingredients;
}
