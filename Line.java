
public class Line {

    static Line Unknown;    
    private String lineId;
    private String lineNo;
    private String lineName;
    private String lineVehicleTypeId;
    
    

    public Line(String lineId, String lineNo, String lineName, String lineVehicleTypeId){
        this.lineId = lineId;
        this.lineNo = lineNo;
        this.lineName = lineName;
        this.lineVehicleTypeId = lineVehicleTypeId;
               
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public void setLineVehicleTypeId(String lineVehicleTypeId) {
        this.lineVehicleTypeId = lineVehicleTypeId;
    }

    public String getLineId() {
        return lineId;
    }

    public String getLineNo() {
        return lineNo;
    }

    public String getLineName() {
        return lineName;
    }

    public String getLineVehicleTypeId() {
        return lineVehicleTypeId;
    }
    
    
    
}
   