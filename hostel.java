package Hostel;

public class HostelModel {
    private String  hostelName;
    private String hostelType;
    private String numberOfRooms;

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public void setHostelType(String hostelType) {
        this.hostelType = hostelType;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getHostelName() {
        return hostelName;
    }

    public String getHostelType() {
        return hostelType;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }
}
