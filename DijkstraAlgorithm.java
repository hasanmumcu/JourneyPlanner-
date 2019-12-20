
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DijkstraAlgorithm {

    private final Vertex start;
    private final Vertex end;
    private final Graph graph;
    private LinkedList<Vertex> unexploredStations = new LinkedList<>();
    private LinkedList<Edge> past = new LinkedList<>();
    Map<Vertex, Integer> distances = new HashMap<>();

    public DijkstraAlgorithm(Vertex start, Vertex end, Graph newgraph) {
        this.start = start;
        this.end = end;
        this.graph = newgraph;
        
    }

    public Vertex run() {
         //Setting the distances to every node to the max
        for (Vertex station : graph.getVertices()) {
            distances.put(station, Integer.MAX_VALUE);
            unexploredStations.add(station);
        }
        distances.put(start, 0);
        this.unexploredStations.add(start);

        while (this.unexploredStations.size() > 0) {
            Vertex current = getBestEdgeSoFar();
            if (current.equals(end)) {
                return end;
            }
            System.out.println("Current: " + current.getStop().getStopName());
            unexploredStations.remove(current);
            findBestVertex(current);
        }
        return start;
    }
    
    public Vertex getBestEdgeSoFar() {
        Vertex vertex = this.unexploredStations.iterator().next();
        for (Vertex station : this.unexploredStations) {
            if (distances.get(station) < distances.get(vertex)) {
                vertex = station;
            }
        }
        return vertex;
    }
//v this hash calculation finds the neighbours of the current node and then, 
//compares the distances between neighbours to find the best neighbour    

    public void findBestVertex(Vertex current) {
        LinkedList<Vertex> edges = getUnexploredEdges(current);
//        System.out.println("Edges: " + edges.toString());
        edges.forEach((vertex) -> {
            int dist = graph.getDistanceBetweenVertices(current, vertex) + distances.get(current);
            int vertexDist = distances.get(vertex);
            if (dist < vertexDist) {
                distances.put(vertex, dist);
                past.add(graph.getConnection(current, vertex));
                System.out.println("NextStation: " + vertex.getStop().getStopName());
            }
        });
    }

        public LinkedList<Vertex> getUnexploredEdges(Vertex current) {
        LinkedList<Vertex> connections = new LinkedList<>();
        for (Edge edge : graph.getEdges(current)) {
            if (this.unexploredStations.contains(edge.getDestination())) {
                connections.add(edge.getDestination());
//                System.out.println("Vertex> " + edge.getDestination().getStop().getStopName());
            }
        }
        return connections;
    }

    public LinkedList<Edge> getResult() {
        LinkedList<Edge> past2 = new LinkedList<>();
            Vertex destination = end;
//while the destination is not equal to the start, get the desination's connections 
            while (!destination.equals(start)) {
                Edge dest = getConnectionDestination(destination);
                past2.add(dest);
                destination = dest.getSource();
            }
        
        System.out.println(past.toString());
        Collections.reverse(past2);
        return past2;
    }

    public Edge getConnectionDestination(Vertex destination) {  // end vertex inden başlayıp geriye doğru path i yazdırıyor........
        Edge connection = null;
        for (Edge edge : past) {
            if (edge.getDestination().equals(destination)) {
                connection = edge;
            }
        }
        return connection;
    }

}