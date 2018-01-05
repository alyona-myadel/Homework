package by.myadel.Homework9.Task2;

import java.util.ArrayList;

import static by.myadel.Homework9.Task2.Room.getLightWindows;

public class Building {
    private int numberName;
    private ArrayList<Room> roomsList = new ArrayList<>();

    public Building(int numberName) {
        this.numberName = numberName;
    }

    public int getNumberName() {
        return numberName;
    }

    public void addRoom(Room room) {
        roomsList.add(room);
    }

    public Room getRoomInList(int nameRoomSearch) {
        for (Room roomFromList : roomsList) {
            if (nameRoomSearch == roomFromList.getNameRoom()) {
                return roomFromList;
            }
        }
        return null;
    }

    public void describe() {
        System.out.println("Здание " + getNumberName());
        for (Room room : roomsList) {
            System.out.println("Комната " + room.getNameRoom());
            System.out.print("Освещенность = " + room.getIllumination() + "(" + room.getNumberWindows()
                    + " окна по " + getLightWindows() + " лк, лампочки ");
            for (Lamp lamp : room.getLamps()) {
                System.out.print(lamp.getLight() + " лк ");
            }
            System.out.println(") \n Площадь = " + room.getArea() + " м.кв. (занято " + room.getOccupiedArea()
                    + " м.кв., гарантированно свободно " + room.getFreeSpace() + " м.кв или "
                    + room.getFreeSpacePercent() + "% площади) \n Мебель:");
            if (room.getFurnitures() != null) {
                for (AbleToReceive furniture : room.getFurnitures()) {
                    System.out.println(furniture.getNameFurniture() + " площадь " + furniture.getAreaFurniture()
                            + " м.кв.)");
                }
            } else {
                System.out.print("нет");
            }
        }
    }
}
