package com.eileen.presentation;

import com.eileen.logic.Customer;
import com.eileen.logic.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("movies", movieServices.getAllAvailableMovies());
        return "index";
    }

    @GetMapping("/customer")
    public String customerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/customer")
    public String customerSubmit(@ModelAttribute Customer customer){
        movieServices.createNewCustomer(customer);
        return "loggedIn";
    }
}
