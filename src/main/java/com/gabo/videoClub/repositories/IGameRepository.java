package com.gabo.videoClub.repositories;

import com.gabo.videoClub.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameRepository extends JpaRepository<Game, Integer> {
}
