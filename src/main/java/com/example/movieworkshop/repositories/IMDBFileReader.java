package com.example.movieworkshop.repositories;

import com.example.movieworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IMDBFileReader {

    private File imdbFile = new File("src/main/resources/imdb-data.csv");
    private Scanner imdbScanner;
    private List<Movie> movies = new ArrayList<>();

    public IMDBFileReader() {
        readIMDBFile();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void readIMDBFile() {
        try {
            imdbScanner = new Scanner(imdbFile);
            
            imdbScanner.nextLine();
            while (imdbScanner.hasNextLine()) {
                String[] movieData = imdbScanner.nextLine().split(";");

                movies.add(new Movie(Integer.parseInt(movieData[0]), Integer.parseInt(movieData[1]), movieData[2],
                        movieData[3], Integer.parseInt(movieData[4]), movieData[5]));
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

    }
}
