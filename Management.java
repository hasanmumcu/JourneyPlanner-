
public class Management {
    
    public static void main(String[] args){
        
        Graph graph = new Graph();
        Vertex start = graph.findVertexByStopId("10001");
        Vertex end = graph.findVertexByStopId("10005");
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(start, end, graph);
        dijkstraAlgorithm.run();
//        dijkstraAlgorithm.getResult();
        
    }
}
