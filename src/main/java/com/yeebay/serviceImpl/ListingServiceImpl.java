package com.yeebay.serviceImpl;

import com.yeebay.dto.ListingValidation;
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
        return listingRepository.findById(id).filter(e->e.getStatus()==1).orElse(null);
    }

    @Override
    public List<Listing> findAll() {
        return listingRepository.findAll().stream().filter(l->l.getStatus()==1).toList();
    }

    @Override
    public void save(Listing listing) {
        listingRepository.save(listing);
    }

    @Override
    public void save(ListingValidation listingValidation) {
        Listing listing = new Listing(Integer.valueOf(0), listingValidation.getTitle(), listingValidation.getCategory(), listingValidation.getBrand(),
                listingValidation.getItemCondition(), listingValidation.getPrice(), listingValidation.getDescription(), listingValidation.getSeller(), Integer.valueOf(1), listingValidation.getDateCreated(), listingValidation.getLastModified());
        listingRepository.save(listing);
    }

    @Override
    public Boolean update(Listing listing) {
        Boolean result = Boolean.FALSE;
        Listing l = listingRepository.findById(listing.getId()).orElse(null);
        if (l != null) {
            listingRepository.save(listing);
            //l.setAllAttributes(listing);
            result = Boolean.TRUE;
        } else {
            System.out.println("The Listing id" + listing.getId() + "does not meet our record.");
        }
        return result;
    }


//    @Override
//    public Boolean deleteById(Integer id) //throws IllegalArgumentException
//    {
//        Boolean result = false;
//        if (listingRepository.findById(id).isPresent()) {
//            listingRepository.deleteById(id);
//            result = true;
//        } else {
//            //throw new IllegalArgumentException("Id: " + id + "does not meet our records.");
//            result = false;
//        }
//        return result;
//    }

    @Override
    public List<Listing> findByCategory(String category) {
        return listingRepository.findByCategory(category);
    }
}
