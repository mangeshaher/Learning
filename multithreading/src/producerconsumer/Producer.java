package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Semaphore prodSemaphore;
    private Semaphore conSemaphore;
    Queue<Integer> queue;

    public Producer(Semaphore prodSemaphore, Semaphore conSemaphore, Queue<Integer> queue) {
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                prodSemaphore.acquire();
                queue.add(i);
                System.out.println("Produced value to queue :- " + i);
                conSemaphore.release();
            }
        } catch (Exception e){

        }
    }
}
