
public class Distance {
    
    private String originStopId;
    private String destinationStopId;
    private String distance;

    public Distance(String originStopId, String destinationStopId, String distance) {
        this.originStopId = originStopId;
        this.destinationStopId = destinationStopId;
        this.distance = distance;
    }

    public String getOriginStopId() {
        return originStopId;
    }

    public String getDestinationStopId() {
        return destinationStopId;
    }

    public String getDistance() {
        return distance;
    }

    public void setOriginStopId(String originStopId) {
        this.originStopId = originStopId;
    }

    public void setDestinationStopId(String destinationStopId) {
        this.destinationStopId = destinationStopId;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Distance{" + "originStopId=" + originStopId + ", destinationStopId=" + destinationStopId + ", distance=" + distance + '}';
    }
    
    
    
    
            
    
}
