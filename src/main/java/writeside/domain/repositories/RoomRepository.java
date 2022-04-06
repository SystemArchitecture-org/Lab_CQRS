package writeside.domain.repositories;

import writeside.domain.Room;

import java.util.Optional;

public interface RoomRepository {
    void createRoom(Room room);
    Optional<Room> getRoomByRoomNumber(int roomNumber);
}
