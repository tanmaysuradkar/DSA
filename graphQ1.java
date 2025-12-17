// Print All Path In Graph Question //

import java.util.ArrayList;

public class graphQ1 {
    public static class Edge {
        int scr;
        int dest;

        public Edge(int scr, int dest) {
            this.scr = scr;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[], int tar, String path) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                vis[curr] = true;
                dfs(graph, e.dest, vis, tar, (path + e.dest));
                vis[curr] = false;
            }
        }
    }

    public static void main(String args[]) {
        int v = 7;
        int target = 5;
        String path = "0";
        boolean vis[] = new boolean[v];
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        dfs(graph, 0, vis, target, path);
    }
}
