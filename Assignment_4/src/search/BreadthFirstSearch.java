package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BreadthFirstSearch {

    public Path breadthFirstSearch(Graph graph, String start, String goal) throws CloneNotSupportedException {
        if (start.equals(goal)) {
            return new Path(start);
        }

        for (AirRoute startTrip : graph.adj(start)) {
            FiFo<Path> frontier = new FiFo<>();
            ArrayList<String> startPath = new ArrayList<>();
            startPath.add(start);
            Path item = new Path(startTrip.destination, startPath);
            item.setAirline(startTrip.airline);

            frontier.enqueue(item);
            Map<String, Boolean> explored = new HashMap<>();

            if (startTrip.destination.equals(goal)) {
                return frontier.dequeue();
            }

            while (frontier.size() > 0) {
                Path node = frontier.dequeue();
                if (node.getLocation().equals(goal)) {
                    return node;
                }
                explored.put(node.getLocation(), true);
                for (AirRoute new_location : graph.adj(node.getLocation())) {
                    if (explored.containsKey(new_location.destination)
                            || locationInQue(new_location.destination, frontier)
                            || !new_location.airline.equals(node.getAirline())
                            || new_location.destination.equals(start)) {
                        continue;
                    }
                    frontier.enqueue(node.goPath(new_location.destination));

                }
            }
        }


        return null;
    }

    private static boolean locationInQue(String destination, FiFo<Path> frontier) {
        for (Path path : frontier) {
            if (path.getLocation().equals(destination)) {
                return true;
            }
        }
        return false;
    }

}
