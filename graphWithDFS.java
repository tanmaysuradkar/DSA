import java.util.ArrayList;

public class graphWithDFS {
    static class Edge {
        int scr;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.scr = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 2, 0));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 1, 4));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));
        graph[6].add(new Edge(6, 7, 0));
        graph[7].add(new Edge(7, 6, 0));
    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false)
                dfs(graph, vis, e.dest);
        }
    }

    public static void main(String args[]) {
        int v = 8;
        boolean vis[] = new boolean[v];
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        for (int i = 0; i < v; i++)
            if (vis[i] == false)
                dfs(graph, vis, i);
    }
}
