import java.util.ArrayList;


public class Graph {
    private final String DELIMETER = ":";
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
  
    public Graph(){
        
        vertices = new ArrayList();
        edges = new ArrayList();
        Reader reader = new Reader();
        ArrayList<Line> lines = reader.readFile("Line.txt", "Line");
        ArrayList<Stop> stops = reader.readFile("Stop.txt", "Stop");
        ArrayList<Trip> trips = reader.readFile("Trip.txt", "Trip");
        ArrayList<Distance> distances = reader.readFile("Distance.txt", "Distance");  
        generateVertices(stops);
        generateStandardEdge(distances);
        generateWalkingEdge();
        
   
    }
   
//    public static void main(String[] args){
//        
//        new Graph();
//      
//        //Vertex start = management.findVertexByStopId("123132");
//        //Vertex end = management.findVertexByStopId("1231");
//        
//    }
    public void generateVertices(ArrayList<Stop> stops){
        for (Stop stop : stops ) {
            vertices.add(new Vertex(stop));
        }
    }
    public void generateWalkingEdge(){

        
        for(Vertex v : vertices){ 
            if(v.getStop().getNeighbourStops() != null){
                String[] neighbours = v.getStop().getNeighbourStops().split("\\.");
               
                for(int i = 0 ; i < neighbours.length ; i++){
                    String[] parts = neighbours[i].split(DELIMETER);
                    if(parts.length == 2){
                        Edge edge = new Edge(v, findVertexByStopId(parts[0]), Integer.parseInt(parts[1]), Edge.Type.WALKING);
                        v.addWalkingEdge(edge);
                        edges.add(edge);
                    }
                }
            }
        }
    
    }
    
    public void generateStandardEdge( ArrayList<Distance> distances ){
        for (Distance d : distances) {
            Vertex sourceVertex = findVertexByStopId(d.getOriginStopId());
            Vertex destinationVertex = findVertexByStopId(d.getDestinationStopId());
            Edge edge = null;
      
            if(sourceVertex != null && destinationVertex != null){
                edge = new Edge(sourceVertex, destinationVertex, Integer.parseInt(d.getDistance()), Edge.Type.STANDARD);
                sourceVertex.addEdge(edge);
                destinationVertex.addEdge(edge);
                edges.add(edge);
            }
        }
    }
//    public void printStandardEdges(){
//        vertices.forEach((v) -> {
//            for(Edge e : v.getEdges()){
//                System.out.println(e.getSource().getStop().getStopName() + " " + e.getDestination().getStop().getStopName() + " " + e.getWeight());
//            }
//        });  
//    }
//    
//    
//    public void printWalkingEdges(){
//        vertices.forEach((v) -> {
//            for(Edge e : v.getWalkingEdges()){
//                System.out.println(e.getSource().getStop().getStopName() + " " + e.getDestination().getStop().getStopName() + " " + e.getWeight());
//            }
//        });
//    }    
    
   
    public Vertex findVertexByStopId(String stopId){
        for(Vertex v : vertices){
            if(v.getStop().getStopId().equals(stopId)){
                return v;
            }
        }
        
        return null;
    }
    
    public void print(){

	System.out.println("Source\tDestination\tWeight");
	for (Edge e : edges) { 
		System.out.println("" + e.getSource().getStop().getStopName() + "\t" + e.getDestination().getStop().getStopName() + "\t\t" + e.getWeight()+ " ");
	}
    }



    public int size()
    {
	return vertices.size();
    }
    
    public Edge getConnection(Vertex current, Vertex neighbor) {
        Edge edge = null;
        for (Edge t : getEdges(current)) {
            if (t.getDestination().equals(neighbor)) {
                edge = t;
            }
        }
        return edge;
    }
        
    public int getDistanceBetweenVertices(Vertex current, Vertex neighbor) {
        
        for (Edge edge: this.getEdges(current)) {
            if (edge.getDestination().equals(neighbor))
                return edge.getWeight();   
        }
        return 0;     // buraya bakılacak!!!!!!!!!!!
    }
    
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public ArrayList<Edge> getEdges(Vertex vertex) {
        return vertex.getEdges();
    }
    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
        
  
}