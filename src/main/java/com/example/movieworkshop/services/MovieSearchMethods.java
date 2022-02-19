package com.example.movieworkshop.services;

import com.example.movieworkshop.models.Movie;
import com.example.movieworkshop.repositories.IMDBFileReader;

import java.util.*;

public class MovieSearchMethods {

    private IMDBFileReader dataOfMovies = new IMDBFileReader();
    private List<Movie> movies = dataOfMovies.getMovies();
    private Random random = new Random();


    public Movie getFirstMovie() {
        return movies.get(0);
    }

    public Movie getRandomMovie() {
        int index = random.nextInt(movies.size());
        return movies.get(index);
    }

    public String getTenSortByPopularity() {
        List<Movie> tenRandomMovies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tenRandomMovies.add(getRandomMovie());
        }

        Collections.sort(tenRandomMovies);
        return moviesToString(tenRandomMovies);
    }

    public String moviesToString(List<Movie> movies) {
        int count = 1;
        String moviesString = "";

        for (Movie movie: movies) {
            moviesString += count + ". " + movie + "   ";
            count++;
        }

        return moviesString;
    }

    public int getAmountOfMoviesThatWonAnAward() {
        int awardCount = 0;

        for (Movie movie: movies) {
            if (movie.getHasAwards().equals("Yes")) awardCount++;
        }

        return awardCount;
    }

    public String getMoviesByChar(char c, int n) {
        List<Movie> movieMatches = new ArrayList<>();
        for (Movie movie : movies) {
            String title = movie.getTitle();
            int charCount = 0;

            for (int i = 0; i < title.length(); i++) {
                if (title.charAt(i) == c) charCount++;
            }

            if (n == charCount) movieMatches.add(movie);
        }

        return moviesToString(movieMatches);
    }

    public String findGenreWithTheLongerMovies(String genre1, String genre2) {
        String g1 = genre1.toLowerCase();
        String g2 = genre2.toLowerCase();
        int g1Length = 0;
        int g1Count = 0;

        int g2Length = 0;
        int g2Count= 0;


        for (Movie movie : movies) {
            if (g1.equals(movie.getGenre().toLowerCase())) {
                g1Length += movie.getLength();
                g1Count++;
            }
            if (g2.equals(movie.getGenre().toLowerCase())) {
                g2Length += movie.getLength();
                g2Count++;
            }
        }

        int g1Average = g1Length / g1Count;
        int g2Average = g2Length / g2Count;

        if (g1Average > g2Average) {
            return genre1;
        } else {
            return genre2;
        }
    }

}
