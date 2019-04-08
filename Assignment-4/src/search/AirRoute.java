package search;

public class AirRoute implements Comparable{
    public double time;
    public double distance;
    public String destination;
    public String airline;
    public String compareMode = "distance";

    public AirRoute(double time, double distance, String destination, String airline) {
        this.time = time;
        this.distance = distance;
        this.destination = destination;
        this.airline = airline;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() != getClass()) {
            return 0;
        }
        AirRoute obj = (AirRoute) o;

        switch (compareMode) {
            case "time":
                if(time > obj.time){
                    return 1;
                } else if (time ==  obj.time) {
                    return 0;
                }
                return -1;
            case "distance":
                if(distance > obj.distance){
                    return 1;
                } else if (distance ==  obj.distance) {
                    return 0;
                }
                return -1;
        }

        return 0;
    }
}