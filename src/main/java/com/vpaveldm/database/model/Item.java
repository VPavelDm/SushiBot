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
    @ManyToOne
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;
    @OneToMany(mappedBy = "item")
    private Set<BasketItem> basketItems;
}
