package readside.domain.repositories;

import readside.domain.AvailableRoom;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailableRoomsRepository {

    List<AvailableRoom> getAvailableRooms();

    void add(AvailableRoom availableRoom);

    void remove(AvailableRoom availableRoom);

    Optional<AvailableRoom> getAvailableRoomAfter(LocalDate toDate, int roomNumber);

    Optional<AvailableRoom> getAvailableRoomBefore(LocalDate fromDate, int roomNumber);

    List<AvailableRoom> getFreeRooms(LocalDate from, LocalDate to, int personCount);

}
