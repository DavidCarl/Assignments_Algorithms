import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        long startTime_con = System.nanoTime();
        converter.dist();
        long endTime_con = System.nanoTime();
        System.out.println("Conversion of data!");
        System.out.println((endTime_con-startTime_con)/1e6+ " ms");

        System.out.println("\nDepth First Search, Result:");
        long startTime_dfs = System.nanoTime();
        dfs(1825, 1835);
        long endTime_dfs = System.nanoTime();
        System.out.println((endTime_dfs-startTime_dfs)/1e6+ " ms \n");
        System.out.println("Breadth First Search, Result:");
        long startTime_bfs = System.nanoTime();
        bfs_main(1825, 1835);
        long endTime_bfs = System.nanoTime();
        System.out.println((endTime_bfs-startTime_bfs)/1e6+ " ms");
        System.out.println("\nDijkstra Distance, Result:");
        long startTime_dj = System.nanoTime();
        dj(1825, 1835);
        long endTime_dj = System.nanoTime();
        System.out.println((endTime_dj-startTime_dj)/1e6+ " ms");
    }

    private static void dj(int to, int from){
        In in = new In("EWD.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = from;

        DijkstraSP sp = new DijkstraSP(G, s);

        if(sp.hasPathTo(to)){
            StdOut.printf("%d to %d (%.2f))  ", s, to, sp.distTo(to));
        }
    }

    private static void dfs(int to, int from){
        In in = new In("CG.txt");
        Graph G = new Graph(in);
        int s = from;
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);
        if (dfs.hasPathTo(to)) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    private static void bfs_main(int to, int from){
        In in = new In("CG.txt");
        edu.princeton.cs.algs4.Graph G = new edu.princeton.cs.algs4.Graph(in);

        int s = from;
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        if (bfs.hasPathTo(to)) {
            StdOut.printf("%d to %d (%d):  ", s, to, bfs.distTo(to));
        }
    }
}
