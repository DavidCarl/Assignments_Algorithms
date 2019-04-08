package search;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {
    public boolean DepthFirstSearch(Graph graph, String start, String end){
        if(start.equals((end))) return true;

        Map<String, Boolean> explored = new HashMap();
        explored.put(start, true);

        for (AirRoute for_start : graph.adj(start)){
            if (for_start.destination.equals(end)) {
                return true;
            }

            if (depth(for_start.destination, end, for_start.airline, graph, explored)) {
                return true;
            }

        }
        return false;
    }

    private static boolean depth(String start, String end, String airline, Graph graph, Map<String, Boolean> explored) {

        for (AirRoute new_location : graph.adj(start)) {
            if (explored.containsKey(new_location.destination) || !new_location.airline.equals(airline)) {
                continue;
            }
            if (new_location.destination.equals(end)) {
                return true;
            }
            explored.put(new_location.destination, true);
            if(depth(new_location.destination, end, airline, graph, explored)){
                return true;
            }
        }
        return false;
    }
}
