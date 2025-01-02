package w4kened;

import java.util.ArrayList;


public class Graph_DSA {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph_DSA(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }
    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }
    public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }
    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }
    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        if (!this.isDirected) {
            vertex1.removeEdge(vertex2);
            vertex2.removeEdge(vertex1);
        }
        else {
            vertex1.removeEdge(vertex2);
        }
    }
    public void print() {
        for(Vertex v: this.vertices) {
            v.print(isWeighted);
        }
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }
    public Vertex getVertexByValue(String value) {
        for(Vertex v: this.vertices) {
            if (v.getData() == value) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph_DSA trainNetwork = new Graph_DSA(true, true);
        Vertex la_var = trainNetwork.addVertex("Los Angeles");
        Vertex sf_var = trainNetwork.addVertex("San Francisco");
        Vertex ny_var = trainNetwork.addVertex("New York");
        Vertex atl_var = trainNetwork.addVertex("Atlanta");
        Vertex dnv_var = trainNetwork.addVertex("Denver");
        Vertex clg_var = trainNetwork.addVertex("Calgary");

        trainNetwork.addEdge(sf_var, la_var, 400);
        trainNetwork.addEdge(la_var, sf_var, 400);
        trainNetwork.addEdge(ny_var, dnv_var, 1800);
        trainNetwork.addEdge(dnv_var, ny_var, 1800);
        trainNetwork.addEdge(clg_var, dnv_var, 1000);
        trainNetwork.addEdge(dnv_var, clg_var, 1000);
        trainNetwork.addEdge(la_var, atl_var, 2100);
        trainNetwork.addEdge(atl_var, la_var, 2100);

        trainNetwork.removeEdge(ny_var, dnv_var);
        trainNetwork.removeEdge(clg_var, dnv_var);
        trainNetwork.removeEdge(dnv_var, clg_var);
        trainNetwork.removeVertex(clg_var);

        trainNetwork.print();
        /*
        * Currently, it is possible to add duplicate edges between two vertices.
        *  How will you improve this Graph implementation to avoid adding duplicate edges?
        * How would you iterate through a directed graph? What about an undirected graph?
        * How would you create a cycle with a directed graph?
        * */
    }
}
class Vertex {
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }
    public void addEdge(Vertex endVertex, Integer weight) {
        Edge edge = new Edge(this, endVertex, weight);
        edges.add(edge);
    }
    public void removeEdge(Vertex endVertex) {
        edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }
    public void print(boolean showWeight) {
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }
        System.out.println("edges = "+this.edges.size());
        for (int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().data + " -->  ";
            }

            message += this.edges.get(i).getEnd().data;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }
    public String getData() {
        return this.data;
    }
    public ArrayList<Edge> getEdges() {
        return this.edges;
    }
}
class Edge {
    private Vertex start;
    private Vertex end;
    private Integer weight;

    public Edge(Vertex startV, Vertex endV, Integer inputWeight) {
        this.start = startV;
        this.end = endV;
        this.weight = inputWeight;
    }
    public Vertex getStart() {
        return this.start;
    }
    public Vertex getEnd() {
        return this.end;
    }
    public Integer getWeight() {
        return this.weight;
    }
}
