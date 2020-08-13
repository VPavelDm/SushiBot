package com.vpaveldm.database.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "users")
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(
            mappedBy = "choseIngredients",
            fetch = FetchType.EAGER
    )
    private Set<User> users;
    @ManyToMany(
            mappedBy = "ingredients",
            fetch = FetchType.EAGER
    )
    private Set<Item> items;
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Category category;
}
