package com.gabo.videoClub.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;

@Entity
@SQLDelete(sql = "UPDATE game SET deleted=true WHERE id = ?")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game extends Product{
    private Console console;

}
