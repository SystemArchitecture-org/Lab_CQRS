package readside.infrastructure;

import org.springframework.stereotype.Repository;
import readside.domain.AvailableRoom;
import readside.domain.repositories.AvailableRoomsRepository;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class AvailableRoomsRepositoryImpl implements AvailableRoomsRepository {

    private final List<AvailableRoom> availableRooms = new LinkedList<>();

    public AvailableRoomsRepositoryImpl() {
        availableRooms.add(new AvailableRoom(101, 1, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(102, 1, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(103, 1, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(104, 1, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(105, 1, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(201, 2, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(202, 2, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(203, 2, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(204, 2, LocalDate.MIN, LocalDate.MAX));
        availableRooms.add(new AvailableRoom(205, 2, LocalDate.MIN, LocalDate.MAX));
    }

    public List<AvailableRoom> getAvailableRooms() {
        return availableRooms;
    }

    @Override
    public void add(AvailableRoom availableRoom) {
        availableRooms.add(availableRoom);
    }

    @Override
    public void remove(AvailableRoom availableRoom) {
        availableRooms.remove(availableRoom);
    }

    public List<AvailableRoom> getFreeRooms(LocalDate from, LocalDate to, int personCount){
        List<AvailableRoom> freeRooms = new LinkedList<>();

        for (AvailableRoom availableRoom:availableRooms) {
            if(availableRoom.getAvailableFrom().isBefore(from) && !availableRoom.getAvailableTo().isAfter(from) ||
            !availableRoom.getAvailableFrom().isBefore(to) && availableRoom.getAvailableTo().isAfter(to)){
                //do nothing
            } else {
                freeRooms.add(availableRoom);
            }
        }
        return freeRooms;
    }

    @Override
    public Optional<AvailableRoom> getAvailableRoomBefore(LocalDate fromDate, int roomNumber) {
        Optional<AvailableRoom> roomOpt = Optional.empty();

        for (AvailableRoom room : availableRooms) {
            if (room.getRoomNumber() == roomNumber && room.getAvailableTo().isEqual(fromDate)) {
                roomOpt = Optional.of(room);
            }
        }

        return roomOpt;
    }

    @Override
    public Optional<AvailableRoom> getAvailableRoomAfter(LocalDate toDate, int roomNumber) {
        Optional<AvailableRoom> roomOpt = Optional.empty();

        for (AvailableRoom room : availableRooms) {
            if (room.getRoomNumber() == roomNumber && room.getAvailableFrom().isEqual(toDate)) {
                roomOpt = Optional.of(room);
            }
        }

        return roomOpt;
    }
}
