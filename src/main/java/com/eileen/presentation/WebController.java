package com.eileen.presentation;

import com.eileen.logic.Customer;
import com.eileen.logic.Movie;
import com.eileen.logic.MovieServices;
import com.eileen.logic.RentalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/")
    public String showAll( Model model) {
        model.addAttribute("movies", movieServices.getAllAvailableMovies());
        model.addAttribute("rentalRequest", new RentalRequest());
        model.addAttribute("searchRequest", new SearchRequest());
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @GetMapping("/search-results")
    public String showSearchResults(@RequestParam(name="title", required = false) String title, Model model){
        model.addAttribute("searchRequest", new SearchRequest());
        model.addAttribute("searchedMovies", movieServices.showResultFromMovieTitle(title));
        return "searchResults";
    }

    @PostMapping("/rent")
    public String rentAMovie(@ModelAttribute RentalRequest rentalRequest) {
        movieServices.rentAMovie(rentalRequest.getCustomerName(), rentalRequest.getMovieTitle());
        return "/rented";
    }

    @GetMapping("/return")
    public String returnPage(@RequestParam(name = "customerName", required = true) String customerName, Model model) {
        model.addAttribute("rentalRequest", new RentalRequest());
        List<Movie> attributeValue = movieServices.showAllMoviesToReturn(customerName);
        model.addAttribute("movies", attributeValue);
        return "/return";
    }

    @PostMapping("/return")
    public String returnAMovie(@ModelAttribute RentalRequest rentalRequest) {
        movieServices.returnAMovie(rentalRequest.getCustomerName(), rentalRequest.getMovieTitle());
        return "/returned";
    }

    @GetMapping("/customer")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/customer")
    public String customerSubmit(@ModelAttribute Customer customer) {
        movieServices.createNewCustomer(customer);
        return "loggedIn";
    }

}
