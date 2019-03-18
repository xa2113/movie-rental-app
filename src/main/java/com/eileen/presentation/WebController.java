package com.eileen.presentation;

import com.eileen.logic.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("movies", movieServices.getAllAvailableMovies());
        return "listMovies";
    }
}
