public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(10);

        Vehicle car1 = new Car("C1", "BMW", 220, 9000, 4);
        Vehicle car2 = new Car("C2", "Audi", 210, 12000, 2);
        Vehicle motorcycle1 = new Motorcycle("M1", "Yamaha", 180, 5000, false);
        Vehicle motorcycle2 = new Motorcycle("M2", "Honda", 170, 7000, true);
        Vehicle truck1 = new Truck("T1", "Volvo", 130, 16000, 5000);

        garage.add(car1);
        garage.add(car2);
        garage.add(motorcycle1);
        garage.add(motorcycle2);
        garage.add(truck1);

        Vehicle[] vehicles = {car1, car2, motorcycle1, motorcycle2, truck1};

        for (Vehicle v : vehicles) {
            v.move();
        }

        garage.rentById("C1");
        garage.rentById("M1");

        garage.printAvailable();

        garage.printNeedsService();

        garage.printRentalEstimate("C1", 3);
        garage.printRentalEstimate("T1", 2);

        garage.returnById("C1", 300);

        Car firstCar = new Car("C10", "BMW", 220, 9000, 4);
        Car secondCar = new Car("C10", "BMW", 220, 9000, 4);

        System.out.println("Are cars equal? " + firstCar.equals(secondCar));
    }
}