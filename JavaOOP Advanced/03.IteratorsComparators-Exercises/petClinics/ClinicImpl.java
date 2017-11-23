package petClinics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClinicImpl<T extends Room> implements Clinic<Room>, Iterable<Room> {
    private static final String INVALID_OPERATION = "Invalid Operation!";
    private String name;
    private Room[] rooms;
    private int[] roomIndexes;
    private List<Integer> releaseIndexes;

    public ClinicImpl(String name, int roomsCount) {
        this.setName(name);
        this.setRooms(roomsCount);
        this.setRoomIndexes();
        this.setReleaseIndexes();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRooms(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException(INVALID_OPERATION);
        }
        this.rooms = new Room[roomsCount];
    }

    private void setRoomIndexes() {
        this.roomIndexes = new int[this.rooms.length];
        int firstIndex = this.rooms.length / 2;
        this.roomIndexes[0] = firstIndex;
        if (this.rooms.length == 1) {
            return;
        }
        int leftIndex = firstIndex - 1;
        int rightIndex = firstIndex + 1;
        for (int i = 1; i < this.rooms.length; i += 2) {
            this.roomIndexes[i] = leftIndex--;
            this.roomIndexes[i + 1] = rightIndex++;
        }
    }

    @Override
    public boolean addPet(Pet pet) {
        for (int roomIndex : this.roomIndexes) {
            if (this.rooms[roomIndex] == null) {
                Room room = new RoomImpl(pet);
                this.rooms[roomIndex] = room;
                if (this.rooms[roomIndex] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        for (int roomIndex : roomIndexes) {
            if (this.rooms[roomIndex] == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void print(int roomNumber) {
        for (int roomIndex : roomIndexes) {
            if (roomIndex == roomNumber - 1) {
                Room room = this.rooms[roomIndex];
                System.out.println(room == null ? "Room empty" : room.toString());
                return;
            }
        }
    }

    private void setReleaseIndexes() {
        this.releaseIndexes = new ArrayList<>();
        int firstElement = this.rooms.length / 2;
        this.releaseIndexes.add(firstElement);
        if (this.rooms.length == 1) {
            return;
        }

        for (int i = firstElement + 1; i < this.rooms.length; i++) {
            this.releaseIndexes.add(i);
        }
        for (int i = 0; i < firstElement; i++) {
            this.releaseIndexes.add(i);
        }
    }

    @Override
    public boolean release() {
        for (Integer releaseIndex : releaseIndexes) {
            if (this.rooms[releaseIndex] != null) {
                this.rooms[releaseIndex] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Room> iterator() {
        return new RoomIterator();
    }

    private final class RoomIterator implements Iterator<Room> {
        private int index;

        private RoomIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Room next() {
            return rooms[index++];
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
