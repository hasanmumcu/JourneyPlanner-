import java.util.ArrayList;

public class Vertex {
	private Stop stop;
	private ArrayList<Edge> edges;
//        private ArrayList<Edge> walkingEdges; 
	private Vertex parent;
	
	 public Vertex(Stop stop) {
                
	        this.stop = stop;
	        edges = new ArrayList();
//                walkingEdges = new ArrayList();
	        parent = null;
	    }
	 
//         public void addWalkingEdge(Edge e){
//             walkingEdges.add(e);
//         }
	 public void addEdge(Edge e)
	 {
		 edges.add(e);  
	 }
	 
	 public ArrayList<Edge> getAllEdges()
	 {         
		 return edges;
             
	 }

	public Stop getStop() {
		return stop;
	}
       
	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

//    public ArrayList<Edge> getWalkingEdges() {
//        return walkingEdges;
//    }
    

    @Override
    public String toString() {
        return "Vertex{" + "stop=" + stop.getStopName() + ", edges=" + edges ;
    }
        
}

