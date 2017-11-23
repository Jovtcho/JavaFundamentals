package petClinics;

public interface Clinic<Room> extends Iterable<Room> {
    boolean addPet(Pet pet);

    boolean hasEmptyRooms();

    void print(int roomNumber);

    boolean release();
}
