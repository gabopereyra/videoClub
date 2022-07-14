package com.gabo.videoClub.repositories;

import com.gabo.videoClub.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}