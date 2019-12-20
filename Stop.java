
public class Stop {

 
    private String stopId;
    private String stopName;
    private String stopCoordinateX;
    private String stopCoordinateY;
    private String stopVehicleTypeId;
    private String neighbourStops;


    public Stop(String stopId, String stopName, String stopCoordinateX, String stopCoordinateY, String stopVehicleTypeId, String neighbourStops) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.stopCoordinateX = stopCoordinateX;
        this.stopCoordinateY = stopCoordinateY;
        this.stopVehicleTypeId = stopVehicleTypeId;
        this.neighbourStops = neighbourStops;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public void setStopCoordinateX(String stopCoordinateX) {
        this.stopCoordinateX = stopCoordinateX;
    }

    public void setStopCoordinateY(String stopCoordinateY) {
        this.stopCoordinateY = stopCoordinateY;
    }

    public void setStopVehicleTypeId(String stopVehicleTypeId) {
        this.stopVehicleTypeId = stopVehicleTypeId;
    }

    public void setNeighbourStops(String neighbourStops) {
        this.neighbourStops = neighbourStops;
    }

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public String getStopCoordinateX() {
        return stopCoordinateX;
    }

    public String getStopCoordinateY() {
        return stopCoordinateY;
    }

    public String getStopVehicleTypeId() {
        return stopVehicleTypeId;
    }

    public String getNeighbourStops() {
        return neighbourStops;
    }

    @Override
    public String toString() {
        return "Stop{" + "stopId=" + stopId + ", stopName=" + stopName + ", stopCoordinateX=" + stopCoordinateX + ", stopCoordinateY=" + stopCoordinateY + ", stopVehicleTypeId=" + stopVehicleTypeId + ", neighbourStops=" + neighbourStops + '}';
    }
}
