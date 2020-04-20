package com.VideoStoreRoberto.Client;

/*

Por otro lado, nuestro cliente nos cuenta que le interesa saber acerca de quienes alquilan
sus películas, su nombre, teléfono y dirección.
 */

import com.VideoStoreRoberto.Movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int idClientCounter=0;
    private int idClient;
    private int clientDocument;
    private String clientName;
    private String phoneNumber;
    private String adress;
    private List<Movie>movieList;
    private static List<Client>clientList=new ArrayList<>();

    public static List<Client> getClientList() {
        return clientList;
    }


    public Client(){
        idClientCounter++;
        this.idClient=idClientCounter;
        this.clientDocument=00000000;
        this.clientName="";
        this.phoneNumber="";
        this.adress="";
        this.movieList=new ArrayList<>();
        clientList.add(this);
    }

    public Client(int clientDocument,String clientName, String phoneNumber, String adress){
        idClientCounter++;
        this.idClient=idClientCounter;
        this.clientDocument=clientDocument;
        this.clientName=clientName;
        this.phoneNumber=phoneNumber;
        this.adress=adress;
        this.movieList=new ArrayList<>();
        clientList.add(this);
    }

    //para la  busqueda del cliente, busco por DNI, si lo encuetnra me devuelve el objeto cliente, sino me devuelve
    //null, si me devuelve null se corta el alquiler y me lleva a ingresar un nuevo cliente

    public Client checkClient(int document){
        for (Client client: clientList) {
            if(client.clientDocument==document){
                return client;
            }
        }
        return null;
    }

    public void movieHistory(Movie movie){
        this.movieList.add(movie);
    }

    public void viewMovieHistory(){
        int i =0;
        int movies=(this.movieList.size()-1);
        while(i <10&&movies>=0){
            System.out.println("Title: "+this.movieList.get(movies).getMovieTitle());
            movies--;
            i++;
        }
    }

    public int getIdClient() {
        return idClient;
    }

    public int getClientDocument() {
        return clientDocument;
    }

    public void setClientDocument(int clientDocument) {
        this.clientDocument = clientDocument;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
