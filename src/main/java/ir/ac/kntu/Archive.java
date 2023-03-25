package ir.ac.kntu;
import java.util.Date;
public class Archive {
    String start;
    String end;
    Date takeOff;
    Date landing;
    int passengers;

    public Archive(String start, String end, Date takeOff, Date landing,int passengers ){
        this.start = start;
        this.end = end;
        this.takeOff = takeOff;
        this.landing = landing;
        this.passengers = passengers;
    }
}
