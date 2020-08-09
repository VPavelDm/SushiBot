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
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Category category;
}
