package by.myadel.Homework9.Task2;

public class Main {
    public static void main(String[] args) throws Exception {
        Building building = new Building(1);
        Room room1 = new Room(1, 100, 3);
        building.addRoom(room1);
        try {
            building.getRoomInList(1).add(new Lamp(150));
            building.getRoomInList(1).add(new Lamp(250));
        } catch (IlluminanceTooMuchException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        try {
            building.getRoomInList(1).add(new Table("Стол письменный", 3));
            building.getRoomInList(1).add(new SoftChair("Кресло мягкое и пушистое", 10));
        } catch (SpaceUsageTooMuchException ex) {
            System.out.println(ex.getMessage());
        }
        building.describe();
    }
}
