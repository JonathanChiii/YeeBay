package com.yeebay.repository;

import com.yeebay.model.Listing;
import com.yeebay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

}
