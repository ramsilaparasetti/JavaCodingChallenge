//Create a Flight class that contains a departure airport, a destination airport, and a price.
//        Implement a method that takes a list of Flight objects and returns the cheapest flight
//        from a given departure airport to a given destination airport.

import java.util.ArrayList;
import java.util.List;

public class Flights  {

    String fltName;
    String depAirport;
    String destAirport;
    Double price;



    public Flights(String fltName, String depAirport, String destAirport, Double price){
        this.fltName = fltName;
        this.depAirport = depAirport;
        this.destAirport = destAirport;
        this.price = price;
    }

    public String getFltName() {
        return fltName;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static String getCheapestFlight(List<Flights> flights){
        Double cheapPrice = 0.0;
        Flights cheapFlight = flights.get(0);
        for(Flights flt: flights){
            if(cheapPrice > flt.getPrice()){
                cheapFlight = flt;
            }
        }
        return cheapFlight.getFltName();
    }

    public static void main(String[] args) {
        List<Flights> flights = new ArrayList<>();
        flights.add(new Flights("indigo", "Delhi", "Bombay", 500.00));
        flights.add(new Flights("vistara", "Delhi", "Bombay", 1500.00));
        flights.add(new Flights("airIndia", "Delhi", "Bombay", 3500.00));
        flights.add(new Flights("air asia", "Delhi", "Bombay", 550.00));
        flights.add(new Flights("kingfisher","Delhi", "Bombay", 7500.00));
        System.out.println("Cheapest flight for a given destination is : "+getCheapestFlight(flights));
    }
}
