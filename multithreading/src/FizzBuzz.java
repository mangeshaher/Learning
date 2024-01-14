import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;
    private Semaphore numSemaphore = new Semaphore(1);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore fizzbuzzSemaphore = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz() throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5!=0){
                fizzSemaphore.acquire();
                System.out.print("fizz ");
                if((i+1)%3!=0 && (i+1)%5!=0){
                    numSemaphore.release();
                }
                else if((i+1)%3!=0 && (i+1)%5==0){
                    buzzSemaphore.release();
                }
                else if((i+1)%3==0 && (i+1)%5==0){
                    fizzbuzzSemaphore.release();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz() throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%3!=0 && i%5==0){
                buzzSemaphore.acquire();
                System.out.print("buzz ");
                if((i+1)%3!=0 && (i+1)%5!=0){
                    numSemaphore.release();
                }
                else if((i+1)%3==0 && (i+1)%5!=0){
                    fizzSemaphore.release();
                }
                else if((i+1)%3==0 && (i+1)%5==0){
                    fizzbuzzSemaphore.release();
                }
            }

        }


    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz() throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                fizzbuzzSemaphore.acquire();
                System.out.print("fizzbuzz ");
                if((i+1)%3!=0 && (i+1)%5!=0){
                    numSemaphore.release();
                }
                else if((i+1)%3==0 && (i+1)%5!=0){
                    fizzSemaphore.release();
                }
                else if((i+1)%3!=0 && (i+1)%5==0){
                    buzzSemaphore.release();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number() throws InterruptedException {
        for(int i=1;i<=n;i++){
            if(i%3!=0 && i%5!=0){
                numSemaphore.acquire();
                System.out.print(i + " ");
                if((i+1)%3==0 && (i+1)%5!=0){
                    fizzSemaphore.release();
                }
                else if((i+1)%3!=0 && (i+1)%5==0){
                    buzzSemaphore.release();
                }
                else if((i+1)%3==0 && (i+1)%5==0){
                    fizzbuzzSemaphore.release();
                }
                else if((i+1)%3!=0 && (i+1)%5!=0){
                    numSemaphore.release();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(16);
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        t3.start();
        t2.start();
        t1.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}