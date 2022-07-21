package com.gabo.videoClub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE client SET is_deleted=true WHERE id = ?")
@Where(clause = "is_deleted = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String email;

    @CreationTimestamp
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate clientSince;

    private Boolean isDeleted = false;

    private LocalDate birthDate;

    private Boolean blockedForBorrow = false;

    @OneToMany(mappedBy = "id")
    List<Borrow> borrows;
}
