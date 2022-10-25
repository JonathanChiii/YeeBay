package com.yeebay.service;

import com.yeebay.model.Listing;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

public interface ListingService {
    Listing findById(Integer id);
    List<Listing> findAll();
    void save(Listing listing);
    Boolean update(Listing listing);

    List<Listing> findByCategory(String category);

}
