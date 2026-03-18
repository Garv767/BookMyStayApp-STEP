/**
 * ABSTRACT CLASS - Room
 * Represents a generic hotel room. Updated for UC7 to support the Decorator Pattern.
 */
public abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    // Base cost of the room
    public double getCost() {
        return pricePerNight;
    }

    // Abstract method to get the room/add-on description
    public abstract String getDescription();

    public void displayRoomDetails() {
        System.out.println("Description: " + getDescription());
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Total Cost: " + getCost() + " INR");
    }
}

class SingleRoom extends Room {
    public SingleRoom() { super(1, 250, 1500.0); }
    @Override
    public String getDescription() { return "Single Room"; }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super(2, 400, 2500.0); }
    @Override
    public String getDescription() { return "Double Room"; }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super(3, 750, 5000.0); }
    @Override
    public String getDescription() { return "Suite Room"; }
}