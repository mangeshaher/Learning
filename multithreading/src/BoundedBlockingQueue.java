import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {
    private Queue<Integer> queue;
    private Semaphore countSemaphore;
    private Semaphore emptySemaphore;

    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        countSemaphore = new Semaphore(0);
        emptySemaphore = new Semaphore(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        emptySemaphore.acquire();
        queue.offer(element);
        countSemaphore.release();
    }

    public int dequeue() throws InterruptedException {
        countSemaphore.acquire();
        int retval = queue.poll();
        emptySemaphore.release();
        return retval;
    }

    public int size() {
        return queue.size();
    }
}
