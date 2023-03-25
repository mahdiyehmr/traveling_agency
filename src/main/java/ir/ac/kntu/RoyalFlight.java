package ir.ac.kntu;

import java.util.ArrayList;

public class RoyalFlight extends Flight{

    private static ArrayList<Flight> royalFlights = new ArrayList<Flight>();

    public RoyalFlight(String airlineName, long flightNumber, double basePrice, String start,
                           String end,DateAndTime takeOff, DateAndTime landing, int totalSeats) {
        super(airlineName,flightNumber,basePrice,start,end,takeOff,landing,totalSeats);
    }
    public static RoyalFlight newFlight(Flight flight){
        RoyalFlight royalFlight = new RoyalFlight(flight.getAirlineName(),flight.getFlightNumber(),
                flight.getBasePrice(),flight.getStart(),flight.getEnd(),flight.getTakeOff(),
                flight.getLanding(),flight.getTotalSeats());
        royalFlights.add(royalFlight);
        return royalFlight;
    }

    public static ArrayList<Flight> getRoyalFlights() {
        return royalFlights;
    }

}
