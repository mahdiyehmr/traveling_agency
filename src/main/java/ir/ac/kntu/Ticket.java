package ir.ac.kntu;

import java.util.Date;

public class Ticket {

    private long flightNumber;
    private long shoppingCode;
    private int seats;
    private int adults;
    private int underTwelve;
    private int underTwo;
    private double basePrice;
    private double price;
    boolean bought;
    boolean canceled;
    private String firstName;
    private String lastName;
    private Date shoppingDate;

    public Date getShoppingDate() {
        return shoppingDate;
    }

    public long getShoppingCode() {
        return shoppingCode;
    }

    public int getSeats() {
        return seats;
    }

    public int getAdults() {
        return adults;
    }

    public int getUnderTwelve() {
        return underTwelve;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        return price;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public Ticket(long flightNumber, long shoppingCode, double basePrice,
                  int seats, int adults, int underTwelve, int underTwo, String firstName, String lastName) {
        this.flightNumber = flightNumber;
        this.shoppingCode = shoppingCode;
        this.seats = seats;
        this.adults = adults;
        this.underTwelve = underTwelve;
        this.underTwo = underTwo;
        this.basePrice = basePrice;
        this.firstName = firstName;
        this.lastName = lastName;
        this.price = calculatePrice(basePrice, adults, underTwelve, underTwo);
        canceled = false;
        shoppingDate = Bill.getDate();
    }

    public static double calculatePrice(double basePrice, int adults, int underTwelve, int underTwo) {
        adults *= basePrice;
        underTwelve *= basePrice / 2;
        underTwo *= basePrice / 10;
        double price = adults + underTwelve + underTwo;
        return price;
    }

    public void printTicket() {
        System.out.println("Buyer :" + firstName + " " + lastName);
        System.out.println("Flight number :" + flightNumber);
        System.out.println("Purchase code :" + shoppingCode);
        System.out.println("Seats : " + seats);
        System.out.println("Adults :" + adults);
        System.out.println("Under 12 years old :" + underTwelve);
        System.out.println("Under 2 years old :" + underTwo);
        System.out.println("Base price :" + basePrice);
        System.out.println("Final price :" + price);
        if (!bought) {
            System.out.println("Reserved");
        } else {
            System.out.println("Sold");
        }
    }

    public static void cancelReservation(long shoppingCode) {
        Ticket ticket = Search.ticketByPurchaseCode(shoppingCode);
        Flight flight = Search.byFlightNumber(ticket.flightNumber);
        flight.getCanceledTickets().add(ticket);
        flight.setAvailableSeats(flight.getAvailableSeats() + ticket.getSeats());
        System.out.println("Operation completed");
        flight.getTickets().remove(ticket);
    }
}
