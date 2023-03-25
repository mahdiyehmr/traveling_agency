package ir.ac.kntu;

import java.util.ArrayList;

public class WithoutGradeFlight extends Flight{

    private static ArrayList<Flight> withoutGradeFlights = new ArrayList<Flight>();

    public WithoutGradeFlight(String airline, long flightNumber, double basePrice, String start,
                              String end, DateAndTime takeOff, DateAndTime landing, int totalSeats) {
        super(airline,flightNumber,basePrice,start,end,takeOff,landing,totalSeats);
    }
    public static WithoutGradeFlight newFlight(Flight flight){
        WithoutGradeFlight withoutGradeFlight = new WithoutGradeFlight(flight.getAirlineName(),flight.getFlightNumber(),
                flight.getBasePrice(),flight.getStart(),flight.getEnd(),flight.getTakeOff(),
                flight.getLanding(),flight.getTotalSeats());
        withoutGradeFlights.add(withoutGradeFlight);
        return withoutGradeFlight;
    }
    public static ArrayList<Flight> getWithoutGradeFlights() {
        return withoutGradeFlights;
    }
}
