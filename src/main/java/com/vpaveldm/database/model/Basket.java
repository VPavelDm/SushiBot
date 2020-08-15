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
public class Basket {
    @Id @GeneratedValue
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "basket_items",
            joinColumns = { @JoinColumn(name = "basket_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private Set<Item> items;
}
