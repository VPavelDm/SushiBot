package com.vpaveldm.database.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "choseIngredients")
@ToString(exclude = "choseIngredients")
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;
}
