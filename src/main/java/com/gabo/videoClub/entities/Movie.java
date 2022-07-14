package com.gabo.videoClub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;

@Entity
@SQLDelete(sql = "UPDATE movie SET deleted=true WHERE id = ?")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Product{
    private Short duration;

    private MovieStorageType movieStorageType;
}
