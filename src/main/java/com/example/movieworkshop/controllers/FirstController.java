package com.example.movieworkshop.controllers;

import com.example.movieworkshop.services.MovieSearchMethods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    MovieSearchMethods msm = new MovieSearchMethods();

    @GetMapping("/")
    public String welcome() {
        return "Welcome to IMDB, a movie database where you can look up any movie there exists in the world.";
    }

    @GetMapping("/getFirst")
    public String getFirst() {
        return msm.getFirstMovie().toString();
    }

    @GetMapping("/getRandom")
    public String getRandom() {
        return msm.getRandomMovie().toString();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() {
        return msm.getTenSortByPopularity();
    }

    @GetMapping("/howManyWonAnAward")
    public String howManyWonAnAward() {
        return "Amount of movies that has won an award according to IMDB: " + msm.getAmountOfMoviesThatWonAnAward();
    }

    @GetMapping("/filter")
    public String findMoviesByChar(@RequestParam char character, int amount) {
        return msm.getMoviesByChar(character, amount);
    }

    @GetMapping("/longest")
    public String genreWithLongerMovies(@RequestParam String genre1, String genre2) {
        String longestGenre = msm.findGenreWithTheLongerMovies(genre1, genre2);
        return longestGenre + " has on average longer movies";
    }

}
