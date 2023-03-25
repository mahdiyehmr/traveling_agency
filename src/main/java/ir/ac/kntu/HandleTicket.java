package ir.ac.kntu;

public class HandleTicket {

    public static void ticketActions(Ticket ticket) {
        ticket.printTicket();
        if (ticket.bought == true) {
            System.out.println("This ticket is already bought" + '\n' + "Enter '1' to complete purchase or '-1' to cancel purchase");
            if(ScannerWrapper.nextInt() == -1){
                Ticket tmp = Search.ticketByPurchaseCode(ticket.getShoppingCode());
                tmp.canceled = true;
                Search.byFlightNumber(tmp.getFlightNumber()).getCanceledTickets().add(tmp);
                tmp.cancelReservation(tmp.getShoppingCode());
            }

        } else {
            System.out.println("Thanks for completing your purchase");
            Search.ticketByPurchaseCode(ticket.getShoppingCode()).bought = true;
        }
    }
}
