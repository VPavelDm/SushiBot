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
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private Long telegramId;
    @Column(unique = true)
    private Long chatId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_chose_ingredients",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private Set<Ingredient> choseIngredients;
}
