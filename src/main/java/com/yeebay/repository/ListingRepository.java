package com.yeebay.repository;

import com.yeebay.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {

    List<Listing> findByCategory(String category);
}
