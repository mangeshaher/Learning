import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private Semaphore semaphore;

    public DiningPhilosophers() {
        semaphore = new Semaphore(1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        semaphore.acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        semaphore.release();
    }
}
