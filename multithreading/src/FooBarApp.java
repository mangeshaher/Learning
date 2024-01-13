import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarApp {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean fooPrinted = false;

    public FooBarApp(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if(fooPrinted){
                    lock.wait();
                }
                if(!fooPrinted){
                    printFoo.run();
                    fooPrinted = true;
                    lock.notify();
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if(!fooPrinted){
                    lock.wait();
                }
                if(fooPrinted){
                    printBar.run();
                    fooPrinted = false;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarApp fooBarApp = new FooBarApp(7);
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
