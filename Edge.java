
public class Edge {
	
        public static enum Type{
            WALKING,
            STANDARD
        };
        private Vertex source;
	private Vertex destination;
	private int weight;
        private Type type;
        
	
	public Edge(Vertex source, Vertex destination, int weight, Type type) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
                this.type = type;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}	

    @Override
    public String toString() {
        return "Edge: " + "source " + source.getStop().getStopName() + ", destination " + destination.getStop().getStopName() + ", weight " + String.valueOf(weight) + ", type " + type.toString()  ;
    }
        
}
 
