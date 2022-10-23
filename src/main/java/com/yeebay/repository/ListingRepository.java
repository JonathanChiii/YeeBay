package com.yeebay.repository;

import com.yeebay.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingsRepository extends JpaRepository<Listing, Integer> {

}
