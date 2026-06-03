public class Exercise17_CarClass {

    String make;
    String model;
    int year;

    void displayDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        CarClass car1 = new CarClass();
        car1.make = "Toyota";
        car1.model = "Camry";
        car1.year = 2022;
        car1.displayDetails();

        CarClass car2 = new CarClass();
        car2.make = "Honda";
        car2.model = "Civic";
        car2.year = 2023;
        car2.displayDetails();
    }
}