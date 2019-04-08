package search;

import java.util.ArrayList;

public class Path implements Cloneable, Comparable {
    private ArrayList<String> path;
    private double cost;
    private String airline;

    public ArrayList<String> getPath() {
        return path;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    private String location;

    public Path(String location) {
        this.location = location;
        this.path = new ArrayList<String>();
        this.cost = 0;
    }
    public Path(String location, ArrayList<String> path) {
        this.location = location;
        this.path = path;
        this.cost = 0;
    }
    public Path(String location, ArrayList<String> path, double cost ) {
        this.location = location;
        this.path = path;
        this.cost = cost;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public Path goPath(String pathGo) throws CloneNotSupportedException{
        return goPath(pathGo, 0);
    }

    public Path goPath(String pathGo, double cost) throws CloneNotSupportedException{
        Path newNode = (Path) this.clone();
        newNode.path = (ArrayList<String>) this.path.clone();
        newNode.path.add(newNode.location);
        newNode.location = pathGo;
        newNode.cost += cost;
        return newNode;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "path " + path + ", airline " + airline +", cost " + cost;
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass() != this.getClass()) {
            return 0;
        }
        Path object = (Path) o;

        if( this.cost > object.cost){
            return 1;
        } else if (this.cost ==  object.cost) {
            return 0;
        }
        return -1;
    }
}
