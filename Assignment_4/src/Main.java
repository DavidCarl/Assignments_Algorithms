import search.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Graph graph = buildGraph();
        ArrayList<String> airports = readAirports();

        DepthFirstSearch dfs = new DepthFirstSearch();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Dijkstra dij = new Dijkstra();


        boolean dfs_result = dfs.DepthFirstSearch(graph, "MAG", "MAS");
        System.out.println(dfs_result);

        Path bfs_result = bfs.breadthFirstSearch(graph, "MAG", "MAS");
        System.out.println(bfs_result);

        Path dij_dist = dij.dist(graph, "MAG", "MAS");
        System.out.println(dij_dist);

        Path dij_time = dij.time(graph, "MAG", "MAS");
        System.out.println(dij_time);


        System.out.println( testForWidestCoverage(airports, graph) );


    }

    private static String testForWidestCoverage(ArrayList<String> airports, Graph graph) {
        int biggest_airline_paths = 0;
        String biggest_airline = null;

        for (String airport : airports) {
            HashSet<String> airlines = new HashSet<>();

            for (AirRoute outgoing : graph.adj(airport)) {
                airlines.add(outgoing.airline);
            }

            for (String airline : airlines) {
                int coverage = buildMst(graph, airline, airport);
                if (coverage > biggest_airline_paths) {
                    biggest_airline = airline;
                    biggest_airline_paths = coverage;
                }
            }

        }

        return biggest_airline + "has " + biggest_airline_paths + " connections";
    }

    private static int buildMst(Graph graph, String airline, String start) {
        HashMap<String, Double> explored = new HashMap<>();

        HashSet<String> unexploredSet = new HashSet<>();
        PQMin<AirRoute> unexplored = new PQMin<>();

        unexploredSet.add(start);
        unexplored.enqueue(new AirRoute(start, airline, 0, 0));

        while (unexplored.size() > 0) {
            AirRoute lowest = unexplored.dequeue();
            unexploredSet.remove(lowest.destination);

            explored.put(lowest.destination, lowest.distance);
            for (AirRoute outgoing : graph.adj(lowest.destination)) {
                if (!outgoing.airline.equals(airline)) {
                    continue;
                }
                if (explored.containsKey(outgoing.destination)) {
                    continue;
                }
                if (unexploredSet.contains(outgoing.destination)) {
                    continue;
                }
                unexploredSet.add(outgoing.destination);
                unexplored.enqueue(outgoing);
            }
        }
        return explored.size();
    }

    private static Graph buildGraph( ) {
        Graph graph = new Graph();
        for(String[] item : FileManager.readFile("airports.txt")){
            graph.addVertex(item[0]);
        }
        for(String[] item : FileManager.readFile("routes.txt")){
            graph.addEdge(item[1], item[2], item[0], Double.parseDouble(item[4]), Double.parseDouble(item[3]));
        }
        return graph;
    }


    private static ArrayList<String> readAirports() {
        ArrayList<String> airports = new ArrayList<>();

        for (String[] item : FileManager.readFile("airports.txt")) {
            airports.add(item[0]);
        }

        return airports;
    }
}
