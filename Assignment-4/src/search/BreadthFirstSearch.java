package search;

import java.util.*;

public class BreadthFirstSearch {

    private LinkedList<String> adj[];

    public boolean BreadthFirstSearch(Graph graph, String start, String end) {

        LinkedList<AirRoute> nextToVisit = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap();

        for (AirRoute ar : graph.adj(start)) {
            nextToVisit.add(ar);
        }

        String airline = nextToVisit.getFirst().airline;

        while (!nextToVisit.isEmpty()) {
            AirRoute route = nextToVisit.pop();
            if (visited.containsKey(route.destination) || !route.airline.equals(airline)) {
                continue;
            }
            if (route.destination.equals(end)) {
                return true;
            }
            visited.put(route.destination, true);

            for (AirRoute child : graph.adj(route.destination)) {
                nextToVisit.add(child);
            }
        }

        return false;
    }
}
