package com.yeebay.serviceImpl;

import com.yeebay.model.Listing;
import com.yeebay.repository.ListingRepository;
import com.yeebay.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {
    @Autowired
    ListingRepository listingRepository;

    @Override
    public Listing findById(Integer id) {
        //return listingRepository.getReferenceById(id); this will throw EntityNotFoundException
        return listingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    @Override
    public void save(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public Boolean update(Listing listing) {
        Boolean result = Boolean.FALSE;
        Listing l = listingRepository.findById(listing.getId()).orElse(null);
        if (l != null) {
            l.setAllAttributes(listing);
            result = Boolean.TRUE;
        } else {
            System.out.println("The Listing id" + listing.getId() + "does not meet our record.");
        }
        return result;
    }


    @Override
    public Boolean deleteById(Integer id) //throws IllegalArgumentException
    {
        Boolean result = false;
        if (listingRepository.findById(id).isPresent()) {
            listingRepository.deleteById(id);
            result = true;
        } else {
            //throw new IllegalArgumentException("Id: " + id + "does not meet our records.");
            result = false;
        }
        return result;
    }

    @Override
    public List<Listing> findByCategory(String category) {
        return listingRepository.findByCategory(category);
    }
}
