package com.yeebay.service;

import com.yeebay.model.Listing;

import java.util.List;

public interface ListingService {
    Listing findById(Integer id);
    List<Listing> findAll();
    void save(Listing listing);
    Boolean update(Listing listing);
    Boolean deleteById(Integer id);

    List<Listing> findByCategory(String category);

}
