package com.gabo.videoClub.repositories;

import com.gabo.videoClub.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {

    @Modifying
    @Query("UPDATE Borrow b SET b.isOver=true WHERE b.id = :id")
    void deletedBorrowById(@Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE borrow SET is_over=true WHERE client_id = :id", nativeQuery = true)
    void deletedBorrowByClientId(@Param("id") Integer id);
}
