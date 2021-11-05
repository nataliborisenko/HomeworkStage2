package maintask;

public class CarParking {
    private int numberOfFreeParkingSpace;

    public CarParking(int numberOfFreeParkingSpace) {
        this.numberOfFreeParkingSpace = numberOfFreeParkingSpace;
    }

    public synchronized void takeParkingPlace(String name) {
        System.out.println("Car " + name + " arrived at the car parking");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (numberOfFreeParkingSpace > 0) {
            numberOfFreeParkingSpace --;
            System.out.println("Car " + name + " took a parking space");
            System.out.println("Left " + this.numberOfFreeParkingSpace + " parking space");
        } else {

            System.out.println("There is no parking space for car " + name);
        }
    }
}
