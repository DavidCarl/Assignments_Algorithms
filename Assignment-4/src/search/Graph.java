package search;

import java.util.*;

public class Graph {
    private HashMap<String, ArrayList<AirRoute>> node;

    public Graph() {
        node = new HashMap();
    }

    public ArrayList<AirRoute> adj(String origin) {
        return node.get(origin);
    }

    public Set<String> keys (){
        return node.keySet();
    }

    public void addVertex(String airport){
        node.put(airport, new ArrayList<AirRoute>());
    }

    public void addEdge(String from, String to, String airlinenetwork, double time, double destination) {
        node.get(from).add(new AirRoute(time, destination,to, airlinenetwork));
    }
}
