public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String id, String brand, double speed, int mileage, double loadCapacity) {
        super(id, brand, speed, mileage);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void move() {
        System.out.println("The truck " + getBrand() + " is transporting goods.");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 15000;
    }

    @Override
    public double rentalPrice(int days) {
        return (80 + 0.02 * loadCapacity) * days;
    }
}