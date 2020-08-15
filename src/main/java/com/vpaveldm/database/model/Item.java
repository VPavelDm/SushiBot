package com.vpaveldm.database.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String photoURL;
    private Double price;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "item_ingredients",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> ingredients;
    @ManyToMany(
            mappedBy = "items",
            fetch = FetchType.EAGER
    )
    private Set<Basket> baskets;
}
