import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import search.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*Graph graph = buildGraph();

        //Dijkstra dijkstra = new Dijkstra();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        DepthFirstSearch dfs = new DepthFirstSearch();

        boolean dfs_result = dfs.DepthFirstSearch(graph, "MAG", "MAS");
        boolean bfs_result = bfs.BreadthFirstSearch(graph, "POM", "HAC");


        System.out.println("DFS is route? : " + dfs_result);
        System.out.println("BFS is route? : " + bfs_result);


        //dijkstra.dist(graph, "MAG", "MAS");*/

        //Converter conv = new Converter();

        //conv.dist();
        dj(1825, 1835);
    }

    private static void dj(int to, int from){
        In in = new In("test2.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = from;

        DijkstraSP sp = new DijkstraSP(G, s);

        sp.hasPathTo(to);
        StdOut.printf("%d to %d (%.2f))  ", s, to, sp.distTo(to));
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
