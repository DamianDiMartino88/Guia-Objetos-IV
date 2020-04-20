package com.VideoStoreRoberto.Movie;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;

/*

Nos contactan para realizar un software que le permita a un video store gestionar los
alquileres de sus películas. Nuestro cliente, Roberto, nos cuenta que su negocio dispone de
un amplio catálogo de películas, de los siguientes géneros. Acción, Aventura, Comedia,
Drama, Horror y Documental. Cada film de su inventario cuenta con un título, una fecha de
lanzamiento, una duración en minutos, una clasificación de audiencia, las siglas del país de
origen y una descripción de la misma. El video store de Roberto, ofrece la posibilidad de
alquilar los títulos físicamente, esto significa que hay un límite fijo de copias de cada título.

 */
public class Movie {
        private static int idMovieCounter=0;
        private int idMovie;
        private String movieTitle;
        private String genre;
        private LocalDate releaseDate;
        private String rating;
        private String country;
        private String description;
        private int stock;
        private int rentedTimes=0;
        private static List<Movie> moviesList= new ArrayList<>();

        public Movie(){
                idMovieCounter++;
                this.idMovie=idMovieCounter;
                this.movieTitle="";
                this.genre="";
                this.releaseDate= LocalDate.now();
                this.rating="";
                this.country="";
                this.description="";
                this.stock=0;
                moviesList.add(this);
        }


        public Movie(String title, String genre, int year,int month, int day, String rating, String country, String description, int stock){
                idMovieCounter++;
                this.idMovie=idMovieCounter;
                this.movieTitle=title;
                this.genre=genre;
                this.releaseDate= LocalDate.of(year,month,day);
                this.rating=rating;
                this.country=country;
                this.description=description;
                this.stock=stock;
                moviesList.add(this);
        }

        public void ranking(String genre){
                moviesList.sort(Comparator.comparing(Movie::getRentedTimes).reversed());
                if(genre.equals("")) {
                        System.out.println("Most Rented Movies: ");
                        for (Movie movie : moviesList) {
                                System.out.println("Title: " + movie.movieTitle + ", Rented Times: "
                                        + movie.rentedTimes);
                        }
                }else{
                        System.out.println("Most Rented "+genre+" Movies: ");
                        for (Movie movie : moviesList) {
                                if(movie.genre.equals(genre)){
                                System.out.println("Title: " + movie.movieTitle + ", Rented Times: "
                                        + movie.rentedTimes);
                                }
                        }
                }
        }

        public void viewMovie(String titleSearch){
                for (Movie movie : moviesList) {
                        System.out.println((movie.movieTitle.equals(titleSearch)) ?
                                "Title: " + movie.movieTitle +
                                " Genre: " + movie.genre +
                                " Rating: " + movie.rating +
                                " Release Date: " + movie.releaseDate +
                                " Country: " + movie.country +
                                " Description: " + movie.description
                                : "");
                }
        }

        public Movie checkMovie(String movieTitle){
                for (Movie movie : moviesList) {
                        if(movie.movieTitle.equals(movieTitle)) {
                               return movie;
                        }
                }
                return null;
        }

        public int rentMovie(int idSearch){
                for (Movie movie : moviesList) {
                        if(movie.idMovie==idSearch) {
                                if(movie.stock>0) {
                                        stock--;
                                }else{
                                        System.out.println("Out Of Stock");
                                        return 0;
                                }
                        }
                }
                return 1;
        }

        public void returnMovie(int idSearch){
                for (Movie movie : moviesList) {
                        if(movie.idMovie==idSearch) {
                               stock++;
                        }
                }
        }


        public static List<Movie> getMoviesList() {
                return moviesList;
        }


        public String getGenre() {
                return genre;
        }


        public void setGenre(String genre) {
                this.genre = genre;
        }

        public int getStock() {
                return stock;
        }

        public void setStock(int stock) {
                this.stock = stock;
        }

        public int getRentedTimes() {
                return rentedTimes;
        }

        public void setRentedTimes() {
                this.rentedTimes++;
        }

        public int getIdMovie() {
                return idMovie;
        }


        public String getMovieTitle() {
                return movieTitle;
        }

        public void setMovieTitle(String movieTitle) {
                this.movieTitle = movieTitle;
        }

        public LocalDate getReleaseDate() {
                return releaseDate;
        }

        public void setReleaseDate(LocalDate releaseDate) {
                this.releaseDate = releaseDate;
        }

        public String getRating() {
                return rating;
        }

        public void setRating(String rating) {
                this.rating = rating;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
