package ir.ac.kntu;

import java.util.ArrayList;

public class Airline {

    private String airlineName;
    private int numberOfAirplanes;
    private ArrayList<Flight> flights = new ArrayList<Flight>();

    public Airline(String airlineName, int numberOfAirplanes) {
        this.airlineName = airlineName;
        this.numberOfAirplanes = numberOfAirplanes;
    }

    public String getName() {
        return airlineName;
    }

    public ArrayList getFlights() {
        return flights;
    }

}
