package com.gabo.videoClub.entities;

import com.gabo.videoClub.enums.MovieStorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@SQLDelete(sql = "UPDATE product SET deleted=true WHERE id = ?")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Product{
    private Short duration;

    @Enumerated(value = EnumType.STRING)
    private MovieStorageType movieStorageType;
}
