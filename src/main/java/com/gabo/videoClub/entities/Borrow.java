package com.gabo.videoClub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE borrow SET is_over=true WHERE id = ?")
@Where(clause = "is_over = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate initialDate = LocalDate.now();

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate finalizationDate;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "rel_borrow_product",
            joinColumns = {
                    @JoinColumn(name = "fk_borrow", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name="fk_product", nullable = false)
            })
    private List<Product> products;

    @Column(name = "is_over")
    private Boolean isOver = false;
}
