package com.eileen.presentation;

import com.eileen.logic.movie.Movie;
import com.eileen.logic.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private MovieService movieService;

    @Autowired
    public Menu(MovieService movieService) {
        this.movieService = movieService;
    }

    public void startMenu() {

        System.out.println("Welcome to the blockbuster!");
        System.out.println("Please enter your name to log in: ");
        String customerName = scanner.nextLine();

        boolean finish = false;
        while (!finish) {
            System.out.println("Please see menu below: ");
            System.out.println("---------------------------------------------------");
            System.out.println("You have logged in. Here is the menu.");
            System.out.println("1 - List all available movies.");
            System.out.println("2 - Rent a movie.");
            System.out.println("3 - Return a movie.");
            System.out.println("4 - Show all rented movies.");
            System.out.println("0 - Exit.");

            int userSelected = Integer.valueOf(scanner.nextLine());

            switch (userSelected) {
                case 1:
                    System.out.println("Here are all the available movies to rent: ");
                    List<Movie> allAvailableMovies = movieService.getAllAvailableMovies();
                    for (Movie movie : allAvailableMovies) {
                        System.out.println(movie);
                    }
                    break;
                case 2:
                    System.out.println("Please enter the movie you want to rent:");
                    String movieTitleToRent = scanner.nextLine();
                    movieService.rentAMovie(customerName, movieTitleToRent);
                    System.out.println("You have rented : " + movieTitleToRent);
                    break;
                case 3:
                    System.out.println("Please enter the movie you want to return:");
                    String movieTitleToReturn = scanner.nextLine();
                    movieService.returnAMovie(customerName, movieTitleToReturn);
                    System.out.println("You have returned: " + movieTitleToReturn);
                    break;
                case 4:
                    System.out.println(movieService.showAllMoviesToReturn(customerName));
                    break;
                case 5:
                    System.out.println("Please enter the movie you want to rent:");
                    String movieTitle = scanner.nextLine();
                    System.out.println(movieService.showResultFromMovieTitle(movieTitle));
                    break;

                case 0:
                    System.out.println("Goodbye! Thank you for visiting us.");
                    finish = true;
                    break;
                default:
                    System.out.println("That is not a valid option. Please enter again.");
            }
            System.out.println();
        }

    }


}
