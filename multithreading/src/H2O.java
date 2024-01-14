import java.util.concurrent.Semaphore;

public class H2O {
        private Semaphore hSemaphore = new Semaphore(2);
        private Semaphore oSemaphore = new Semaphore(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            hSemaphore.acquire();
            releaseHydrogen.run();
            if(hSemaphore.availablePermits()==0){
                oSemaphore.release(1);
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            oSemaphore.acquire();
            releaseOxygen.run();
            if(oSemaphore.availablePermits()==0){
                hSemaphore.release(2);
            }
        }
}
