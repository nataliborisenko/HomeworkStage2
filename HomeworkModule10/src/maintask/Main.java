package maintask;

public class Main {
    public static void main(String[] args) {

        CarParking carParking = new CarParking(3);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                carParking.takeParkingPlace("FORD");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                carParking.takeParkingPlace("RENO");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                carParking.takeParkingPlace("KIA");
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                carParking.takeParkingPlace("TOYOTA");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
