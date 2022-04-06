package writeside.domain;

public class Room {

    private final Integer roomNumber;
    private final Integer numberOfBeds;

    public Room(Integer roomNumber, Integer numberOfBeds) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

}
