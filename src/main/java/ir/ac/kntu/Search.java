package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Date;

public class Search {

    public static Airline airlineByName(String Key) {
        for (int i = 0; i < Main.getAirlines().size(); i++) {
            if (Main.getAirlines().get(i).getName().equals(Key)) {
                return Main.getAirlines().get(i);
            }
        }
        return null;
    }

    public static ArrayList<Flight> flightByAirline(String airline,
                                                    ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getAirlineName().equals(airline)) {
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        Flight.sortFlightsByPrice(ans);
        return ans;
    }

    public static ArrayList<Flight> byStart(String Start,
                                            ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for(int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getStart().equals(Start)) {
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        Flight.sortFlightsByPrice(ans);
        return ans;
    }

    public static ArrayList<Flight> byEnd(String End,
                                          ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getEnd().equals(End)) {
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        Flight.sortFlightsByPrice(ans);
        return ans;
    }

    public static Flight byFlightNumber(long Key) {
        for (int i = 0; i <  Main.getFlights().size(); i++) {
            if (Main.getFlights().get(i).getFlightNumber() == Key) {
                return Main.getFlights().get(i);
            }
        }
        return null;
    }

    public static ArrayList<Flight> bySeats(int numberOfSeats,
                                            ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getAvailableSeats() >= numberOfSeats) {
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        return ans;
    }

    public static ArrayList<Flight> byTakeOffsAfterDate(Date after, ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getTakeOff().before(after)){
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        return ans;
    }

    public static ArrayList<Flight> byTakeOffsBeforeDate(Date before, ArrayList<Flight> Flights) {
        ArrayList<Flight> resultFlights = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getTakeOff().after(before)) {
                resultFlights.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        return resultFlights;
    }

    public static ArrayList<Flight> byLandingsAfterDate(Date after, ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getLanding().before(after)){
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        return ans;
    }

    public static ArrayList<Flight> byLandingBeforeDate(Date before, ArrayList<Flight> Flights) {
        ArrayList<Flight> ans = new ArrayList<Flight>();
        int cnt = 0;
        for (int i = 0; i < Flights.size(); i++) {
            if (Flights.get(i).getLanding().after(before)) {
                ans.set(cnt, Flights.get(i));
                cnt++;
            }
        }
        return ans;
    }

    public static ArrayList<Flight> validTakeOff(ArrayList<Flight> Flights) {

        ArrayList<Flight> ans = Flights;
        System.out.println("Take off start: 'Enter with this format : Year  Month  Day Hour Minute'" +  '\n' + "If you don't want to search via this option write ' -1 ' !");
        int year;
        year = ScannerWrapper.nextInt();
        if (year != -1) {
            Date from = new Date(year, ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt());
            ans = byTakeOffsAfterDate(from, ans);
            System.out.println("Take off end: 'Enter with this format : Year  Month  Day Hour Minute'");
            Date to = new Date(ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt());
            ans = byTakeOffsBeforeDate(to, ans);
            return ans;
        } else {
            return Flights;
        }
    }

    public static ArrayList<Flight> validLanding(ArrayList<Flight> Flights) {

        ArrayList<Flight> ans = Flights;
        System.out.println("Landing start: 'Enter with this format : Year  Month  Day Hour Minute'" +  '\n' + "If you don't want to search via this option write ' -1 ' !");
        int year;
        year = ScannerWrapper.nextInt();
        if (year != -1) {
            Date from = new Date(year, ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt());

            ans = byLandingBeforeDate(from, ans);
            System.out.println("Landing end : 'Enter with this format : Year  Month  Day Hour Minute'");
            Date to = new Date(ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt(), ScannerWrapper.nextInt());
            ans = byLandingsAfterDate(to, ans);

            return ans;
        } else {
            return ans;
        }
    }

    public static ArrayList<Flight> mainFlightSearch() {
        ArrayList<Flight> ans = Main.getFlights();
        System.out.println("Enter start :" + '\n' + "If you don't want to search via this option write ' -1 ' !");
        String start;
        start = ScannerWrapper.nextLine();
        if (!start.equals("-1")) {
            ans = byStart(start, ans);
        }
        System.out.println( '\n' + "Enter destination :" + '\n' + "If you don't want to search via this option write ' -1 ' !");
        String destination;
        destination = ScannerWrapper.nextLine();
        if (!destination.equals("-1")) {
            ans = byEnd(destination, ans);
        }
        System.out.println("Enter number of seats you are looking for :" + '\n' + "If you don't want to search via this option write ' -1 ' !");
        int Seats = 1;
        Seats = ScannerWrapper.nextInt();
        if (Seats != -1) {
            ans = bySeats(Seats, ans);
        }
        ans = validTakeOff(ans);
        ans = validLanding(ans);
        System.out.println('\n' + "Enter Airline name :" + '\n' + "If you don't want to search via this option write ' -1 ' !");
        String airline;
        ScannerWrapper.nextLine();
        airline = ScannerWrapper.nextLine();
        if (!airline.equals("-1")) {
            ans = flightByAirline(airline, ans);
        }
        Flight.sortFlightsByPrice(ans);
        for (int i = 0; i < ans.size(); i++) {
            Flight.printFlight(ans.get(i));
        }
        return ans;

    }

    public static Flight byFlightNumberInRoyal(long flightNumber) {
        ArrayList <Flight> royalFlights = RoyalFlight.getRoyalFlights();
        for (Flight curFlight : royalFlights) {
            if (curFlight.getFlightNumber() == flightNumber) {
                return curFlight;
            }
        }
        return null;
    }

    public static Flight byFlightNumberInGrade(long flightNumber) {
        ArrayList <Flight> gradeFlights = GradeFlight.getGradeFlights();
        for (Flight curFlight : gradeFlights) {
            if (curFlight.getFlightNumber() == flightNumber) {
                return curFlight;
            }
        }
        return null;
    }

    public static Flight byFlightNumberInWithoutGrade(long flightNumber) {
        ArrayList <Flight> withoutGradeFlights = WithoutGradeFlight.getWithoutGradeFlights();
        for (Flight curFlight : withoutGradeFlights) {
            if (curFlight.getFlightNumber() == flightNumber) {
                return curFlight;
            }
        }
        return null;
    }

    public static Ticket ticketByPurchaseCode(long shoppingCode) {
        for(int i = 0; i < Main.getAirlines().size(); i++){
            Airline airline = Main.getAirlines().get(i);
            for(int j = 0; j < airline.getFlights().size(); j++){
                Flight flight = (Flight) (airline.getFlights().get(j));
                for(int k = 0; k < flight.getTickets().size(); k++){
                    Ticket ticket = flight.getTickets().get(k);
                    if(ticket.getShoppingCode() == shoppingCode){
                        return ticket;
                    }
                }
            }
        }
        return null;
    }
}
