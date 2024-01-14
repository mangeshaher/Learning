import java.util.concurrent.Semaphore;

public class ZeroOddEven {
    private int n;
    private Semaphore zeroSemaphore = new Semaphore(1);
    private Semaphore oddSemaphore = new Semaphore(0);
    private Semaphore evenSemaphore = new Semaphore(0);

    public ZeroOddEven(int n) {
        this.n = n;
    }

    public void zero() throws InterruptedException {
        for(int i=0;i<n;i++){
            zeroSemaphore.acquire();
            System.out.print(0);
            if(i%2==1){
                evenSemaphore.release();
            }
            else{
                oddSemaphore.release();
            }
        }
    }

    public void even() throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            evenSemaphore.acquire();
            System.out.print(i);
            zeroSemaphore.release();
        }
    }

    public void odd() throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            oddSemaphore.acquire();
            System.out.print(i);
            zeroSemaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroOddEven zeroOddEven = new ZeroOddEven(4);
        Thread t1 = new Thread(() -> {
            try {
                zeroOddEven.zero();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroOddEven.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroOddEven.even();
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
