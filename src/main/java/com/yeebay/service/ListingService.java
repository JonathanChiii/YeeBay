package com.yeebay.service;

import com.yeebay.model.Listing;

import java.util.List;

public interface ListingRepository {
    Listing findById(Integer id);
    List<Listing> findAll();
    void save(Listing listing);
    void update(Listing listing);
    void deleteById();

    List<Listing> findByCategory(String category);
}
