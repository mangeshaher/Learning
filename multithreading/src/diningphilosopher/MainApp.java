package diningphilosopher;

import java.util.concurrent.Semaphore;

public class MainApp {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Semaphore[] forks = new Semaphore[5];
        for(int i=0;i<5;i++){
            forks[i] = new Semaphore(1);
        }
        for(int i=0;i<5;i++){
            forks[i] = new Semaphore(1);
            philosophers[i] = new Philosopher(i, forks[i], forks[(i+1)%5]);
        }
        for(int i=0;i<5;i++){
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}
