
public class Trip {
    private String lineId;
    private String direction;
    private String order;
    private String stopId;
    
    public Trip(String lineId, String direction, String order, String stopId) {
        
        this.lineId = lineId;
        this.direction = direction;
        this.order = order;
        this.stopId = stopId;
    }

    public String getLineId() {
        return lineId;
    }

    public String getDirection() {
        return direction;
    }

    public String getOrder() {
        return order;
    }

    public String getStopId() {
        return stopId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    @Override
    public String toString() {
        return "Trip{" + "lineId=" + lineId + ", direction=" + direction + ", order=" + order + ", stopId=" + stopId + '}';
    }
    
    
    
    
}
