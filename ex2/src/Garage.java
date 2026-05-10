public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        fleet = new Vehicle[capacity];
        size = 0;
    }

    public void add(Vehicle v) {
        if (size == fleet.length) {
            throw new IllegalStateException("Garage is full.");
        }

        if (findById(v.getId()) != null) {
            throw new IllegalArgumentException("Duplicate vehicle ID.");
        }

        fleet[size] = v;
        size++;
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }

        return null;
    }

    public void rentById(String id) {
        Vehicle vehicle = findById(id);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        vehicle.rent();
    }

    public void returnById(String id, int drivenKm) {
        Vehicle vehicle = findById(id);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        vehicle.returnVehicle(drivenKm);
    }

    public void printAvailable() {
        System.out.println("Available vehicles:");

        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i].getId() + " - " + fleet[i].getBrand());
            }
        }
    }

    public void printNeedsService() {
        System.out.println("Vehicles that need service:");

        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i].getId() + " - " + fleet[i].getBrand());
            }
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle vehicle = findById(id);

        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found.");
        }

        System.out.println("Rental estimate for " + vehicle.getBrand() + ": " + vehicle.rentalPrice(days));
    }
}