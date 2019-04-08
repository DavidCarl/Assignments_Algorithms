package search;

import java.util.ArrayList;
import java.util.HashMap;

@FunctionalInterface
interface GetCostFunction {
    double getCost(AirRoute element);
}

public class Dijkstra {

    public Path dist(Graph graph, String start, String end){
        return dijkstra(graph, "MAG", "MAS", element -> element.distance);
    }

    public Path time(Graph graph, String start, String end){
        return dijkstra(graph, "MAG", "MAS", element -> element.time + 1);
    }

    private static Path dijkstra(Graph graph, String start, String end, GetCostFunction costFunction) {
        HashMap<String, Path> unExplored = new HashMap<>();
        HashMap<String, Path> distances = new HashMap<>();

        for (String airport : graph.keys()) {
            Path path = new Path(airport, new ArrayList<>(), Integer.MAX_VALUE);
            if (airport.equals(start)) {
                path.setCost(0);
                path.getPath().add(airport);
            }
            unExplored.put(airport, path);
            distances.put(airport, path);
        }


        while (unExplored.size() > 0) {
            Path v = airportWithLowestDistance(unExplored, distances);
            unExplored.remove(v.getLocation());

            for(AirRoute neighbor : graph.adj(v.getLocation())){
                double newCost = v.getCost() + costFunction.getCost(neighbor);
                Path path = distances.get(neighbor.destination);
                if (newCost < path.getCost()) {
                    path.setCost(newCost);
                    ArrayList<String> newPath = (ArrayList<String>) v.getPath().clone();
                    newPath.add(neighbor.destination);
                    path.setPath(newPath);
                }
            }
        }

        return distances.get(end);
    }

    private static Path airportWithLowestDistance(HashMap<String,Path> q, HashMap<String,Path> distances) {
        Double lowestFoundValue = Double.MAX_VALUE;
        Path pathWithLowestValue = null;
        for (String possible : q.keySet()) {
            Path path = distances.get(possible);
            if (path.getCost() <= lowestFoundValue) {
                pathWithLowestValue = path;
                lowestFoundValue = path.getCost();
            }
        }
        return pathWithLowestValue;
    }
}
