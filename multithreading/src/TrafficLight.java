import java.util.concurrent.Semaphore;

public class TrafficLight {
    private int currentRoad;
    private Semaphore semaphore;

    public TrafficLight() {
        semaphore = new Semaphore(1);
        currentRoad = 1;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) throws InterruptedException{
        semaphore.acquire();
        if(roadId!=currentRoad){
            turnGreen.run();
            currentRoad = roadId;
        }
        crossCar.run();
        semaphore.release();
    }
}
