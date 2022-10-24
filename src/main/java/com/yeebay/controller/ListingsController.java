package com.yeebay.controller;

import com.yeebay.model.Listing;
import com.yeebay.model.User;
import com.yeebay.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("")
public class ListingsController {

    @Autowired
    ListingService listingService;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/test1")
    public String test1(){
        User testUser1 = new User();
        testUser1.setUsername("Jonathan Chi");
        testUser1.setEmail("jonathanchi@foodie.com");
        testUser1.setPassword("0000");
        testUser1.setBalance((float)1999);
        testUser1.setMobileNum("6140008888");
        testUser1.setAddress("Columbus, OH");
        List<Listing> ll = new LinkedList<>();
        testUser1.setUserListings(ll);

        Listing testListing1 = new Listing();
        testListing1.setTitle("iPhone 14 Pro");
        testListing1.setCategory("Phone & Tablet");
        testListing1.setBrand("Apple");
        testListing1.setItemCondition("Used");
        testListing1.setPrice((float)999);
        testListing1.setDescription("256GB, color is Deep purple");
        testListing1.setStatus(1);
        testListing1.setSeller(testUser1);
        ll.add(testListing1);
        listingService.save(testListing1);
        return "redirect:/";
    }

    @GetMapping("/printViewPage")
    public String passParametersWithModelMap(ModelMap map) {
        map.addAttribute("welcomeMessage", "welcome");
        map.addAttribute("message", "Baeldung");
        return "viewPage";
    }

    @GetMapping("/")
    public String home(Model model) {
        //ModelAndView mv = new ModelAndView("Viewname");
        //mv.setViewName("welcome");
        //mv.addA("userName", "Jonathan");
        //mv.getModel().put("appName", appName);
        model.addAttribute("userName", "Jonathan");
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/all")
    public String findAllListings(Model model){
        List<Listing> listings =  listingService.findAll();
        model.addAttribute("allListings", listings);
        return "allListings";
    }

    @GetMapping("/find")
    public String findById(@RequestParam Integer id, Model model) {
        Listing listing = listingService.findById(id);
        model.addAttribute("listing", listing);
        return "listingDetails";
    }





    @GetMapping("/greeting/{name}")
    public String sayHello(@PathVariable String name){
        return String.format("Hello %s!", name);
    }


}
