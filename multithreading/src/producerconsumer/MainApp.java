package producerconsumer;

import diningphilosopher.Philosopher;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class MainApp {
    private Semaphore conSemaphore = new Semaphore(0);
    private Semaphore prodSemaphore = new Semaphore(1);


    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(mainApp.prodSemaphore, mainApp.conSemaphore, queue);
        Consumer consumer = new Consumer(mainApp.prodSemaphore, mainApp.conSemaphore, queue);
        Thread con = new Thread(consumer);
        Thread prod = new Thread(producer);
        con.start();
        prod.start();
    }
}
