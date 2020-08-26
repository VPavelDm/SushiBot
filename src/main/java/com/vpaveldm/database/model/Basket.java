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
public class Basket {
    @Id @GeneratedValue
    private Long id;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "basket",
            cascade = CascadeType.ALL
    )
    private Set<BasketItem> basketItems;
}
