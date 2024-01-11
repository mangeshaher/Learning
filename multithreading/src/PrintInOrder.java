import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Condition scondition = lock.newCondition();
    private boolean oneDone = false;
    private boolean twoDone = false;

    private void one(){
        lock.lock();
        System.out.println("In first");
        oneDone = true;
        condition.signal();
        lock.unlock();
    }

    private void two() throws InterruptedException {
        lock.lock();
        while(!oneDone){
            condition.await();
        }
        System.out.println("In second");
        twoDone = true;
        scondition.signal();
        lock.unlock();
    }

    private void third() throws InterruptedException {
        lock.lock();
        while(!twoDone){
            scondition.await();
        }
        System.out.println("In third");
        lock.unlock();
    }



    public static void main(String[] args) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
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
