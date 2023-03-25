package ir.ac.kntu;

import java.util.ArrayList;

public class ProfessionalAirline extends Airline {

    private static ArrayList<Archive> archives = new ArrayList<Archive>();

    public ProfessionalAirline(String airlineName, int numOfPlanes) {
        super(airlineName,numOfPlanes);
    }

    public  ArrayList<Archive> getArchives() {
        return archives;
    }

    public void setArchives(ArrayList<Archive> archives) {
        ProfessionalAirline.archives = archives;
    }
}
