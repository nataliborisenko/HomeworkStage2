package optionaltask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Airport {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 11; i++) {
            final int numberOfPlane = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Plane №: " + numberOfPlane + " began to enter the runway");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Plane №: " + numberOfPlane + " is gaining speed for takeoff");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Plane №: " + numberOfPlane + " took off");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("The lane is free");
                }
            });

        }
        executorService.shutdown();
    }
}
