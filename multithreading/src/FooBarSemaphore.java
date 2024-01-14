import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarSemaphore {
    private int n;
    private Semaphore semaphore = new Semaphore(1);
    private Semaphore secondSemaphore = new Semaphore(0);
    public FooBarSemaphore(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore.acquire();
            printFoo.run();
            secondSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            secondSemaphore.acquire();
            printBar.run();
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarSemaphore fooBarApp = new FooBarSemaphore(7);
        Thread t1 = new Thread(() -> {
            try {
                fooBarApp.foo(() -> System.out.print("Foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBarApp.bar(() -> System.out.println("Bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
