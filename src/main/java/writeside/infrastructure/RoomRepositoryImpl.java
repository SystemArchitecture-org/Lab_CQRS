package writeside.infrastructure;

import org.springframework.stereotype.Repository;
import readside.domain.AvailableRoom;
import writeside.domain.Room;
import writeside.domain.repositories.RoomRepository;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private final List<Room> roomDatabase = new LinkedList<>();

    public RoomRepositoryImpl() {
        roomDatabase.add(new Room(101, 1));
        roomDatabase.add(new Room(102, 1));
        roomDatabase.add(new Room(103, 1));
        roomDatabase.add(new Room(104, 1));
        roomDatabase.add(new Room(105, 1));
        roomDatabase.add(new Room(201, 2));
        roomDatabase.add(new Room(202, 2));
        roomDatabase.add(new Room(203, 2));
        roomDatabase.add(new Room(204, 2));
        roomDatabase.add(new Room(205, 2));
    }

    public Optional<Room> getRoomByRoomNumber(int roomNumber){
        return roomDatabase.stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst();
    }

    @Override
    public void createRoom(Room room) {
        roomDatabase.add(room);
    }

}
