package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Flight {

    private String airlineName;
    private long flightNumber;
    private double basePrice;
    private String start;
    private String end;
    private int totalSeats;
    private int availableSeats;
    private Date takeOff;
    private Date landing;
    private ArrayList<Ticket> tickets;
    private ArrayList<Ticket> canceledTickets;

    public Flight(String airlineName, long flightNumber, double basePrice, String start,
                  String end,Date takeOff, Date landing, int totalSeats) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.start = start;
        this.end = end;
        this.takeOff = takeOff;
        this.landing = landing;
        this.basePrice = basePrice;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.tickets = new ArrayList<Ticket>();
        this.canceledTickets = new ArrayList<Ticket>();

    }

    public static void printFlight(Flight flight) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Airline name :" + flight.airlineName);
        System.out.println("Flight number :" + flight.flightNumber);
        System.out.println("Origin :" + flight.start);
        System.out.println("Destination :" + flight.end);
        System.out.println("take off :" + flight.takeOff.toString());
        System.out.println("landing :" + flight.landing.toString());
        System.out.println("total seats :" + flight.totalSeats);
        System.out.println("sold seats :" + (flight.totalSeats - flight.availableSeats));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }


    public String getAirlineName() {
        return airlineName;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public Date getTakeOff() {
        return takeOff;
    }

    public Date getLanding() {
        return landing;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getTotalSeats() {
        return this.totalSeats;
    }

    public int getAvailableSeats(){
        return this.availableSeats;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public ArrayList<Ticket> getCanceledTickets() {
        return canceledTickets;
    }

    public void setCanceledTickets(ArrayList<Ticket> canceledTickets) {
        this.canceledTickets = canceledTickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setAvailableSeats(int a) {
        this.availableSeats = a;
    }

    public static void sortFlightsByPrice(ArrayList<Flight> flights) {
        Flight tmp;
        for (int i = 0; i < flights.size(); i++) {
            for (int j = 0; j < flights.size(); j++) {
                if (flights.get(i).basePrice > flights.get(j).basePrice) {
                    tmp = flights.get(i);
                    flights.set(i, flights.get(j));
                    flights.set(j, tmp);
                }
            }
        }
    }
    public static void sortFlightsByAirlineName(ArrayList<Flight> flights){
        int cnt = 0;
        String[] holder = new String[flights.size() + 2];
        for(int i = 0; i < flights.size(); i++){
            holder[i] = new String(flights.get(i).getAirlineName());
        }
        Arrays.sort(holder);
        ArrayList<Flight> holding = new ArrayList<Flight>();
        for(int i = 0; i < flights.size(); i++){
            for(int j = 0; j < flights.size();j++){
                if(flights.get(j).getAirlineName() == holder[i]){
                    holding.set(i, flights.get(j));
                    for(int k = 0; k < flights.size(); k++){
                        flights.set(k, holding.get(k));
                    }
                }
            }
        }
    }

    public static Flight newFlight(String airlineName) {

        System.out.println("Enter flight number :");
        long flightNumber = ScannerWrapper.nextLong();
        System.out.println("Enter base Price :");
        double basePrice = ScannerWrapper.nextDouble();
        System.out.println("Enter Start :");
        String start = ScannerWrapper.nextLine();
        System.out.println("Enter End :");
        String end = ScannerWrapper.nextLine();
        System.out.println("Enter take off date with this format : Year Month Day Hour Minute");
        Date takeOff = new Date(ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt());
        System.out.println("Enter landing date with this format : Year Month Day Hour Minute");
        Date landing = new Date(ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt());
        System.out.println("Enter the number of seats the flight has");
        int totalSeats = ScannerWrapper.nextInt();
        Flight flight = new Flight(airlineName, flightNumber, basePrice, start, end, takeOff, landing, totalSeats);
        System.out.println("What type of flight it is?");
        System.out.println("1- Without grade");
        System.out.println("2- With grade");
        System.out.println("3- Royal");
        int flightType = ScannerWrapper.nextInt();
        switch (flightType){
            case 1:
                return WithoutGradeFlight.newFlight(flight);
            case 2:
                return GradeFlight.newFlight(flight);
            case 3:
                return RoyalFlight.newFlight(flight);
            default:
                return null;
        }


    }

}


