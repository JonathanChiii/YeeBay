package com.yeebay.service;

import com.yeebay.dto.ListingValidation;
import com.yeebay.model.Listing;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

public interface ListingService {
    Listing findById(Integer id);
    List<Listing> findAll();
    void save(Listing listing);
    void save(ListingValidation listingValidation);
    Boolean update(Listing listing);

    List<Listing> findByCategory(String category);

}
