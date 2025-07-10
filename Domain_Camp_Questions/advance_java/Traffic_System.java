package Domain_Camp_Questions.advance_java;

import java.util.concurrent.ThreadLocalRandom;
public class Traffic_System {
enum Road { NS, EW }

static class TrafficLight {
    private Road green = Road.NS;

    public synchronized void awaitGreen(Road myRoad) {
        while (green != myRoad) {
            try { wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    public synchronized void switchLight() {
        green = (green == Road.NS) ? Road.EW : Road.NS;
        System.out.println("\n=== Light switched: " + green + " is now GREEN ===");
        notifyAll();
    }
}

static class Controller extends Thread {
    private final TrafficLight light;
    private final int periodMs;

    Controller(TrafficLight light, int periodMs) {
        this.light = light;
        this.periodMs = periodMs;
        setDaemon(true);
    }
    public void run() {
        try {
            while (true) {
                Thread.sleep(periodMs);
                light.switchLight();
            }
        } catch (InterruptedException ignored) { }
    }
}

static class Car extends Thread {
    private final TrafficLight light;
    private final Road road;

    Car(int id, Road road, TrafficLight light) {
        super("Car-" + id + "-" + road);
        this.road = road;
        this.light = light;
    }
    public void run() {
        light.awaitGreen(road);
        System.out.println(getName() + " is crossing");
        try { Thread.sleep(300); } catch (InterruptedException ignored) { }
        System.out.println(getName() + " has passed");
    }
}


    public static void main(String[] args) throws InterruptedException {
        TrafficLight light = new TrafficLight();
        new Controller(light, 2000).start();

        for (int i = 1; i <= 10; i++) {
            Road r = ThreadLocalRandom.current().nextBoolean() ? Road.NS : Road.EW;
            new Car(i, r, light).start();
            Thread.sleep(500);
        }
    }
}

