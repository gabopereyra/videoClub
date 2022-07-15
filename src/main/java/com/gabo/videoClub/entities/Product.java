package com.gabo.videoClub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SQLDelete(sql = "UPDATE product SET deleted=true WHERE id = ?")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer totalQuantity;

    private Integer borrowQuantity = 0;

    private ClasificationPerAge clasificationPerAge;

    private Boolean deleted= false;

    @ManyToMany(mappedBy = "products")
    List<Borrow> borrows;
}
