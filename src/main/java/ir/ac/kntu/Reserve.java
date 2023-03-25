package ir.ac.kntu;

import java.util.Random;

public class Reserve {

    public static int takeSeats(int cnt) {
        System.out.println("Enter flight number :");
        long enteredFlightNumber = ScannerWrapper.nextLong();
        Flight flight = Search.byFlightNumber(enteredFlightNumber);
        System.out.println("How many seats do you want ?");
        int neededSeats = ScannerWrapper.nextInt();
        if (flight.getAvailableSeats() < neededSeats) {
            System.out.println("There is only " + flight.getAvailableSeats() + "seats left");
            return -1;
        }
        System.out.println("Enter number of passengers with the following pattern : 'Adults 2-12-kids under-2-kids' ");
        int adults = ScannerWrapper.nextInt();
        int underTwelve = ScannerWrapper.nextInt();
        int underTwo = ScannerWrapper.nextInt();
        ScannerWrapper.nextLine();
        System.out.println("Enter your first name :");
        String firstName = ScannerWrapper.nextLine();
        System.out.println("Enter your last name :");
        String lastName = ScannerWrapper.nextLine();
        System.out.println("Your tickets are already reserved. Do you wish to Buy them now ?");
        double basePrice = flight.getBasePrice();
        if (Main.existFlight(enteredFlightNumber, RoyalFlight.getRoyalFlights()) != null) {
            basePrice = FirstClassSeat.seatPrice(flight.getBasePrice());
        } else if (Main.existFlight(enteredFlightNumber, GradeFlight.getGradeFlights()) != null) {

            System.out.println("What type of seats do you want?");
            System.out.println("1- Economic");
            System.out.println("2- Business class");
            System.out.println("3- First class");
            int choice = ScannerWrapper.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    basePrice = BusinessSeat.seatPrice(flight.getBasePrice());
                    break;
                case 3:
                    basePrice = FirstClassSeat.seatPrice(flight.getBasePrice());
                    break;
                default:
                    break;
            }
        }
        double price = Ticket.calculatePrice(basePrice, adults, underTwelve, underTwo);
        System.out.println("You have to pay " + price + "$");
        System.out.println("1-Pay now    2-reserve  3-Cancel");
        int tmp = ScannerWrapper.nextInt();
        if (tmp == 3) {
            return -1;
        } else {
            flight.setAvailableSeats(flight.getAvailableSeats() - neededSeats);
        }
        System.out.println("Your purchase codes will be :");
        for (int i = 1; i <= neededSeats; i++) {
            System.out.println(++cnt);
            Ticket ticket = new Ticket(enteredFlightNumber, ++cnt, basePrice, neededSeats, adults, underTwelve, underTwo, firstName, lastName);
            if (tmp == 1) {
                ticket.bought = true;
                if (Main.existProfessionalAirline(flight.getAirlineName()) != null) {

                    ProfessionalAirline airline = Main.existProfessionalAirline(flight.getAirlineName());
                    Archive archive = new Archive(flight.getStart(), flight.getEnd(),
                            flight.getTakeOff(), flight.getLanding(), (adults + underTwelve + underTwo));
                    airline.getArchives().add(archive);

                }
                flight.getTickets().add(ticket);
            }
            System.out.println('\n' + "Purchase was successful");
        }
        return cnt;
    }
}
