package com.gabo.videoClub.repositories;

import com.gabo.videoClub.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IProductRepository extends JpaRepository<Product, Long> {
}
