

import java.util.ArrayList;
import java.util.LinkedList;


public class Management {
    private static Vertex foundVertex;
    
    private static String foundTripLineId = " ";
    private static String foundFoundVertexId = " ";
    private static String foundVertexId = " ";
    private static String tripLineId = " ";
           
    public Management(){
        
        
        
    
    }
    public static void main(String[] args){
        Reader reader = new Reader();
        ArrayList<Trip> trips =  reader.readFile("Trip.txt", "Trip");
        Graph graph = new Graph();
        Vertex start = graph.findVertexByStopId("10036");
        Vertex end = graph.findVertexByStopId("40661");
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);
        
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(start);
        LinkedList<Vertex> path = dijkstra.getPath(end);
        int i = 0 ;
        if(path.size() > 0 ){
            for (Vertex vertex : path) {
          
                if(i!=0){
                    for (Edge edge : vertex.getAllEdges()) {
                    
                    
                        if(((edge.getSource().getStop().getStopId()).equals(foundVertex.getStop().getStopId())) && (edge.getDestination().getStop().getStopId()).equals(vertex.getStop().getStopId())  ){
                            
//                        String foundDestinations = edge.getDestination().getStop().getStopName();
                            int foundStandartWeights = edge.getWeight();
                            System.out.println(foundStandartWeights);
                           
                            for (Trip trip : trips) {
                                
                                if(!(foundTripLineId.equals(trip.getLineId())) && !(foundTripLineId.equals(" ")) ){
                                    foundFoundVertexId = " ";
                                    foundVertexId = " ";
                                    if(!(tripLineId.equals(" "))){
                                    System.out.println(tripLineId + "id li aracı kullan "  );
                                    tripLineId = " ";
                                    }
                                }
                               
                                if(trip.getStopId().equals(foundVertex.getStop().getStopId())){
                                    foundFoundVertexId = trip.getStopId();
                                }
                                if(trip.getStopId().equals(vertex.getStop().getStopId())){
                                    foundVertexId = trip.getStopId();
                                              
                                }
                                if(!(foundFoundVertexId.equals(" ")) && !(foundVertexId.equals(" ")) && !(trip.getLineId().equals(tripLineId))){
                                    tripLineId = trip.getLineId();
                                }
                                foundTripLineId = trip.getLineId();
                            }
                          
                        }
                        else if(edge.getType() == edge.getType().WALKING){
                            if((((edge.getSource().getStop().getStopId()).equals(foundVertex.getStop().getStopId())) && (edge.getDestination().getStop().getStopId()).equals(vertex.getStop().getStopId())) ||( edge.getDestination().getStop().getStopId().equals(foundVertex.getStop().getStopId()) && (edge.getSource().getStop().getStopId()).equals(vertex.getStop().getStopId())) ){
                                int foundWalkingWeights = edge.getWeight();
                                System.out.println(foundWalkingWeights +  "m walk" );
                            }
                        
                        }
                    }
                }
                i++;
                System.out.println( vertex.getStop().getStopId() + "  " + vertex.getStop().getStopName()+ " " + vertex.getAllEdges());
                foundVertex = vertex;
                
            }
            
         
        }
        
    }
//    public static void definedLines(ArrayList<Trip> trips, LinkedList<Vertex> path){
//        if(path.size()>0){
//            for (Vertex vertex : path) {
//                
//            }
//            
//    }
        
        
           
        //
    }
        

        
    

