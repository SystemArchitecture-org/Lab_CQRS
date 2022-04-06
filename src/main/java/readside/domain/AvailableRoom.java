package readside.domain;

import java.time.LocalDate;

public class AvailableRoom {

    private final int roomNumber;
    private final int numberOfBeds;
    private final LocalDate availableFrom;
    private final LocalDate availableTo;

    public AvailableRoom(int roomNumber, int numberOfBeds, LocalDate availableFrom, LocalDate availableTo) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public LocalDate getAvailableFrom() {
        return availableFrom;
    }

    public LocalDate getAvailableTo() {
        return availableTo;
    }
}
