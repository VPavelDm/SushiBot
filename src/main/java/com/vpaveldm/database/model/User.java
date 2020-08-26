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
    private Set<Ingredient> choseIngredients;
    @OneToOne(cascade = CascadeType.ALL)
    private Basket basket;
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private UserState state = UserState.DEFAULT;
}
