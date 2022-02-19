package com.example.movieworkshop.models;

public class Movie implements Comparable<Movie> {

    private int year;
    private int length;
    private String title;
    private String genre;
    private int popularity;
    private String hasAwards;

    public Movie(int year, int length, String title, String genre, int popularity, String hasAwards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.genre = genre;
        this.popularity = popularity;
        this.hasAwards = hasAwards;
    }

    public String getHasAwards() {
        return hasAwards;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public int getPopularity() {
        return popularity;
    }

    public int compareTo(Movie otherMovie) {
        return Integer.compare(popularity, otherMovie.popularity);
    }

    @Override
    public String toString() {
        return title + ", " + year + ", Length: " + length + " min., Genre: " + genre + ", Popularity: " + popularity;
    }
}
