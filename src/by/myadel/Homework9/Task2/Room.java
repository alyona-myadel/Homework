package by.myadel.Homework9.Task2;

import java.util.ArrayList;

public class Room {
    private static final int maxPercent = 70;
    private static final int lightWindows = 700;
    private static final int minLightRoom = 300;
    private static final int maxLightRoom = 4000;
    private int nameRoom;
    private double area;
    private int numberWindows;
    private ArrayList<Lamp> lamps = new ArrayList<>();
    private ArrayList<AbleToReceive> furnitures = new ArrayList<>();

    public Room(int nameRoom, double area, int numberWindows) {
        this.nameRoom = nameRoom;
        this.area = area;
        this.numberWindows = numberWindows;
    }

    public double getArea() {
        return area;
    }

    public ArrayList<AbleToReceive> getFurnitures() {
        return furnitures;
    }

    public static int getLightWindows() {
        return lightWindows;
    }

    public int getNameRoom() {
        return nameRoom;
    }

    public int getNumberWindows() {
        return numberWindows;
    }

    public ArrayList<Lamp> getLamps() {
        return lamps;
    }

    public static int getMinLightRoom() {
        return minLightRoom;
    }

    public static int getMaxLightRoom() {
        return maxLightRoom;
    }

    void add(AbleToReceive furniture) throws SpaceUsageTooMuchException {
        double furnitureRoom = furniture.getAreaFurniture();
        for (AbleToReceive furnitureList : furnitures) {
            furnitureRoom += furnitureList.getAreaFurniture();
        }
        if (furnitureRoom >= area * maxPercent / 100) {
            throw new SpaceUsageTooMuchException("Мебель превысила допустимую норму заполняемости комнаты. \nМебель не добавлена.");
        }
        furnitures.add(furniture);
    }

    public void add(Lamp lamp) throws IlluminanceTooMuchException {
        int lightRoom = numberWindows * lightWindows + lamp.getLight();
        for (Lamp lampList : lamps) {
            lightRoom += lampList.getLight();
        }
        if (lightRoom < getMinLightRoom() || lightRoom > getMaxLightRoom()) {
            throw new IlluminanceTooMuchException("Освещенность вышла за пределы допустимого. \nЛампочка не добавлена.");
        }
        lamps.add(lamp);
    }

    public int getIllumination() {
        int illuminationRoom = getNumberWindows() * lightWindows;
        for (Lamp lamp : lamps) {
            illuminationRoom += lamp.getLight();
        }
        return illuminationRoom;
    }

    public double getOccupiedArea() {
        double crookedArea = 0;
        for (AbleToReceive furnitureList : getFurnitures()) {
            crookedArea += furnitureList.getAreaFurniture();
        }
        return crookedArea;
    }

    public double getFreeSpace() {
        return getArea() - getOccupiedArea();
    }

    public int getFreeSpacePercent() {
        int freeSpacePercent = (int) (Math.round(getOccupiedArea() * 100 / getArea()));
        return freeSpacePercent;
    }

}
