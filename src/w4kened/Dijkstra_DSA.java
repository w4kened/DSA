package w4kened;

import java.util.*;


public class Dijkstra_DSA {
    public static Dictionary[] dijkstra (Graph_DSA g, Vertex startingVertex){
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        for (Vertex v : g.getVertices()) {
            distances.put(v.getData(), Integer.MAX_VALUE);
            previous.put(v.getData(), new Vertex("Null"));

        }
        distances.put(startingVertex.getData(), 0);
        queue.add(new QueueObject(startingVertex, 0));
        while (queue.size() != 0) {
            Vertex current = queue.poll().vertex;

            for (Edge e: current.getEdges()) {
                Integer alternate = e.getWeight()
                                    + distances.get(current.getData());
                String neighborValue = e.getEnd().getData();
//                System.out.println("edge to neighbor "+ neighborValue);
//                System.out.println("sum of "+ distances.get(current.getData())+" to "+e.getWeight());
//                System.out.print("alternate "+ alternate+" <? ");
//                System.out.println("distances.get(neighborValue) "+ distances.get(neighborValue));
                if (alternate < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternate);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
                }
            }
            System.out.print("queue : ");
            queue.forEach(a -> {System.out.print(a.vertex.getData()+" "+a.priority+" ");});
            System.out.println();
        }
        return new Dictionary[]{distances, previous};
    }
    public static void shortestPathBetween(Graph_DSA g, Vertex startingVertex, Vertex targetVertex) {
        Dictionary[] dijkstraDicts = dijkstra(g, startingVertex);
        Dictionary distances = dijkstraDicts[0];
        Dictionary previous = dijkstraDicts[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Shortest Distance between " + startingVertex.getData() + " and " + targetVertex.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex tempVertex = targetVertex;
        while (tempVertex.getData() != "Null") {
            path.add(0, tempVertex);
            tempVertex = (Vertex) previous.get(tempVertex.getData());
        }
        System.out.println("Shortest Path");
        for (Vertex pathVertex: path) {
            System.out.println(pathVertex.getData());
        }
    }
    public static void dijkstraResultPrinter(Dictionary[] d){
        System.out.println("Distances:\n");
        for (Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getData());
        }
    }
    public static void main(String[] args){
        Graph_DSA testGraph = new Graph_DSA(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 100);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, c, 3);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, -2);
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, -50);

//        dijkstraResultPrinter(dijkstra(testGraph, a));
        Dijkstra_DSA.shortestPathBetween(testGraph, a, g);
    }
}
class QueueObject implements Comparable<QueueObject> {
    public Vertex vertex;
    public int priority;

    public QueueObject(Vertex v, int p) {
        this.vertex = v;
        this.priority = p;
    }
    @Override
    public int compareTo(QueueObject o) {
        if (o.priority == this.priority) {
            return  0;
        }
        else if (this.priority > o.priority) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
