import java.util.concurrent.Semaphore;

public class PrintInOrderSemaphore {
    private Semaphore semaphore = new Semaphore(0);
    private Semaphore secondSemaphore = new Semaphore(0);
    private void one(){
        System.out.println("In first");
        semaphore.release();
    }

    private void two() throws InterruptedException {
        semaphore.acquire();
        System.out.println("In second");
        secondSemaphore.release();
    }

    private void third() throws InterruptedException {
        secondSemaphore.acquire();
        System.out.println("In third");
    }

    public static void main(String[] args) throws InterruptedException {
        PrintInOrderSemaphore printInOrder = new PrintInOrderSemaphore();
        Thread t1 = new Thread(() -> printInOrder.one());
        Thread t2 = new Thread(() -> {
            try {
                printInOrder.two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                printInOrder.third();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t3.start();
        t2.start();
        t1.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
