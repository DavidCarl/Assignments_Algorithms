package search;

import java.util.ArrayList;

public class Path {
    private ArrayList<String> path;
    private Double cost;

    public Path(ArrayList<String> path, Double cost) {
        this.path = path;
        this.cost = cost;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
