package ir.ac.kntu;

import java.util.ArrayList;

public class Main {

    enum Option {
        DEFINE_AIRLINE, DEFINE_FLIGHT, PRINT_AIRLINES, PRINT_FLIGHTS,
        SEARCH_FLIGHT, TICKET_BUY_OR_RESERVATION, CANCEL_RESERVATION, COMPLETE_RESERVATION,
        BUY_TICKETS, CANCEL_TICKET, EXIT, UNDEFINED
    }


    private static int cnt;
    private static ArrayList<Airline> airlines = new ArrayList<Airline>();
    private static ArrayList<Airline> newAirlines = new ArrayList<Airline>();
    private static ArrayList<Airline> professionalAirlines = new ArrayList<Airline>();
    private static ArrayList<Flight> flights = new ArrayList<Flight>();

    public static ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public static ArrayList<Airline> getNewAirlines() {
        return newAirlines;
    }

    public static ArrayList<Airline> getProfessionalAirlines() {
        return professionalAirlines;
    }

    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public static void main(String[] args) {
        Option option;
        Menu.printTheMenu();
        option = Menu.getInstance().getOption();
        cnt = 0;
        while (option != Option.EXIT) {
            handle(option);
            Menu.printTheMenu();
            option = Menu.getInstance().getOption();
        }
    }

    public static void handle(Option option) {
        switch (option) {
            case DEFINE_AIRLINE:
                newAirline();
                break;
            case DEFINE_FLIGHT:
                if (!airlines.isEmpty()) {
                    flights.add(newFlight());
                } else {
                    System.out.println("Define an airline first");
                }
                break;
            case PRINT_AIRLINES:
                if (!airlines.isEmpty()) {
                    System.out.println("No airline exists ");
                } else {
                    if (!newAirlines.isEmpty()) {
                        System.out.println("No new airline exists ");
                    } else {
                        printNewAirlines();
                    }
                    if (!professionalAirlines.isEmpty()) {
                        System.out.println("No professional airline exists ");
                    } else {
                        printProfessionalAirlines();
                    }
                }
                break;
            case PRINT_FLIGHTS:
                System.out.println("Enter airline's name:");
                String airlineName = ScannerWrapper.next();
                Airline airline = Search.airlineByName(airlineName);
                ArrayList<Flight> curFlights = airline.getFlights();
                for(Flight eachFlight : curFlights){
                    Flight.printFlight(eachFlight);
                }
                break;
            case SEARCH_FLIGHT:
                Search.mainFlightSearch();
                break;
            case TICKET_BUY_OR_RESERVATION:
                if (!airlines.isEmpty()) {
                    Reserve.takeSeats(cnt);
                }else if(!flights.isEmpty()){
                    System.out.println("Define a flight first");
                } else {
                    System.out.println("Define an airline first");
                }
                break;
            case CANCEL_RESERVATION:
                System.out.println("Enter shopping code : ");
                long shoppingCode = ScannerWrapper.nextLong();
                Ticket.cancelReservation(shoppingCode);
                break;
            case COMPLETE_RESERVATION:
                System.out.println("Enter shopping code : ");
                shoppingCode = ScannerWrapper.nextLong();
                HandleTicket.ticketActions(Search.ticketByPurchaseCode(shoppingCode));
                break;
            case CANCEL_TICKET:
                System.out.println("Enter shopping code : ");
                shoppingCode = ScannerWrapper.nextLong();
                HandleTicket.ticketActions(Search.ticketByPurchaseCode(shoppingCode));
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void newAirline() {

        System.out.println("Enter the airline's name ");
        String airlineName = ScannerWrapper.next();
        System.out.println("What type of airline is it? ");
        System.out.println("1- New");
        System.out.println("2- Professional ");
        int choice = ScannerWrapper.nextInt();
        System.out.println("How many airplanes does it have ? ");
        int numberOfAirplanes = ScannerWrapper.nextInt();

        switch (choice) {
            case 1:
                if(existNewAirline(airlineName) == null) {
                    NewAirline newAirline = new NewAirline(airlineName, numberOfAirplanes);
                    newAirlines.add(newAirline);
                    airlines.add(newAirline);
                }else{
                    while(existNewAirline(airlineName) != null){
                        System.out.println("There is already an airline with this name please enter another name");
                        airlineName = ScannerWrapper.next();
                    }
                    NewAirline newAirline = new NewAirline(airlineName, numberOfAirplanes);
                    newAirlines.add(newAirline);
                    airlines.add(newAirline);
                }
                break;
            case 2:
                if(existProfessionalAirline(airlineName) == null) {
                    ProfessionalAirline professionalAirline = new ProfessionalAirline(airlineName, numberOfAirplanes);
                    professionalAirlines.add(professionalAirline);
                    airlines.add(professionalAirline);
                }else{
                    while(existProfessionalAirline(airlineName) != null){
                        System.out.println("There is already an airline with this name please enter another name");
                        airlineName = ScannerWrapper.next();
                    }
                    ProfessionalAirline professionalAirline = new ProfessionalAirline(airlineName, numberOfAirplanes);
                    professionalAirlines.add(professionalAirline);
                    airlines.add(professionalAirline);
                }
                break;

        }

    }

    //check if there is already an airline with this name
    public static NewAirline existNewAirline(String name) {
        for (Airline newAirline : newAirlines) {
            if (newAirline.getName().equals(name)) {
                return (NewAirline) newAirline;
            }
        }
        return null;
    }

    public static ProfessionalAirline existProfessionalAirline(String name) {
        for (Airline professionalAirline : professionalAirlines) {
            if (professionalAirline.getName().equals(name)) {
                return (ProfessionalAirline) professionalAirline;
            }
        }
        return null;
    }

    public static Flight existFlight(long flightNumber,ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public static void printNewAirlines() {
        System.out.println("New airlines are:");
        for (int i = 0; i < newAirlines.size(); i++) {
            System.out.println(newAirlines.get(i).getName());
        }
    }

    public static void printProfessionalAirlines() {
        System.out.println("Professional airlines are:");
        for (int i = 0; i < professionalAirlines.size(); i++) {
            System.out.println(professionalAirlines.get(i).getName());
        }
    }
    //define new flight
    public static Flight newFlight() {
        System.out.println("Enter airline's name :");
        String airlineName = ScannerWrapper.nextLine();
        if (checkAirlineName(airlineName) == null) {
            System.out.println("This airline doesn't exist");
            return null;
        }
        return Flight.newFlight(airlineName);

    }

    public static Airline checkAirlineName(String name) {
        for (Airline airline : airlines) {
            if (airline.getName().equals(name)) {
                return airline;
            }
        }
        return null;
    }

}