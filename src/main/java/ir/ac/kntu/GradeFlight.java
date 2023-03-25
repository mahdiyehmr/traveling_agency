package ir.ac.kntu;

import java.util.ArrayList;

public class GradeFlight extends Flight{

    private int firstClassSeats;
    private int businessSeats;
    private int economicSeats;
    private static ArrayList<Flight> gradeFlights = new ArrayList<Flight>();

    public GradeFlight(String airline, long flightNumber, double basePrice, String start,
                       String end,DateAndTime takeOff, DateAndTime landing,
                       int totalSeats, int firstClassSeats,int businessSeats, int economicSeats) {
        super(airline, flightNumber, basePrice, start, end, takeOff, landing, totalSeats);
        this.firstClassSeats = firstClassSeats;
        this.businessSeats = businessSeats;
        this.economicSeats = economicSeats;

    }

    public static GradeFlight newFlight(Flight flight){

        System.out.println("How many first class seats does it have?");
        int firstClassSeats = ScannerWrapper.nextInt();
        System.out.println("How many business seats does it have?");
        int businessSeats = ScannerWrapper.nextInt();
        System.out.println("How many economic class seats does it have?");
        int economicSeats = ScannerWrapper.nextInt();
        GradeFlight gradeFlight = new GradeFlight(flight.getAirlineName(),flight.getFlightNumber(),
                flight.getBasePrice(),flight.getStart(),flight.getEnd(),flight.getTakeOff(),
                flight.getLanding(),flight.getTotalSeats(),firstClassSeats,businessSeats,economicSeats);
        gradeFlights.add(gradeFlight);
        return gradeFlight;
    }

    public static ArrayList<Flight> getGradeFlights() {
        return gradeFlights;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }
    public int getBusinessSeats(){
        return businessSeats;
    }

    public int getEconomicSeats() {
        return economicSeats;
    }
}
