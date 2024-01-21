package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Semaphore prodSemaphore;
    private Semaphore conSemaphore;
    private Queue<Integer> queue;

    public Consumer(Semaphore prodSemaphore, Semaphore conSemaphore, Queue<Integer> queue) {
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++){
                conSemaphore.acquire();
                int intConsumed = queue.poll();
                System.out.println("Consumed value from queue :- " + intConsumed);
                prodSemaphore.release();
            }
        } catch (Exception e){

        }
    }
}
