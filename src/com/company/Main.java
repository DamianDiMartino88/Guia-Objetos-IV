package com.company;

import com.VideoStoreRoberto.Client.Client;
import com.VideoStoreRoberto.Movie.Movie;
import com.VideoStoreRoberto.Rental.Rental;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Client[] arrayClient = new Client[100];
        Movie[] arrayMovie = new Movie[100];
        Rental[] arrayRental = new Rental[100];
        arrayClient[0] = new Client(12345678, "Roberto Owner", "2234567890", "Calle Falsa 123");
        arrayMovie[0] = new Movie("Avengers I", "Action", 2012, 5, 17, "PG", "USA", "Action movie based in super heros", 3);
        arrayMovie[arrayMovie[0].getMoviesList().size()] = new Movie("Avengers II", "Action", 2014, 8, 21, "PG", "USA", "Action movie based in super heros", 2);
        arrayMovie[arrayMovie[0].getMoviesList().size()] = new Movie("21 Jump Street", "Comedy", 2017, 4, 15, "PG-13", "USA", "Two young cops getting back to school", 1);
        arrayMovie[arrayMovie[0].getMoviesList().size()] = new Movie("Joker", "Drama", 2019, 10, 2, "R", "USA", "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker", 4);
        arrayRental[0] = new Rental(arrayClient[0], arrayMovie[0], 2);


        int option=1, clienDocument, movieYear, movieMonth, movieDay, movieStock, rentDays;
        String clientName, clientPhoneNumber, clientAdress, movieTitle, movieGenre, movieRating, movieCountry, movieDescription;
        Scanner numScan = new Scanner(System.in);
        Scanner txtScan = new Scanner(System.in);

        while (option!=0) {

            System.out.println("1. New Rental ");
            System.out.println("2. New Return ");
            System.out.println("3. Current Rentals ");
            System.out.println("4. Day Returns ");
            System.out.println("5. Ranking by Genre");
            System.out.println("6. Absolute Ranking");
            System.out.println("7. Last 10 Client Rentals");
            System.out.println("8. View Movie");
            System.out.println("9. New Movie");
            System.out.println("0. Exit");
            option=numScan.nextInt();

            switch (option) {
                case 1: {
                    Client rentClient;
                    Movie rentMovie=null;
                    System.out.println("Client Document?: ");
                    clienDocument = numScan.nextInt();
                    rentClient=arrayClient[0].checkClient(clienDocument);
                    if (rentClient == null) {
                        System.out.println("The Client Does Not Exist, Please Create a New Client");
                        System.out.println("Document: ");
                        clienDocument = numScan.nextInt();

                        System.out.println("Name: ");
                        clientName = txtScan.nextLine();

                        System.out.println("Phone Number:");
                        clientPhoneNumber = txtScan.nextLine();

                        System.out.println("Adress:");
                        clientAdress = txtScan.nextLine();

                        rentClient=arrayClient[arrayClient[0].getClientList().size()]=new Client(clienDocument,clientName,clientPhoneNumber,clientAdress);
                    }

                        while(rentMovie==null) {
                            System.out.println("Type Movie Title: ");
                            movieTitle = txtScan.nextLine();
                            rentMovie = arrayMovie[0].checkMovie(movieTitle);
                            if (rentMovie != null&&rentMovie.getStock()!=0) {
                                arrayRental[arrayRental[0].getRentalsLists().size()] = new Rental(rentClient, rentMovie, 2);
                            } else {
                                System.out.println(" Out of Stock, please pick another");
                            }
                        }

                }
                break;
                case 2: {
                    System.out.println("Title of Movie: ");

                    arrayRental[0].returnMovie(txtScan.nextLine());

                }
                break;
                case 3: {
                    arrayRental[0].currentRentals(null);
                }
                break;

                case 4: {
                    arrayRental[0].currentRentals(LocalDate.now());
                }
                break;

                case 5: {
                    System.out.println("Genre to Search:");
                    arrayMovie[0].ranking(txtScan.nextLine());
                }
                break;

                case 6: {
                    arrayMovie[0].ranking("");
                }
                break;

                case 7: {
                    System.out.println("Client Document: ");
                    Client historySearch = null;
                    clienDocument=numScan.nextInt();
                    while (historySearch==null&&clienDocument!=0){

                        historySearch=arrayClient[0].checkClient(clienDocument);
                        if (historySearch != null) {
                            historySearch.viewMovieHistory();
                        }else{
                            System.out.println("Wrong Document, Please Type another");
                            clienDocument=numScan.nextInt();
                        }
                    }
                }
                break;

                case 8: {
                    System.out.println("Title of Movie: ");
                    arrayMovie[0].viewMovie(txtScan.nextLine());
                }
                break;

                case 9: {

                    System.out.println("Title: ");
                    movieTitle = txtScan.nextLine();
                    System.out.println("Genre: ");
                    movieGenre = txtScan.nextLine();

                    System.out.println("Release Year:");
                    movieYear = numScan.nextInt();

                    System.out.println("Release Month:");
                    movieMonth = numScan.nextInt();

                    System.out.println("Release Day:");
                    movieDay = numScan.nextInt();

                    System.out.println("Rating:");
                    movieRating = txtScan.nextLine();

                    System.out.println("Country:");
                    movieCountry = txtScan.nextLine();

                    System.out.println("Description: ");
                    movieDescription = txtScan.nextLine();

                    System.out.println("Stock: ");
                    movieStock = numScan.nextInt();

                    arrayMovie[arrayMovie[0].getMoviesList().size()] = new Movie(movieTitle, movieGenre, movieYear, movieMonth, movieDay, movieRating,
                            movieCountry, movieDescription, movieStock);
                }
                break;

                default: {
                    System.out.println("Please Choose a correct Option ( 0 - 9");
                }
            }
        }


        //para la  busqueda del cliente, busco por DNI, si lo encuetnra me devuelve el objeto cliente, sino me devuelve
        //null, si me devuelve null se corta el alquiler y me lleva a ingresar un nuevo cliente



        arrayClient[0].viewMovieHistory();
        System.out.println(arrayMovie[0].getDescription());
        System.out.println(arrayRental[0].getReturnDate());
        System.out.println(arrayMovie[0].getRentedTimes());
        arrayRental[0].currentRentals(null);
        System.out.println("Day Returns");
        arrayRental[0].currentRentals(LocalDate.now());
        arrayRental[0].returnMovie("Avengers I");
        arrayRental[0].currentRentals(null);
        arrayMovie[0].ranking("Action");
        arrayMovie[0].ranking("");
    }
}
