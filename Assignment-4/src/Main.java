import search.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Graph graph = buildGraph();

        DepthFirstSearch dfs = new DepthFirstSearch();

        boolean dfs_result = dfs.DepthFirstSearch(graph, "MAG", "MAS");
        System.out.println(dfs_result);
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
}
