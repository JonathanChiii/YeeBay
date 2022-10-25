package com.yeebay.controller;

import com.yeebay.service.ListingService;
import com.yeebay.service.UserService;
import com.yeebay.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    ListingService listingService;
    @Autowired
    UserService userService;

}
