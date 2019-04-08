package search;

public class AirRoute implements Comparable{
    public String destination;
    public String airline;
    public double time;
    public double distance;
    public String compareMode = "distance";

    public AirRoute(String destination, String airline, double time, double distance) {
        this.destination = destination;
        this.airline = airline;
        this.time = time;
        this.distance = distance;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() != this.getClass()) {
            return 0;
        }
        AirRoute object = (AirRoute) o;

        switch (compareMode) {
            case "time":
                if( this.time > object.time){
                    return 1;
                } else if (this.time ==  object.time) {
                    return 0;
                }
                return -1;
            case "distance":
                if( this.distance > object.distance){
                    return 1;
                } else if (this.distance ==  object.distance) {
                    return 0;
                }
                return -1;
        }

        return 0;
    }
}