
package Object;

public class Train {
    private String tCode;
    private String trainName;
    private int seat;
    private int booked;
    private String departurePlace;
    private String arrivalPlace;
    private String departureTime;
    private String arrivalTime;

    public Train(String tCode, String trainName, int seat, int booked, String departurePlace, String arrivalPlace, String departureTime, String arrivalTime) {
        this.tCode = tCode;
        this.trainName = trainName;
        this.seat = seat;
        this.booked = booked;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getTCode() {
        return tCode;
    }

    public void setTCode(String tCode) {
        this.tCode = tCode;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return tCode + "|" + trainName +"|" + seat +"|" + booked +"|" + departurePlace + "|" + arrivalPlace + "|" + departureTime + "|" + arrivalTime;
    }
    
}
