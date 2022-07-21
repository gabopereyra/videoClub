package com.gabo.videoClub.repositories;

import com.gabo.videoClub.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
}
