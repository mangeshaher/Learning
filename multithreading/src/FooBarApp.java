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
            //System.out.println("Running foo for i -> " + i);
            synchronized (lock){
                if(fooPrinted){
                    //System.out.println("Inside waiting for foo");
                    lock.wait();
                }
                if(!fooPrinted){
                    printFoo.run();
                    fooPrinted = true;
                    lock.notify();
                    //System.out.println("notified for foo");
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            //System.out.println("Running bar for i -> " + i);
            synchronized (lock){
                if(!fooPrinted){
                    lock.wait();
                   // System.out.println("Inside waiting for bar");
                }
                if(fooPrinted){
                    printBar.run();
                    fooPrinted = false;
                    lock.notify();
                    //System.out.println("notified for bar");
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
