package com.VideoStoreRoberto.Rental;

import com.VideoStoreRoberto.Client.Client;
import com.VideoStoreRoberto.Movie.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rental implements RentalList {
    private static int idRentalCounter=0;
    private int idRental;
    private Client rentalClient;
    private Movie movieRented;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private String rentalState;
    public static List<Rental> rentalsLists=new ArrayList<>();


    public Rental(){
        idRentalCounter++;
        this.idRental=idRentalCounter;
        this.rentalClient=null;
        this.movieRented=null;
        this.rentalDate=LocalDate.now();
        this.returnDate=LocalDate.now();
        this.rentalState="";
        rentalsLists.add(this);
    }

    public Rental(Client rentalClient, Movie movieRented, int rentDays){
        if(movieRented.rentMovie(movieRented.getIdMovie())==1) {
            idRentalCounter++;
            idRental = idRentalCounter;
            this.rentalClient = rentalClient;
            this.movieRented = movieRented;
            rentalClient.movieHistory(movieRented);
            movieRented.setRentedTimes();
            this.rentalDate = LocalDate.now();
            this.returnDate = rentalDate.plusDays(rentDays);
            this.rentalState = "Client Possession";
            rentalsLists.add(this);
        }
    }

    public void returnMovie(String titleSearch){
        Scanner scan = new Scanner(System.in);
        for (Rental rent: rentalsLists) {
            if(rent.movieRented.getMovieTitle().equals(titleSearch)&&rent.rentalState.equals("Client Possession")) {
                System.out.println("Rent ID: " + rent.idRental
                        + ", Client: " + rent.rentalClient.getClientName());
            }
        }
        System.out.println("Rental ID Returned: ");
        int idSearch=scan.nextInt();
        for (Rental rent: rentalsLists) {
            if(rent.idRental==idSearch){
                rent.movieRented.returnMovie(rent.movieRented.getIdMovie());
                rent.setRentalState("Returned");
            }
        }
        System.out.println("Process Successful");
    }

    public void currentRentals(LocalDate date){
        int movies=0;
       if(date!=null){
           for (Rental rent : rentalsLists) {
               if(rent.returnDate.getDayOfMonth()== date.getDayOfMonth()) {
                   if(rent.rentalState.equals("Client Possession"))
                       System.out.println("Rent ID: " + rent.idRental + ", Movie Rented: "
                               + rent.movieRented.getMovieTitle() + ", Rental Client: " + rent.rentalClient.getClientName());
                   movies++;
                  }
           }
       }else {
           for (Rental rent : rentalsLists) {
               if(rent.rentalState.equals("Client Possession")) {
                   System.out.println("Rent ID: " + rent.idRental + ", Movie Rented: "
                           + rent.movieRented.getMovieTitle() + ", Rental Client: " + rent.rentalClient.getClientName());
                   movies++;
               }
           }
       }
       if(movies==0){
           System.out.println("No Rentals Found");
       }
    }

    public void movieSearch(){

    }


    public void viewRent(int id){
        for (Rental rent: rentalsLists ) {
            System.out.println((rent.idRental==id)?", Movie Rented: "+rent.movieRented.getMovieTitle()
                    +", Rental Client: "+rent.rentalClient.getClientName():"");
        }
    }

    public int getIdRental() {
        return idRental;
    }

    public Client getRentalClient() {
        return rentalClient;
    }

    public void setRentalClient(Client rentalClient) {
        this.rentalClient = rentalClient;
    }

    public Movie getMovieRented() {
        return movieRented;
    }

    public void setMovieRented(Movie movieRented) {
        this.movieRented = movieRented;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getRentalState() {
        return rentalState;
    }

    public void setRentalState(String rentalState) {
        this.rentalState = rentalState;
    }

    public static List<Rental> getRentalsLists() {
        return rentalsLists;
    }

}
